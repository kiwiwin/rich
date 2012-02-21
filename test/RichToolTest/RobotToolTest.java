package RichToolTest;

import RichCore.RichPoint;
import RichCore.RichTool;
import RichTool.RobotTool;
import junit.framework.TestCase;

public class RobotToolTest extends TestCase {
    public void test_should_display_empty_for_robot_tool() {
        assertEquals(" ", new RobotTool().display());
    }

    public void test_should_return_30_for_robot_get_points() {
        assertEquals(new RichPoint(30), new RobotTool().getPoints());
    }

    public void test_should_return_机器娃娃_for_getName() {
        RichTool tool = new RobotTool();
        assertEquals("机器娃娃", tool.getName());
    }
}
