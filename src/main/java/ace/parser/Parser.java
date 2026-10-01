package ace.parser;

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
        return new Deadline(description, by);
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
        return new Event(description, from, to);
    }

    /**
     * Holds a parsed command and any task or index required to execute it.
     */
    public static final class ParsedCommand {
        private final String keyword;
        private final Task task;
        private final int taskNumber;

        private ParsedCommand(String keyword, Task task, int taskNumber) {
            this.keyword = keyword;
            this.task = task;
            this.taskNumber = taskNumber;
        }

        public String getKeyword() {
            return keyword;
        }

        public Task getTask() {
            return task;
        }

        public int getTaskNumber() {
            return taskNumber;
        }
    }
}
