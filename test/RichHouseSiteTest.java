import RichHouse.RichHouse;
import RichMap.RichHouseSite;
import RichMap.*;
import RichPlayer.RichPlayer;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;

public class RichHouseSiteTest extends RichSiteTest {
    public void test_should_return_player_buy_house() {
        set_input("./test/player_buy_house_input.txt");
        set_output("./test/buy_empty_play_test.txt");

        RichHouse house = new RichHouse(1000);
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertEquals(player, house.getOwner());
        assertEquals(4000, player.getMoney());
        assertTrue(compareFile("./test/note_for_empty_plat_answer.txt", "./test/buy_empty_play_test.txt"));
    }

    public void test_should_return_player_not_buy_house() {
        set_input("./test/player_not_buy_house_input.txt");
        set_output("./test/not_buy_empty_play_test.txt");

        RichHouse house = new RichHouse(1000);
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertEquals(null, house.getOwner());
        assertEquals(5000, player.getMoney());
        assertTrue(compareFile("./test/note_for_empty_plat_answer.txt", "./test/not_buy_empty_play_test.txt"));
    }

    public void test_should_return_player_upgrade_house() {
        set_input("./test/player_upgrade_house_input.txt");
        set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(2000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);
        player.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(3000, player.getMoney());
        assertTrue(compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }


    public void test_should_return_player_not_upgrade_house() {
        set_input("./test/player_not_upgrade_house_input.txt");
        set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(2000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);
        player.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(5000, player.getMoney());
        assertTrue(compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }

    public void test_should_return_player_pay_for_toll() {
        RichHouse house = new RichHouse(2000);
        RichPlayer owner = new RichPlayer();
        owner.addHouse(house);
        owner.setMoney(5000);
        RichPlayer visitor = new RichPlayer();
        visitor.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(visitor);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(6000, owner.getMoney());
        assertEquals(4000, visitor.getMoney());
    }

    public void test_player_move_5_steps_forward_buy_house() {
        set_input("./test/player_not_buy_house_input.txt");

        RichPlayer player = new RichPlayer();
        RichMap map = RichMap.buildMap();
        player.setPosition(new RichSitePosition(map, 0));

        player.setRemainStep(5);
        player.stepForward();

        reset_input();

        assertEquals(5, player.getPosition().getIndex());
    }

}
