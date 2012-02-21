package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichGift.MoneyGift;
import junit.framework.TestCase;

public class MoneyGiftTest extends TestCase {
    public void test_should_add_2000_money_for_open_money_gift() {
        RichMoney playerMoneyBeforeGetGift = new RichMoney(0);
        RichPlayer player = new RichPlayer(playerMoneyBeforeGetGift, null);
        MoneyGift moneyGift = new MoneyGift();
        moneyGift.openGift(player);
        assertEquals(new RichMoney(2000), player.getMoney());
    }
}
