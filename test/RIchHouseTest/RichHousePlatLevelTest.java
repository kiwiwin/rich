package RIchHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import junit.framework.TestCase;

public class RichHousePlatLevelTest extends TestCase {
    public void test_should_return_0_for_plat_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(0)));
        assertEquals("0", house.display());
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(0)));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }
}
