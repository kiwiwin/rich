package RichTool;

import RichPlayer.RichPlayer;

public class RoadBlockTool extends RichTool {
    public String display() {
        return "#";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "路障";
    }

    public void executeTool(RichPlayer player) {
        player.setRemainStep(0);
        player.getPosition().getSite().acceptPlayer(player);
    }

    protected RoadBlockTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof RoadBlockTool;
    }
}
