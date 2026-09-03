public class Deadline extends Task {
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[D][" + status + "] "
                + getLabel()
                + " (by: " + by + ")";
    }
}