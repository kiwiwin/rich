package RichToolTest;

import RichTool.BombTool;
import RichTool.RichDefaultToolFactory;
import RichTool.RoadBlockTool;
import RichTool.RobotTool;
import junit.framework.TestCase;

public class RichToolFactoryTest extends TestCase {
    public void test_should_return_roadblock_tool_for_rich_tool_roadblock() {
        assertTrue(new RichDefaultToolFactory().createTool(RichDefaultToolFactory.ROADBLOCK) instanceof RoadBlockTool);
    }

    public void test_should_return_robot_tool_for_rich_tool_robot() {
        assertTrue(new RichDefaultToolFactory().createTool(RichDefaultToolFactory.ROBOT) instanceof RobotTool);
    }

    public void test_should_return_bomb_tool_for_rich_tool_bomb() {
        assertTrue(new RichDefaultToolFactory().createTool(RichDefaultToolFactory.BOMB) instanceof BombTool);
    }

    public void test_should_exception_for_create_5() {
        try {
            new RichDefaultToolFactory().createTool(5);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的道具类型", ex.getMessage());
        }
    }

    public void test_should_exception_for_create_invalid_tool() {
        try {
            new RichDefaultToolFactory().createTool("invalid tool");
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的道具类型", ex.getMessage());
        }
    }
}
