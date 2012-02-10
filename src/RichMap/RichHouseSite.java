package RichMap;

import RichPlayer.RichPlayer;
import RichHouse.RichHouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RichHouseSite extends RichSite {
    private RichHouse _house;

    public RichHouseSite(RichHouse house) {
        _house = house;
    }

    public RichHouse getHouse() {
        return _house;
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
            System.out.println("福神附身，可免过路费");
            return;
        }
        player.payHouseToll(_house);
    }

    private void handleUpgradeHouse(RichPlayer player) {
        System.out.println("是否升级该处地产，" + _house.getOriginalPrice() + "元（Y/N）?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String command = reader.readLine();
            if (command.equals("Y") || command.equals("y"))
                player.upgradeHouse(_house);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void handleBuyHouse(RichPlayer player) {
        System.out.println("是否购买该处空地，" + _house.getOriginalPrice() + "元（Y/N）?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String command = reader.readLine();
            if (command.equals("Y") || command.equals("y"))
                player.buyHouse(_house);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
