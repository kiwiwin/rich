package RichPlayer;

import RichTool.RichTool;

import java.util.ArrayList;

public class RichPlayer {
    private int _points;
    private ArrayList<RichTool> _richTools;
    private final int TOOL_NUMBER_LIMIT = 10;

    public RichPlayer() {
        _richTools = new ArrayList<RichTool>();
    }

    public int getToolsNumber() {
        return _richTools.size();
    }

    public void addTool(RichTool tool) {
        if (getToolsNumber() >= TOOL_NUMBER_LIMIT) throw new ToolOverflowException();
        _richTools.add(tool);
    }

    public void removeTool(RichTool toolToRemove) {
        for (RichTool tool : _richTools) {
            if (tool.equals(toolToRemove)) {
                _richTools.remove(tool);
                return;
            }
        }

        throw new ToolUnderflowException();
    }

    public void setPoints(int points) {
        this._points = points;
    }

    public int getPoints() {
        return _points;
    }

    public void buyTool(RichTool tool) {
        if (getPoints() < tool.getPoints()) throw new ToolPointsNotEnoughException(_points, tool);
        addTool(tool);
        _points -= tool.getPoints();
    }


    public void sellTool(RichTool toolToSell) {
        removeTool(toolToSell);
        _points += toolToSell.getPoints();
    }

    public void useTool(RichTool toolToUse) {
        removeTool(toolToUse);
    }
}