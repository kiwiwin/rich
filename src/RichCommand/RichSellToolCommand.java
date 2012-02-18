package RichCommand;

import RichCore.RichPlayer;
import RichCore.RichTool;

public class RichSellToolCommand extends RichCommand {
    private RichPlayer _player;
    private RichTool _tool;

    public RichSellToolCommand(RichPlayer player, RichTool tool) {
        _player = player;
        _tool = tool;
    }

    public void executeCommand() {
        _player.sellTool(_tool);
    }

    public static String getHelp() {
        return "sellTool x  出售道具，x 道具编号";
    }
}
