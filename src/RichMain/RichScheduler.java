package RichMain;

import RichCommand.RichCommandFactory;
import RichCommand.RichCommand;
import RichCore.*;
import RichCore.RichMap;
import RichCore.RichSitePosition;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class RichScheduler {
    protected final ArrayList<RichPlayer> _players;
    private final BufferedReader _reader;
    private final PrintStream _writer;
    protected RichMoney _initMoney = new RichMoney(10000);
    private RichPlayerFactory _playerFactory;
    private RichCommandFactory _commandFactory;
    private RichMap _map;
    private int _currentPlayerIndex;

    public RichScheduler(BufferedReader reader, PrintStream writer) {
        _players = new ArrayList<RichPlayer>();
        _reader = reader;
        _writer = writer;
        _currentPlayerIndex = 0;
    }

    public void setPlayerFactory(RichPlayerFactory factory) {
        _playerFactory = factory;
    }

    public void setCommandFactory(RichCommandFactory commandFactory) {
        _commandFactory = commandFactory;
    }

    public void setMap(RichMap map) {
        _map = map;
    }

    public void initMoney() {
        _writer.println("设置玩家初始资金，范围1000～50000（默认10000）");
        String initMoneyString;
        try {
            initMoneyString = _reader.readLine();
            if (!initMoneyString.equals(""))
                _initMoney = new RichMoney(parseMoneyAmount(initMoneyString));
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid money");
        }
    }

    private int parseMoneyAmount(String initMoneyString) {
        int initMoneyAmount = Integer.parseInt(initMoneyString);
        if (initMoneyAmount < 1000 || initMoneyAmount > 50000)
            throw new IllegalArgumentException();
        return initMoneyAmount;
    }

    public void initPlayers() {
        _writer.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        String playerIndexString;
        try {
            playerIndexString = _reader.readLine();
            for (int i = 0; i < playerIndexString.length(); i++) {
                _players.add(_playerFactory.createPlayer(playerIndexString.substring(i, i + 1)));
                _players.get(i).addMoney(_initMoney);
                _players.get(i).initPosition(new RichSitePosition(_map, 0));
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("invalid players");
        }
    }

    public void schedule() {
        _currentPlayerIndex = 0;

        while (_players.size() > 1) {
            RichPlayer currentPlayer = _players.get(_currentPlayerIndex);
            boolean quitGame = scheduleSinglePlayer(currentPlayer);
            if (quitGame) return;

            checkPlayerHasMoney(currentPlayer);
            _currentPlayerIndex = getNextPlayerIndex(_currentPlayerIndex);
        }

        if (_players.size() == 1) {
            _writer.println("Winner is: " + _players.get(0).display());
        }
    }

    private void checkPlayerHasMoney(RichPlayer currentPlayer) {
        if (currentPlayer.getMoney().isLessThan(new RichMoney(0))) {
            _players.remove(currentPlayer);
            _currentPlayerIndex--;
            _writer.println(currentPlayer.display() + " has no money anymore! ");
        }
    }

    private int getNextPlayerIndex(int currentPlayerIndex) {
        currentPlayerIndex = (currentPlayerIndex + 1) % _players.size();
        return currentPlayerIndex;
    }

    private boolean scheduleSinglePlayer(RichPlayer player) {
        if (isPlayerPunished(player)) return false;

        while (true) {
            flushDisplay(player);

            try {
                String commandString = _reader.readLine().toLowerCase();
                RichCommand command = _commandFactory.createCommand(commandString, player);
                command.executeCommand();

                if (commandString.equals("roll")) return false;
                if (commandString.equals("quit")) return true;
            } catch (Exception ex) {
                _writer.println(ex.getMessage());
            }
        }
    }

    private void flushDisplay(RichPlayer player) {
        _writer.println((char)27 + "[0J");
        _writer.println(_map.display());
        _writer.println("It's " + player.display() + " turn:");
    }

    private boolean isPlayerPunished(RichPlayer player) {
        if (player.isPunished()) {
            _writer.println(player.display() + "has to wait " + player.getPunishDays());
            player.setPunishDays(player.getPunishDays() - 1);
            return true;
        }
        return false;
    }
}
