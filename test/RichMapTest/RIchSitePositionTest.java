//package RichMapTest;
//
//import RichMap.RichMap;
//import junit.framework.TestCase;
//
//public class RIchSitePositionTest extends TestCase {
//
//    public void test_should_return_rich_house_site_for_moving_forward_2_from_startup() {
//        RichMap map = new RichMap.RichStandardMap();
//        RichMap.RichSitePosition position = new RichMap.RichSitePosition(map, 0);
//
//        position.moveForward(2);
//
//        assertTrue(position.getSite() instanceof RichMap.RichHouseSite);
//    }
//
//    public void test_should_return_hospital_site_for_moving_forward_14_from_startup() {
//        RichMap map = RichMap.instance();
//
//        RichMap.RichSitePosition position = new RichMap.RichSitePosition(map, 0);
//
//        position.moveForward(14);
//
//        assertTrue(position.getSite() instanceof RichMap.RichHospitalSite);
//    }
//
//    public void test_should_return_mine_site_for_moving_backward_2_from_startup() {
//        RichMap map = RichMap.instance();
//
//        RichMap.RichSitePosition position = new RichMap.RichSitePosition(map, 0);
//
//        position.moveBackward(2);
//
//        assertTrue(position.getSite() instanceof RichMap.RichMineSite);
//    }
//
//    public void test_should_return_magic_site_for_moving_backward_7_from_startup() {
//        RichMap map = RichMap.instance();
//
//        RichMap.RichSitePosition position = new RichMap.RichSitePosition(map, 0);
//
//        position.moveBackward(7);
//
//        assertTrue(position.getSite() instanceof RichMap.RichMagicSite);
//    }
//
//
//}
