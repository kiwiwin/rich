package RichTool;

import RichPlayer.RichPlayer;
import RichMap.RichMap;

public class BombTool extends RichTool {
    public String display() {
        return "@";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "炸弹";
    }

    public void executeTool(RichPlayer player) {
        player.setPosition(RichMap.instance().getHospitalSitePosition());
        player.setPunishDays(3);
    }

    protected BombTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof BombTool;
    }
}
