package RichGift;

import RichMap.RichGift;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;

public class MoneyGift extends RichGift {
    private static final RichMoney GIFT_MONEY = new RichMoney(2000);

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addMoney(GIFT_MONEY);
    }
}
