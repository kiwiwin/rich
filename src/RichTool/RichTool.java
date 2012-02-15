package RichTool;

import RichPlayer.RichPoint;

public interface RichTool {
    public abstract String display();

    public abstract RichPoint getPoints();

    public abstract String getName();

    public abstract boolean isSameTool(RichTool tool);
}
