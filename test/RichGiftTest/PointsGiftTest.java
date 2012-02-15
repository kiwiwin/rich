package RichGiftTest;

import RichGift.PointsGift;
import RichPlayer.RichPlayer;
import RichPlayer.RichMoney;
import RichPlayer.RichPoint;
import junit.framework.TestCase;


public class PointsGiftTest extends TestCase{
    private static final RichMoney dummyMoney = new RichMoney(0);


    public void test_should_add_200_points_for_open_points_gift() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.acceptGift(new PointsGift());
        assertEquals(new RichPoint(200), player.getPoints());
    }
}
