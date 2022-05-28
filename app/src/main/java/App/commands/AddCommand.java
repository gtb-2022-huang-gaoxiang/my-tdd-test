package App.commands;

import App.Repository;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AddCommand extends BaseCommand{
    public AddCommand(Repository repository) {
        super(repository);
    }

    public void execute(String... name) {
        getRepository().addTask(Arrays.stream(name).collect(Collectors.joining(" ")));
    }

}
