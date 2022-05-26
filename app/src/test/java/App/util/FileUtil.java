package App.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final String SEPARATOR = File.separator;
    private static final String TODO_DIR_STR = System.getProperty("user.home");
    private static final String DIR_NAME = ".todo";
    private static final String FILE_NAME = "tasks";

    public static File getTasksFile() {
        return Paths.get(TODO_DIR_STR, DIR_NAME, FILE_NAME).toFile();
    }

    private static File getTodoDir() {
        return Paths.get(TODO_DIR_STR, DIR_NAME).toFile();
    }

    public static void createTasksFile() {
        var f = getTasksFile();
        var dir = getTodoDir();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTasksFile() {
        getTasksFile().delete();
    }
}
