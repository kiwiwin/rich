package RichCommandTest;

import RichCommand.RichBombCommand;
import RichCore.*;
import RichCore.RichMap;
import RichSite.RichDefaultMap;
import RichTool.BombTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;
import RichCore.RichSitePosition;

public class RichBombCommandTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;


    public void test_should_return_has_bomb_at_site_10() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new BombTool());
        player.initPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, 10, null);

        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }

    public void test_should_return_has_bomb_at_negative_site_10() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new BombTool());
        player.initPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, -10, null);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }
}
