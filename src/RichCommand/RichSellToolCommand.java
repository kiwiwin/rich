package RichCommand;

import RichPlayer.RichPlayer;
import RichTool.ITool;

public class RichSellToolCommand {
    private RichPlayer _player;
    private ITool _tool;

    public RichSellToolCommand(RichPlayer player, ITool tool) {
        _player = player;
        _tool = tool;
    }

    public void executeCommand() {
        _player.sellTool(_tool);
    }
}
