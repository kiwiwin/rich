package RichCoreTest;

import RichCommandTest.RichDummyMapBuilder;
import RichCore.*;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichHouse.RichHouseSkyscraperLevel;
import RichHouse.RichHouseVillaLevel;
import RichTool.BombTool;
import RichTool.RoadBlockTool;
import RichTool.RobotTool;
import RichSite.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

import RichColor.*;

public class RichPlayerTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer(dummyMoney, new RichPoint(100000));

        for (int i = 0; i < 10; i++) {
            richPlayer.buyTool(new RoadBlockTool());
        }

        try {
            richPlayer.buyTool(new RoadBlockTool());
            fail("there should have an exception: Each player cannot have more than 10 tools");
        } catch (ToolOverflowException ex) {
            assertEquals("Each player cannot have more than 10 tools", ex.getMessage());
        }
        assertEquals(new RichPoint(99500), richPlayer.getPoints());
    }

    public void test_player_has_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(100));
        player.buyTool(new RoadBlockTool());

        assertEquals(new RichPoint(50), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(30));
        try {
            player.buyTool(new RoadBlockTool());
            fail("there should have an exception: 您当前剩余的点数为30， 不足以购买路障道具.");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为30， 不足以购买路障道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(30), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        player.addTool(new RoadBlockTool());
        assertEquals(1, player.getToolsNumber());

        player.sellTool(new RoadBlockTool());

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(50), player.getPoints());
    }

    public void test_player_has_not_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(new RoadBlockTool());
            fail("there should have an exception: You don't have 路障");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 路障", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_roadblock_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(new RoadBlockTool());

        assertEquals(1, player.getToolsNumber());

        player.useTool(new RoadBlockTool());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_roadblock_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(new RoadBlockTool());
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 路障", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(100));
        player.buyTool(new RobotTool());

        assertEquals(new RichPoint(70), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(20));
        try {
            player.buyTool(new RobotTool());
            fail("there should have an exception");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为20， 不足以购买机器娃娃道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(20), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_robot_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        player.addTool(new RobotTool());
        assertEquals(1, player.getToolsNumber());

        player.sellTool(new RobotTool());

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(30), player.getPoints());
    }

    public void test_player_has_not_enough_robot_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(new RobotTool());
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_bomb_use_tool_null() {
        RichPlayer player = new RichPlayer(null, null);
        try {
            player.addTool(new BombTool());
            player.useTool(null);
            fail();
        } catch (Exception ex) {

        }
    }

    public void test_player_has_null_sell_tool_null() {
        RichPlayer player = new RichPlayer(null, null);
        try {
            player.addTool(null);
            player.sellTool(null);
            fail();
        } catch (Exception ex) {

        }
    }

    public void test_player_has_robot_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(new RobotTool());

        assertEquals(1, player.getToolsNumber());

        player.useTool(new RobotTool());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_robot_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(new RobotTool());
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(100));
        player.buyTool(new BombTool());

        assertEquals(new RichPoint(50), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(20));
        try {
            player.buyTool(new BombTool());
            fail("there should have an exception");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为20， 不足以购买炸弹道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(20), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_bomb_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        player.addTool(new BombTool());
        assertEquals(1, player.getToolsNumber());

        player.sellTool(new BombTool());

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(50), player.getPoints());
    }

    public void test_player_has_not_enough_bomb_sell() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(new BombTool());
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 炸弹", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_bomb_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(new BombTool());

        assertEquals(1, player.getToolsNumber());

        player.useTool(new BombTool());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_bomb_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney, null);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(new BombTool());
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 炸弹", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_money_buy_house_without_owner() {
        RichPlayer player = new RichPlayer(new RichMoney(5000), null);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));

        assertNull(house.getOwner());

        player.buyHouse(house);
        assertEquals(1, player.getHousesNumber());
        assertEquals(player, house.getOwner());
        assertEquals(new RichMoney(4000), player.getMoney());
    }

    public void test_player_has_not_enough_money_buy_house_without_owner() {
        RichMoney notEnoughMoney = new RichMoney(500);
        RichPlayer player = new RichPlayer(notEnoughMoney, null);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        assertNull(house.getOwner());

        try {
            player.buyHouse(house);
            fail("there should have an exception");
        } catch (HouseMoneyNotEnoughException ex) {
            assertEquals("You do not have enough money", ex.getMessage());
        }

        assertNull(house.getOwner());
        assertEquals(notEnoughMoney, player.getMoney());
    }

    public void test_player_can_not_buy_house_already_has_owner() {
        RichPlayer visitor = new RichPlayer(dummyMoney, null);
        RichPlayer owner = new RichPlayer(dummyMoney, null);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        owner.addHouse(house);

        try {
            visitor.buyHouse(house);
            fail("there should have an exception");
        } catch (HouseOwnerException ex) {
            assertEquals("House has already been occupied", ex.getMessage());
        }

        assertEquals(0, visitor.getHousesNumber());
    }

    public void test_player_has_not_enough_money_to_upgrade_house() {
        RichPlayer player = new RichPlayer(new RichMoney(0), dummyPoint);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));

        player.addHouse(house);

        try {
            player.upgradeHouse(house);
            fail("there should be an exception");
        } catch (HouseMoneyNotEnoughException ex) {

        }
    }

    public void test_should_be_exception_for_not_owner_upgrade_the_house() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        RichHouse house = new RichHouse(null);

        try {
            player.upgradeHouse(house);
            fail("there should be an exception");
        } catch (HouseOwnerException ex) {

        }
    }

    public void test_player_has_enough_money_to_upgrade_house_from_plat_to_cottage() {
        RichMoney enoughMoney = new RichMoney(10000);
        RichPlayer player = new RichPlayer(enoughMoney, null);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        player.addHouse(house);

        player.upgradeHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(new RichMoney(9000), player.getMoney());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_cottage_to_villa() {
        RichMoney enoughMoney = new RichMoney(10000);
        RichPlayer player = new RichPlayer(enoughMoney, null);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        player.addHouse(house);

        player.upgradeHouse(house);
        player.upgradeHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(new RichMoney(8000), player.getMoney());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_villa_to_skyscraper() {
        RichMoney enoughMoney = new RichMoney(10000);
        RichPlayer player = new RichPlayer(enoughMoney, null);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        player.addHouse(house);

        player.upgradeHouse(house);
        player.upgradeHouse(house);
        player.upgradeHouse(house);
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(new RichMoney(7000), player.getMoney());
    }


//    public void test_player_has_null_to_sell_null() {
//        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
//        try {
//            player.addHouse(new RichHouse(null));
//            player.sellHouse(null);
//            fail();
//        } catch (HouseOwnerException  ex) {
//
//        }
//    }

    public void test_player_sell_plat() {
        RichMoney playerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell, null);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(new RichMoney(1000), house.getOriginalPrice());
        assertEquals(new RichMoney(12000), player.getMoney());
        assertEquals(0, player.getHousesNumber());

    }

    public void test_player_sell_cottage() {
        RichMoney playerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell, null);
        RichHouse house = new RichHouse(new RichHouseCottageLevel(new RichMoney(1000)));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(new RichMoney(1000), house.getOriginalPrice());
        assertEquals(new RichMoney(14000), player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_villa() {
        RichMoney playerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell, null);
        RichHouse house = new RichHouse(new RichHouseVillaLevel(new RichMoney(1000)));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(new RichMoney(1000), house.getOriginalPrice());
        assertEquals(new RichMoney(16000), player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_skyscraper() {
        RichMoney playerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell, null);
        RichHouse house = new RichHouse(new RichHouseSkyscraperLevel(new RichMoney(1000)));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(new RichMoney(1000), house.getOriginalPrice());
        assertEquals(new RichMoney(18000), player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }

    public void test_should_be_exception_for_player_not_the_owner() {
        RichPlayer player = new RichPlayer(new RichMoney(0), null);

        try {
            player.sellHouse(new RichHouse(new RichHousePlatLevel(new RichMoney(100))));
            fail("there should be an exception");
        } catch (HouseOwnerException ex) {
            assertEquals(new RichMoney(0), player.getMoney());
        }
    }

    public void test_player_pay_for_toll() {
        RichMoney ownerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer owner = new RichPlayer(ownerMoneyBeforeSell, null);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        owner.addHouse(house);

        RichMoney visitorMoneyBeforeSell = new RichMoney(10000);
        RichPlayer visitor = new RichPlayer(visitorMoneyBeforeSell, null);

        visitor.payHouseToll(house);

        assertEquals(owner, house.getOwner());
        assertEquals(new RichMoney(9500), visitor.getMoney());
        assertEquals(new RichMoney(10500), owner.getMoney());
    }


    public void test_should_be_exception_for_owner_pay_for_the_toll() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        RichHouse house = new RichHouse(null);

        player.addHouse(house);

        try {
            player.payHouseToll(house);
            fail("there should be an exception");
        } catch (HouseOwnerException ex) {

        }
    }

    public void test_player_add_money() {
        RichMoney playerMoneyBeforeAddMoney = new RichMoney(0);
        RichPlayer player = new RichPlayer(playerMoneyBeforeAddMoney, dummyPoint);
        player.addMoney(new RichMoney(10000));
        assertEquals(new RichMoney(10000), player.getMoney());
    }

    public void test_should_return_5_for_move_forward_3_steps_from_index_2() {
        RichMap map = createDefaultDummyMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 2));
        player.forwardSteps(3);

        assertEquals(5, player.getPosition().getIndex());
        assertEquals(map.getSite(5), player.getPosition().getSite());
    }

    public void test_should_return_2_for_get_bomb_number() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new BombTool());
        player.addTool(new BombTool());
        player.addTool(new RoadBlockTool());

        assertEquals(2, player.getToolsNumberByType(new BombTool()));
    }

    public void test_should_return_3_for_get_cottage_number() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addHouse(new RichHouse(new RichHouseCottageLevel(dummyMoney)));
        player.addHouse(new RichHouse(new RichHouseCottageLevel(dummyMoney)));
        player.addHouse(new RichHouse(new RichHouseCottageLevel(dummyMoney)));

        player.addHouse(new RichHouse(new RichHousePlatLevel(dummyMoney)));

        assertEquals(3, player.getHousesNumberByLevel(new RichHouse(new RichHouseCottageLevel(dummyMoney))));
    }

    public void test_should_return_true_for_has_remain_steps() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setRemainStep(100);

        assertTrue(player.hasRemainStep());
    }

    public void test_should_return_true_for_is_punished() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setPunishDays(11);

        assertTrue(player.isPunished());
        assertEquals(11, player.getPunishDays());
    }

    private RichMap createDefaultDummyMap() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        return map;
    }

    public void test_should_return_A_RED_for_display() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setName("A");
        player.setColor(new RichRedColor());

        String expectDisplay = (char) 27 + "[01;31mA" + (char) 27 + "[00;00m";
        assertEquals(expectDisplay, player.display());
    }

    public void test_should_return_2_for_get_house_numbers() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addHouse(new RichHouse(null));
        player.addHouse(new RichHouse(null));

        assertEquals(2, player.getHousesNumber());
    }

    public void test_should_return_300_for_get_points() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        player.addPoints(new RichPoint(300));
        assertEquals(new RichPoint(300), player.getPoints());
    }

    public void test_should_return_player_at_site_5() {
        RichMap map = createDefaultDummyMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 0));

        player.setPosition(new RichSitePosition(map, 5));

        assertEquals(5, player.getPosition().getIndex());
        assertEquals(map.getSite(5), player.getPosition().getSite());
        assertFalse(map.getSite(0).hasPlayerStand());
        assertTrue(map.getSite(5).hasPlayerStand());
    }

    public void test_should_return_true_for_has_blessing_god() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setBlessingGod();

        assertTrue(player.hasBlessingGod());
    }
}