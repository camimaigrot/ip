package ace.task;
import ace.exception.*;
import ace.ui.*;

import java.util.ArrayList;
/**
 * Manages the tasks stored by Ace.
 */
public class TaskManager{
    private ArrayList<Task> tasks = new ArrayList<>();

    public Task getTask(int taskNumber) throws AceException {
        if (taskNumber < 0 || taskNumber >= tasks.size()){
            throw new AceException(Messages.UNKNOWN_TASK_EXCEPTION);
        }
        return tasks.get(taskNumber);
    }

    public int getTasksCount(){
        return tasks.size();
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
        tasks.add(task);
    }

    public Task deleteTask(int taskNumber) throws AceException {
        Task task = getTask(taskNumber);
        tasks.remove(taskNumber);
        return task;
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
