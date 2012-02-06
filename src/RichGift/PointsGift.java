package RichGift;

import RichPlayer.RichPlayer;

public class PointsGift extends RichGift {
    private static final int GIFT_POINTS = 200;

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addPoints(GIFT_POINTS);
    }
}
