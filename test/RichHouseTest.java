import junit.framework.TestCase;

import RichHouse.*;

public class RichHouseTest extends TestCase {
    public void test_upgrade_empty_to_cottage() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHousePlatLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseCottageLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
    }

    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseVillaLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseSkyscraperLevel(0));
        boolean isException = false;
        try {
            house.upgrade();
        } catch (HouseLevelOverflowException ex) {
            assertEquals("You cannot upgrade skyscraper", ex.getMessage());
            isException = true;
        }

        assertTrue(isException);
    }

    public void test_plat_toll() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(500, house.getToll());
    }

    public void test_cottage_toll() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(1000, house.getToll());
    }

    public void test_villa_toll() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        house.upgrade();
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(2000, house.getToll());
    }
    
    public void test_skyscraper_toll() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        house.upgrade();
        house.upgrade();
        house.upgrade();
        assertTrue(house.getLevel() instanceof  RichHouseSkyscraperLevel);
        assertEquals(4000, house.getToll());
    }
}
