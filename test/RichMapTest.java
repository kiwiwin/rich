import RichMap.RichMap;
import junit.framework.TestCase;

import RichMap.*;

public class RichMapTest extends TestCase {
    public void test_should_return_map_has_70_sites() {
        RichMap map = RichMap.instance();
        assertEquals(70, map.getSitesNumber());
    }

    public void test_should_return_rich_house_site_for_moving_forward_2_from_startup() {
        RichMap map = RichMap.instance();

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveForward(2);

        assertTrue(position.getSite() instanceof RichHouseSite);
    }

    public void test_should_return_hospital_site_for_moving_forward_14_from_startup() {
        RichMap map = RichMap.instance();

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveForward(14);

        assertTrue(position.getSite() instanceof RichHospitalSite);
    }

    public void test_should_return_mine_site_for_moving_backward_2_from_startup() {
        RichMap map = RichMap.instance();

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveBackward(2);

        assertTrue(position.getSite() instanceof RichMineSite);
    }

    public void test_should_return_magic_site_for_moving_backward_7_from_startup() {
        RichMap map = RichMap.instance();

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveBackward(7);

        assertTrue(position.getSite() instanceof RichMagicSite);
    }


    public void test_should_return_default_map() {
        String richMapDisplay = "S0000000000000H0000000000000T\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "$                           0\n";
        richMapDisplay += "M0000000000000P0000000000000G";

        assertEquals(richMapDisplay, RichMap.instance().display());
    }
}