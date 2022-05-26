package App;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ListTasksTest {
    @Test
    public void should_list_tasks_with_id() {
        final List<String> tasks = Repository.getTasks();

        var expected = List.of(
                "# To be done",
                "1 Task001",
                "2 Task002",
                "# Completed",
                "3 Task003",
                "4 Task004");

        Assert.assertEquals(expected, tasks);
    }
}
