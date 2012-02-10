package RichCommand;

import RichUtil.RichScheduler;

public class RichQuitCommand extends RichCommand {
    public static String getHelp() {
        return "quit           强制退出";
    }

    public void executeCommand() {
        RichScheduler.setSwitchPlayer();
        RichScheduler.exit();
    }
}
