package RichToolTest;

import RichCore.*;
import RichSite.RichDefaultMap;
import RichSite.RichDefaultMapBuilder;
import RichTool.BombTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class BombToolTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_display_at_for_bomb_tool() {
        assertEquals("@", new BombTool().display());
    }

    public void test_should_return_50_for_bomb_get_points() {
        assertEquals(new RichPoint(50), new BombTool().getPoints());
    }

    public void test_should_return_炸弹_for_getName() {
        assertEquals("炸弹", new BombTool().getName());
    }

    public void test_should_return_player_at_hospital_when_pass_by_a_bomb() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.initPosition(new RichSitePosition(map, 0));

        RichSitePosition hospitalPosition = new RichSitePosition(map, 14);
        BombTool tool = new BombTool();
        tool.setHospitalSitePosition(hospitalPosition);

        RichSite installBombSite = map.getSite(1);
        installBombSite.installDeferredTool(tool);
        
        player.forwardSteps(3);

        RichSite hospitalSite = hospitalPosition.getSite();

        assertEquals(hospitalSite, player.getPosition().getSite());
        assertEquals(3, player.getPunishDays());
        assertFalse(map.getSite(0).hasPlayerStand());
        assertFalse(hospitalSite.hasPlayerStand());
    }
}
