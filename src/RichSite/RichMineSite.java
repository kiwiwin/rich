package RichSite;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMineSite extends RichSite {
    private RichPoint _bonusPoints;

    public RichMineSite(BufferedReader reader, PrintStream writer, RichPoint points) {
        super(reader, writer);
        _bonusPoints = points;
    }

    public void doAcceptPlayer(RichPlayer player) {
        player.addPoints(_bonusPoints);
    }

    public String display() {
        return "$";
    }
}
