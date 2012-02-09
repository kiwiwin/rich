package RichCommand;

import RichPlayer.RichPlayer;

public class RichRollCommand {
    private RichPlayer _player;

    public RichRollCommand(RichPlayer player) {
        _player = player;
    }

    public void executeCommand() {
        int step = (int) Math.ceil(Math.random() * 6);
        _player.stepForward(step);
    }

    public static String getHelp() {
        return "roll           掷骰子命令，行走1~6步。步数由随即算法产生。";
    }
}
