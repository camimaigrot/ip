package ace;

import java.util.Scanner;
import ace.ui.*;
import ace.task.*;
import ace.exception.*;

public class Ace {

     static final String[] AUTHORIZED_COMMANDS = {
            "help", "bye", "list", "mark", "unmark",
            "todo", "deadline", "event"
    };

    private static final TaskManager taskManager = new TaskManager();

    public static void printAceMessage(String message) {
        printAceMessage(message, true);
    }

    public static void printAceMessage(String message, boolean withSeparation) {
        if (withSeparation) {
            printAceSeparation();
        }
        System.out.print("\t" + message + "\n");
        if (withSeparation) {
            printAceSeparation();
        }
    }

    public static void printAceSeparation() {
        System.out.print("\t" + Messages.HL + "\n");
    }

    public static void printTaskList() throws AceException {
        printAceSeparation();
        int taskCount = taskManager.getTasksCount();
        if (taskCount == 0) {
            printAceMessage("\tI don't know what happened or if I messed something up, but... you have no tasks available.\n", false);
        } else {
            printAceMessage("\tThese should be your tasks:\n", false);
            for (int i = 0; i < taskCount; i++) {
                Task task = taskManager.getTask(i);
                printAceMessage("\t" + (i + 1) + "." + task, false);
            }
        }
        printAceSeparation();
    }

    public static void printTaskMarkedDone(int taskNumber) throws AceException {
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Oh wow, you managed to finish this task:\n" + "\t" + task);
    }

    public static void printTaskMarkedUndone(int taskNumber) throws AceException {
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("I'm sorry, looks like this task isn't done after all:\n" + "\t" + task);
    }

    public static void throwAceError(String error) {
        printAceSeparation();
        System.err.print("\t"+error+"\n");
        printAceSeparation();
    }

    public static boolean inAuthorizedCommands(String command) {
        for (int i = 0; i < AUTHORIZED_COMMANDS.length; i++) {
            if (AUTHORIZED_COMMANDS[i].equals(command)) {
                return true;
            }
        }
        return false;
    }

    private static boolean processCommand(String line) throws AceException {
        String[] lineWords = line.split(" ");
        String keyword = lineWords[0];

        if (!inAuthorizedCommands(keyword)) {
            throw new AceException(Messages.UNKNOWN_COMMAND_EXCEPTION);
        }

        switch (keyword) {
            case "help":
                printAceMessage("help");
                break;
            case "bye":
                printAceMessage(Messages.BYE_MESSAGE);
                return false;
            case "list":
                printTaskList();
                break;
            case "mark":
                markTask(lineWords);
                break;
            case "unmark":
                unmarkTask(lineWords);
                break;
            case "todo":
                addTodo(line);
                break;
            case "deadline":
                addDeadline(line);
                break;
            case "event":
                addEvent(line);
                break;
            default:
                throw new AceException(Messages.UNKNOWN_COMMAND_EXCEPTION);
        }
        return true;
    }

    private static void markTask(String[] lineWords) throws AceException {
        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
        taskManager.markAsDone(taskNumber);
        printTaskMarkedDone(taskNumber);
    }

    private static void unmarkTask(String[] lineWords) throws AceException {
        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
        taskManager.markAsUndone(taskNumber);
        printTaskMarkedUndone(taskNumber);
    }

    private static void addTodo(String line) throws AceException {
        String description = line.substring("todo".length()).trim();
        Task task = new Todo(description);
        addTask(task);
    }

    private static void addDeadline(String line) throws AceException {
        int byIndex = line.indexOf("/by");
        if (byIndex == -1) {
            throw new AceException(Messages.NO_BY_DEADLINE_EXCEPTION);
        }
        String description = line.substring(
                "deadline".length(), byIndex).trim();
        String by = line.substring(byIndex + 3).trim();

        Task task = new Deadline(description, by);
        addTask(task);
    }

    private static void addEvent(String line) throws AceException {
        int fromIndex = line.indexOf("/from");
        if (fromIndex == -1) {
            throw new AceException(Messages.NO_FROM_EVENT_EXCEPTION);
        }
        int toIndex = line.indexOf("/to");
        if (toIndex == -1) {
            throw new AceException(Messages.NO_TO_EVENT_EXCEPTION);
        }

        String description = line.substring(
                "event".length(), fromIndex).trim();
        String from = line.substring(fromIndex + 5, toIndex).trim();
        String to = line.substring(toIndex + 3).trim();

        Task task = new Event(description, from, to);
        addTask(task);
    }

    private static void addTask(Task task) throws AceException {
        taskManager.addTask(task);
        printAceMessage("I think I managed to add this new task:\n\t" + task);
    }

    public static void main(String[] args) throws AceException {
        Scanner in = new Scanner(System.in);

        printAceMessage(Messages.BANNER);
        printAceMessage(Messages.WELCOME_MESSAGE);
        printAceMessage(Messages.ASSISTANCE_MESSAGE);

        boolean isRunning = true;

        while (isRunning) {
            String line = in.nextLine();
            try {
                isRunning = processCommand(line);
            } catch (AceException e) {
                throwAceError(e.getMessage());
            }
        }
    }
}
