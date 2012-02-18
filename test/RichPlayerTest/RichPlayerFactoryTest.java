package RichPlayerTest;

import RichCore.RichPlayer;
import RichCore.RichPlayerFactory;
import junit.framework.TestCase;

public class RichPlayerFactoryTest extends TestCase {
    public void test_should_return_Q_for_1() {
        RichPlayer player = RichPlayerFactory.createPlayer("1", null);
        assertEquals("Q", player.display());
    }

    public void test_should_return_A_for_2() {
        RichPlayer player = RichPlayerFactory.createPlayer("2", null);
        assertEquals("A", player.display());
    }

    public void test_should_return_S_for_3() {
        RichPlayer player = RichPlayerFactory.createPlayer("3", null);
        assertEquals("S", player.display());
    }

    public void test_should_return_J_for_4() {
        RichPlayer player = RichPlayerFactory.createPlayer("4", null);
        assertEquals("J", player.display());
    }

    public void test_invalid_player() {
        try {
            RichPlayerFactory.createPlayer("Invalid player Index", null);
            fail("there should have an exception: Unknown player index");
        } catch (IllegalArgumentException ex) {
            assertEquals("Unknown player index", ex.getMessage());
        }
    }
}
