package RichSiteTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichStartSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichStartSiteTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;

    public void test_should_return_S_for_display_without_player_or_tool_installed() {
        assertEquals("S", new RichStartSite(dummyReader, dummyWriter).display());
    }

    public void test_todo_accept_player_for_start_site() {
        RichStartSite site = new RichStartSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(dummyMoney, dummyPoint));
        //TODO: when player go into a start site
    }
}
