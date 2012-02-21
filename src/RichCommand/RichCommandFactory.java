package RichCommand;

import RichCore.RichMap;
import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichCore.RichToolFactory;
import RichSite.RichHouseSite;

import java.io.PrintStream;

public class RichCommandFactory {
    private RichToolFactory _toolFactory;
    private RichSitePosition _hospitalSitePosition;
    private RichMap _map;
    private PrintStream _writer;


    public RichCommandFactory() {
    }

    public void setToolFactory(RichToolFactory factory) {
        _toolFactory = factory;
    }

    public void setHospitalSitePosition(RichSitePosition position) {
        _hospitalSitePosition = position;
    }

    public void setMap(RichMap map) {
        _map = map;
    }

    public void setWriter(PrintStream writer) {
        _writer = writer;
    }

    public RichCommand createCommand(String commandText, RichPlayer player) {
        String lowerCaseCommandText = commandText.toLowerCase();

        try {
            if (lowerCaseCommandText.equals("roll")) {
                return new RichRollCommand(player);
            } else if (lowerCaseCommandText.contains("block ")) {
                return createBlockCommand(player, lowerCaseCommandText);
            } else if (lowerCaseCommandText.contains("bomb ")) {
                return createBombCommand(player, lowerCaseCommandText);
            } else if (lowerCaseCommandText.equals("robot")) {
                return new RichRobotCommand(player);
            } else if (lowerCaseCommandText.contains("sell ")) {
                return createSellHouseCommand(player, lowerCaseCommandText);
            } else if (lowerCaseCommandText.contains("selltool ")) {
                return createSellToolCommand(player, lowerCaseCommandText);
            } else if (lowerCaseCommandText.equals("query")) {
                return new RichQueryCommand(_writer, player);
            } else if (lowerCaseCommandText.equals("quit")) {
                return new RichQuitCommand();
            } else if (lowerCaseCommandText.equals("help")) {
                return new RichHelpCommand(_writer);
            } else {
                throw new IllegalArgumentException("错误的命令");
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("错误的命令");
        }
    }

    private RichCommand createSellToolCommand(RichPlayer player, String lowerCaseCommandText) {
        String arg[] = lowerCaseCommandText.split(" ");
        return new RichSellToolCommand(player, _toolFactory.createTool(arg[1]));
    }

    private RichCommand createSellHouseCommand(RichPlayer player, String lowerCaseCommandText) {
        String arg[] = lowerCaseCommandText.split(" ");
        RichHouseSite houseSite = (RichHouseSite) _map.getSite(Integer.parseInt(arg[1]));
        return new RichSellHouseCommand(player, houseSite.getHouse());
    }

    private RichCommand createBombCommand(RichPlayer player, String lowerCaseCommandText) {
        String arg[] = lowerCaseCommandText.split(" ");
        int offset = Integer.parseInt(arg[1]);
        if (offset < -10 || offset > 10) throw new IllegalArgumentException("");
        return new RichBombCommand(player, offset, _hospitalSitePosition);
    }

    private RichCommand createBlockCommand(RichPlayer player, String lowerCaseCommandText) {
        String arg[] = lowerCaseCommandText.split(" ");
        int offset = Integer.parseInt(arg[1]);
        if (offset < -10 || offset > 10) throw new IllegalArgumentException("");
        return new RichBlockCommand(player, offset);
    }
}
