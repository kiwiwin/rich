package RichGiftTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichGift.MoneyGift;
import junit.framework.TestCase;

public class MoneyGiftTest extends TestCase {
    private final RichPoint dummyPoint = null;

    public void test_should_add_2000_money_for_open_money_gift() {
        RichMoney moneyBeforeOpen = new RichMoney(0);
        RichPlayer player = new RichPlayer(moneyBeforeOpen, dummyPoint);

        MoneyGift moneyGift = new MoneyGift();
        moneyGift.openGift(player);

        RichMoney expectMoneyAfterOpen = moneyBeforeOpen.add(new RichMoney(2000));
        assertEquals(expectMoneyAfterOpen, player.getMoney());
    }
}
