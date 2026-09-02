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

    public static void printAceMessage(String message){
        printAceSeparation();
        System.out.print("\t"+message+"\n");
        printAceSeparation();
    }

    public static void printAceSeparation(){
        System.out.print("\t"+HL+"\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printAceMessage(BANNER);
        printAceMessage(WELCOME_MESSAGE);
        printAceMessage(ASSISTANCE_MESSAGE);
        String line = in.nextLine();
        while(!line.contains("bye")){
            printAceMessage(line);
            line = in.nextLine();
        }
        printAceMessage(BYE_MESSAGE);
    }
}
