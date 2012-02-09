package RichTool;

import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;

public class RobotTool extends RichRealTimeTool {
    public String display() {
        return " ";
    }

    public int getPoints() {
        return 30;
    }

    public String getName() {
        return "机器娃娃";
    }

    public boolean equals(Object arg) {
        return arg instanceof RobotTool;
    }

    public void useTool(RichPlayer player) {
        RichSitePosition position = new RichSitePosition(player.getPosition());
        for (int i = 0; i < 10; i++) {
            position.moveForward(1);
            position.getSite().removeDeferredTool();
        }
    }
}
