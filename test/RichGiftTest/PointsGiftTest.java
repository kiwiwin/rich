package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichGift.PointsGift;
import junit.framework.TestCase;


public class PointsGiftTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);


    public void test_should_add_200_points_for_open_points_gift() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        PointsGift pointsGift = new PointsGift();
        pointsGift.openGift(player);
        assertEquals(new RichPoint(200), player.getPoints());
    }
}
