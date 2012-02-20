package RichCommand;

import RichCore.RichHouse;
import RichCore.RichPlayer;

public class RichSellHouseCommand extends RichCommand {
    private final RichHouse _house;
    private final RichPlayer _player;

    public RichSellHouseCommand(RichPlayer player, RichHouse house) {
        _player = player;
        _house = house;
    }

    public void executeCommand() {
        _player.sellHouse(_house);
    }

    public static String getHelp() {
        return "sell x        出售自己的房产，x 地图上的绝对位置，即地产的编号。";
    }
}
