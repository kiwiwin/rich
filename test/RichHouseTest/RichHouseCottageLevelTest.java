package RichHouseTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseVillaLevel;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RichHouseCottageLevelTest extends TestCase {
    private final RichMoney dummyMoney = null;

    public void test_upgrade_cottage_to_villa() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
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
        assertTrue(new RichHouseCottageLevel(dummyMoney).isSameLevel(new RichHouseCottageLevel(dummyMoney)));
    }

    public void test_should_return_false_for_cottage_villa_is_same_level() {
        assertFalse(new RichHouseCottageLevel(dummyMoney).isSameLevel(new RichHouseVillaLevel(dummyMoney)));
    }

    public void test_should_return_1_for_cottage_house_display() {
        assertEquals("1", new RichHouseCottageLevel(dummyMoney).display());
    }

    public void test_should_return_plat_after_sell_cottage() {
        RichHouse house = new RichHouse(new RichHouseCottageLevel(dummyMoney));
        house.sell();
        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_should_return_true_for_can_upgrade_cottage() {
        assertTrue(new RichHouseCottageLevel(dummyMoney).canUpgrade());
    }
}
