package RichTool;

import RichPlayer.RichPlayer;

public class ToolBuyCommand {
    private RichTool _tool;
    private RichPlayer _player;

    public ToolBuyCommand(RichPlayer player, RichTool _tool) {
        this._player = player;
        this._tool = _tool;
    }

    public void executeCommand() {
        _player.buyTool(_tool);
    }
}
