package ace.parser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import ace.exception.AceException;
import ace.task.Deadline;
import ace.task.Event;
import ace.task.Task;
import ace.task.Todo;
import ace.ui.Messages;

/**
 * Interprets user input and extracts the arguments needed to execute a command.
 */
public final class Parser {
    private static final String INVALID_DATE_MESSAGE =
            "Please enter a valid date in yyyy-MM-dd format.";
    private static final String INVALID_DATE_RANGE_MESSAGE =
            "The event cannot end before it starts.";

    private static final String EMPTY_FIND_MESSAGE =
            "Please specify a keyword to search for.";

    private Parser() {
    }

    /**
     * Parses a command without changing the task list or producing output.
     *
     * @param input complete line entered by the user
     * @return the command name and its parsed arguments
     * @throws AceException if the command is unknown or has invalid arguments
     */
    public static ParsedCommand parse(String input) throws AceException {
        String line = input.trim();
        if (line.isEmpty()) {
            throw new AceException(Messages.UNKNOWN_COMMAND_EXCEPTION);
        }

        String[] words = line.split("\\s+", 2);
        String keyword = words[0];

        switch (keyword) {
        case "help":
        case "bye":
        case "list":
            return new ParsedCommand(keyword, null, -1);
        case "find":
            String searchTerm = getDescription(line, keyword);
            if (searchTerm.isBlank()) {
                throw new AceException(EMPTY_FIND_MESSAGE);
            }
            return new ParsedCommand(keyword, null, -1, searchTerm);
        case "mark":
        case "unmark":
            return new ParsedCommand(keyword, null,
                    parseTaskNumber(line, Messages.UNKNOWN_TASK_EXCEPTION));
        case "delete":
            return new ParsedCommand(keyword, null,
                    parseTaskNumber(line, Messages.INVALID_DELETE_EXCEPTION));
        case "todo":
            return new ParsedCommand(keyword, new Todo(getDescription(line, keyword)), -1);
        case "deadline":
            return new ParsedCommand(keyword, parseDeadline(line), -1);
        case "event":
            return new ParsedCommand(keyword, parseEvent(line), -1);
        default:
            throw new AceException(Messages.UNKNOWN_COMMAND_EXCEPTION);
        }
    }

    /**
     * Converts a one-based task number to the zero-based index used internally.
     */
    private static int parseTaskNumber(String line, String invalidMessage) throws AceException {
        String[] parts = line.split("\\s+");
        if (parts.length != 2) {
            throw new AceException(invalidMessage);
        }
        try {
            int number = Integer.parseInt(parts[1]);
            if (number <= 0) {
                throw new AceException(invalidMessage);
            }
            return number - 1;
        } catch (NumberFormatException exception) {
            throw new AceException(invalidMessage);
        }
    }

    private static String getDescription(String line, String keyword) {
        return line.substring(keyword.length()).trim();
    }

    private static Deadline parseDeadline(String line) throws AceException {
        int byIndex = line.indexOf("/by");
        if (byIndex == -1) {
            throw new AceException(Messages.NO_BY_DEADLINE_EXCEPTION);
        }
        String description = line.substring("deadline".length(), byIndex).trim();
        String by = line.substring(byIndex + "/by".length()).trim();
        return new Deadline(description, parseDate(by));
    }

    private static Event parseEvent(String line) throws AceException {
        int fromIndex = line.indexOf("/from");
        if (fromIndex == -1) {
            throw new AceException(Messages.NO_FROM_EVENT_EXCEPTION);
        }
        int toIndex = line.indexOf("/to", fromIndex + "/from".length());
        if (toIndex == -1) {
            throw new AceException(Messages.NO_TO_EVENT_EXCEPTION);
        }
        String description = line.substring("event".length(), fromIndex).trim();
        String from = line.substring(fromIndex + "/from".length(), toIndex).trim();
        String to = line.substring(toIndex + "/to".length()).trim();
        LocalDate startDate = parseDate(from);
        LocalDate endDate = parseDate(to);
        if (endDate.isBefore(startDate)) {
            throw new AceException(INVALID_DATE_RANGE_MESSAGE);
        }
        return new Event(description, startDate, endDate);
    }

    /**
     * Reads an ISO-format date from a user command.
     *
     * @param input date in yyyy-MM-dd format
     * @return parsed date
     * @throws AceException if the date is missing or invalid
     */
    private static LocalDate parseDate(String input) throws AceException {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException exception) {
            throw new AceException(INVALID_DATE_MESSAGE);
        }
    }

    /**
     * Holds a parsed command and its arguments.
     */
    public static final class ParsedCommand {
        private final String keyword;
        private final Task task;
        private final int taskNumber;
        private final String searchTerm;

        private ParsedCommand(String keyword, Task task, int taskNumber) {
            this(keyword, task, taskNumber, null);
        }

        private ParsedCommand(String keyword, Task task, int taskNumber, String searchTerm) {
            this.keyword = keyword;
            this.task = task;
            this.taskNumber = taskNumber;
            this.searchTerm = searchTerm;
        }

        /**
         * Returns the command name used to select an operation.
         *
         * @return the command keyword.
         */
        public String getKeyword() {
            return keyword;
        }

        /**
         * Returns the task to add for todo, deadline, and event commands.
         *
         * @return the task, or null if the command does not add a task.
         */
        public Task getTask() {
            return task;
        }

        /**
         * Returns the zero-based task index for numbered commands.
         *
         * @return the task index, or -1 when no index is needed.
         */
        public int getTaskNumber() {
            return taskNumber;
        }

        /**
         * Returns the keyword to search for in a find command.
         *
         * @return the search term, or null for other commands.
         */
        public String getSearchTerm() {
            return searchTerm;
        }
    }
}
