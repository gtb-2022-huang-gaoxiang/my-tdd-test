package App;

import App.commands.RemoveCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class RemoveCommandTest {

    private Repository repository;

    @Before
    public void setUp() throws Exception {
        repository = mock(Repository.class);
    }

    @Test
    public void should_remove_single_word_task() {
        final var id = 1;
        final RemoveCommand removeCommand = new RemoveCommand(repository);

        removeCommand.execute(id);

        verify(repository).remove(1);
    }
    @Test
    public void should_add_multiple_word_task() {
        final var ids = new int[]{1,2,3};
        final RemoveCommand command = new RemoveCommand(repository);

        for (int i = 0; i < ids.length; i++) {
            command.execute(ids[i]);
        }

        InOrder inOrder = inOrder(repository);

        inOrder.verify(repository).remove(1);
        inOrder.verify(repository).remove(2);
        inOrder.verify(repository).remove(3);

    }
}
