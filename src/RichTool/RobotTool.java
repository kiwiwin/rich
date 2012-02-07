package RichTool;

public class RobotTool extends RichTool {
    public String display() {
        return " ";
    }

    public int getPoints() {
        return 30;
    }

    public String getName() {
        return "机器娃娃";
    }

    protected RobotTool() {
    }
    
    public boolean equals(Object arg) {
        return arg instanceof RobotTool;
    }
}
