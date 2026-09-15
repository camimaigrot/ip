package ace.ui;

public class Messages {
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
    public static final String ASSISTANCE_MESSAGE = "Oh, you need help? Uh... Not sure I'm the right person, but I'll try.";
    public static final String BYE_MESSAGE = "Leaving already? Sorry for the mistakes.";

    // Exceptions messages
    public static final String UNKNOWN_COMMAND_EXCEPTION = "I'm not sure I understand, sorry.";
    public static final String UNKNOWN_TASK_EXCEPTION = "I cannot find this task, I don't know what I did wrong.";
    public static final String OUT_OF_BOUNDS_TASK_EXCEPTION = "Oh, I don't know what went wrong. I swear, I'm trying, but it looks like I cannot add any more tasks.";
    public static final String INVALID_TASK_EXCEPTION = "I don't understand... this task is... weird.";
    public static final String EMPTY_TASK_EXCEPTION = "I don't want to bother more, I'm just questioning the utility of an empty field.";
    public static final String NO_BY_DEADLINE_EXCEPTION = "I must have missed the actual deadline (given with /by). Could you retype the command please?";
    public static final String NO_FROM_EVENT_EXCEPTION = "I must have missed the beginning of the event (given with /from). Could you retype the command please?";
    public static final String NO_TO_EVENT_EXCEPTION = "I must have missed the end of the event (given with /to). Could you retype the command please?";
    public static final String INVALID_DELETE_EXCEPTION = "Please... Could you specify a valid task number to delete?";
    public static final String STORAGE_EXCEPTION = "Something went wrong while accessing the saved tasks.";
    public static final String CORRUPTED_DATA_EXCEPTION = "The saved task file contains invalid data.";
}
