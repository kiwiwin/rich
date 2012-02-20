package RichCommand;

import RichCore.RichPlayer;
//import RichUtil.RichScheduler;

public class RichRollCommand extends RichCommand {
    private final RichPlayer _player;

    public RichRollCommand(RichPlayer player) {
        _player = player;
    }

    public void executeCommand() {
        int step = (int) Math.ceil(Math.random() * 6);
        _player.forwardSteps(step);
//        RichScheduler.setSwitchPlayer();
    }

    public static String getHelp() {
        return "roll           掷骰子命令，行走1~6步。步数由随即算法产生。";
    }
}
