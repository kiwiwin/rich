package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.*;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RichHouseVillaLevelTest extends TestCase {
    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(null));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_should_return_3000_for_get_price_villa_original_price_is_1000() {
        Assert.assertEquals(new RichMoney(3000), new RichHouseVillaLevel(new RichMoney(1000)).getPrice());
    }

    public void test_should_return_8000_for_get_toll_villa_original_price_is_4000() {
        Assert.assertEquals(new RichMoney(8000), new RichHouseVillaLevel(new RichMoney(4000)).getToll());
    }

    public void test_should_return_true_for_plat_is_same_level() {
        assertTrue(new RichHouseVillaLevel(null).isSameLevel(new RichHouseVillaLevel(null)));
    }

    public void test_should_return_2_for_plat_house_display() {
        RichHouseVillaLevel platLevel = new RichHouseVillaLevel(null);
        Assert.assertEquals("2", platLevel.display());
    }

    public void test_should_return_plat_after_sell_villa() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(null));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_villa() {
        assertTrue(new RichHouseVillaLevel(null).canUpgrade());
    }
}
