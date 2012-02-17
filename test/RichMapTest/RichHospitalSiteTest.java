package RichMapTest;

import RichMap.RichHospitalSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichHospitalSiteTest extends TestCase {
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_H_for_display() {
        RichHospitalSite site = new RichHospitalSite(dummyReader, dummyWriter);
        assertEquals("H", site.display());
    }
}
