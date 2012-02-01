package RichHouse;

import RichPlayer.RichPlayer;

public class HouseVisitCommand extends HouseCommand {
    private RichPlayer _player;
    private RichHouse _house;

    public HouseVisitCommand(RichPlayer player, RichHouse house) {
        _player = player;
        _house = house;
    }

    public void executeCommand() {
        _player.payHouseToll(_house);
    }
}
