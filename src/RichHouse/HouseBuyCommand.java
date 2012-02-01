package RichHouse;

import RichPlayer.RichPlayer;

public class HouseBuyCommand extends HouseCommand {
    public HouseBuyCommand(RichPlayer player, RichHouse house) {
        _player = player;
        _house = house;
    }

    private RichPlayer _player;
    private RichHouse _house;

    public void executeCommand() {
        _player.buyHouse(_house);
    }
}
