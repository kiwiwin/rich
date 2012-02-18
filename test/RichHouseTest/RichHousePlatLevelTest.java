package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import junit.framework.TestCase;

public class RichHousePlatLevelTest extends TestCase {
    public void test_upgrade_plat_to_cottage() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(null));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_should_return_1000_for_get_price_plat_original_price_is_1000() {
        assertEquals(new RichMoney(1000), new RichHousePlatLevel(new RichMoney(1000)).getPrice());
    }

    public void test_should_return_2000_for_get_toll_plat_original_price_is_4000() {
        assertEquals(new RichMoney(2000), new RichHousePlatLevel(new RichMoney(4000)).getToll());
    }

    public void test_should_return_true_for_plat_is_same_level() {
        assertTrue(new RichHousePlatLevel(null).isSameLevel(new RichHousePlatLevel(null)));
    }

    public void test_should_return_0_for_plat_house_display() {
        RichHousePlatLevel platLevel = new RichHousePlatLevel(null);
        assertEquals("0", platLevel.display());
    }

    public void test_should_return_plat_after_sell_plat() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(null));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_plat() {
        assertTrue(new RichHousePlatLevel(null).canUpgrade());
    }
}
