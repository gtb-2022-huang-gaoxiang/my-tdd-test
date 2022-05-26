package App;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MarkTaskTest {
    @Before
    public void setUp() throws Exception {
        List<String> initTasksList = List.of(
                "Task001",
                "Task002",
                "Task003",
                "Task004");

        Repository.reset();

        initTasksList.forEach(o -> Repository.addTask(o));
    }

    @Test
    public void should_mark_single_task() {
        var expected = List.of(
                "# To be done",
                "1 Task001",
                "2 Task002",
                "4 Task004",
                "# Completed",
                "3 Task003"
        );
        Repository.markTask(3, true);

        final List<String> taskLines = Repository.getTaskLines();


        Assert.assertEquals(expected, taskLines);
    }
}
