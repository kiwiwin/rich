package RichCommand;

import RichPlayer.RichPlayer;
import RichTool.RichDeferredTool;
import RichTool.RichToolFactory;

public class RichBlockCommand extends RichCommand {
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

    public static String getHelp() {
        return "block n     玩家拥有路障后，可将路障放置到离当前位置前后10步的距离，任一玩家经过路障，都将被拦截。该道具一次有效。n 前后的相对距离，负数表示后方。";
    }
}
