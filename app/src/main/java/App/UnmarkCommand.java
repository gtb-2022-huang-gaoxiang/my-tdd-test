package App;

public class UnmarkCommand extends BaseCommand{
    public UnmarkCommand(Repository repository) {
        super(repository);
    }

    public void execute(int... ids) {
        getRepository().unmarkTask(ids);
    }
}
