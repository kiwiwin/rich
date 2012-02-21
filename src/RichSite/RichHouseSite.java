package RichSite;

import RichCore.RichHouse;
import RichCore.RichPlayer;
import RichCore.RichSite;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichHouseSite extends RichSite {
    private final RichHouse _house;

    public RichHouseSite(BufferedReader reader, PrintStream writer, RichHouse house) {
        super(reader, writer);
        _house = house;
    }

    protected void doAcceptPlayer(RichPlayer player) {
        if (!hasOwner()) {
            handleBuyHouse(player);
        } else if (isOwner(player)) {
            handleUpgradeHouse(player);
        } else {
            handlePayToll(player);
        }
    }

    private boolean isOwner(RichPlayer player) {
        return _house.getOwner() == player;
    }

    private boolean hasOwner() {
        return !isOwner(null);
    }

    public String doDisplay() {
        return _house.display();
    }

    private void handlePayToll(RichPlayer player) {
        if (_house.getOwner().isPunished()) {
            _outputWriter.println(_house.getOwner().display() + "受罚中，无需过路费");
            return;
        }
        if (player.hasBlessingGod()) {
            _outputWriter.println("福神附身，可免过路费");
            return;
        }

        _outputWriter.println(player.display() + "付给" + _house.getOwner().display() + "过路费" + _house.getToll().toInt() + "元");
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

    public RichHouse getHouse() {
        return _house;
    }
}
