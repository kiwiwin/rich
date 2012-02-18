package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.*;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RichHouseCottageLevelTest extends TestCase {
    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(null));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
    }

    public void test_should_return_2000_for_get_price_cottage_original_price_is_1000() {
        Assert.assertEquals(new RichMoney(2000), new RichHouseCottageLevel(new RichMoney(1000)).getPrice());
    }

    public void test_should_return_4000_for_get_toll_cottage_original_price_is_4000() {
        Assert.assertEquals(new RichMoney(4000), new RichHouseCottageLevel(new RichMoney(4000)).getToll());
    }

    public void test_should_return_true_for_cottage_is_same_level() {
        assertTrue(new RichHouseCottageLevel(null).isSameLevel(new RichHouseCottageLevel(null)));
    }

    public void test_should_return_1_for_cottage_house_display() {
        RichHouseCottageLevel cottageLevel = new RichHouseCottageLevel(null);
        Assert.assertEquals("1", cottageLevel.display());
    }

    public void test_should_return_plat_after_sell_cottage() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(null));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_cottage() {
        assertTrue(new RichHouseCottageLevel(null).canUpgrade());
    }
}
