package RichSite;

import RichCore.RichHouse;
import RichCore.RichPlayer;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichHouseSite extends RichSite {
    private RichHouse _house;

    public RichHouseSite(BufferedReader reader, PrintStream writer, RichHouse house) {
        super(reader, writer);
        _house = house;
    }

    public void doAcceptPlayer(RichPlayer player) {
        if (hasOwner()) {
            handleBuyHouse(player);
        } else if (isOwner(player)) {
            handleUpgradeHouse(player);
        } else {
            handlePayToll(player);
        }
    }

    public boolean isOwner(RichPlayer player) {
        return _house.getOwner() == player;
    }

    public boolean hasOwner() {
        return isOwner(null);
    }

    public String display() {
        return _house.display();
    }

    private void handlePayToll(RichPlayer player) {
        if (_house.getOwner().isPunished()) return;
        if (player.hasBlessingGod()) {
            _outputWriter.println("福神附身，可免过路费");
            return;
        }
        player.payHouseToll(_house);
    }

    private void handleUpgradeHouse(RichPlayer player) {
        _outputWriter.println("是否升级该处地产，" + _house.getOriginalPrice().toInt() + "元（Y/N）?");
        try {
            String command = _inputReader.readLine();
            if (command.equals("Y") || command.equals("y"))
                player.upgradeHouse(_house);
        } catch (Exception ex) {
            _outputWriter.println(ex.getMessage());
        }
    }

    private void handleBuyHouse(RichPlayer player) {
        _outputWriter.println("是否购买该处空地，" + _house.getOriginalPrice().toInt() + "元（Y/N）?");
        try {
            String command = _inputReader.readLine();
            if (command.equals("Y") || command.equals("y"))
                player.buyHouse(_house);
        } catch (Exception ex) {
            _outputWriter.println(ex.getMessage());
        }
    }
}
