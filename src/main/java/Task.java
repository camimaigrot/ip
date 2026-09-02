public class Task{
    private String label;
    private boolean isDone;

    public Task(){
        this("");
    }

    public Task(String taskLabel){
        this(taskLabel, false);
    }

    public Task (String taskLabel, boolean taskStatus){
        this.label = taskLabel;
        this.isDone = taskStatus;
    }

    public String getLabel(){
        return label;
    }

    public boolean isDone(){
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsUndone() {
        isDone = false;
    }
}