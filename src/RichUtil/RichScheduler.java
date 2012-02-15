package RichUtil;

import RichCommand.RichCommand;
import RichCommand.RichCommandFactory;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichPlayer.RichPlayerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import RichPlayer.RichMoney;

public class RichScheduler {
    private static int _currentPlayerIndex = 0;
    private static ArrayList<RichPlayer> _players = new ArrayList<RichPlayer>();
    private static boolean _switchPlayer = false;
    private static boolean _exit = false;

    public static void initialize() {
        try {
            int money = initializePlayerMoney();
            initializePlayer(new RichMoney(money));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void initializePlayer(RichMoney money) throws IOException {
        System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        _players.addAll(Arrays.asList(RichPlayerFactory.createPlayers(RichIO.readLine(), money)));

        for (RichPlayer player : _players) {
            player.setPosition(new RichSitePosition(RichMap.instance(), 0));
        }
    }

    private static int initializePlayerMoney() throws IOException {
        System.out.println("设置玩家初始资金，范围1000～50000（默认10000）");
        String moneyStr = RichIO.readLine();
        int money = 10000;
        if (!moneyStr.equals("")) {
            money = Integer.parseInt(moneyStr);
        }
        return money;
    }

    public static void schedule() {
        while (_players.size() > 1 && !_exit) {
            System.out.println(getCurrentPlayer().display());
            
            while (!_switchPlayer) {
                try {
                    String commandText = RichIO.readLine();
                    RichCommand command = RichCommandFactory.createCommand(commandText);
                    command.executeCommand();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            resetSwitchPlayer();
            switchPlayer();
        }
    }

    private static void switchPlayer() {
        _currentPlayerIndex = (_currentPlayerIndex + 1) % _players.size();
    }

    public static RichPlayer getCurrentPlayer() {
        return _players.get(_currentPlayerIndex);
    }

    public static void setSwitchPlayer() {
        _switchPlayer = true;
    }

    private static void resetSwitchPlayer() {
        _switchPlayer = false;
    }

    public static void exit() {
        _exit = true;
    }
}
