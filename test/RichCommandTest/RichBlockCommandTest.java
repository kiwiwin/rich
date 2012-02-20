package RichCommandTest;

import RichCommand.RichBlockCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichBlockCommandTest extends TestCase{
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;
    
    public void test_should_return_has_road_block_at_site_10_for_block_8_player_at_site_2()
    {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new RoadBlockTool());
        player.initPosition(new RichSitePosition(map, 2));
        RichBlockCommand command = new RichBlockCommand(player, 8);

        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(2, player.getPosition().getIndex());
    }

    public void test_should_return_has_road_block_at_negative_site_10()
    {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(new RoadBlockTool());
        player.initPosition(new RichSitePosition(map, 0));
        RichBlockCommand command = new RichBlockCommand(player, -10);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }
}
