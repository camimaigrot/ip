import java.util.Scanner;
import java.util.List;

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

    public static final String[] AUTHORIZED_COMMANDS = {"help", "bye", "list", "mark", "unmark"};

    private static TaskManager taskManager = new TaskManager();

    public static void printAceMessage(String message){
        printAceSeparation();
        System.out.print("\t"+message+"\n");
        printAceSeparation();
    }

    public static void printAceSeparation(){
        System.out.print("\t"+HL+"\n");
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
                String crossIfDone = task.isDone() ? "X" : " ";
                System.out.println("\t" + (i + 1) + ": [" + crossIfDone + "] " + task.getLabel());
            }
        }
        printAceSeparation();
    }

    public static void printTaskMarkedDone(int taskNumber){
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Done with this task:\n"+"\t   [X] "+task.getLabel());
    }

    public static void printTaskMarkedUndone(int taskNumber){
        Task task = taskManager.getTask(taskNumber);
        printAceMessage("Marked this task to undone:\n"+"\t   [ ] "+task.getLabel());
    }

    public static void throwAceError(String error){
        printAceSeparation();
        System.err.print("\t"+error+"\n");
        printAceSeparation();
    }

    public static boolean inAuthorizedCommands(String command){
        for (int i = 0; i < AUTHORIZED_COMMANDS.length; i++){
            if (AUTHORIZED_COMMANDS[i].equals(command)){
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

        String line, keyword;
        String[] lineWords;
        int taskErrorCode = 0;
        int taskNumber;

        outerInputLoop:
        while(true){
            line = in.nextLine();
            lineWords = line.split(" ");
            keyword = lineWords[0];

            if (inAuthorizedCommands(keyword)){
                switch(keyword){
                    case "help":
                        printAceMessage("help");
                        break;
                    case "bye":
                        printAceMessage(BYE_MESSAGE);
                        break outerInputLoop;
                    case "list":
                        printTaskList();
                        break;
                    case "mark":
                        taskNumber = Integer.parseInt(lineWords[1]) - 1;
                        taskErrorCode = taskManager.markAsDone(taskNumber);
                        if (taskErrorCode > 0){
                            printAceMessage(UNKNOWN_MESSAGE);
                        } else {
                            printTaskMarkedDone(taskNumber);
                        }
                        break;
                    case "unmark":
                        taskNumber = Integer.parseInt(lineWords[1]) - 1;
                        taskErrorCode = taskManager.markAsUndone(taskNumber);
                        if (taskErrorCode > 0){
                            printAceMessage(UNKNOWN_MESSAGE);
                        } else {
                            printTaskMarkedUndone(taskNumber);
                        }
                        break;
                    default:
                        printAceMessage(UNKNOWN_MESSAGE);
                        break;
                }
            } else {
                taskErrorCode = taskManager.addTask(line);
                if (taskErrorCode > 0){
                    throwAceError("Too many tasks have been added, time to work.");
                } else {
                    printAceMessage("Added task: "+ line);
                }
            }
        }
    }
}
