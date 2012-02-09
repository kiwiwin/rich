package RichTool;

import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;

public abstract class RichDeferredTool implements ITool{
    public abstract void triggerTool(RichPlayer player);

    public boolean installTool(RichPlayer player, int offset) {
        RichSitePosition position = new RichSitePosition(player.getPosition());
        position.moveForward(offset);
        return position.getSite().installDeferredTool(this);
    }
}
