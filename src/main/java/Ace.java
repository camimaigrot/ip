import java.util.Scanner;

public class Ace {
    public static final String BANNER = "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣠⣄⠀⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣠⡾⣿⡟⠁⠀⠀⠀⠈⠙⠻⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠁⠀⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⣀⣀⣤⣾⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⢀⣴⢶⣿⣿⡿⠛⠉⣿⡆⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⡿⠃⠀⠀⢀⣿⠁⢸⣿⣿⠆⢀⣀⣿⣿⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⡿⠁⠀⠀⠀⠈⢿⡄⠀⠈⣉⠀⣾⣿⣿⢿⡇⠀⠀⠀⠀⣴⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠈⠙⣛⣿⣿⡄⠀⠉⠁⣼⠇⠀⠀⢀⣼⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠐⠾⣿⣿⠋⠛⠶⠶⠞⠋⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⣸⣿⡴⠟⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀⠀⠻⠟⠁⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
        "\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
    public static final String HL = "______________________________";
    public static final String WELCOME_MESSAGE = "Welcome, Ace  here.";
    public static final String ASSISTANCE_MESSAGE = "What can I do for you?";
    public static final String BYE_MESSAGE = "Catch you later.";
    public static final String UNKNOWN_MESSAGE = "?";

    public static final String[] AUTHORIZED_COMMANDS = {
            "help", "bye", "list", "mark", "unmark",
            "todo", "deadline", "event"
    };

    private static final TaskManager taskManager = new TaskManager();

    public static void printAceMessage(String message) {
        printAceSeparation();
        System.out.print("\t" + message + "\n");
        printAceSeparation();
    }

    public static void printAceSeparation() {
        System.out.print("\t" + HL + "\n");
    }

    public static void printTaskList() {
        printAceSeparation();
        int taskCount = taskManager.getTasksCount();
        if (taskCount == 0) {
            System.out.print("\tNo tasks.\n");
        } else {
            System.out.print("\tYour tasks:\n");
            for (int i = 0; i < taskCount; i++) {
                Task task = taskManager.getTask(i);
                System.out.println("\t" + (i + 1) + "." + task);
            }
        }
        printAceSeparation();
    }

    public static void printTaskMarkedDone(int taskNumber) {
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Done with this task:\n" + "\t" + task);
    }

    public static void printTaskMarkedUndone(int taskNumber) {
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Marked this task to undone:\n" + "\t" + task);
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printAceMessage(BANNER);
        printAceMessage(WELCOME_MESSAGE);
        printAceMessage(ASSISTANCE_MESSAGE);

        outerInputLoop:
        while(true) {
            String line = in.nextLine();
            String[] lineWords = line.split(" ");
            String keyword = lineWords[0];

            if (inAuthorizedCommands(keyword)) {
                switch(keyword) {
                    case "help":
                        printAceMessage("help");
                        break;
                    case "bye":
                        printAceMessage(BYE_MESSAGE);
                        break outerInputLoop;
                    case "list":
                        printTaskList();
                        break;
                    case "mark": {
                        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
                        int taskErrorCode = taskManager.markAsDone(taskNumber);
                        if (taskErrorCode > 0) {
                            printAceMessage(UNKNOWN_MESSAGE);
                        } else {
                            printTaskMarkedDone(taskNumber);
                        }
                        break;
                    }
                    case "unmark": {
                        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
                        int taskErrorCode = taskManager.markAsUndone(taskNumber);
                        if (taskErrorCode > 0) {
                            printAceMessage(UNKNOWN_MESSAGE);
                        } else {
                            printTaskMarkedUndone(taskNumber);
                        }
                        break;
                    }
                    case "todo": {
                        String description = line.substring("todo".length()).trim();
                        Task task = new Todo(description);
                        int taskErrorCode = taskManager.addTask(task);

                        if (taskErrorCode > 0) {
                            throwAceError("Too many tasks have been added, time to work.");
                        } else {
                            printAceMessage("Got it. I've added this task:\n\t" + task);
                        }
                        break;
                    }
                    case "deadline": {
                        int byIndex = line.indexOf("/by");

                        String description = line.substring(
                                "deadline".length(), byIndex).trim();
                        String by = line.substring(byIndex + 3).trim();

                        Task task = new Deadline(description, by);
                        int taskErrorCode = taskManager.addTask(task);

                        if (taskErrorCode > 0) {
                            throwAceError("Too many tasks have been added, time to work.");
                        } else {
                            printAceMessage("Got it. I've added this task:\n\t" + task);
                        }
                        break;

                    }
                    case "event": {
                        int fromIndex = line.indexOf("/from");
                        int toIndex = line.indexOf("/to");

                        String description = line.substring(
                                "event".length(), fromIndex).trim();
                        String from = line.substring(fromIndex + 5, toIndex).trim();
                        String to = line.substring(toIndex + 3).trim();

                        Task task = new Event(description, from, to);
                        int taskErrorCode = taskManager.addTask(task);

                        if (taskErrorCode > 0) {
                            throwAceError("Too many tasks have been added, time to work.");
                        } else {
                            printAceMessage("Got it. I've added this task:\n\t" + task);
                        }
                        break;
                    }
                    default:
                        printAceMessage(UNKNOWN_MESSAGE);
                        break;
                }
            } else {
                printAceMessage(UNKNOWN_MESSAGE);
            }

        }
    }
}
