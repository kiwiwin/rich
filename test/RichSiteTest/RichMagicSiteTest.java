package RichSiteTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichMagicSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMagicSiteTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;

    public void test_should_return_M_for_display_without_player_or_toll_installed() {
        assertEquals("M", new RichMagicSite(dummyReader, dummyWriter).display());
    }

    public void test_should_return_noting_for_enter_magic_site() {
        RichMagicSite site = new RichMagicSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(dummyMoney, dummyPoint));
        //TODO: undefined behavior
    }
}
