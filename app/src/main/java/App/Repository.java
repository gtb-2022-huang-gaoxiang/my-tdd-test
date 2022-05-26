package App;

import App.util.FileUtil;
import App.util.FormatUtil;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> getTaskLines() {
        return FormatUtil.getLinesFromTasks(getTasks());
    }

    private static List<Task> getTasks() {
        List<String> lines = FileUtil.getLinesFromFile();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            final String[] split = lines.get(i).split("\\s", 2);
            final String isCompletedTag = split[0];
            final String name = split[1];

            if (Constants.TODO_TAG.equals(isCompletedTag)) {
                tasks.add(new Task(false,name));
            } else {
                tasks.add(new Task(true, name));
            }
        }
        return tasks;
    }

    public static void addTask(String name) {
        FileUtil.writeNewTask(new Task(name));
    }

    public static void reset() {
        FileUtil.clear();
    }

    public static void markTask(int... ids) {
        for (int i = 0; i < ids.length; i++) {
            setTaskState(ids[i], true);
        }
    }

    private static void setTaskState(int id, boolean isCompleted) {
        final List<Task> tasks = getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            if (i+1 == id){
                tasks.get(i).setCompleted(isCompleted);
            }
        }

        FileUtil.writeNewTasks(tasks);
    }

    public static void unmarkTask(int... ids) {
        for (int i = 0; i < ids.length; i++) {
            setTaskState(ids[i], false);
        }
    }
}
