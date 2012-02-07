package RichTool;

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

    protected RoadBlockTool() {
    }

    public boolean equals(Object arg) {
        return arg instanceof RoadBlockTool;
    }
}
