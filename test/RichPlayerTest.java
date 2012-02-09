import RichTool.*;
import RichHouse.*;
import RichMap.*;
import junit.framework.TestCase;

import RichPlayer.RichPlayer;

public class RichPlayerTest extends TestCase {

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(100000);

        for (int i = 0; i < 10; i++) {
            richPlayer.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        }

        richPlayer.setPoints(100000);

        try {
            richPlayer.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        } catch (ToolOverflowException ex) {
            assertTrue(true);
            assertEquals("Each player cannot have more than 10 tools", ex.getMessage());
        }
        assertEquals(100000, richPlayer.getPoints());
    }

    public void test_player_has_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));

        assertEquals(50, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer();
        player.setPoints(30);
        boolean isException = false;
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("您当前剩余的点数为30， 不足以购买路障道具.", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(30, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(1));

        assertEquals(0, player.getToolsNumber());
        assertEquals(50, player.getPoints());
    }

    public void test_player_has_not_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 路障", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_roadblock_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_roadblock_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 路障", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(70, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer();
        player.setPoints(20);
        boolean isException = false;
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("您当前剩余的点数为20， 不足以购买机器娃娃道具.", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(20, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_robot_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(0, player.getToolsNumber());
        assertEquals(30, player.getPoints());
    }

    public void test_player_has_not_enough_robot_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_robot_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROBOT));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_robot_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.ROBOT));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 机器娃娃", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(50, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer();
        player.setPoints(20);
        boolean isException = false;
        try {
            player.buyTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("您当前剩余的点数为20， 不足以购买炸弹道具.", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(20, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_bomb_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(0, player.getToolsNumber());
        assertEquals(50, player.getPoints());
    }

    public void test_player_has_not_enough_bomb_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 炸弹", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_bomb_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_bomb_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have 炸弹", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }


    public void test_player_has_enough_money_buy_house_without_owner() {
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);

        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);

        assertNull(house.getOwner());

        player.buyHouse(house);
        assertEquals(1, player.getHousesNumber());
        assertEquals(player, house.getOwner());
        assertEquals(4000, player.getMoney());
    }

    public void test_player_has_not_enough_money_buy_house_without_owner() {
        RichPlayer player = new RichPlayer();
        player.setMoney(500);

        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);

        assertNull(house.getOwner());

        boolean isException = false;
        try {
            player.buyHouse(house);
        } catch (HouseMoneyNotEnoughException ex) {
            isException = true;
            assertEquals("You do not have enough money", ex.getMessage());
        }

        assertTrue(isException);

        assertNull(house.getOwner());
        assertEquals(500, player.getMoney());
    }

    public void test_player_can_not_buy_house_already_has_owner() {
        RichPlayer visitor = new RichPlayer();
        RichPlayer owner = new RichPlayer();

        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);
        owner.addHouse(house);

        boolean isException = false;

        try {
            visitor.buyHouse(house);
        } catch (HouseOwnerException ex) {
            isException = true;
            assertEquals("House has already been occupied", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, visitor.getHousesNumber());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_plat_to_cottage() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);
        player.addHouse(house);
        player.setMoney(10000);

        player.upgradeHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(9000, player.getMoney());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_cottage_to_villa() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);
        player.addHouse(house);
        player.setMoney(10000);

        player.upgradeHouse(house);
        player.upgradeHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(8000, player.getMoney());
    }

    public void test_player_has_enough_money_to_upgrade_house_from_villa_to_skyscraper() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);
        player.addHouse(house);
        player.setMoney(10000);

        player.upgradeHouse(house);
        player.upgradeHouse(house);
        player.upgradeHouse(house);
        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(1, player.getHousesNumber());
        assertEquals(7000, player.getMoney());
    }


    public void test_player_sell_plat() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setOriginalPrice(1000);

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(1000, house.getOriginalPrice());
        assertEquals(12000, player.getMoney());
        assertEquals(0, player.getHousesNumber());

    }

    public void test_player_sell_cottage() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setLevel(new RichHouseCottageLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(1000, house.getOriginalPrice());
        assertEquals(14000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_villa() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setLevel(new RichHouseVillaLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(1000, house.getOriginalPrice());
        assertEquals(16000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_skyscraper() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setLevel(new RichHouseSkyscraperLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertNull(house.getOwner());
        assertEquals(1000, house.getOriginalPrice());
        assertEquals(18000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }

    public void test_player_pay_for_toll() {
        RichPlayer owner = new RichPlayer();
        RichHouse house = new RichHouse(0);
        house.setLevel(new RichHousePlatLevel(1000));

        owner.addHouse(house);

        RichPlayer visitor = new RichPlayer();
        owner.setMoney(10000);
        visitor.setMoney(10000);


        visitor.payHouseToll(house);

        assertEquals(owner, house.getOwner());
        assertEquals(9500, visitor.getMoney());
        assertEquals(10500, owner.getMoney());
    }

    public void test_player_add_tool() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_add_money() {
        RichPlayer player = new RichPlayer();
        player.setMoney(0);
        player.addMoney(10000);
        assertEquals(10000, player.getMoney());
    }

    public void test_player_move_forward_4_steps() {
        RichPlayer player = new RichPlayer();
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