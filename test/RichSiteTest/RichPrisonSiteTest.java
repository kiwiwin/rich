package RichSiteTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;
import RichSite.RichPrisonSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichPrisonSiteTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_return_P_for_display_without_player_or_tool_installed() {
        assertEquals("P", new RichPrisonSite(dummyReader, dummyWriter).display());
    }

    public void test_should_punish_for_2_days_when_stop_at_prison_site() {
        RichSite prisonSite = new RichPrisonSite(dummyReader, dummyWriter);

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        prisonSite.acceptPlayer(player);

        assertEquals(2, player.getPunishDays());
    }
}
