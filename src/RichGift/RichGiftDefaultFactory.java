package RichGift;

import RichCore.RichGift;
import RichCore.RichGiftFactory;

public class RichGiftDefaultFactory extends RichGiftFactory{
    public RichGift createGift(int giftNumber) {
        switch(giftNumber){
            case 1:
                return new MoneyGift();
            case 2:
                return new PointsGift();
            case 3:
                return new BlessingGodGift();
            default:
                throw new IllegalArgumentException("Unknown gift type");
        }
    }
}
