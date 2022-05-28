package App;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class AddCommandTest {

    private Repository repository;

    @Before
    public void setUp() throws Exception {
        repository = mock(Repository.class);
    }

    @Test
    public void should_add_single_word_task() {
        final var name = "Task001";

        final AddCommand command = new AddCommand(repository);

        command.execute(name);

        verify(repository).addTask(name);
    }
    @Test
    public void should_add_multiple_word_task() {
        final var names = new String[]{"Task001", "Task002", "Task003"};
        final AddCommand command = new AddCommand(repository);

        Arrays.stream(names).forEach(s -> {
            command.execute(s);
        });

        InOrder inOrder = inOrder(repository);

        inOrder.verify(repository).addTask(names[0]);
        inOrder.verify(repository).addTask(names[1]);
        inOrder.verify(repository).addTask(names[2]);

    }
}
