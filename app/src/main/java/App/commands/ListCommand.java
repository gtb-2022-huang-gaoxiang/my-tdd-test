package App.commands;

import App.Repository;

public class ListCommand extends BaseCommand{
    public ListCommand(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        getRepository().list();
    }
}
