import RichHouse.HouseBuyCommand;
import RichPlayer.RichPlayer;
import RichHouse.RichHouseSite;
import RichHouse.RichHouse;
import RichHouse.*;

import junit.framework.TestCase;

public class RichHouseSiteTest extends TestCase {
    public void test_should_display_O() {
        RichHouseSite site = new RichHouseSite();
        assertEquals("O", site.display());
    }

    public void test_buy_empty_plat() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(500);
        RichHouseSite site = new RichHouseSite();
        site.setHouse(house);
        RichPlayer player = new RichPlayer();
        player.setMoney(1000);
        HouseBuyCommand command = new HouseBuyCommand(player, site.getHouse());
        site.acceptPlayerCommand(command);

        assertEquals(500, player.getMoney());
        assertEquals(1, player.getHousesNumber());
    }

    public void test_cannot_buy_a_place_already_has_owner() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        RichPlayer owner = new RichPlayer();
        owner.addHouse(house);
        owner.setMoney(1000);
        RichPlayer visitor = new RichPlayer();
        visitor.setMoney(1000);

        RichHouseSite site = new RichHouseSite();
        site.setHouse(house);

        boolean isException = false;
        try {
            site.acceptPlayerCommand(new HouseBuyCommand(visitor, house));
        } catch (HouseOwnerException ex) {
            isException = true;
        }
        assertTrue(isException);

        assertEquals(1000, visitor.getMoney());
        assertEquals(1000, owner.getMoney());

        assertEquals(1, owner.getHousesNumber());
        assertEquals(0, visitor.getHousesNumber());
    }

    public void test_upgrade_site() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite();
        site.acceptPlayerCommand(new HouseUpgradeCommand(player, house));

        assertEquals(1, player.getHousesNumber());
        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
    }

    public void test_go_through_other_player_site() {
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);
        RichPlayer owner = new RichPlayer();
        owner.addHouse(house);
        owner.setMoney(1000);
        RichPlayer visitor = new RichPlayer();
        visitor.setMoney(1000);

        RichHouseSite site = new RichHouseSite();
        site.setHouse(house);

        site.acceptPlayerCommand(new HouseVisitCommand(visitor, house));


        assertEquals(1500, owner.getMoney());
        assertEquals(500, visitor.getMoney());
    }
}
