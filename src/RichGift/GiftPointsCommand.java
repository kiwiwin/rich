package RichGift;

import RichPlayer.RichPlayer;

public class GiftPointsCommand extends GiftCommand {
    private static final int BONUS_POINTS = 200;
    private RichPlayer _player;

    public GiftPointsCommand(RichPlayer player) {
        _player = player;
    }

    public void executeCommand() {
        _player.addPoints(BONUS_POINTS);
    }
}
