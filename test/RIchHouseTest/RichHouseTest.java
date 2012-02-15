package RIchHouseTest;

import RichPlayer.RichMoney;
import junit.framework.TestCase;

import RichHouse.*;

public class RichHouseTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);
    
    public void test_should_return_0_for_plat_house_display() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertEquals("0", house.display());
    }

    public void test_should_return_1_for_cottage_house_display() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        assertEquals("1", house.display());
    }

    public void test_should_return_2_for_villa_house_display() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        assertEquals("2", house.display());
    }

    public void test_should_return_3_for_skyscraper_house_display() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        assertEquals("3", house.display());
    }
    
    public void test_should_return_true_for_can_upgrade_plat(){
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertTrue(house.canUpgrade());
    }
    
    public void test_should_return_true_for_can_upgrade_cottage(){
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        assertTrue(house.canUpgrade());
    }
    
    public void test_should_return_true_for_can_upgrade_villa(){
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        assertTrue(house.canUpgrade());
    }
    
    public void test_should_return_false_for_can_upgrade_skyscraper(){
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        assertFalse(house.canUpgrade());
    }

    public void test_upgrade_empty_to_cottage() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
    }

    public void test_upgrade_villa_to_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        try {
            house.upgrade();
            fail("there should have an exception: not update skyscraper") ;
        } catch (HouseLevelOverflowException ex) {
            assertEquals("You cannot upgrade skyscraper", ex.getMessage());
        }

    }

    public void test_should_return_plat_after_sell_plat() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_plat_after_sell_cottage() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_plat_after_sell_villa() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_plat_after_sell_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_500_for_toll_of_plat_original_price_is_1000() {
        RichMoney originalHousePrice = new RichMoney(1000);
        
        RichHouse house = new RichHouse(new RichHousePlatLevel(originalHousePrice));

        RichMoney expectTollPrice = originalHousePrice.divide(2);
        
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(expectTollPrice, house.getToll());
    }

    public void test_should_return_1000_for_toll_of_cottage_original_price_is_1000() {
        RichMoney originalHousePrice = new RichMoney(1000);
        
        RichHouse house = new RichHouse(new RichHouseCottageLevel(originalHousePrice));

        RichMoney expectTollPrice = originalHousePrice.divide(2).times(2);
        
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(expectTollPrice, house.getToll());
    }

    public void test_should_return_2000_for_toll_of_villa_original_price_is_1000() {
        RichMoney originalHousePrice = new RichMoney(1000);
        
        RichHouse house = new RichHouse(new RichHouseVillaLevel(originalHousePrice));

        RichMoney expectTollPrice = originalHousePrice.divide(2).times(2).times(2);
        
        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(expectTollPrice, house.getToll());
    }

    public void test_should_return_4000_for_toll_of_skyscraper_original_price_is_1000() {
        RichMoney originalHousePrice = new RichMoney(1000);

        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(originalHousePrice));

        RichMoney expectTollPrice = originalHousePrice.divide(2).times(2).times(2).times(2);

        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(expectTollPrice, house.getToll());
    }

    public void test_should_return_2000_for_sell_price_of_plat_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(2000), house.getPriceForSell());
    }

    public void test_should_return_4000_for_sell_price_of_cottage_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(4000), house.getPriceForSell());
    }

    public void test_should_return_6000_for_sell_price_of_villa_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(6000), house.getPriceForSell());
    }

    public void test_should_return_8000_for_sell_price_of_skyscraper_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(8000), house.getPriceForSell());
    }

    public void test_should_house_has_no_owner_at_beginning() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertFalse(house.hasOwner());
    }
}
