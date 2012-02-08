package RichCommand;

import RichHouse.RichHouse;
import RichPlayer.RichPlayer;

public class RichSellHouseCommand {
    private RichHouse _house;
    private RichPlayer _player;

    public RichSellHouseCommand(RichPlayer player, RichHouse house) {
        _player = player;
        _house = house;
    }

    public void executeCommand() {
        _player.sellHouse(_house);
    }
}
