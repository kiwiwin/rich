package RichCommandTest;

import RichCommand.RichRobotCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import RichTool.RobotTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichRobotCommandTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_clean_tools() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new RobotTool());
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        player.initPosition(new RichSitePosition(map, 0));

        map.getSite(10).installDeferredTool(new RoadBlockTool());

        RichRobotCommand command = new RichRobotCommand(player);
        command.executeCommand();

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}