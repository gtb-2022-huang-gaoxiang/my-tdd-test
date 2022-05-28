package App;

import App.commands.ListCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListCommandTest {
    @Test
    public void should_list_tasks_with_id() {
        final var repository = mock(Repository.class);

        final ListCommand command = new ListCommand(repository);

        command.execute();

        verify(repository).list();


    }
}
