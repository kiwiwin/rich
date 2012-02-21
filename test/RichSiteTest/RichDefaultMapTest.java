package RichSiteTest;

import DummyObject.RichDummyMapBuilder;
import RichCore.RichMap;
import RichSite.RichDefaultMap;
import junit.framework.TestCase;

public class RichDefaultMapTest extends TestCase {
    public void test_should_return_70_for_sites_number() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        assertEquals(70, map.getSitesNumber());
    }

    public void test_should_return_14_for_get_hospital_index() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        assertEquals(14, map.getHospitalIndex());
    }
}
