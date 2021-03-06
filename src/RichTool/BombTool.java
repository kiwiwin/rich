package RichTool;

import RichCore.*;

public class BombTool implements RichDeferredTool, RichTool {
    private RichSitePosition _hospitalSitePosition;

    public BombTool() {
    }

    public void setHospitalSitePosition(RichSitePosition position) {
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
        player.setRemainStep(0);
        final int PUNISH_HOSPITAL_DAYS = 3;
        player.setPunishDays(PUNISH_HOSPITAL_DAYS);
        player.setPosition(_hospitalSitePosition);
    }
}
