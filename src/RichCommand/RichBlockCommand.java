package RichCommand;

import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichTool.RoadBlockTool;

public class RichBlockCommand extends RichCommand {
    private final RichPlayer _player;
    private final int _offset;

    public RichBlockCommand(RichPlayer player, int offset) {
        _player = player;
        _offset = offset;
    }

    public void executeCommand() {
        if (installRoadBlock()) {
            _player.useTool(new RoadBlockTool());
        } else {
            throw new RuntimeException("此处不能安装" + new RoadBlockTool().getName());
        }
    }

    private boolean installRoadBlock() {
        RichSitePosition position = new RichSitePosition(_player.getPosition());
        position.moveForward(_offset);
        return position.getSite().installDeferredTool(new RoadBlockTool());
    }

    public static String getHelp() {
        return "block n     玩家拥有路障后，可将路障放置到离当前位置前后10步的距离，任一玩家经过路障，都将被拦截。该道具一次有效。n 前后的相对距离，负数表示后方。";
    }
}
