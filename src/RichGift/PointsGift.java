package RichGift;

import RichCore.RichGift;
import RichCore.RichPlayer;
import RichCore.RichPoint;

public class PointsGift implements RichGift {
    private static final RichPoint GIFT_POINTS = new RichPoint(200);

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addPoints(GIFT_POINTS);
    }
}
