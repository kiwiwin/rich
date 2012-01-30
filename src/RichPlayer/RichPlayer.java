package RichPlayer;

import RichTool.RichTool;
import RichTool.ToolOverflowException;
import RichTool.ToolPointsNotEnoughException;

import java.util.ArrayList;

public class RichPlayer {
    private int _points;
    private ArrayList<RichTool> _richTools;

    public RichPlayer() {
        _richTools = new ArrayList<RichTool>();
    }

    public void setPoints(int points) {
        this._points = points;
    }

    public void buyTool(RichTool tool) throws ToolPointsNotEnoughException, ToolOverflowException {
        if (_points < tool.getPoints()) throw new ToolPointsNotEnoughException(_points, tool);
        if (_richTools.size() >= 10) throw new ToolOverflowException();
        _points -= tool.getPoints();
        _richTools.add(tool);
    }

    public int getPoints() {
        return _points;
    }
}
