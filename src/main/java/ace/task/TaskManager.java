package ace.task;
import ace.exception.*;
import ace.ui.*;
/**
 * Manages the tasks stored by Ace.
 */
public class TaskManager{
    public final int MAX_TASKS = 100;

    private Task[] tasks = new Task[MAX_TASKS];
    private int tasksCount;

    public Task getTask(int taskNumber) throws AceException {
        if (taskNumber < 0 || taskNumber >= tasksCount){
            throw new AceException(Messages.UNKNOWN_TASK_EXCEPTION);
        }
        return tasks[taskNumber];
    }

    public int getTasksCount(){
        return tasksCount;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task the task to add.
     */
    public void addTask(Task task) throws AceException {
        if (task == null) {
            throw new AceException(Messages.INVALID_TASK_EXCEPTION);
        }
        if (task.isEmpty()){
            throw new AceException(Messages.EMPTY_TASK_EXCEPTION);
        }
        if (tasksCount >= MAX_TASKS) {
            throw new AceException(Messages.OUT_OF_BOUNDS_TASK_EXCEPTION);
        }
        tasks[tasksCount] = task;
        tasksCount++;
    }

    public void markAsDone(int taskNumber) throws AceException {
        Task task = getTask(taskNumber);
        task.markAsDone();
    }

    public void markAsUndone(int taskNumber) throws AceException {
        Task task = getTask(taskNumber);
        task.markAsUndone();
    }
}
