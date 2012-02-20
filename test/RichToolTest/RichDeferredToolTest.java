package RichToolTest;

import RichCommandTest.RichDummyMapBuilder;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDeferredToolTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_cannot_install_tool_if_the_site_already_has_one() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 0));

        RoadBlockTool deferredTool = new RoadBlockTool();
        assertTrue(deferredTool.installTool(player, 1));
        assertFalse(deferredTool.installTool(player, 1));
    }

    public void test_cannot_install_tool_if_the_site_already_stand_a_person() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 0));
        RichPlayer stander = new RichPlayer(dummyMoney, dummyPoint);
        stander.initPosition(new RichSitePosition(map, 69));

        RoadBlockTool deferredTool = new RoadBlockTool();
        assertFalse(deferredTool.installTool(player, 69));
    }
}
