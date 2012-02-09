package RichCommand;

import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichTool.*;
import RichTool.RichToolFactory;

public class RichBombCommand {
    private RichPlayer _player;
    private int _offset;

    public RichBombCommand(RichPlayer player, int offset) {
        _player = player;
        _offset = offset;
    }

    public void executeCommand() {
        RichSitePosition position = new RichSitePosition(_player.getPosition());
        position.moveForward(_offset);

        _player.useTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        position.getSite().installDeferredTool((RichDeferredTool) RichToolFactory.createTool(RichToolFactory.BOMB));
    }

    public static String getHelp() {
        return "bomb n    可将路障放置到离当前位置前后10步的距离，任一玩家j 经过在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方。";
    }
}
