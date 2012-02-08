package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichDeferredTool;

public abstract class RichSite {
    private RichDeferredTool _tool;

    public abstract void acceptPlayer(RichPlayer player);

    public abstract String display();

    public void installDeferredTool(RichDeferredTool tool) {
        if (hasDeferredToolInstalled()) ;//TODO
        _tool = tool;
    }

    public void removeDeferredTool() {
        _tool = null;
    }

    public void acceptPassenger(RichPlayer player) {
        if (hasDeferredToolInstalled()) {
            _tool.triggerTool(player);
        }

        if (isUserStopHere(player)) {
            acceptPlayer(player);
        }
        if (player.hasRemainStep()) {
            player.stepForward();
        }
    }

    private boolean isUserStopHere(RichPlayer player) {
        return this == player.getPosition().getSite() && !player.hasRemainStep();
    }

    public boolean hasDeferredToolInstalled() {
        return _tool != null;
    }
}
