public class TaskManager{
    public static final int MAX_TASKS = 100;

    Task[] tasks = new Task[MAX_TASKS];
    int tasksCount;

    public Task getTask(int taskNumber){
        if (taskNumber < MAX_TASKS && taskNumber < this.tasksCount){
            return tasks[taskNumber];
        }
        return null;
    }

    public int getTasksCount(){
        return tasksCount;
    }

    public int addTask(String task){
        Task newTask = new Task(task);
        if (this.tasksCount < MAX_TASKS) {
            this.tasks[tasksCount] = newTask;
            this.tasksCount++;
            return 0;
        } else {
            return 1;
        }
    }

    public int markAsDone(int taskNumber){
        Task task = getTask(taskNumber);
        if(!(task==null)) {
            task.done = true;
            return 0;
        } else {
            return 1;
        }
    }

    public int markAsUndone(int taskNumber){
        Task task = getTask(taskNumber);
        if(!(task==null)) {
            task.done = false;
            return 0;
        } else {
            return 1;
        }
    }
}
