import RichSite.*;
import junit.framework.TestCase;

public class RichSiteTest extends TestCase {
    public void test_should_return_S_for_startup_site() {
        RichSite richSite = new StartupRichSite();
        assertEquals("S", richSite.display());
    }

    public void test_should_return_0_for_empty_site() {
        RichSite richSite = new EmptyRichSite();
        assertEquals("0", richSite.display());
    }

    public void test_dshould_return_T_for_tool_site() {
        RichSite richSite = new ToolRichSite();
        assertEquals("T", richSite.display());
    }

    public void test_should_return_M_for_magic_site() {
        RichSite richSite = new MagicRichSite();
        assertEquals("M", richSite.display());
    }

    public void test_should_return_G_for_gift_site() {
        RichSite richSite = new GiftRichSite();
        assertEquals("G", richSite.display());
    }

    public void test_should_return_H_for_hospital_site() {
        RichSite richSite = new HospitalRichSite();
        assertEquals("H", richSite.display());
    }

    public void test_should_return_P_for_prison_site() {
        RichSite richSite = new PrisonRichSite();
        assertEquals("P", richSite.display());
    }

    public void test_should_return_$_for_mine_site() {
        RichSite richSite = new MineRichSite();
        assertEquals("$", richSite.display());
    }
}