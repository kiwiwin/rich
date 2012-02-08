package RichCommand;

import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichTool.*;
import RichTool.RichDeferredTool;
import RichTool.RichToolFactory;

public class RichBlockCommand {
    private RichPlayer _player;
    private int _offset;

    public RichBlockCommand(RichPlayer player, int offset) {
        _player = player;
        _offset = offset;
    }

    public void executeCommand() {
        _player.useTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        RichDeferredTool tool = (RichDeferredTool) RichToolFactory.createTool(RichToolFactory.ROADBLOCK);
        tool.installTool(_player, _offset);
    }
}
