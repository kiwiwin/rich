package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichTool;

public abstract class RichSite {
    private RichTool _tool;

    public abstract void acceptPlayer(RichPlayer player);

    public abstract String display();

    public void installTool(RichTool tool) {
        if (hasToolInstalled()) ;//TODO
        if (true);//TODO: if there has already a person here, tool can not install at here
        _tool = tool;
    }

    public void removeTool() {
        _tool = null;
    }

    public void acceptPassenger(RichPlayer player) {
        if (hasToolInstalled()) {
            _tool.executeTool(player);
        }

        if (isUserStopHere(player))
            acceptPlayer(player);
        if (player.hasRemainStep())
        {
            player.stepForward();
        }
    }

    private boolean isUserStopHere(RichPlayer player) {
        return this == player.getPosition().getSite() && player.getRemainStep() == 0;
    }

    public boolean hasToolInstalled() {
        return _tool != null;
    }
}
