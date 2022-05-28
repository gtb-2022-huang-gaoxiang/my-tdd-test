package App;

import App.constant.Constants;
import App.util.FileUtil;
import App.util.FormatUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {

    private static List<Task> getTasks() {
        List<String> lines = FileUtil.getLinesFromFile();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            final String[] split = lines.get(i).split("\\s", 2);
            final String isCompletedTag = split[0];
            final String name = split[1];

            if (Constants.TODO_TAG.equals(isCompletedTag)) {
                tasks.add(new Task(false, name));
            } else {
                tasks.add(new Task(true, name));
            }
        }
        return tasks;
    }

    private static void setTaskState(int id, boolean isCompleted) {
        final List<Task> tasks = getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            if (i + 1 == id) {
                tasks.get(i).setCompleted(isCompleted);
            }
        }

        final List<String> lines = tasks.stream().
                flatMap(task -> Stream.of(task.toString()))
                .collect(Collectors.toList());
        FileUtil.writeLines(lines);
    }

    public void reset() {
        FileUtil.clear();
    }

    public void unmarkTask(int... ids) {
        for (int i = 0; i < ids.length; i++) {
            setTaskState(ids[i], false);
        }
    }

    public void markTask(int... ids) {
        for (int i = 0; i < ids.length; i++) {
            setTaskState(ids[i], true);
        }
    }

    public List<String> getTaskLines() {
        return FormatUtil.getLinesFromTasks(getTasks());
    }

    public void addTask(String name) {
        FileUtil.appendNewLine(new Task(name).toString());
    }

    public void init() {
        File dirFile = new File(Constants.TODO_DIR_PATH);
        File tasksFile = new File(Constants.TASK_FILE_PATH);
        try {
            FileUtil.createFileInDir(dirFile, tasksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        final List<String> line = getTaskLines();
        line.forEach(l -> System.out.println(l));
    }

    public void remove(int... ids) {
        FileUtil.deleteById(ids);
    }
}
