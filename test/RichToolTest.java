import RichTool.*;
import junit.framework.TestCase;

public class RichToolTest extends TestCase {
    public void test_should_return_roadblock_tool_for_rich_tool_roadblock() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.ROADBLOCK) instanceof RoadBlockTool);
    }

    public void test_should_return_robot_tool_for_rich_tool_robot() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.ROBOT) instanceof RobotTool);
    }

    public void test_should_return_bomb_tool_for_rich_tool_bomb() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.BOMB) instanceof BombTool);
    }

    public void test_should_display_sharp_for_roadblock_tool() {
        assertEquals("#", RichToolFactory.createTool(RichToolFactory.ROADBLOCK).display());
    }

    public void test_should_return_50_for_roadblock_get_points() {
        assertEquals(50, RichToolFactory.createTool(RichToolFactory.ROADBLOCK).getPoints());
    }

    public void test_should_display_empty_for_robot_tool() {
        assertEquals(" ", RichToolFactory.createTool(RichToolFactory.ROBOT).display());
    }

    public void test_should_return_30_for_robot_get_points() {
        assertEquals(30, RichToolFactory.createTool(RichToolFactory.ROBOT).getPoints());
    }

    public void test_should_display_at_for_bomb_tool() {
        assertEquals("@", RichToolFactory.createTool(RichToolFactory.BOMB).display());
    }

    public void test_should_return_50_for_bomb_get_points() {
        assertEquals(50, RichToolFactory.createTool(RichToolFactory.BOMB).getPoints());
    }
}
