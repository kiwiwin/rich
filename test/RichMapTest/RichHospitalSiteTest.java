package RichMapTest;

import RichMap.RichHospitalSite;
import junit.framework.TestCase;

public class RichHospitalSiteTest extends TestCase {
    public void test_should_return_H_for_display() {
        RichHospitalSite site = new RichHospitalSite();
        assertEquals("H", site.display());
    }
}
