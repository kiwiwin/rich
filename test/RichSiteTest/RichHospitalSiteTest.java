package RichSiteTest;

import RichCore.RichPlayer;
import RichSite.RichHospitalSite;
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

    public void test_todo_hospital_accept_player() {
        RichHospitalSite site = new RichHospitalSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(null, null));
        //TODO: hospital site accept player
    }
}
