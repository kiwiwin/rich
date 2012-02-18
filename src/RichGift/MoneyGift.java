package RichGift;

import RichCore.RichGift;
import RichCore.RichMoney;
import RichCore.RichPlayer;

public class MoneyGift implements RichGift {
    private static final RichMoney GIFT_MONEY = new RichMoney(2000);

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addMoney(GIFT_MONEY);
    }
}
