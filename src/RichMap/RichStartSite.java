package RichMap;

import RichPlayer.RichPlayer;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichStartSite extends RichSite {
    public RichStartSite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    public void doAcceptPlayer(RichPlayer richPlayer) {
    }

    public String display() {
        return "S";
    }
}
