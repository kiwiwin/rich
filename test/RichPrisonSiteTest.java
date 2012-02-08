import RichMap.RichPrisonSite;
import junit.framework.TestCase;

public class RichPrisonSiteTest extends TestCase {
    public void test_should_return_P_for_display(){
        RichPrisonSite site = new RichPrisonSite();
        assertEquals("P", site.display());
    }
}
