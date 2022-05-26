package App;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class InitTodoTest {
    @Test public void should_init_todo_file(){
        App app = new App();
        File tasksFile = new File(Constants.TASK_FILE_PATH);

        app.main(new String[]{"init"});

        Assert.assertTrue(tasksFile.exists());
    }
}
