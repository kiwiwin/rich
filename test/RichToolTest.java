import RichPlayer.RichPlayer;
import RichTool.*;
import junit.framework.TestCase;

public class RichToolTest extends TestCase {
    public void test_should_display_sharp_for_roadblock_tool() {
        assertEquals("#", RichTool.createTool(1).display());
    }

    public void test_should_display_empty_for_robot_tool() {
        assertEquals(" ", RichTool.createTool(2).display());
    }

    public void test_should_display_at_for_bomb_tool() {
        assertEquals("@", RichTool.createTool(3).display());
    }

    public void test_should_player_has_points_to_buy_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(200);

        richPlayer.buyTool(RichTool.createTool(1));
        richPlayer.buyTool(RichTool.createTool(2));
        richPlayer.buyTool(RichTool.createTool(3));
    }

    public void test_should_player_has_no_points_to_buy_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(20);

        try {
            richPlayer.buyTool(RichTool.createTool(1));
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Road Block tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());

        try {
            richPlayer.buyTool(RichTool.createTool(2));
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Robot tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());

        try {
            richPlayer.buyTool(RichTool.createTool(3));
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Bomb tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());
    }

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(100000);

        for (int i = 0; i < 10; i++) {
            richPlayer.buyTool(RichTool.createTool(1));
        }

        richPlayer.setPoints(100000);

        try {
            richPlayer.buyTool(RichTool.createTool(1));
        } catch (ToolOverflowException ex) {
            assertTrue(true);
            assertEquals("Each player cannot have more than 10 tools", ex.getMessage());
        }
        assertEquals(100000, richPlayer.getPoints());
    }

    public void test_should_have_150_points_after_selling_road_block() {
        RichPlayer player = new RichPlayer();
        player.setPoints(10000);
        player.buyTool(RichTool.createTool(1));
        player.setPoints(100);

        assertEquals(1, player.getToolsNumber());

        player.sellTool(RichTool.createTool(1));

        assertEquals(150, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }

    public void test_should_get_tool_underflow_exception_when_not_have_road_block() {
        RichPlayer player = new RichPlayer();
        boolean isException = false;
        try {
            player.sellTool(RichTool.createTool(1));
        } catch (ToolUnderflowException ex) {
            isException = true;
        }

        assertTrue(isException);
        assertEquals(0, player.getToolsNumber());
    }
    
    
    public void test_player_can_use_tool() {
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        player.addTool(RichTool.createTool(1));
        
        assertEquals(1, player.getToolsNumber());
        assertEquals(100, player.getPoints());

        player.useTool(RichTool.createTool(1));

        assertEquals(0, player.getToolsNumber());
        assertEquals(100, player.getPoints());
    }
}
