package RichToolTest;

import RichCommandTest.RichDummyMapBuilder;
import RichMap.RichDefaultMap;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import RichTool.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RobotToolTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;


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

    public void test_should_return_clean_site() {
        RichRealTimeTool robot = new RobotTool();
        RichDeferredTool bomb = new BombTool(null);
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setPosition(new RichSitePosition(map, 0));

        bomb.installTool(player, 10);
        robot.useTool(player);

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}
