package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import junit.framework.TestCase;

public class RichHousePlatLevelTest extends TestCase {
    private final RichMoney dummyMoney = null;

    public void test_upgrade_plat_to_cottage() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
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
        assertTrue(new RichHousePlatLevel(dummyMoney).isSameLevel(new RichHousePlatLevel(dummyMoney)));
    }

    public void test_should_return_false_for_plat_and_cottage_is_same_level() {
        assertFalse(new RichHousePlatLevel(dummyMoney).isSameLevel(new RichHouseCottageLevel(dummyMoney)));
    }

    public void test_should_return_0_for_plat_house_display() {
        assertEquals("0", new RichHousePlatLevel(dummyMoney).display());
    }

    public void test_should_return_plat_after_sell_plat() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        house.reInitialize();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_plat() {
        assertTrue(new RichHousePlatLevel(null).canUpgrade());
    }
}
