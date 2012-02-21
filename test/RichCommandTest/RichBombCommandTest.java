package RichCommandTest;

import DummyObject.RichDummyMapBuilder;
import RichCommand.RichBombCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import RichTool.BombTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichBombCommandTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichSitePosition dummyHospitalPosition = null;


    public void test_should_return_has_bomb_at_site_10() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasBomb();

        player.initPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, 10, dummyHospitalPosition);

        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }

    public void test_should_return_has_bomb_at_negative_site_10() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasBomb();

        player.initPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, -10, dummyHospitalPosition);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }


    public void test_should_be_exception_when_install_bomb_at_a_site_already_installed_something() {
        RichMap map = createDummyMap();
        RichPlayer player = createDummyPlayerHasBomb();

        player.initPosition(new RichSitePosition(map, 0));

        RichSite site = map.getSite(5);
        site.installDeferredTool(new BombTool());

        RichBombCommand command = new RichBombCommand(player, 5, dummyHospitalPosition);

        try {
            command.executeCommand();
            fail("cannot install a bomb at site already have a person stand or a tool installed");
        } catch (Exception ex) {
            assertEquals("此处不能安装炸弹", ex.getMessage());
        }
    }

    private RichPlayer createDummyPlayerHasBomb() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.addTool(new BombTool());
        return player;
    }

    private RichMap createDummyMap() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        return map;
    }
}
