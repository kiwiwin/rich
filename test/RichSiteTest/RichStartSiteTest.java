package RichSiteTest;

import RichCore.RichPlayer;
import RichSite.RichStartSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichStartSiteTest extends TestCase {
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_S_for_display() {
        RichStartSite site = new RichStartSite(dummyReader, dummyWriter);
        assertEquals("S", site.display());
    }

    public void test_todo_accept_player_for_start_site() {
        RichStartSite site = new RichStartSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(null, null));
        //TODO: when player go into a start site
    }
}
