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
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_P_for_display() {
        RichPrisonSite site = new RichPrisonSite(dummyReader, dummyWriter);
        assertEquals("P", site.display());
    }

    public void test_should_punish_for_2_days_when_stop_at_prison_site() {
        RichSite prisonSite = new RichPrisonSite(dummyReader, dummyWriter);//new RichDefaultMapBuilder(dummyReader, dummyWriter).buildPrisonSite();
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        prisonSite.acceptPlayer(player);

        assertEquals(2, player.getPunishDays());
    }
}
