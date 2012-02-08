package RichTool;

import RichPlayer.RichPlayer;
import RichMap.RichMap;

public class BombTool extends RichDeferredTool {
    public String display() {
        return "@";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "炸弹";
    }

    protected BombTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof BombTool;
    }

    public void triggerTool(RichPlayer player) {
        player.setPosition(RichMap.instance().getHospitalSitePosition());
        player.setPunishDays(3);
    }
}
