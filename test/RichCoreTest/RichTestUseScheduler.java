package RichCoreTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichMain.RichScheduler;

import java.io.BufferedReader;
import java.io.PrintStream;

class RichTestUseScheduler extends RichScheduler {
    public RichTestUseScheduler(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    public RichMoney getInitMoney() {
        return _initMoney;
    }

    public int getPlayersNumber() {
        return _players.size();
    }

    public void addPlayer(RichPlayer player) {
        _players.add(player);
    }
}
