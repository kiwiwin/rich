package RichTool;

import RichMap.RichMap;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;

public class BombTool extends RichDeferredTool {
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
        player.setPosition(RichMap.instance().getHospitalSitePosition());
        player.setPunishDays(3);
        player.setVisible(false);
    }
}
