package RichTool;

public abstract class RichTool {
    public abstract String display();

    public abstract int getPoints();

    public static RichTool createTool(int toolNumber){
        switch (toolNumber){
            case 1:
                return new RoadBlockTool();
            case 2:
                return new RobotTool();
            case 3:
                return new BombTool();
            default:
                throw new IllegalArgumentException("Unknown tool type");
        }
    }
}
