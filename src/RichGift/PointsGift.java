package RichGift;

import RichMap.RichGift;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;

public class PointsGift extends RichGift {
    private static final RichPoint GIFT_POINTS = new RichPoint(200);

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addPoints(GIFT_POINTS);
    }
}
