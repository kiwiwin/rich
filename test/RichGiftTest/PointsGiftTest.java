package RichGiftTest;

import RichGift.PointsGift;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import junit.framework.TestCase;


public class PointsGiftTest extends TestCase{
    public void test_should_add_200_points_for_open_points_gift() {
        RichPlayer player = new RichPlayer();
        player.acceptGift(new PointsGift());
        assertEquals(new RichPoint(200), player.getPoints());
    }
}