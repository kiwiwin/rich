package RichCommand;

import RichMap.RichHouseSite;
import RichMap.RichMap;
import RichTool.RichToolFactory;
import RichUtil.RichScheduler;

public class RichCommandFactory {
    public static RichCommand createCommand(String commandText) {
        String lowerCaseCommandText = commandText.toLowerCase();
        if (lowerCaseCommandText.equals("roll")) {
            return new RichRollCommand(RichScheduler.getCurrentPlayer());
        } else if (lowerCaseCommandText.contains("block ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichBlockCommand(RichScheduler.getCurrentPlayer(), Integer.parseInt(arg[1]));
        } else if (lowerCaseCommandText.contains("bomb ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichBombCommand(RichScheduler.getCurrentPlayer(), Integer.parseInt(arg[1]));
        } else if (lowerCaseCommandText.equals("robot")) {
            return new RichRobotCommand(RichScheduler.getCurrentPlayer());
        } else if (lowerCaseCommandText.equals("sell ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichSellHouseCommand(RichScheduler.getCurrentPlayer(), ((RichHouseSite) RichMap.instance().getSite(Integer.parseInt(arg[1]))).getHouse());
        } else if (lowerCaseCommandText.equals("selltool ")) {
            String arg[] = lowerCaseCommandText.split(" ");
            return new RichSellToolCommand(RichScheduler.getCurrentPlayer(), RichToolFactory.createTool(arg[1]));
        } else if (lowerCaseCommandText.equals("query")) {
            return new RichQueryCommand(RichScheduler.getCurrentPlayer());
        } else if (lowerCaseCommandText.equals("quit")) {
            return new RichQuitCommand();
        } else {
            throw new IllegalArgumentException("Invalid Command");
        }

    }
}
