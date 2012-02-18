package RichMapTest;

import RichSite.RichMagicSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMagicSiteTest extends TestCase {
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_M_for_display(){
        RichMagicSite site = new RichMagicSite(dummyReader, dummyWriter);
        assertEquals("M", site.display());
    }
}
