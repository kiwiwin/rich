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
        richPlayer.SetPoints(200);
        assertTrue(richPlayer.BuyTool(RichTool.createTool(1)));
        assertTrue(richPlayer.BuyTool(RichTool.createTool(2)));
        assertTrue(richPlayer.BuyTool(RichTool.createTool(3)));
    }

    public void test_should_player_has_no_points_to_buy_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.SetPoints(20);
        assertFalse(richPlayer.BuyTool(RichTool.createTool(1)));
        assertFalse(richPlayer.BuyTool(RichTool.createTool(2)));
        assertFalse(richPlayer.BuyTool(RichTool.createTool(3)));
    }

    public void test_should_player_can_not_have_more_than_10_tools() {
        RichPlayer richPlayer = new RichPlayer();
        richPlayer.SetPoints(100000);
        for (int i = 0; i < 10; i++) {
            assertTrue(richPlayer.BuyTool(RichTool.createTool(1)));
        }
        assertFalse(richPlayer.BuyTool(RichTool.createTool(1)));
    }
}
