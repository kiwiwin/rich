package RichTool;


public class ToolPointsNotEnoughException extends ToolException{
    private int _playerPoints;
    private RichTool _tool;
    
    public ToolPointsNotEnoughException(int playerPoints, RichTool tool){
        _playerPoints = playerPoints;
        _tool = tool;
    }

    public int getPlayerPoints() {
        return _playerPoints;
    }
    
    public String getMessage() {
        return "You have " + getPlayerPoints() + " points, not enough to buy " + _tool.getName() + " tool";
    }
}
