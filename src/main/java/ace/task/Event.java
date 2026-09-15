package ace.task;

public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        this(description, from, to, false);
    }

    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[E][" + status + "] "
                + getLabel()
                + " (from: " + from + " to: " + to + ")";
    }
}