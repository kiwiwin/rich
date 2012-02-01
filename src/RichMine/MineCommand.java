package RichMine;

import RichPlayer.RichPlayer;

public class MineCommand {
    private RichPlayer _player;
    private int _bonusPoints;
    public MineCommand(RichPlayer player, int bonusPoints) {
         _player = player;
        _bonusPoints = bonusPoints;
    }

    public void executeCommand() {
        _player.addPoints(_bonusPoints);
    }
}
