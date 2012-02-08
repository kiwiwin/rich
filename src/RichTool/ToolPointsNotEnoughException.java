package RichTool;


public class ToolPointsNotEnoughException extends ToolException {
    private int _playerPoints;
    private ITool _tool;

    public ToolPointsNotEnoughException(int playerPoints, ITool tool) {
        _playerPoints = playerPoints;
        _tool = tool;
    }

    public int getPlayerPoints() {
        return _playerPoints;
    }

    public String getMessage() {
        return "您当前剩余的点数为" + _playerPoints + "， 不足以购买" + _tool.getName() + "道具.";
    }
}
