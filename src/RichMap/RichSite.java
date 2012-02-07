package RichMap;

import RichPlayer.RichPlayer;

import java.io.IOException;

public abstract class RichSite {
    public abstract void acceptPlayer(RichPlayer richPlayer) throws IOException;
}
