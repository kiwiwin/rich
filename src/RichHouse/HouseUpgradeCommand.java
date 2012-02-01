package RichHouse;

import RichPlayer.RichPlayer;

public class HouseUpgradeCommand extends HouseCommand {
    private RichPlayer _player;
    private RichHouse _house;
    
    public HouseUpgradeCommand(RichPlayer player, RichHouse house) {
        _player = player;
        _house = house;
    }

    public void executeCommand() {
        _player.upgradeHouse(_house);
    }
}
