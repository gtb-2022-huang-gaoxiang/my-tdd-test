package App;

import App.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> getTasks() {
        var lines = FileUtil.getLinesFromFile();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            result.add(String.format("%d %s", i+1, lines.get(i).split("\\s",2)[1]));
        }

        return result;
    }

}
