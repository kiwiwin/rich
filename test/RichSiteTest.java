import RichSite.*;
import junit.framework.TestCase;

public class RichSiteTest extends TestCase {
    public void test_should_return_S_for_startup_site() {
        Site site = new StartupSite();
        assertEquals("S", site.display());
    }

    public void test_should_return_0_for_empty_site() {
        Site site = new EmptySite();
        assertEquals("0", site.display());
    }

    public void test_should_return_T_for_tool_site() {
        Site site = new ToolSite();
        assertEquals("T", site.display());
    }

    public void test_should_return_M_for_magic_site() {
        Site site = new MagicSite();
        assertEquals("M", site.display());
    }

    public void test_should_return_G_for_gift_site() {
        Site site = new GiftSite();
        assertEquals("G", site.display());
    }

    public void test_should_return_H_for_hosptial_site() {
        Site site = new HospitalSite();
        assertEquals("H", site.display());
    }

    public void test_should_return_P_for_prison_site() {
        Site site = new PrisonSite();
        assertEquals("P", site.display());
    }

    public void test_should_return_$_for_mine_site() {
        Site site = new MineSite();
        assertEquals("$", site.display());
    }
}