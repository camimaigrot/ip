/**
 * Manages the tasks stored by Ace.
 */
public class TaskManager{
    public static final int MAX_TASKS = 100;

    private Task[] tasks = new Task[MAX_TASKS];
    private int tasksCount;

    public Task getTask(int taskNumber){
        if (taskNumber >= 0 && taskNumber < MAX_TASKS && taskNumber < tasksCount){
            return tasks[taskNumber];
        }
        return null;
    }

    public int getTasksCount(){
        return tasksCount;
    }

    /**
     * Adds a task to the task list.
     *
     * @param taskLabel Label of the task to add.
     * @return 0 if the task was added successfully, or 1 if the task list is full.
     */
    public int addTask(String taskLabel){
        if (tasksCount < MAX_TASKS) {
            tasks[tasksCount] = new Task(taskLabel);
            tasksCount++;
            return 0;
        } else {
            return 1;
        }
    }

    public int markAsDone(int taskNumber){
        Task task = getTask(taskNumber);
        if(task!=null) {
            task.markAsDone();
            return 0;
        } else {
            return 1;
        }
    }

    public int markAsUndone(int taskNumber){
        Task task = getTask(taskNumber);
        if(!(task==null)) {
            task.markAsUndone();
            return 0;
        } else {
            return 1;
        }
    }
}
