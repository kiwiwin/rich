import junit.framework.TestCase;

import RichHouse.*;

public class RichHouseTest extends TestCase {
    public void test_upgrade_empty_to_cottage() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_should_return_0_for_plat_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        assertEquals("0", house.display());
    }

    public void test_should_return_1_for_cottage_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.upgrade();
        assertEquals("1", house.display());
    }

    public void test_should_return_2_for_villa_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.upgrade();
        house.upgrade();
        assertEquals("2", house.display());
    }

    public void test_should_return_3_for_skyscraper_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.upgrade();
        house.upgrade();
        house.upgrade();
        assertEquals("3", house.display());
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.setLevel(new RichHouseCottageLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
    }

    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
        house.setLevel(new RichHouseVillaLevel(0));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(0));
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

    public void test_should_return_500_for_toll_of_plat_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(500, house.getToll());
    }

    public void test_should_return_1000_for_toll_of_cottage_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(1000, house.getToll());
    }

    public void test_should_return_2000_for_toll_of_villa_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(2000, house.getToll());
    }

    public void test_should_return_400_for_toll_of_skyscraper_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        house.upgrade();
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(4000, house.getToll());
    }

    public void test_should_return_2000_for_sell_price_of_plat_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        assertEquals(2000, house.getPriceForSell());
    }

    public void test_should_return_4000_for_sell_price_of_cottage_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        assertEquals(4000, house.getPriceForSell());
    }

    public void test_should_return_6000_for_sell_price_of_villa_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        house.upgrade();
        assertEquals(6000, house.getPriceForSell());
    }

    public void test_should_return_8000_for_sell_price_of_skyscraper_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        house.upgrade();
        house.upgrade();
        house.upgrade();
        assertEquals(8000, house.getPriceForSell());
    }

    public void test_should_house_has_no_owner_at_beginning() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        assertNull(house.getOwner());
    }
}
