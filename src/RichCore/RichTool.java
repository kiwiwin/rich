package RichCore;

public interface RichTool {
    public abstract String display();

    public abstract RichPoint getPoints();

    public abstract String getName();

    public abstract boolean isSameTool(RichTool tool);
}
