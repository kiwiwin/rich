import RichTool.*;
import junit.framework.TestCase;

public class RichToolTest extends TestCase {
    public void test_should_return_roadblock_tool_for_rich_tool_roadblock() {
        assertTrue(RichTool.createTool(RichTool.ROADBLOCK) instanceof RoadBlockTool);
    }

    public void test_should_return_robot_tool_for_rich_tool_robot() {
        assertTrue(RichTool.createTool(RichTool.ROBOT) instanceof RobotTool);
    }

    public void test_should_return_bomb_tool_for_rich_tool_bomb() {
        assertTrue(RichTool.createTool(RichTool.BOMB) instanceof BombTool);
    }

    public void test_should_display_sharp_for_roadblock_tool() {
        assertEquals("#", RichTool.createTool(RichTool.ROADBLOCK).display());
    }

    public void test_should_return_50_for_roadblock_get_points() {
        assertEquals(50, RichTool.createTool(RichTool.ROADBLOCK).getPoints());
    }

    public void test_should_display_empty_for_robot_tool() {
        assertEquals(" ", RichTool.createTool(RichTool.ROBOT).display());
    }

    public void test_should_return_30_for_robot_get_points() {
        assertEquals(30, RichTool.createTool(RichTool.ROBOT).getPoints());
    }

    public void test_should_display_at_for_bomb_tool() {
        assertEquals("@", RichTool.createTool(RichTool.BOMB).display());
    }

    public void test_should_return_50_for_bomb_get_points() {
        assertEquals(50, RichTool.createTool(RichTool.BOMB).getPoints());
    }
}
