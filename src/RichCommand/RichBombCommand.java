package RichCommand;

import RichCore.RichDeferredTool;
import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichTool.BombTool;

public class RichBombCommand extends RichCommand {
    private RichPlayer _player;
    private int _offset;
    private RichSitePosition _hospitalPosition;

    public RichBombCommand(RichPlayer player, int offset, RichSitePosition position) {
        _player = player;
        _offset = offset;
        _hospitalPosition = position;
    }

    public void executeCommand() {
        _player.useTool(new BombTool(_hospitalPosition));
        RichDeferredTool tool = new BombTool(_hospitalPosition);
        tool.installTool(_player, _offset);
    }

    public static String getHelp() {
        return "bomb n    可将路障放置到离当前位置前后10步的距离，任一玩家j 经过在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方。";
    }
}
