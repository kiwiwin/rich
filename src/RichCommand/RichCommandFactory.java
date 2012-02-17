package RichCommand;

import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;
//import RichUtil.RichScheduler;

public class RichCommandFactory {
    private RichToolFactory _factory;

    public RichCommandFactory(RichToolFactory factory) {
        _factory = factory;
    }

    public RichCommand createCommand(String commandText, RichPlayer player) {
        String lowerCaseCommandText = commandText.toLowerCase();
        if (lowerCaseCommandText.equals("roll")) {
            return new RichRollCommand(player);
        } else if (lowerCaseCommandText.contains("block ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichBlockCommand(player, Integer.parseInt(arg[1]));
        } else if (lowerCaseCommandText.contains("bomb ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichBombCommand(player, Integer.parseInt(arg[1]), null);
        } else if (lowerCaseCommandText.equals("robot")) {
            return new RichRobotCommand(player);
        } else if (lowerCaseCommandText.equals("sell ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return null;
            //return new RichSellHouseCommand(RichScheduler.getCurrentPlayer(), ((RichHouseSite) RichMap.instance().getSite(Integer.parseInt(arg[1]))).getHouse());
        } else if (lowerCaseCommandText.equals("selltool ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichSellToolCommand(player, _factory.createTool(arg[1]));
        } else if (lowerCaseCommandText.equals("query")) {
            return new RichQueryCommand(null, player);    //TODO: replace null
        } else if (lowerCaseCommandText.equals("quit")) {
            return new RichQuitCommand();
        } else {
            throw new IllegalArgumentException("Invalid Command");
        }

    }
}
