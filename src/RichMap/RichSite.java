package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichDeferredTool;

import java.util.ArrayList;

public abstract class RichSite {
    private RichDeferredTool _tool;
    private ArrayList<RichPlayer> _players;

    public RichSite() {
        _players = new ArrayList<RichPlayer>();
        _tool = null;
    }
    public void acceptPlayer(RichPlayer player){
        addPlayer(player);
        doAcceptPlayer(player);
    }
    
    protected abstract void doAcceptPlayer(RichPlayer player);

    public abstract String display();

    public boolean installDeferredTool(RichDeferredTool tool) {
        if (hasDeferredToolInstalled()) return false;
        if (hasPlayerStand()) return false;
        _tool = tool;
        return true;
    }

    public boolean hasPlayerStand() {
        return _players.size() > 0;
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
    }

    private boolean isUserStopHere(RichPlayer player) {
        boolean re = player.hasRemainStep();
        boolean bu = player.isPunished();
        return !re && !bu;
    }

    public boolean hasDeferredToolInstalled() {
        return _tool != null;
    }

    public void addPlayer(RichPlayer player) {
        _players.add(player);
    }
    
    public void removePlayer(RichPlayer player) {
        _players.remove(player);
    }
}
