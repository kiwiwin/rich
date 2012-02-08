package RichCommand;

import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;

public class RichRobotCommand {

    private RichPlayer _player;

    public RichRobotCommand(RichPlayer player) {
        _player = player;
    }


    public void executeCommand() {
        RichSitePosition position = new RichSitePosition(_player.getPosition());

        for (int i = 0; i < 10; i++) {
            position.moveForward(1);
            position.getSite().removeDeferredTool();
        }
    }
}
