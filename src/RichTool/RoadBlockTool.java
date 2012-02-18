package RichTool;

import RichCore.RichDeferredTool;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichTool;

public class RoadBlockTool extends RichDeferredTool {
    public String display() {
        return "#";
    }

    public RichPoint getPoints() {
        return new RichPoint(50);
    }

    public String getName() {
        return "路障";
    }

    public boolean isSameTool(RichTool tool) {
        return tool instanceof RoadBlockTool;
    }

    public void triggerTool(RichPlayer player) {
        player.setRemainStep(0);
    }
}
