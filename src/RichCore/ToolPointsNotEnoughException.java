package RichCore;


public class ToolPointsNotEnoughException extends ToolException {
    private final RichPoint _playerPoints;
    private final RichTool _tool;

    public ToolPointsNotEnoughException(RichPoint playerPoints, RichTool tool) {
        _playerPoints = playerPoints;
        _tool = tool;
    }

    public String getMessage() {
        return "您当前剩余的点数为" + _playerPoints.toInt() + "， 不足以购买" + _tool.getName() + "道具.";
    }
}
