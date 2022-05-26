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
        Repository.markTask(3);

        final List<String> taskLines = Repository.getTaskLines();


        Assert.assertEquals(expected, taskLines);
    }

    @Test
    public void should_mark_multiply_tasks(){
        var expected = List.of(
                "# To be done",
                "1 Task001",
                "# Completed",
                "2 Task002",
                "3 Task003",
                "4 Task004"
        );
        Repository.markTask(2,3,4);

        final List<String> taskLines = Repository.getTaskLines();


        Assert.assertEquals(expected, taskLines);

    }

    @Test
    public void should_unmark_single_tasks(){
        var expected = List.of(
                "# To be done",
                "1 Task001",
                "2 Task002",
                "# Completed",
                "3 Task003",
                "4 Task004"
        );
        Repository.markTask(2,3,4);
        Repository.unmarkTask(2);


        final List<String> taskLines = Repository.getTaskLines();


        Assert.assertEquals(expected, taskLines);

    }
}
