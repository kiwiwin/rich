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

        try {
            richPlayer.buyTool(RichTool.createTool(1));
            richPlayer.buyTool(RichTool.createTool(2));
            richPlayer.buyTool(RichTool.createTool(3));
        } catch (ToolOverflowException ex) {
            assertTrue(false);
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(false);
        }
    }

    public void test_should_player_has_no_points_to_buy_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(20);

        try {
            richPlayer.buyTool(RichTool.createTool(1));
        } catch (ToolOverflowException ex) {
            assertTrue(false);
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Road Block tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());

        try {
            richPlayer.buyTool(RichTool.createTool(2));
        } catch (ToolOverflowException ex) {
            assertTrue(false);
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Robot tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());

        try {
            richPlayer.buyTool(RichTool.createTool(3));
        } catch (ToolOverflowException ex) {
            assertTrue(false);
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Bomb tool.", ex.getMessage());
        }

        assertEquals(20, richPlayer.getPoints());
    }

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.setPoints(100000);

        try {
            for (int i = 0; i < 10; i++) {
                richPlayer.buyTool(RichTool.createTool(1));
            }
        } catch (ToolException ex) {
            assertTrue(false);
        }

        richPlayer.setPoints(100000);

        try {
            richPlayer.buyTool(RichTool.createTool(1));
        } catch (ToolOverflowException ex) {
            assertTrue(true);
            assertEquals("Each player cannot have more than 10 tools", ex.getMessage());
        } catch (ToolPointsNotEnoughException ex){
            assertTrue(false);
        }

        assertEquals(100000, richPlayer.getPoints());
    }
}
