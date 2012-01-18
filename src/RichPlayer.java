import RichTool.RichTool;

import java.util.ArrayList;

public class RichPlayer {
    private int _points;
    private ArrayList<RichTool> _richTools;

    public RichPlayer() {
        _richTools = new ArrayList<RichTool>();
    }

    public void SetPoints(int points) {
        this._points = points;
    }

    public boolean BuyTool(RichTool tool) {
        if (_points < tool.getPoints()) return false;
        if (_richTools.size() >= 10) return false;
        _points -= tool.getPoints();
        _richTools.add(tool);

        return true;
    }
}
