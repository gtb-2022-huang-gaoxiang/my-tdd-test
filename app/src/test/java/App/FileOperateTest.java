package App;

import App.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

public class FileOperateTest {
    @Test public void should_read_tasks_file(){
        FileUtil.createTasksFile();
        Assert.assertEquals("tasks file should exist",true, FileUtil.getTasksFile().exists());
    }
    @Test public void should_delete_tasks_file(){
        FileUtil.createTasksFile();
        FileUtil.deleteTasksFile();
        Assert.assertEquals("tasks file should not exist",false, FileUtil.getTasksFile().exists());

    }

}
