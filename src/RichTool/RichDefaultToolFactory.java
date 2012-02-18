package RichTool;

import RichCore.RichSitePosition;
import RichCore.RichTool;
import RichCore.RichToolFactory;

public class RichDefaultToolFactory implements RichToolFactory{
    public static final int ROADBLOCK = 1;
    public static final int ROBOT = 2;
    public static final int BOMB = 3;

    private RichSitePosition _hospitalPosition;

    public RichDefaultToolFactory(RichSitePosition position) {
        _hospitalPosition = position;
    }

    public RichTool createTool(int toolNumber) {
        switch (toolNumber) {
            case ROADBLOCK:
                return new RoadBlockTool();
            case ROBOT:
                return new RobotTool();
            case BOMB:
                return new BombTool(_hospitalPosition);
            default:
                throw new IllegalArgumentException("Unknown tool type");
        }
    }

    public RichTool createTool(String command) {
        try {
            return createTool(Integer.parseInt(command));
        } catch (Exception ex) {
            throw new IllegalArgumentException("错误的道具类型");
        }
    }
}