package RichCommand;

import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichTool.BombTool;

public class RichBombCommand extends RichCommand {
    private final RichPlayer _player;
    private final int _offset;
    private final RichSitePosition _hospitalPosition;

    public RichBombCommand(RichPlayer player, int offset, RichSitePosition hospitalPosition) {
        _player = player;
        _offset = offset;
        _hospitalPosition = hospitalPosition;
    }

    public void executeCommand() {
        _player.useTool(new BombTool());

        BombTool bomb = new BombTool();
        bomb.setHospitalSitePosition(_hospitalPosition);

        if (!installBomb(bomb))
        {
            throw new RuntimeException("此处不能安装" + new BombTool().getName());
        }
    }

    private boolean installBomb(BombTool bomb) {
        RichSitePosition position = new RichSitePosition(_player.getPosition());
        position.moveForward(_offset);
        return position.getSite().installDeferredTool(bomb);
    }

    public static String getHelp() {
        return "bomb n    可将路障放置到离当前位置前后10步的距离，任一玩家j 经过在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方。";
    }
}
