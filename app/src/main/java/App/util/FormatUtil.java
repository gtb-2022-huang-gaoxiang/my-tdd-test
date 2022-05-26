package App.util;

import App.Constants;
import App.Task;

import java.util.ArrayList;
import java.util.List;

public class FormatUtil {

    public static String formatLine(int id, String name) {
        return String.format("%d %s", id, name);
    }


    public static List<String> getLinesFromTasks(List<Task> tasks) {
        List<String> tbdList = new ArrayList<>();
        List<String> completedList = new ArrayList<>();
        tbdList.add("# To be done");
        completedList.add("# Completed");

        for (int i = 0; i < tasks.size(); i++) {
            var t = tasks.get(i);
            var line = formatLine(i+1, t.getName());

            if (t.isCompleted()){
                completedList.add(line);
            }else {
                tbdList.add(line);
            }
        }

        if (tbdList.size() == 1){
            tbdList.add(Constants.EMPTY);
        }
        if (completedList.size() == 1){
            completedList.add(Constants.EMPTY);
        }
        tbdList.addAll(completedList);
        return tbdList;
    }
}
