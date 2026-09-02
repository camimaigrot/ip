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
    public static final List<String> AUTHORIZED_COMMANDS = List.of("help", "bye", "list");
    public static final String UNKNOWN_MESSAGE = "?";
    public static final int MAX_TASKS = 2;

    static String[] tasks = new String[MAX_TASKS];
    static int tasksCount = 0;

    public static void printAceMessage(String message){
        printAceSeparation();
        System.out.print("\t"+message+"\n");
        printAceSeparation();
    }

    public static void printAceSeparation(){
        System.out.print("\t"+HL+"\n");
    }

    public static void printAceList(){
        printAceSeparation();
        for (int i = 0; i < tasksCount; i++){
            System.out.println("\t\t"+Integer.toString(i+1)+": "+tasks[i]);
        }
        printAceSeparation();
    }

    public static void throwAceError(String error){
        printAceSeparation();
        System.err.print("\t"+error+"\n");
        printAceSeparation();
    }

    public static void addTask(String task) {
        if (tasksCount < MAX_TASKS) {
            tasks[tasksCount] = task;
            tasksCount++;
            printAceMessage("Added task: "+ task);
            return;
        } else {
            throwAceError("Too many tasks have been added, time to work.");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printAceMessage(BANNER);
        printAceMessage(WELCOME_MESSAGE);
        printAceMessage(ASSISTANCE_MESSAGE);
        String line = in.nextLine();
        outerInputLoop:
        while(true){
            if (AUTHORIZED_COMMANDS.contains(line)){
                //automatize (dic)
                switch(line){
                    case "help":
                        printAceMessage("help");
                        break;
                    case "bye":
                        printAceMessage(BYE_MESSAGE);
                        break outerInputLoop;
                    case "list":
                        printAceList();
                        break;
                    default:
                        printAceMessage(UNKNOWN_MESSAGE);
                        break;
                }
            } else {
                addTask(line);
            }
            line = in.nextLine();
        }
    }
}
