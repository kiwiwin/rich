package RichSiteTest;

import RichCore.RichGiftFactory;
import RichCore.RichMapBuilder;
import RichCore.RichPoint;
import RichCore.RichToolFactory;
import RichSite.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDefaultMapBuilderTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichToolFactory dummyToolFactory = null;

    public void test_should_return_rich_gift_site() {
        RichGiftFactory dummyGiftFactory = null;
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildGiftSite(dummyGiftFactory) instanceof RichGiftSite);
    }

    public void test_should_return_rich_hospital_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildHospitalSite() instanceof RichHospitalSite);
    }

    public void test_should_return_rich_house_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildHouseSite(null) instanceof RichHouseSite);
    }

    public void test_should_return_rich_magic_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildMagicSite() instanceof RichMagicSite);
    }

    public void test_should_return_rich_prison_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildPrisonSite() instanceof RichPrisonSite);
    }

    public void test_should_return_rich_start_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildStartSite() instanceof RichStartSite);
    }

    public void test_should_return_rich_tool_site() {
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildToolSite(dummyToolFactory) instanceof RichToolSite);
    }

    public void test_should_return_mine_site_site() {
        final RichPoint dummyPoint = new RichPoint(0);
        RichMapBuilder mapBuilder = createDefaultMapBuilderDummy();
        assertTrue(mapBuilder.buildMineSite(dummyPoint) instanceof RichMineSite);
    }

    private RichMapBuilder createDefaultMapBuilderDummy() {
        return new RichDefaultMapBuilder(dummyReader, dummyWriter);
    }
}
