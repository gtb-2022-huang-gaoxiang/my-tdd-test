package App.commands;

import App.Repository;

public abstract class BaseCommand {
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
