package RichGiftTest;

import junit.framework.TestCase;
import RichGift.*;
import RichPlayer.*;

public class MoneyGiftTest extends TestCase {
    public void test_should_add_2000_money_for_open_money_gift() {
        RichPlayer player = new RichPlayer();
        player.setMoney(new RichMoney(0));
        player.acceptGift(new MoneyGift());
        assertEquals(new RichMoney(2000), player.getMoney());
    }
}
