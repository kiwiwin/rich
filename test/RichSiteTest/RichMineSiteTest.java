package RichSiteTest;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichMineSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMineSiteTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichPoint dummyBonusPoint = null;

    public void test_should_return_$_for_display_mine_site_without_player_or_tool_installed() {
        assertEquals("$", new RichMineSite(dummyReader, dummyWriter, dummyBonusPoint).display());
    }

    public void test_player_should_gain_40_points_for_enter_mine_site() {
        RichPoint playerPointBefore = new RichPoint(10);
        RichPlayer player = new RichPlayer(null, playerPointBefore);

        RichPoint bonusPoint = new RichPoint(40);
        RichMineSite mineSite = new RichMineSite(dummyReader, dummyWriter, bonusPoint);

        mineSite.acceptPlayer(player);

        RichPoint expectPlayerPointAfter = playerPointBefore.add(bonusPoint);
        assertEquals(expectPlayerPointAfter, player.getPoints());
    }
}
