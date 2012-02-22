package RichCoreTest;

import RichColor.RichRedColor;
import RichCore.RichHouse;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseSkyscraperLevel;
import RichHouse.RichHouseVillaLevel;
import junit.framework.TestCase;

public class RichHouseTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);
    private static final RichPoint dummyPoint = new RichPoint(0);


    public void test_should_house_has_no_owner_at_beginning() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertFalse(house.hasOwner());
    }

    public void test_should_return_true_for_can_upgrade_plat() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertTrue(house.canUpgrade());
    }

    public void test_should_return_false_for_can_upgrade_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        assertFalse(house.canUpgrade());
    }

    public void test_upgrade_plat_to_cottage() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(dummyMoney));
        house.upgrade();
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_cannot_upgrade_skyscraper() {
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(dummyMoney));
        house.upgrade();

        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
    }

    public void test_should_return_2000_for_sell_price_of_plat_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(2000), house.getPriceForSell());
    }

    public void test_should_return_4000_for_sell_price_of_cottage_original_price_is_1000() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(new RichMoney(1000)));
        assertEquals(new RichMoney(4000), house.getPriceForSell());
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

    public void test_should_return_0_for_plat_house_without_display() {
        assertEquals("0", new RichHouse(new RichHousePlatLevel(dummyMoney)).display());
    }

    public void test_should_return_1_RED_for_cottage_house_display() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setColor(new RichRedColor());
        player.addHouse(house);

        String expectDisplay = (char) 27 + "[01;31m1" + (char) 27 + "[00;00m";

        assertEquals(expectDisplay, house.display());
    }


    public void test_should_return_plat_after_sell_cottage() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        house.reInitialize();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_plat_after_sell_villa() {
        RichHouse house = new RichHouse(new RichHouseVillaLevel(dummyMoney));
        house.reInitialize();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_plat_house_for_plat_house() {
        RichHouse house1 = new RichHouse(new RichHousePlatLevel(dummyMoney));
        RichHouse house2 = new RichHouse(new RichHousePlatLevel(dummyMoney));
        assertTrue(house1.isSameLevel(house2));
    }

    public void test_should_return_false_for_plat_house_for_cottage_house() {
        RichHouse housePlat = new RichHouse(new RichHousePlatLevel(dummyMoney));
        RichHouse houseCottage = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        assertFalse(housePlat.isSameLevel(houseCottage));
    }
}
