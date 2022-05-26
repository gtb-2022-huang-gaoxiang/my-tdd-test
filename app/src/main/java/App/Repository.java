package App;

import App.util.FileUtil;
import App.util.FormatUtil;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> getTasks() {
        List<String> lines = FileUtil.getLinesFromFile();

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            final String[] split = lines.get(i).split("\\s", 2);
            final String isCompletedTag = split[0];
            final String name = split[1];

            if ("+".equals(isCompletedTag)) {
                tasks.add(new Task(false,name));
            } else {
                tasks.add(new Task(true, name));
            }
        }

        return FormatUtil.getLinesFromTasks(tasks);
    }

    public static void addTask(String name) {
        var task = new Task(name);
        FileUtil.writeNewTask(task);
    }
}
