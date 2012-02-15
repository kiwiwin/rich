package RichGiftTest;

import junit.framework.TestCase;
import RichGift.*;
import RichPlayer.*;

public class MoneyGiftTest extends TestCase {
    public void test_should_add_2000_money_for_open_money_gift() {
        RichPlayer player = new RichPlayer();
        player.setMoney(0);
        player.acceptGift(new MoneyGift());
        assertEquals(2000, player.getMoney());
    }
}
