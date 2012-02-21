package RichToolTest;

import DummyObject.RichDummyMapBuilder;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RoadBlockToolTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;


    public void test_should_display_sharp_for_roadblock_tool() {
        assertEquals("#", new RoadBlockTool().display());
    }

    public void test_should_return_50_for_roadblock_get_points() {
        assertEquals(new RichPoint(50), new RoadBlockTool().getPoints());
    }

    public void test_should_return_路障_for_getName() {
        assertEquals("路障", new RoadBlockTool().getName());
    }

    public void test_should_roadblock_block_player() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 63));

        RichSite installBlockSite = map.getSite(64);
        installBlockSite.installDeferredTool(new RoadBlockTool());
        player.forwardSteps(7);

        assertEquals(64, player.getPosition().getIndex());
        assertTrue(installBlockSite.hasPlayerStand());
    }
}
