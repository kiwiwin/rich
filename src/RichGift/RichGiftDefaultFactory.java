package RichGift;

import RichCore.RichGift;
import RichCore.RichGiftFactory;

public class RichGiftDefaultFactory extends RichGiftFactory {
    public RichGift createGift(String giftNumberString) {
        int giftNumber = getGiftNumberFromString(giftNumberString);

        switch (giftNumber) {
            case 1:
                return new MoneyGift();
            case 2:
                return new PointsGift();
            case 3:
                return new BlessingGodGift();
            default:
                throw new IllegalArgumentException("错误的礼物类型");
        }
    }

    private int getGiftNumberFromString(String giftNumberString) {
        try {
            return Integer.parseInt(giftNumberString);
        } catch (Exception ex) {
            throw new IllegalArgumentException("错误的礼物类型");
        }
    }
}
