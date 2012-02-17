package RichToolTest;

import RichTool.BombTool;
import RichTool.RichToolFactory;
import RichTool.RoadBlockTool;
import RichTool.RobotTool;
import junit.framework.TestCase;

public class RichToolFactoryTest extends TestCase {
    public void test_should_return_roadblock_tool_for_rich_tool_roadblock() {
        assertTrue(new RichToolFactory(null).createTool(RichToolFactory.ROADBLOCK) instanceof RoadBlockTool);
    }

    public void test_should_return_robot_tool_for_rich_tool_robot() {
        assertTrue(new RichToolFactory(null).createTool(RichToolFactory.ROBOT) instanceof RobotTool);
    }

    public void test_should_return_bomb_tool_for_rich_tool_bomb() {
        assertTrue(new RichToolFactory(null).createTool(RichToolFactory.BOMB) instanceof BombTool);
    }
}
