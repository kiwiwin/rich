package RichSite;

import RichCore.RichPlayer;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichHospitalSite extends RichSite {
    public RichHospitalSite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    protected void doAcceptPlayer(RichPlayer richPlayer) {
    }

    protected String doDisplay() {
        return "H";
    }
}
