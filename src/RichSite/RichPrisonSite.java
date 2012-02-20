package RichSite;

import RichCore.RichPlayer;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichPrisonSite extends RichSite {
    public RichPrisonSite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    protected void doAcceptPlayer(RichPlayer player) {
        player.setPunishDays(2);
    }

    protected String doDisplay() {
        return "P";
    }
}
