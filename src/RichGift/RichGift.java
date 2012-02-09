package RichGift;

import RichPlayer.RichPlayer;

public abstract class RichGift {
    public static final int MONEY = 1;
    public static final int POINTS = 2;
    public static final int BLESSINGGOD = 3;
    
    public static RichGift createGift(int giftNumber){
        switch (giftNumber){
            case MONEY:
                return new MoneyGift();
            case POINTS:
                return new PointsGift();
            case BLESSINGGOD:
                return new BlessingGodGift();
            default:
                throw new IllegalArgumentException("Unknown gift type");
        }
    }

    public abstract void openGift(RichPlayer richPlayer);
}
