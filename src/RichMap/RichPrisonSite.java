package RichMap;

import RichPlayer.RichPlayer;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichPrisonSite extends RichSite {
    public RichPrisonSite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    public void doAcceptPlayer(RichPlayer player) {
        player.setPunishDays(2);
        //player.setVisible(false);
    }

    public String display() {
        return "P";
    }
}
