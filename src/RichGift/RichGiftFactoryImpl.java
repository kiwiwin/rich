package RichGift;

import RichMap.RichGift;
import RichMap.RichGiftFactory;

public class RichGiftFactoryImpl extends RichGiftFactory{
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
