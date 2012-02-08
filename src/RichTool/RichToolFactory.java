package RichTool;

public class RichToolFactory {
    public static final int ROADBLOCK = 1;
    public static final int ROBOT = 2;
    public static final int BOMB = 3;

    public static ITool createTool(int toolNumber) {
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

    public static ITool createTool(String command) {
        try {
            return createTool(Integer.parseInt(command));
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unknown tool type");
        }
    }
}