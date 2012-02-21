package RichCoreTest;

import RichColor.RichBlueColor;
import RichColor.RichGreenColor;
import RichColor.RichRedColor;
import RichColor.RichYellowColor;
import RichCore.RichPlayer;
import RichCore.RichPlayerFactory;
import RichMain.RichDefaultPlayerFactory;
import junit.framework.TestCase;

public class RichPlayerFactoryTest extends TestCase {
    public void test_create_qianfuren_for_1() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        RichPlayer player = factory.createPlayer("1");

        String expectDisplay = new RichRedColor().decorate("Q");
        assertEquals(expectDisplay, player.display());
    }

    public void test_create_autubo_for_2() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        RichPlayer player = factory.createPlayer("2");

        String expectDisplay = new RichGreenColor().decorate("A");
        assertEquals(expectDisplay, player.display());
    }

    public void test_create_sunxiaomei_for_3() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        RichPlayer player = factory.createPlayer("3");

        String expectDisplay = new RichYellowColor().decorate("S");
        assertEquals(expectDisplay, player.display());
    }

    public void test_create_jinbeibei_for_4() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        RichPlayer player = factory.createPlayer("4");

        String expectDisplay = new RichBlueColor().decorate("J");
        assertEquals(expectDisplay, player.display());
    }

    public void test_should_be_exception_create_5() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        try {
            factory.createPlayer("5");
            fail("there should be an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid player index", ex.getMessage());
        }
    }

    public void test_should_be_exception_create_invalid_player() {
        RichPlayerFactory factory = new RichDefaultPlayerFactory();
        try {
            factory.createPlayer("invalid player");
            fail("there should be an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid player index", ex.getMessage());
        }
    }
}
