package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichGift.BlessingGodGift;
import junit.framework.TestCase;

public class BlessingGiftTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;

    public void test_should_return_has_blessing_god_for_open_blessing_gift() {
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);

        BlessingGodGift blessingGodGift = new BlessingGodGift();
        blessingGodGift.openGift(player);

        assertTrue(player.hasBlessingGod());
    }
}
