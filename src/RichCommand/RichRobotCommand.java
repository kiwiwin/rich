package RichCommand;

import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichTool.RobotTool;

public class RichRobotCommand extends RichCommand {

    private final RichPlayer _player;

    public RichRobotCommand(RichPlayer player) {
        _player = player;
    }


    public void executeCommand() {
        _player.useTool(new RobotTool());
        RichSitePosition position = new RichSitePosition(_player.getPosition());

        for (int i = 0; i < 10; i++) {
            position.moveForward(1);
            position.getSite().removeDeferredTool();
        }
    }

    public static String getHelp() {
        return "robot        使用该道具，可清扫前方路面上10步以内的其它道具，如炸弹、路障。";
    }
}
