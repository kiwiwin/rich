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

    public void acceptPlayer(RichPlayer player) {
        if (_house.getOwner() == null) {
            handleBuyHouse(player);
        } else if (_house.getOwner() == player) {
            handleUpgradeHouse(player);
        } else {
            handlePayToll(player);
        }
    }

    private void handlePayToll(RichPlayer player) {
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
