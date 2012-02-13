package RIchHouseTest;

import RichHouse.RichHouse;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseCottageLevel;
import junit.framework.TestCase;

public class RichHousePlatLevelTest extends TestCase {
    public void test_should_return_0_for_plat_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        assertEquals("0", house.display());
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }
}
