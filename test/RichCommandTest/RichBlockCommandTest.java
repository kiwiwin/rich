package RichCommandTest;

import DummyObject.RichDummyMapBuilder;
import RichCommand.RichBlockCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichBlockCommandTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_return_has_road_block_at_site_10_for_block_8_player_at_site_2() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasRoadBlock();

        player.initPosition(new RichSitePosition(map, 2));

        RichBlockCommand command = new RichBlockCommand(player, 8);
        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(2, player.getPosition().getIndex());
    }


    public void test_should_return_has_road_block_at_negative_site_10() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasRoadBlock();

        player.initPosition(new RichSitePosition(map, 0));
        RichBlockCommand command = new RichBlockCommand(player, -10);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }

    public void test_should_be_exception_when_install_road_block_at_a_site_already_installed_something() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasRoadBlock();

        player.initPosition(new RichSitePosition(map, 0));

        RichSite site = map.getSite(10);
        site.installDeferredTool(new RoadBlockTool());

        assertTrue(map.getSite(10).hasDeferredToolInstalled());

        RichBlockCommand command = new RichBlockCommand(player, 10);
        try {
            command.executeCommand();
            fail("cannot install a block at site already have a person stand or a tool installed");
        } catch (Exception ex) {
            assertEquals("此处不能安装路障", ex.getMessage());
            assertEquals(1, player.getToolsNumberByType(new RoadBlockTool()));
        }
    }

    private RichPlayer createDummyPlayerHasRoadBlock() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new RoadBlockTool());
        return player;
    }

    private RichMap createDummyMap() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        return map;
    }
}
