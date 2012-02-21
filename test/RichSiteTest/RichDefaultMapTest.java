package RichSiteTest;

import DummyObject.RichDummyMapBuilder;
import RichCore.RichMap;
import RichSite.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDefaultMapTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_return_70_for_sites_number() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        assertEquals(70, map.getSitesNumber());
    }

    public void test_should_return_14_for_get_hospital_index() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader , dummyWriter));
        assertEquals(14, map.getHospitalIndex());
    }
}
