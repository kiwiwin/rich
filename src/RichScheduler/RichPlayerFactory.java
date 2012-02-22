package RichScheduler;

import RichColor.RichBlueColor;
import RichColor.RichGreenColor;
import RichColor.RichRedColor;
import RichColor.RichYellowColor;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;

public class RichPlayerFactory {
    public RichPlayer createPlayer(String s) {
        try {
            return createPlayer(Integer.parseInt(s));
        } catch (Exception ex) {
            throw new IllegalArgumentException("错误的玩家编号");
        }
    }

    private RichPlayer createPlayer(int playerIndex) {
        RichPlayer player = new RichPlayer(new RichMoney(0), new RichPoint(0));

        switch (playerIndex) {
            case 1:
                player.setName("Q");
                player.setColor(new RichRedColor());
                return player;
            case 2:
                player.setName("A");
                player.setColor(new RichGreenColor());
                return player;
            case 3:
                player.setName("S");
                player.setColor(new RichYellowColor());
                return player;
            case 4:
                player.setName("J");
                player.setColor(new RichBlueColor());
                return player;
            default:
                throw new IllegalArgumentException("错误的玩家编号");
        }
    }
}
