import RichTool.*;
import junit.framework.TestCase;

public class RichToolFactoryTest extends TestCase {
    public void test_should_return_roadblock_tool_for_rich_tool_roadblock() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.ROADBLOCK) instanceof RoadBlockTool);
    }

    public void test_should_return_robot_tool_for_rich_tool_robot() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.ROBOT) instanceof RobotTool);
    }

    public void test_should_return_bomb_tool_for_rich_tool_bomb() {
        assertTrue(RichToolFactory.createTool(RichToolFactory.BOMB) instanceof BombTool);
    }
}
