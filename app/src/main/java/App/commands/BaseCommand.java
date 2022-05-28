package App.commands;

import App.Repository;

public class BaseCommand {
    private Repository repository;

    public BaseCommand(Repository repository) {
        this.repository = repository;
    }

    public void execute() {
    }

    public Repository getRepository() {
        return repository;
    }

}
