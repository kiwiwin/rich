package RichToolTest;

import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import RichTool.RichDeferredTool;
import RichTool.RichRealTimeTool;
import RichTool.RichTool;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

public class RobotToolTest extends TestCase {
    public void test_should_display_empty_for_robot_tool() {
        assertEquals(" ", RichToolFactory.createTool(RichToolFactory.ROBOT).display());
    }

    public void test_should_return_30_for_robot_get_points() {
        assertEquals(new RichPoint(30), RichToolFactory.createTool(RichToolFactory.ROBOT).getPoints());
    }

    public void test_should_return_机器娃娃_for_getName() {
        RichTool tool = RichToolFactory.createTool(2);
        assertEquals("机器娃娃", tool.getName());
    }

    public void test_should_return_clean_site() {
        RichRealTimeTool robot = (RichRealTimeTool) RichToolFactory.createTool(RichToolFactory.ROBOT);
        RichDeferredTool bomb = (RichDeferredTool) RichToolFactory.createTool(RichToolFactory.BOMB);
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));

        bomb.installTool(player, 10);
        robot.useTool(player);

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}
