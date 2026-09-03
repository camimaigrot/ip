public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        String status = isDone() ? "X" : " ";
        return "[T][" + status + "] " + getLabel();
    }
}