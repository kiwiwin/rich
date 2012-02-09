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
}
