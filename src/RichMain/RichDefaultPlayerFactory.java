package RichMain;

import RichColor.RichBlueColor;
import RichColor.RichGreenColor;
import RichColor.RichRedColor;
import RichColor.RichYellowColor;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPlayerFactory;
import RichCore.RichPoint;

public class RichDefaultPlayerFactory implements RichPlayerFactory {
    public RichPlayer createPlayer(String s) {
        int playerIndex;
        try {
            playerIndex = Integer.parseInt(s);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid player index");
        }

        RichPlayer player = new RichPlayer(new RichMoney(0), new RichPoint(0));

        switch (playerIndex) {
            case 1:
                player.setName("Q");
                player.setColor(new RichRedColor());
                break;
            case 2:
                player.setName("A");
                player.setColor(new RichGreenColor());
                break;
            case 3:
                player.setName("S");
                player.setColor(new RichYellowColor());
                break;
            case 4:
                player.setName("J");
                player.setColor(new RichBlueColor());
                break;
            default:
                throw new IllegalArgumentException("Invalid player index");
        }

        return player;
    }
}
