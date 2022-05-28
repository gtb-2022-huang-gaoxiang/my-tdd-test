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
import java.util.stream.Collectors;

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
        writeLines(tasks.stream().map(t -> t.toString()).collect(Collectors.toList()));
    }

    private static void writeLines(List<String> lines) {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH));
            for(String l: lines){
                bw.write(l);
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


    public static void deleteById(int[] ids) {
        var lines = getLinesFromFile();
        List<String> newLines = new ArrayList<>();
        int index;

        int lineLength = lines.toArray().length;
        for (int i = 0; i < ids.length; i++) {
            index = ids[i] - 1;
            if (!validIndex(index, lineLength)){
                newLines.add(lines.get(index));
            }
        }

        writeLines(newLines);
    }

    private static boolean validIndex(int index, int lineLength) {
        return lineLength > index && index >= 0;
    }
}
