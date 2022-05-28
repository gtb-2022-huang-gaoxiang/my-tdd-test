package App.util;

import App.Constants;
import App.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void createFileInDir(File dir, File file) throws IOException {
        dir.mkdirs();
        if (file.createNewFile()) {
            System.out.println(Constants.STR_INIT_SUCCESSFULLY);
        }
    }

    public static List<String> getLinesFromFile() {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(Constants.TASK_FILE_PATH), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void writeNewTasks(List<Task> tasks) {
        writeTasks(tasks);
    }

    private static void writeTasks(List<Task> tasks) {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH));
            for (Task t : tasks) {
                bw.write(t.toString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendNewTask(Task task) {
        appendTask(task);
    }

    private static void appendTask(Task task) {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH), StandardOpenOption.APPEND);
            bw.write(task.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH));
            bw.write("");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
