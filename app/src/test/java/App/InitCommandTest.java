package App;

import App.commands.InitCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InitCommandTest {
    @Test
    public void should_init_tasks_file() {
        final var repository = mock(Repository.class);

        final InitCommand command = new InitCommand(repository);

        command.execute();

        verify(repository).init();


    }
}
