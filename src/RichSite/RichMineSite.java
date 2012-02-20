package RichSite;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMineSite extends RichSite {
    private final RichPoint _bonusPoints;

    public RichMineSite(BufferedReader reader, PrintStream writer, RichPoint points) {
        super(reader, writer);
        _bonusPoints = points;
    }

    protected void doAcceptPlayer(RichPlayer player) {
        player.addPoints(_bonusPoints);
    }

    protected String doDisplay() {
        return "$";
    }
}
