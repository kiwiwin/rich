package RichMap;

import RichPlayer.RichPlayer;
import RichTool.RichDeferredTool;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public abstract class RichSite {
    protected BufferedReader _inputReader;
    protected PrintStream _outputWriter;

    private RichDeferredTool _tool;
    private ArrayList<RichPlayer> _players;

    public RichSite(BufferedReader reader, PrintStream writer) {
        _players = new ArrayList<RichPlayer>();
        _tool = null;
        _inputReader = reader;
        _outputWriter = writer;
    }

    public void acceptPlayer(RichPlayer player) {
        if (!player.isPunished()) {
            addPlayer(player);
            doAcceptPlayer(player);
        }
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

//        if (isUserStopHere(player)) {
//            acceptPlayer(player);
//        }
    }

//    private boolean isUserStopHere(RichPlayer player) {
//        return !player.hasRemainStep() &&
////        return !player.hasRemainStep() && !player.isPunished();
//    }

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
