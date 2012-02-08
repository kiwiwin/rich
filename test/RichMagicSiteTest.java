import RichMap.RichMagicSite;
import junit.framework.TestCase;

public class RichMagicSiteTest extends TestCase {
    public void test_should_return_M_for_display(){
        RichMagicSite site = new RichMagicSite();
        assertEquals("M", site.display());
    }
}
