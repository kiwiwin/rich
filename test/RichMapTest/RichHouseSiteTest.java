package RichMapTest;

import RichHouse.RichHouse;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichMap.RichHouseSite;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import TestHelper.RedirectIO;
import junit.framework.TestCase;

public class RichHouseSiteTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_should_return_player_buy_house() {
        RedirectIO.set_input("./test/player_buy_house_input.txt");
        RedirectIO.set_output("./test/buy_empty_play_test.txt");

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer(new RichMoney(5000), null);
        site.doAcceptPlayer(player);

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertEquals(player, house.getOwner());
        assertEquals(new RichMoney(4000), player.getMoney());
        assertTrue(RedirectIO.compareFile("./test/note_for_empty_plat_answer.txt", "./test/buy_empty_play_test.txt"));
    }

    public void test_should_return_player_not_buy_house() {
        RedirectIO.set_input("./test/player_not_buy_house_input.txt");
        RedirectIO.set_output("./test/not_buy_empty_play_test.txt");

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer(new RichMoney(5000), null);
        site.doAcceptPlayer(player);

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertEquals(null, house.getOwner());
        assertEquals(new RichMoney(5000), player.getMoney());
        assertTrue(RedirectIO.compareFile("./test/note_for_empty_plat_answer.txt", "./test/not_buy_empty_play_test.txt"));
    }

    public void test_should_return_player_upgrade_house() {
        RedirectIO.set_input("./test/player_upgrade_house_input.txt");
        RedirectIO.set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(2000)));
        RichPlayer player = new RichPlayer(new RichMoney(5000), null);
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(house);
        site.doAcceptPlayer(player);

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(new RichMoney(3000), player.getMoney());
        assertTrue(RedirectIO.compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }


    public void test_should_return_player_not_upgrade_house() {
        RedirectIO.set_input("./test/player_not_upgrade_house_input.txt");
        RedirectIO.set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(2000)));
        RichPlayer player = new RichPlayer(new RichMoney(5000), null);
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(house);
        site.doAcceptPlayer(player);

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(new RichMoney(5000), player.getMoney());
        assertTrue(RedirectIO.compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }

    public void test_should_return_player_pay_for_toll() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(2000)));
        RichPlayer owner = new RichPlayer(new RichMoney(5000), null);
        owner.addHouse(house);
        RichPlayer visitor = new RichPlayer(new RichMoney(5000), null);

        RichHouseSite site = new RichHouseSite(house);
        site.doAcceptPlayer(visitor);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(new RichMoney(6000), owner.getMoney());
        assertEquals(new RichMoney(4000), visitor.getMoney());
    }

    public void test_player_move_5_steps_forward_buy_house() {
        RedirectIO.set_input("./test/player_not_buy_house_input.txt");

        RichPlayer player = new RichPlayer(dummyMoney, null);
        RichMap map = RichMap.buildMap();
        player.setPosition(new RichSitePosition(map, 0));

        player.stepForward(5);

        RedirectIO.reset_input();

        assertEquals(5, player.getPosition().getIndex());
    }

    public void test_should_return_0_for_toll_of_plat_original_price_is_1000_if_house_owner_is_at_prison_or_hospital() {
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer owner = new RichPlayer(dummyMoney, null);
        owner.setPunishDays(3);
        owner.addHouse(house);
        house.setOwner(owner);

        RichPlayer visitor = new RichPlayer(dummyMoney, null);
        site.acceptPlayer(visitor);

        assertEquals(new RichMoney(0), owner.getMoney());
        assertEquals(new RichMoney(0), visitor.getMoney());
    }

    public void test_should_return_0_for_toll_of_plat_original_price_is_1000_if_visitor_has_blessing_god() {
        RedirectIO.set_output("./test/player_has_blessing_god_test.txt");

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer owner = new RichPlayer(dummyMoney, null);
        owner.addHouse(house);
        house.setOwner(owner);

        RichPlayer visitor = new RichPlayer(dummyMoney, null);
        visitor.setBlessingGod();
        site.acceptPlayer(visitor);

        RedirectIO.reset_output();

        assertEquals(new RichMoney(0), owner.getMoney());
        assertEquals(new RichMoney(0), visitor.getMoney());

        assertTrue(RedirectIO.compareFile("./test/player_has_blessing_god_answer.txt", "./test/player_has_blessing_god_test.txt"));
    }
}
