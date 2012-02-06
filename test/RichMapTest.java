import RichHouse.RichHouse;
import RichMap.RichMap;
import junit.framework.TestCase;

import RichMap.*;

public class RichMapTest extends TestCase {
    public void test_should_return_map_has_3_sites() {
        RichMap map = new RichMap();

        map.addSiteAtTail(new RichStartSite());
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));

        assertEquals(3, map.getSitesNumber());
        assertTrue(map.getSite(0) instanceof RichStartSite);
        assertTrue(map.getSite(1) instanceof RichHouseSite);
        assertTrue(map.getSite(2) instanceof RichHouseSite);
    }
    
    public void test_should_return_rich_house_site_for_moving_forward_2_from_startup(){
        RichMap map = new RichMap();

        map.addSiteAtTail(new RichStartSite());
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveForward(2);

        assertTrue(position.getSite() instanceof RichHouseSite);
    }

    public void test_should_return_startup_site_for_moving_forward_3_from_startup(){
        RichMap map = new RichMap();

        map.addSiteAtTail(new RichStartSite());
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveForward(3);

        assertTrue(position.getSite() instanceof RichStartSite);
    }

    public void test_should_return_rich_house_site_for_moving_backward_2_from_startup(){
        RichMap map = new RichMap();

        map.addSiteAtTail(new RichStartSite());
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveBackward(2);

        assertTrue(position.getSite() instanceof RichHouseSite);
    }

    public void test_should_return_startup_site_for_moving_backward_3_from_startup(){
        RichMap map = new RichMap();

        map.addSiteAtTail(new RichStartSite());
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));
        map.addSiteAtTail(new RichHouseSite(new RichHouse(1000)));

        RichSitePosition position = new RichSitePosition(map, 0);

        position.moveBackward(3);

        assertTrue(position.getSite() instanceof RichStartSite);
    }
}