package RichGift;

import RichPlayer.RichPlayer;

public abstract class RichGift {
    public static final int MONEY = 1;
    public static final int POINTS = 2;
    public static final int GOD = 3;
    
    public static RichGift createGift(int giftNumber){
        switch (giftNumber){
            case MONEY:
                return new MoneyGift();
            case POINTS:
                return new PointsGift();
            case GOD:
                return new GodGift();
            default:
                throw new IllegalArgumentException("Unknown gift type");
        }
    }

    public abstract void openGift(RichPlayer richPlayer);
}
