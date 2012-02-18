package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichGift.BlessingGodGift;
import junit.framework.TestCase;

public class BlessingGiftTest extends TestCase {
    public void test_should_return_has_blessing_god_for_open_blessing_gift() {
        RichPlayer player = new RichPlayer(new RichMoney(0), null);
        BlessingGodGift blessingGodGift = new BlessingGodGift();
        blessingGodGift.openGift(player);
        assertTrue(player.hasBlessingGod());
    }
}
