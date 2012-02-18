package RichTool;

import RichCore.*;

public class BombTool extends RichDeferredTool {
    private RichSitePosition _hospitalSitePosition;

    public BombTool(RichSitePosition position) {
        _hospitalSitePosition = position;
    }

    public String display() {
        return "@";
    }

    public RichPoint getPoints() {
        return new RichPoint(50);
    }

    public String getName() {
        return "炸弹";
    }

    public boolean isSameTool(RichTool tool) {
        return tool instanceof BombTool;
    }

    public void triggerTool(RichPlayer player) {
        player.setPosition(_hospitalSitePosition);
        player.setRemainStep(0);
        player.setPunishDays(3);
    }
}
