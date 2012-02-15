package RichPlayerTest;

import RichHouse.*;
import RichMap.RichHospitalSite;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import RichTool.RichToolFactory;
import RichTool.ToolOverflowException;
import RichTool.ToolPointsNotEnoughException;
import RichTool.ToolUnderflowException;
import junit.framework.TestCase;

public class RichPlayerTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer(dummyMoney);
        richPlayer.setPoints(new RichPoint(100000));

        for (int i = 0; i < 10; i++) {
            richPlayer.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        }

        richPlayer.setPoints(new RichPoint(100000));

        try {
            richPlayer.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
            fail("there should have an exception: Each player cannot have more than 10 tools");
        } catch (ToolOverflowException ex) {
            assertEquals("Each player cannot have more than 10 tools", ex.getMessage());
        }
        assertEquals(new RichPoint(100000), richPlayer.getPoints());
    }

    public void test_player_has_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(100));
        player.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));

        assertEquals(new RichPoint(50), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(30));
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
            fail("there should have an exception: 您当前剩余的点数为30， 不足以购买路障道具.");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为30， 不足以购买路障道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(30), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        player.setPoints(new RichPoint(0));
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(1));

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(50), player.getPoints());
    }

    public void test_player_has_not_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
            fail("there should have an exception: You don't have 路障");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 路障", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_roadblock_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_roadblock_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 路障", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(100));
        player.buyTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(new RichPoint(70), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(20));
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
            fail("there should have an exception");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为20， 不足以购买机器娃娃道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(20), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_robot_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        player.setPoints(new RichPoint(0));
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(30), player.getPoints());
    }

    public void test_player_has_not_enough_robot_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_robot_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_robot_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
            fail("there shold have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(100));
        player.buyTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(new RichPoint(50), player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(20));
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.BOMB));
            fail("there should have an exception");
        } catch (ToolPointsNotEnoughException ex) {
            assertEquals("您当前剩余的点数为20， 不足以购买炸弹道具.", ex.getMessage());
        }
        assertEquals(new RichPoint(20), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_bomb_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        player.setPoints(new RichPoint(0));
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(50), player.getPoints());
    }

    public void test_player_has_not_enough_bomb_sell() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(0));
        assertEquals(0, player.getToolsNumber());

        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.BOMB));
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 炸弹", ex.getMessage());
        }
        assertEquals(0, player.getToolsNumber());
        assertEquals(new RichPoint(0), player.getPoints());
    }


    public void test_player_has_bomb_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_bomb_to_use() {
        RichPlayer player = new RichPlayer(dummyMoney);

        assertEquals(0, player.getToolsNumber());

        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.BOMB));
            fail("there should have an exception");
        } catch (ToolUnderflowException ex) {
            assertEquals("You don't have 炸弹", ex.getMessage());
        }

        assertEquals(0, player.getToolsNumber());
    }


    public void test_player_has_enough_money_buy_house_without_owner() {
        RichPlayer player = new RichPlayer(new RichMoney(5000));

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));

        assertNull(house.getOwner());

        player.buyHouse(house);
        assertEquals(1, player.getHousesNumber());
        assertEquals(player, house.getOwner());
        assertEquals(new RichMoney(4000), player.getMoney());
    }

    public void test_player_has_not_enough_money_buy_house_without_owner() {
        RichMoney notEnoughMoney = new RichMoney(500);
        RichPlayer player = new RichPlayer(notEnoughMoney);

        RichMoney housePrice =  new RichMoney(1000);
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
        RichPlayer visitor = new RichPlayer(dummyMoney);
        RichPlayer owner = new RichPlayer(dummyMoney);

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

    public void test_player_has_enough_money_to_upgrade_house_from_plat_to_cottage() {
        RichMoney enoughMoney = new RichMoney(10000);
        RichPlayer player = new RichPlayer(enoughMoney);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        player.addHouse(house);

        player.upgradeHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(new RichMoney(9000), player.getMoney());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_cottage_to_villa() {
        RichMoney enoughMoney = new RichMoney(10000);
        RichPlayer player = new RichPlayer(enoughMoney);
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
        RichPlayer player = new RichPlayer(enoughMoney);
        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        player.addHouse(house);

        player.upgradeHouse(house);
        player.upgradeHouse(house);
        player.upgradeHouse(house);
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(new RichMoney(7000), player.getMoney());
    }


    public void test_player_sell_plat() {
        RichMoney playerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell);
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
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell);
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
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell);
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
        RichPlayer player = new RichPlayer(playerMoneyBeforeSell);
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

    public void test_player_pay_for_toll() {
        RichMoney ownerMoneyBeforeSell = new RichMoney(10000);
        RichPlayer owner = new RichPlayer(ownerMoneyBeforeSell);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        owner.addHouse(house);

        RichMoney visitorMoneyBeforeSell = new RichMoney(10000);
        RichPlayer visitor = new RichPlayer(visitorMoneyBeforeSell);

        visitor.payHouseToll(house);

        assertEquals(owner, house.getOwner());
        assertEquals(new RichMoney(9500), visitor.getMoney());
        assertEquals(new RichMoney(10500), owner.getMoney());
    }

    public void test_player_add_tool() {
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_add_money() {
        RichMoney playerMoneyBeforeAddMoney = new RichMoney(0);
        RichPlayer player = new RichPlayer(playerMoneyBeforeAddMoney);
        player.addMoney(new RichMoney(10000));
        assertEquals(new RichMoney(10000), player.getMoney());
    }

    public void test_player_move_forward_4_steps() {
        RichPlayer player = new RichPlayer(dummyMoney);
        RichMap map = RichMap.buildMap();
        player.setPosition(new RichSitePosition(map, 0));
        player.stepForward(14);

        System.out.println(player.getPosition().getIndex());

        RichHospitalSite site = (RichHospitalSite) map.getSite(14);
        assertTrue(player.getPosition().getSite() instanceof RichHospitalSite);
        assertEquals(site, player.getPosition().getSite());
        assertEquals(14, player.getPosition().getIndex());
        assertTrue(map.getSite(14).hasPlayerStand());
        assertFalse(map.getSite(0).hasPlayerStand());
    }
}