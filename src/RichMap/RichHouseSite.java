package RichMap;

import RichPlayer.RichPlayer;
import RichHouse.RichHouse;

public class RichHouseSite extends RichSite {
    private RichHouse _house;

    public RichHouseSite(RichHouse house) {
        _house = house;
    }

    public void acceptPlayer(RichPlayer richPlayer) {
        if (_house.getOwner() == null) {
            System.out.println("是否购买该处空地，" + _house.getOriginalPrice() + "元（Y/N）?");
        }
        if (_house.getOwner() == richPlayer) {
            System.out.println("是否升级该处地产，" + _house.getOriginalPrice() + "元（Y/N）?");
        }
    }
}
