package RichTool;

import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;

public class RobotTool extends RichTool {
    public String display() {
        return " ";
    }

    public int getPoints() {
        return 30;
    }

    public String getName() {
        return "机器娃娃";
    }

    public void executeTool(RichPlayer player) {
        RichSitePosition position = new RichSitePosition(RichMap.instance(), player.getPosition().getIndex());
        for (int index = 1; index <= 10; index++) {
            position.moveForward(1);
            position.getSite().removeTool();
        }
    }

    protected RobotTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof RobotTool;
    }
}
