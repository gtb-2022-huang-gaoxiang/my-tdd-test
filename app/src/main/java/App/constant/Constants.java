package App.constant;

import java.io.File;

public class Constants {

    public static final String STR_INIT_SUCCESSFULLY = "Initialize successfully";
    public static final String TODO_TAG = "+";
    public static final String EMPTY = "Empty";
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String SEPARATOR = File.separator;
    public static final String TODO_DIR_PATH = USER_HOME_PATH + SEPARATOR +  ".todo";
    public static final String TASK_FILE_PATH = TODO_DIR_PATH + SEPARATOR + "tasks";
}
