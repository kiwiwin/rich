package RichToolTest;

import DummyObject.RichDummyMapBuilder;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDeferredToolTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    private static int uniqueIndex = 0;

    public void test_should_return_true_for_install_deferred_tool_at_site_without_person_or_another_tool() {
        RichMap map = createDummyMap();

        RichSite site = getUniqueSite(map);

        assertTrue(site.installDeferredTool(new RoadBlockTool()));
    }

    public void test_cannot_install_tool_if_the_site_already_has_one() {
        RichMap map = createDummyMap();

        RichSite site = getUniqueSite(map);

        assertTrue(site.installDeferredTool(new RoadBlockTool()));
        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }

    public void test_cannot_install_tool_if_the_site_already_stand_a_person() {
        RichMap map = createDummyMap();

        RichPlayer stander = new RichPlayer(dummyMoney, dummyPoint);
        stander.initPosition(new RichSitePosition(map, 69));

        RichSite site = map.getSite(69);
        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }

    private RichMap createDummyMap() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        return map;
    }

    private RichSite getUniqueSite(RichMap map) {
        if (++uniqueIndex > map.getSitesNumber())
            uniqueIndex = 0;
        return map.getSite(uniqueIndex);
    }
}
