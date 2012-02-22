package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseSkyscraperLevel;
import RichHouse.RichHouseVillaLevel;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RichHouseVillaLevelTest extends TestCase {
    private final RichMoney dummyMoney = null;

    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_should_return_3000_for_get_price_villa_original_price_is_1000() {
        Assert.assertEquals(new RichMoney(3000), new RichHouseVillaLevel(new RichMoney(1000)).getPrice());
    }

    public void test_should_return_8000_for_get_toll_villa_original_price_is_4000() {
        Assert.assertEquals(new RichMoney(8000), new RichHouseVillaLevel(new RichMoney(4000)).getToll());
    }

    public void test_should_return_true_for_villa_is_same_level() {
        assertTrue(new RichHouseVillaLevel(dummyMoney).isSameLevel(new RichHouseVillaLevel(dummyMoney)));
    }

    public void test_should_return_false_for_villa_skyscraper_is_same_level() {
        assertFalse(new RichHouseVillaLevel(dummyMoney).isSameLevel(new RichHouseSkyscraperLevel(dummyMoney)));
    }

    public void test_should_return_2_for_plat_house_display() {
        Assert.assertEquals("2", new RichHouseVillaLevel(dummyMoney).display());
    }

    public void test_should_return_plat_after_sell_villa() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        house.reInitialize();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_villa() {
        assertTrue(new RichHouseVillaLevel(null).canUpgrade());
    }
}
