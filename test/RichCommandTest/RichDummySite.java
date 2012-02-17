package RichCommandTest;

import RichMap.RichSite;
import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDummySite extends RichSite {
    public RichDummySite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    public RichDummySite(BufferedReader dummyReader, PrintStream dummyWriter, RichToolFactory factory) {
        super(dummyReader, dummyWriter);
    }

    @Override
    protected void doAcceptPlayer(RichPlayer player) {
    }

    @Override
    public String display() {
        return "";
    }
}
