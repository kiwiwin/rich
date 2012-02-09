import RichPlayer.*;
import junit.framework.TestCase;

public class RichPlayerFactoryTest extends TestCase {
    public void test_should_return_Q_for_1() {
        RichPlayer player = RichPlayerFactory.createPlayer("1");
        assertEquals("Q", player.display());
    }

    public void test_should_return_A_for_2() {
        RichPlayer player = RichPlayerFactory.createPlayer("2");
        assertEquals("A", player.display());
    }

    public void test_should_return_S_for_3() {
        RichPlayer player = RichPlayerFactory.createPlayer("3");
        assertEquals("S", player.display());
    }

    public void test_should_return_J_for_4() {
        RichPlayer player = RichPlayerFactory.createPlayer("4");
        assertEquals("J", player.display());
    }

    public void test_invalid_player() {
        boolean isException = false;
        try {
            RichPlayer player = RichPlayerFactory.createPlayer("5");
        } catch (IllegalArgumentException ex) {
            isException = true;
            assertEquals("Unknown player index", ex.getMessage());
        }

        assertTrue(isException);
    }
}
