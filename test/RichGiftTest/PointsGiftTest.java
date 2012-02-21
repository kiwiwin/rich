package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichGift.PointsGift;
import junit.framework.TestCase;


public class PointsGiftTest extends TestCase {
    private static RichMoney dummyMoney = null;

    public void test_should_add_200_points_for_open_points_gift() {
        RichPoint pointBeforeOpen = new RichPoint(0);
        RichPlayer player = new RichPlayer(dummyMoney, pointBeforeOpen);

        PointsGift pointsGift = new PointsGift();
        pointsGift.openGift(player);

        RichPoint expectPointAfterOpen = pointBeforeOpen.add(new RichPoint(200));

        assertEquals(expectPointAfterOpen, player.getPoints());
    }
}
