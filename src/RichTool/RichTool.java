package RichTool;

public abstract class RichTool {
    public abstract String display();

    public abstract int getPoints();

    public abstract String getName();

    public static final int ROADBLOCK = 1;
    public static final int ROBOT = 2;
    public static final int BOMB = 3;

    public static RichTool createTool(int toolNumber) {
        switch (toolNumber) {
            case ROADBLOCK:
                return new RoadBlockTool();
            case ROBOT:
                return new RobotTool();
            case BOMB:
                return new BombTool();
            default:
                throw new IllegalArgumentException("Unknown tool type");
        }
    }
}
