package RichSiteTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichHospitalSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichHospitalSiteTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;

    public void test_should_return_H_for_display_without_player_or_tool_installed() {
        assertEquals("H", new RichHospitalSite(dummyReader, dummyWriter).display());
    }

    public void test_todo_hospital_accept_player() {
        RichHospitalSite site = new RichHospitalSite(dummyReader, dummyWriter);
        site.acceptPlayer(new RichPlayer(dummyMoney, dummyPoint));
        //TODO: hospital site accept player
    }
}
