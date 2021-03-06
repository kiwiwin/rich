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
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        assertEquals(14, map.getHospitalIndex());
    }

    public void test_should_return_70_sites_for_standard_map() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertEquals(70, map.getSitesNumber());
    }

    public void test_should_return_start_site_for_standard_map_index_0() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(0) instanceof RichStartSite);
    }

    public void test_should_return_house_site_for_standard_map_index_3() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(2) instanceof RichHouseSite);
    }

    public void test_should_return_hospital_site_for_standard_map_index_14() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(14) instanceof RichHospitalSite);
    }

    public void test_should_return_tool_site_for_standard_map_index_28() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(28) instanceof RichToolSite);
    }

    public void test_should_return_gift_site_for_standard_map_index_35() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(35) instanceof RichGiftSite);
    }

    public void test_should_return_prison_site_for_standard_map_index_49() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(49) instanceof RichPrisonSite);
    }

    public void test_should_return_magic_site_for_standard_map_index_63() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(63) instanceof RichMagicSite);
    }

    public void test_should_return_mine_site_for_standard_map_index_65() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();
        assertTrue(map.getSite(65) instanceof RichMineSite);
    }

    public void test_should_return_default_map() {
        String expectDefaultRichMapDisplay = "S0000000000000H0000000000000T\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "$                           0\n";
        expectDefaultRichMapDisplay += "M0000000000000P0000000000000G";

        RichMap defaultMap = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        defaultMap.buildMap();

        assertEquals(expectDefaultRichMapDisplay, defaultMap.display());
    }
}
