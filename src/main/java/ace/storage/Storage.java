package ace.storage;

import ace.exception.AceException;
import ace.task.*;
import ace.ui.Messages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final Path FILE_PATH = Path.of("data", "ace.txt");

    public ArrayList<Task> loadTasks() throws AceException {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            Files.createDirectories(FILE_PATH.getParent());

            if (Files.notExists(FILE_PATH)) {
                Files.createFile(FILE_PATH);
                return tasks;
            }

            List<String> lines = Files.readAllLines(FILE_PATH);

            for (String line : lines) {
                if (!line.isBlank()) {
                    tasks.add(parseTask(line));
                }
            }

            return tasks;
        } catch (IOException e) {
            throw new AceException(Messages.STORAGE_EXCEPTION);
        }
    }

    public void saveTasks(TaskManager taskManager) throws AceException {
        ArrayList<String> lines = new ArrayList<>();

        for (int i = 0; i < taskManager.getTasksCount(); i++) {
            Task task = taskManager.getTask(i);
            lines.add(taskToString(task));
        }

        try {
            Files.createDirectories(FILE_PATH.getParent());
            Files.write(FILE_PATH, lines);
        } catch (IOException e) {
            throw new AceException(Messages.STORAGE_EXCEPTION);
        }
    }

    private String taskToString(Task task) {
        String status = task.isDone() ? "1" : "0";

        if (task instanceof Deadline) {
            Deadline deadline = (Deadline) task;
            return "D | " + status
                    + " | " + task.getLabel()
                    + " | " + deadline.getBy();
        }

        if (task instanceof Event) {
            Event event = (Event) task;
            return "E | " + status
                    + " | " + task.getLabel()
                    + " | " + event.getFrom()
                    + " | " + event.getTo();
        }

        return "T | " + status
                + " | " + task.getLabel();
    }

    private Task parseTask(String line) throws AceException {
        String[] parts = line.split("\\s*\\|\\s*", -1);

        if (parts.length < 3) {
            throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
        }

        boolean isDone;

        if (parts[1].equals("1")) {
            isDone = true;
        } else if (parts[1].equals("0")) {
            isDone = false;
        } else {
            throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
        }

        switch (parts[0]) {
            case "T":
                if (parts.length != 3) {
                    throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
                }
                return new Todo(parts[2], isDone);

            case "D":
                if (parts.length != 4) {
                    throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
                }
                return new Deadline(parts[2], parts[3], isDone);

            case "E":
                if (parts.length != 5) {
                    throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
                }
                return new Event(parts[2], parts[3], parts[4], isDone);

            default:
                throw new AceException(Messages.CORRUPTED_DATA_EXCEPTION);
        }
    }
}