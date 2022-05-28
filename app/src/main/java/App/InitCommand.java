package App;

public class InitCommand extends BaseCommand{
    public InitCommand(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        getRepository().init();
    }
}
