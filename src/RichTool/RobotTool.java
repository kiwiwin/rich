package RichTool;

import RichCore.*;

public class RobotTool extends RichRealTimeTool {
    public String display() {
        return " ";
    }

    public RichPoint getPoints() {
        return new RichPoint(30);
    }

    public String getName() {
        return "机器娃娃";
    }

    public boolean isSameTool(RichTool tool) {
        return tool instanceof RobotTool;
    }

    public void useTool(RichPlayer player) {
        RichSitePosition position = new RichSitePosition(player.getPosition());
        for (int i = 0; i < 10; i++) {
            position.moveForward(1);
            position.getSite().removeDeferredTool();
        }
    }
}
