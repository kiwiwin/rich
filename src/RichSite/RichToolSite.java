package RichSite;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;
import RichCore.RichToolFactory;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichToolSite extends RichSite {
    private final RichToolFactory _factory;

    public RichToolSite(BufferedReader reader, PrintStream writer, RichToolFactory factory) {
        super(reader, writer);
        _factory = factory;
    }

    protected void doAcceptPlayer(RichPlayer player) {
        if (player.getPoints().isLessThan(new RichPoint(30)))
            return;

        _outputWriter.println("请选择你想要购买的道具：1.路障（50点）；2.机器娃娃（30点）；3.炸弹（50点）：");

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

    protected String doDisplay() {
        return "T";
    }
}
