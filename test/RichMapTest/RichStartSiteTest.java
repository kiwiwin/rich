package RichMapTest;

import RichMap.RichStartSite;
import junit.framework.TestCase;

public class RichStartSiteTest extends TestCase{
    public void test_should_return_S_for_display(){
        RichStartSite site = new RichStartSite();
        assertEquals("S", site.display());
    }
}
