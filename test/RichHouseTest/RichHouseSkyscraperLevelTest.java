package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseSkyscraperLevel;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RichHouseSkyscraperLevelTest extends TestCase {
    private final RichMoney dummyMoney = null;

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_should_return_4000_for_get_price_skyscraper_original_price_is_1000() {
        Assert.assertEquals(new RichMoney(4000), new RichHouseSkyscraperLevel(new RichMoney(1000)).getPrice());
    }

    public void test_should_return_16000_for_get_toll_skyscraper_original_price_is_4000() {
        Assert.assertEquals(new RichMoney(16000), new RichHouseSkyscraperLevel(new RichMoney(4000)).getToll());
    }

    public void test_should_return_true_for_skyscraper_is_same_level() {
        assertTrue(new RichHouseSkyscraperLevel(dummyMoney).isSameLevel(new RichHouseSkyscraperLevel(dummyMoney)));
    }

    public void test_should_return_false_for_skyscraper_plat_is_same_level() {
        assertFalse(new RichHouseSkyscraperLevel(dummyMoney).isSameLevel(new RichHousePlatLevel(dummyMoney)));
    }

    public void test_should_return_3_for_plat_house_display() {
        Assert.assertEquals("3", new RichHouseSkyscraperLevel(dummyMoney).display());
    }

    public void test_should_return_plat_after_sell_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_false_for_can_upgrade_skyscraper() {
        assertFalse(new RichHouseSkyscraperLevel(dummyMoney).canUpgrade());
    }
}
