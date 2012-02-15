package RichGiftTest;

import RichGift.MoneyGift;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class MoneyGiftTest extends TestCase {
    public void test_should_add_2000_money_for_open_money_gift() {
        RichMoney playerMoneyBeforeGetGift = new RichMoney(0);
        RichPlayer player = new RichPlayer(playerMoneyBeforeGetGift);
        player.acceptGift(new MoneyGift());
        assertEquals(new RichMoney(2000), player.getMoney());
    }
}
