package RichCoreTest;

import RichCommandTest.RichDummyMapBuilder;
import RichCore.RichMap;
import RichCore.RichSitePosition;
import RichSite.RichDefaultMap;
import junit.framework.TestCase;

public class RichSitePositionTest extends TestCase {


    public void test_should_return_5_move_forward_3_steps_from_index_2() {
        RichMap map = createDefaultDummyMap();

        RichSitePosition position = new RichSitePosition(map, 2);

        position.moveForward(3);

        assertEquals(5, position.getIndex());
        assertEquals(position.getSite(), map.getSite(5));
    }

    public void test_should_return_69_move_backward_4_steps_from_index_3() {
        RichMap map = createDefaultDummyMap();

        RichSitePosition position = new RichSitePosition(map, 3);

        position.moveBackward(4);

        assertEquals(69, position.getIndex());
        assertEquals(position.getSite(), map.getSite(69));
    }

    private RichMap createDefaultDummyMap() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        map.buildMap();
        return map;
    }
}
