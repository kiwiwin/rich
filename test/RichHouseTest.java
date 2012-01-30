import junit.framework.TestCase;

import RichHouse.*;

public class RichHouseTest extends TestCase {
    public void test_upgrade_empty_to_cottage(){
        RichHouse house = new RichHouse();
        house.setLevel(1);
        house.upgrade();
        assertTrue(false);
    }
    
    public void test_upgrade_cottage_to_villa(){
        RichHouse house = new RichHouse();
        house.setLevel(2);
        house.upgrade();
        assertTrue(false);
    }
    
    public void test_upgrade_villa_to_skyscraper(){
        RichHouse house = new RichHouse();
        house.setLevel(3);
        house.upgrade();
        assertTrue(false);
    }
}
