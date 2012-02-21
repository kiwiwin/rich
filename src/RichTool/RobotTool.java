package RichTool;

import RichCore.*;

public class RobotTool implements RichTool {
    public String display() {
        return " ";
    }

    public RichPoint getPoints() {
        return new RichPoint(30);
    }

    public String getName() {
        return "机器娃娃";
    }

    public boolean isSameTool(RichTool tool) {
        return tool instanceof RobotTool;
    }
}
