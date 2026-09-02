public class Task{
    String label;
    boolean done;

    public Task(){
        this("");
    }

    public Task(String taskLabel){
        this(taskLabel, false);
    }

    public Task (String taskLabel, boolean taskStatus){
        this.label = taskLabel;
        this.done = taskStatus;
    }

    public String getLabel(){
        return label;
    }

    public boolean isDone(){
        return done;
    }
}