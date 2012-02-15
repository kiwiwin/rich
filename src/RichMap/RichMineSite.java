package RichMap;

import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;

public class RichMineSite extends RichSite {
    private RichPoint _bonusPoints;

    public RichMineSite(RichPoint points) {
        _bonusPoints = points;
    }

    public void doAcceptPlayer(RichPlayer player) {
        player.addPoints(_bonusPoints);
    }

    public String display() {
        return "$";
    }
}
