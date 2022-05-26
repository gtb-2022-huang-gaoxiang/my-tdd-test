package App;

import org.junit.Assert;
import org.junit.Test;

public class AddTaskTest {
    @Test public void should_add_single_word_task(){
        String taskName = new App().run("add", "task001");
        Assert.assertEquals("task001", taskName);
    }

}
