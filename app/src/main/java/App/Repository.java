package App;

import App.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> getTasks() {
        var lines = FileUtil.getLinesFromFile();
        List<String> tbdList = new ArrayList<>();
        List<String> completedList = new ArrayList<>();

        tbdList.add("# To be done");
        completedList.add("# Completed");

        for (int i = 0; i < lines.size(); i++) {
            final String[] split = lines.get(i).split("\\s", 2);
            final String isCompletedTag = split[0];
            final String name = split[1];

            if ("+".equals(isCompletedTag)){
                tbdList.add(String.format("%d %s", i+1, name));
            }else {
                completedList.add(String.format("%d %s", i+1, name));
            }
        }

        tbdList.addAll(completedList);
        return tbdList;
    }

}
