package App.commands;

public class UnknownCommand extends BaseCommand{
    public UnknownCommand() {
    }

    public void execute(String commandName) {
        System.out.println(String.format("Unknown command: %s!", commandName));
    }

}
