package RichTool;

public class RoadBlockTool extends RichTool {
    public String display() {
        return "#";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "Road Block";
    }

    protected RoadBlockTool() {
    }
}
