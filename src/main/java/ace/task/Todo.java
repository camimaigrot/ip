package ace.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }
    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[T][" + status + "] " + getLabel();
    }
}