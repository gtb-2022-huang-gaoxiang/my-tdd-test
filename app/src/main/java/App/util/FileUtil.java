package App.util;

import App.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtil {

    public static void createFileInDir(File dir, File file) throws IOException {
        dir.mkdirs();
        if (file.createNewFile()) {
            System.out.println(Constants.STR_INIT_SUCCESSFULLY);
        }
    }

    public static List<String> getTasks() {
        try {
            return Files.readAllLines(Path.of(Constants.TASK_FILE_PATH), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
