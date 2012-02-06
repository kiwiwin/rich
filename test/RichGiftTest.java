import junit.framework.TestCase;
import RichGift.*;

public class RichGiftTest extends TestCase {
    public void test_should_return_money_gift_for_rich_gift_create_money_gift(){
        assertTrue(RichGift.createGift(RichGift.MONEY) instanceof MoneyGift);
    }
    
    public void test_should_return_points_gift_for_rich_gift_create_points_gift(){
        assertTrue(RichGift.createGift(RichGift.POINTS) instanceof PointsGift);
    }

    public void test_should_return_god_gift_for_rich_gift_create_god_gift(){
        assertTrue(RichGift.createGift(RichGift.GOD) instanceof GodGift);
    }
}
