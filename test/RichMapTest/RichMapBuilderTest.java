package RichMapTest;

import RichCore.RichGiftFactory;
import RichCore.RichMapBuilder;
import RichCore.RichPoint;
import RichSite.*;
import junit.framework.TestCase;

public class RichMapBuilderTest extends TestCase {
    public void test_should_return_rich_gift_site() {
        RichGiftFactory dummyGiftFactory = null;
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildGiftSite(dummyGiftFactory) instanceof RichGiftSite);
    }

    public void test_should_return_rich_hospital_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildHospitalSite() instanceof RichHospitalSite);
    }

    public void test_should_return_rich_house_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildHouseSite(null) instanceof RichHouseSite);
    }

    public void test_should_return_rich_magic_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildMagicSite() instanceof RichMagicSite);
    }

    public void test_should_return_rich_prison_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildPrisonSite() instanceof RichPrisonSite);
    }

    public void test_should_return_rich_start_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildStartSite() instanceof RichStartSite);
    }

    public void test_should_return_rich_tool_site() {
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildToolSite(null) instanceof RichToolSite);
    }
    
    public void test_should_return_mine_site_site(){
        final RichPoint dummyPoint = new RichPoint(0);
        RichMapBuilder mapBuilder = new RichDefaultMapBuilder(null, null);
        assertTrue(mapBuilder.buildMineSite(dummyPoint) instanceof RichMineSite);
    }
}
