package RichGiftTest;

import RichGift.BlessingGodGift;
import RichGift.MoneyGift;
import RichGift.PointsGift;
import RichGift.RichGiftDefaultFactory;
import junit.framework.TestCase;

public class RichGiftDefaultFactoryTest extends TestCase {
    public void test_should_return_money_gift_for_rich_gift_create_money_gift() {
        assertTrue(new RichGiftDefaultFactory().createGift("1") instanceof MoneyGift);
    }

    public void test_should_return_points_gift_for_rich_gift_create_points_gift() {
        assertTrue(new RichGiftDefaultFactory().createGift("2") instanceof PointsGift);
    }

    public void test_should_return_god_gift_for_rich_gift_create_god_gift() {
        assertTrue(new RichGiftDefaultFactory().createGift("3") instanceof BlessingGodGift);
    }

    public void test_should_return_illegal_argument_exception_for_create_invalid_gift() {
        try {
            new RichGiftDefaultFactory().createGift("invalid gift");
            fail("there should have an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid gift type", e.getMessage());
        }
    }

    public void test_should_return_illegal_argument_exception_for_input_100() {
        try {
            new RichGiftDefaultFactory().createGift("100");
            fail("there should have an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid gift type", e.getMessage());
        }
    }
}
