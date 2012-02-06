import RichGift.PointsGift;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class PointsGiftTest extends TestCase{
    public void test_should_add_200_points_for_open_points_gift() {
        RichPlayer player = new RichPlayer();
        player.acceptGift(new PointsGift());
        assertEquals(200, player.getPoints());
    }
}
