package App;

import App.commands.ListCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListCommandTest {

    private Repository repository;

    @Before
    public void setUp() throws Exception {
        repository = mock(Repository.class);
        when(repository.getAllTasks()).thenReturn(List.of(
                new Task("Task001"),
                new Task("Task002")
        ));
    }

    @Test
    public void should_list_tasks_with_id() {

        final ListCommand command = new ListCommand(repository);

        command.execute();

        verify(repository).list();


    }
}
