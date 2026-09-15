package ace.task;

public class Deadline extends Task {
    private String by;

    public Deadline(String description, String by) {
        this(description, by, false);
    }

    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[D][" + status + "] "
                + getLabel()
                + " (by: " + by + ")";
    }
}