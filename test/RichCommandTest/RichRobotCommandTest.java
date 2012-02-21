package RichCommandTest;

import DummyObject.RichDummyMapBuilder;
import RichCommand.RichRobotCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import RichTool.RobotTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichRobotCommandTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_clean_tools() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new RobotTool());

        player.initPosition(new RichSitePosition(map, 0));

        map.getSite(10).installDeferredTool(new RoadBlockTool());

        RichRobotCommand command = new RichRobotCommand(player);
        command.executeCommand();

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}