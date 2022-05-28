package App.util;

import App.constant.Constants;

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

    public static void appendNewLine(String line) {
        appendLine(line);
    }

    private static void appendLine(String line) {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH), StandardOpenOption.APPEND);
            bw.write(line);
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


    public static void deleteById(int... ids) {
        var lines = getLinesFromFile();
        final var idsList = List.of(ids);
        List<String> result = new ArrayList<>();

        lines.stream()
                .filter(l -> idsList.stream().noneMatch(idsShouldDelete -> intsContainIndex(lines.indexOf(l) + 1, idsShouldDelete)))
                .forEach(l -> result.add(l));

        new FileUtil().writeLines(result);
    }

    private static boolean intsContainIndex(int index, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (index == ints[i]) {
                return true;
            }
        }
        return false;
    }

    public static void writeLines(List<String> lines) {
        final BufferedWriter bw;
        try {
            bw = Files.newBufferedWriter(Path.of(Constants.TASK_FILE_PATH));
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
