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
        if (player.getPoints().isLessThan(new RichPoint(30)))
            return; //player do not have enough points, return automatically

        String command;
        try {
            while ((command = _inputReader.readLine()) != null) {
                if (command.equals("F")) return;
                try {
                    player.buyTool(_factory.createTool(command));
                    if (player.getPoints().isLessThan(new RichPoint(30)))
                        return; //player do not have enough points, return automatically
                } catch (IllegalArgumentException ex) {
                    _outputWriter.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            _outputWriter.println(ex.getMessage());
        }
    }

    public String display() {
        return "T";
    }
}
