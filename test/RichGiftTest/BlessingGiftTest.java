package RichGiftTest;

import RichGift.BlessingGodGift;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class BlessingGiftTest extends TestCase {
    public void test_should_return_has_blessing_god_for_open_blessing_gift() {
        RichPlayer player = new RichPlayer();
        player.acceptGift(new BlessingGodGift());
        assertTrue(player.hasBlessingGod());
    }
}
