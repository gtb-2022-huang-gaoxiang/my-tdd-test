package App;

public class ListCommand extends BaseCommand{
    public ListCommand(Repository repository) {
        super(repository);
    }

    @Override
    public void execute() {
        getRepository().list();
    }
}
