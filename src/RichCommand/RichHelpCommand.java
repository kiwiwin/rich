package RichCommand;

public class RichHelpCommand {
    public void executeCommand() {
        String result = "命令一览表\n";
        result += RichRollCommand.getHelp() + "\n";
        result += RichBlockCommand.getHelp() + "\n";
        result += RichBombCommand.getHelp() + "\n";
        result += RichRobotCommand.getHelp() + "\n";
        result += RichSellHouseCommand.getHelp() + "\n";
        result += RichSellToolCommand.getHelp() + "\n";
        result += RichQueryCommand.getHelp() + "\n";
        result += RichHelpCommand.getHelp() + "\n";
        result += RichQuitCommand.getHelp();
        System.out.println(result);
    }

    private static String getHelp() {
        return "help          查看命令帮助";
    }
}
