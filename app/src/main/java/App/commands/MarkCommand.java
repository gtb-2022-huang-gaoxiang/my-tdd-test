package App.commands;

import App.Repository;

public class MarkCommand extends BaseCommand{
    public MarkCommand(Repository repository) {
        super(repository);
    }

    public void execute(int... id) {
        getRepository().markTask(id);
    }
}
