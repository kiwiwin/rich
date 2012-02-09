package RichMap;

import RichPlayer.RichPlayer;

public class RichMineSite extends RichSite {
    private int _bonusPoints;

    public RichMineSite(int points) {
        _bonusPoints = points;
    }

    public void doAcceptPlayer(RichPlayer player) {
        player.addPoints(_bonusPoints);
    }

    public String display() {
        return "$";
    }
}
