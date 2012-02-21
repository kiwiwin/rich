package RichToolTest;

import DummyObject.RichDummyMapBuilder;
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

        RichSite site = map.getSite(1);
        
        assertTrue(site.installDeferredTool(new RoadBlockTool()));
        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }

    public void test_cannot_install_tool_if_the_site_already_stand_a_person() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 0));
        RichPlayer stander = new RichPlayer(dummyMoney, dummyPoint);
        stander.initPosition(new RichSitePosition(map, 69));

        RichSite site = map.getSite(69);
        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }
}
