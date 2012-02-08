package RichTool;

import RichPlayer.RichPlayer;

public class RoadBlockTool extends RichDeferredTool {
    public String display() {
        return "#";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "路障";
    }

    protected RoadBlockTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof RoadBlockTool;
    }

    public void triggerTool(RichPlayer player) {
        player.setRemainStep(0);
        player.getPosition().getSite().acceptPlayer(player);
    }
}
