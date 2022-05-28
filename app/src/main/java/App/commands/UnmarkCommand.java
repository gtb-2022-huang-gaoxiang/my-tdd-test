package App.commands;

import App.Repository;

public class UnmarkCommand extends BaseCommand{
    public UnmarkCommand(Repository repository) {
        super(repository);
    }

    public void execute(int... ids) {
        getRepository().unmarkTask(ids);
    }
}
