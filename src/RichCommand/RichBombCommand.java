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
}
