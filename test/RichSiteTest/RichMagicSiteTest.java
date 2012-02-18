package RichSiteTest;

import RichCore.RichPlayer;
import RichSite.RichMagicSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMagicSiteTest extends TestCase {
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_M_for_display() {
        RichMagicSite site = new RichMagicSite(dummyReader, dummyWriter);
        assertEquals("M", site.display());
    }

    public void test_should_return_noting_for_enter_magic_site() {
        RichMagicSite site = new RichMagicSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(null, null));
        //TODO: undefined behavior
    }
}
