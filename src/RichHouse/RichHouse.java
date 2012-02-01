package RichHouse;

import RichPlayer.RichPlayer;

public class RichHouse {
    private RichHouseLevel _houseLevel;
    private RichPlayer _owner;

    public RichHouse() {
        _houseLevel = new RichHousePlatLevel(0);
        _houseLevel.setOriginalPrice(0);
        _owner = null;
    }

    public void upgrade() {
        _houseLevel.upgrade(this);
    }

    public void setLevel(RichHouseLevel level) {
        _houseLevel = level;
    }

    public RichHouseLevel getLevel() {
        return _houseLevel;
    }

    public int getPrice() {
        return _houseLevel.getPrice();
    }

    public int getPriceForSell() {
        return getPrice() * 2;
    }

    public void setOriginalPrice(int price) {
        _houseLevel.setOriginalPrice(price);
    }

    public void setOwner(RichPlayer player) {
        _owner = player;
    }

    public RichPlayer getOwner() {
        return _owner;
    }

    public int getToll() {
        return _houseLevel.getToll();
    }

    public int getOriginalPrice() {
        return _houseLevel.getOriginalPrice();
    }
}
