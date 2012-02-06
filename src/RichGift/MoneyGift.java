package RichGift;

import RichPlayer.RichPlayer;

public class MoneyGift extends RichGift {
    private static final int GIFT_MONEY = 2000;

    public void openGift(RichPlayer richPlayer) {
        richPlayer.addMoney(GIFT_MONEY);
    }
}
