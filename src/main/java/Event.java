public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[E][" + status + "] "
                + getLabel()
                + " (from: " + from + " to: " + to + ")";
    }
}