package RichSite;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;
import RichCore.RichToolFactory;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichToolSite extends RichSite {
    private RichToolFactory _factory;

    public RichToolSite(BufferedReader reader, PrintStream writer, RichToolFactory factory) {
        super(reader, writer);
        _factory = factory;
    }

    public void doAcceptPlayer(RichPlayer player) {
        while (!player.getPoints().isLessThan(new RichPoint(30))) {
            String toolType;
            try {
                toolType = _inputReader.readLine();
                if (toolType.equals("F")) return;
                player.buyTool(_factory.createTool(toolType));
            } catch (Exception ex) {
                _outputWriter.println(ex.getMessage());
            }
        }
    }

    public String display() {
        return "T";
    }
}
