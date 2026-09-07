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
    public static final String WELCOME_MESSAGE = "Hi, I'm Ace, hopefully I'll ace this.";
    public static final String ASSISTANCE_MESSAGE = "Oh, you need help? Uh... Not sure I' m the right person, but I'll try.";
    public static final String BYE_MESSAGE = "Leaving already? Sorry for the mistakes.";
    public static final String UNKNOWN_MESSAGE = "I'm not sure I understand, sorry.";

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
            System.out.print("\tI don't know what happened or if I messed something up, but... you have no tasks available.\n");
        } else {
            System.out.print("\tI think these might be your tasks:\n");
            for (int i = 0; i < taskCount; i++) {
                Task task = taskManager.getTask(i);
                System.out.println("\t" + (i + 1) + "." + task);
            }
        }
        printAceSeparation();
    }

    public static void printTaskMarkedDone(int taskNumber) {
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Oh wow, you managed to finish this task:\n" + "\t" + task);
    }

    public static void printTaskMarkedUndone(int taskNumber) {
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

    private static boolean processCommand(String line) {
        String[] lineWords = line.split(" ");
        String keyword = lineWords[0];

        if (!inAuthorizedCommands(keyword)) {
            printAceMessage(UNKNOWN_MESSAGE);
            return true;
        }

        switch (keyword) {
            case "help":
                printAceMessage("help");
                break;
            case "bye":
                printAceMessage(BYE_MESSAGE);
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
                printAceMessage(UNKNOWN_MESSAGE);
                break;
        }

        return true;
    }

    private static void markTask(String[] lineWords) {
        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
        int taskErrorCode = taskManager.markAsDone(taskNumber);

        if (taskErrorCode > 0) {
            printAceMessage(UNKNOWN_MESSAGE);
        } else {
            printTaskMarkedDone(taskNumber);
        }
    }

    private static void unmarkTask(String[] lineWords) {
        int taskNumber = Integer.parseInt(lineWords[1]) - 1;
        int taskErrorCode = taskManager.markAsUndone(taskNumber);

        if (taskErrorCode > 0) {
            printAceMessage(UNKNOWN_MESSAGE);
        } else {
            printTaskMarkedUndone(taskNumber);
        }
    }

    private static void addTodo(String line) {
        String description = line.substring("todo".length()).trim();
        Task task = new Todo(description);
        addTask(task);
    }

    private static void addDeadline(String line) {
        int byIndex = line.indexOf("/by");

        String description = line.substring(
                "deadline".length(), byIndex).trim();
        String by = line.substring(byIndex + 3).trim();

        Task task = new Deadline(description, by);
        addTask(task);
    }

    private static void addEvent(String line) {
        int fromIndex = line.indexOf("/from");
        int toIndex = line.indexOf("/to");

        String description = line.substring(
                "event".length(), fromIndex).trim();
        String from = line.substring(fromIndex + 5, toIndex).trim();
        String to = line.substring(toIndex + 3).trim();

        Task task = new Event(description, from, to);
        addTask(task);
    }

    private static void addTask(Task task) {
        int taskErrorCode = taskManager.addTask(task);

        if (taskErrorCode > 0) {
            throwAceError("Oh, I don't know what went wrong. I swear, I'm trying, but it looks like I can't add this new task.");
        } else {
            printAceMessage("I think I managed to add this new task:\n\t" + task);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        printAceMessage(BANNER);
        printAceMessage(WELCOME_MESSAGE);
        printAceMessage(ASSISTANCE_MESSAGE);

        boolean isRunning = true;

        while (isRunning) {
            String line = in.nextLine();
            isRunning = processCommand(line);
        }
    }
}
