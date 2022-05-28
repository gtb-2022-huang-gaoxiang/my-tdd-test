package App;

public class RemoveCommand extends BaseCommand{
    public RemoveCommand(Repository repository) {
        super(repository);
    }

    public void execute(int... ids) {
        getRepository().remove(ids);
    }
}
