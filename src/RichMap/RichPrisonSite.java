package RichMap;

import RichPlayer.RichPlayer;

public class RichPrisonSite extends RichSite {
    public void doAcceptPlayer(RichPlayer player) {
        player.setPunishDays(2);
        player.setVisible(false);
    }

    public String display() {
        return "P";
    }
}
