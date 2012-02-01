import RichTool.RichTool;
import RichTool.*;
import RichHouse.*;
import junit.framework.TestCase;

import RichPlayer.RichPlayer;

public class RichPlayerTest extends TestCase {
    public void test_player_has_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichTool.createTool(RichTool.ROADBLOCK));

        assertEquals(50, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_roadblock() {
        RichPlayer player = new RichPlayer();
        player.setPoints(30);
        boolean isException = false;
        try {
            player.buyTool(RichTool.createTool(RichTool.ROADBLOCK));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("You have 30 points, not enough to buy Road Block tool", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(30, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.ROADBLOCK));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichTool.createTool(1));

        assertEquals(0, player.getToolsNumber());
        assertEquals(50, player.getPoints());
    }

    public void test_player_has_not_enough_roadblock_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichTool.createTool(RichTool.ROADBLOCK));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Road Block", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_roadblock_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.ROADBLOCK));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichTool.createTool(RichTool.ROADBLOCK));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_roadblock_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichTool.createTool(RichTool.ROADBLOCK));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Road Block", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichTool.createTool(RichTool.ROBOT));

        assertEquals(70, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_robot() {
        RichPlayer player = new RichPlayer();
        player.setPoints(20);
        boolean isException = false;
        try {
            player.buyTool(RichTool.createTool(RichTool.ROBOT));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("You have 20 points, not enough to buy Robot tool", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(20, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_robot_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.ROBOT));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichTool.createTool(RichTool.ROBOT));

        assertEquals(0, player.getToolsNumber());
        assertEquals(30, player.getPoints());
    }

    public void test_player_has_not_enough_robot_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichTool.createTool(RichTool.ROBOT));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Robot", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_robot_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.ROBOT));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichTool.createTool(RichTool.ROBOT));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_robot_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichTool.createTool(RichTool.ROBOT));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Robot", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.buyTool(RichTool.createTool(RichTool.BOMB));

        assertEquals(50, player.getPoints());
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_has_not_enough_points_buy_bomb() {
        RichPlayer player = new RichPlayer();
        player.setPoints(20);
        boolean isException = false;
        try {
            player.buyTool(RichTool.createTool(RichTool.BOMB));
        } catch (ToolPointsNotEnoughException ex) {
            isException = true;
            assertEquals("You have 20 points, not enough to buy Bomb tool", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(20, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_enough_bomb_sell() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.BOMB));
        player.setPoints(0);
        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichTool.createTool(RichTool.BOMB));

        assertEquals(0, player.getToolsNumber());
        assertEquals(50, player.getPoints());
    }

    public void test_player_has_not_enough_bomb_sell() {
        RichPlayer player = new RichPlayer();
        player.setPoints(0);
        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.sellTool(RichTool.createTool(RichTool.BOMB));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Bomb", ex.getMessage());
        }
        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
        assertEquals(0, player.getPoints());
    }


    public void test_player_has_bomb_to_use() {
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.BOMB));

        assertEquals(1, player.getToolsNumber());

        player.useTool(RichTool.createTool(RichTool.BOMB));
        assertEquals(0, player.getToolsNumber());
    }

    public void test_player_has_not_bomb_to_use() {
        RichPlayer player = new RichPlayer();

        assertEquals(0, player.getToolsNumber());

        boolean isException = false;
        try {
            player.useTool(RichTool.createTool(RichTool.BOMB));
        } catch (ToolUnderflowException ex) {
            isException = true;
            assertEquals("You don't have Bomb", ex.getMessage());
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }


    public void test_player_has_enough_money_buy_house_without_owner() {
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);

        RichHouse house = new RichHouse();
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

        RichHouse house = new RichHouse();
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

        RichHouse house = new RichHouse();
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
        RichHouse house = new RichHouse();
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
        RichHouse house = new RichHouse();
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
        RichHouse house = new RichHouse();
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
        RichHouse house = new RichHouse();
        house.setOriginalPrice(1000);

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(12000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }

    public void test_player_sell_cottage() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseCottageLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(14000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_villa() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseVillaLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseVillaLevel);
        assertEquals(16000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }


    public void test_player_sell_skyscraper() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse();
        house.setLevel(new RichHouseSkyscraperLevel(1000));

        player.addHouse(house);
        assertEquals(1, player.getHousesNumber());

        player.setMoney(10000);

        player.sellHouse(house);

        assertTrue(house.getLevel() instanceof RichHouseSkyscraperLevel);
        assertEquals(18000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }

    public void test_player_pay_for_toll() {
        RichPlayer owner = new RichPlayer();
        RichHouse house = new RichHouse();
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

    public void test_player_add_tool(){
        RichPlayer player = new RichPlayer();
        player.addTool(RichTool.createTool(RichTool.BOMB));
        assertEquals(1, player.getToolsNumber());
    }

    public void test_player_add_money(){
        RichPlayer player = new RichPlayer();
        player.addMoney(10000);
        assertEquals(10000, player.getMoney());
    }
}
