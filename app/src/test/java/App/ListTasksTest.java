package App;

import App.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ListTasksTest {
    @Test
    public void should_list_original_text_of_tasks() {
        final List<String> tasks = FileUtil.getTasks();

        var expected = List.of(
                "+ Task001",
                "+ Task002",
                "* Task003",
                "* Task004");

        Assert.assertEquals(expected, tasks);
    }
}
