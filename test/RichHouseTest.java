import junit.framework.TestCase;

import RichHouse.*;

public class RichHouseTest extends TestCase {
    public void test_upgrade_empty_to_cottage() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHousePlatLevel());
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseCottageLevel());
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
    }

    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseVillaLevel());
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseSkyscraperLevel());
        boolean isException = false;
        try {
            house.upgrade();
        } catch (HouseLevelOverflowException ex) {
            assertEquals("You cannot upgrade skyscraper", ex.getMessage());
            isException = true;
        }

        assertTrue(isException);
    }
}
