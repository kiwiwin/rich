package RichHouse;

import RichPlayer.RichPlayer;

public class RichHouse {
    private RichHouseLevel _houseLevel;
    private RichPlayer _owner;

    public RichHouse(int originalPrice) {
        _houseLevel = new RichHousePlatLevel(originalPrice);
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

    private int getCost() {
        return _houseLevel.getPrice();
    }

    public int getPriceForSell() {
        return getCost() * 2;
    }

    public int getToll() {
        return _houseLevel.getToll();
    }

    public void setOriginalPrice(int price) {
        _houseLevel.setOriginalPrice(price);
    }

    public int getOriginalPrice() {
        return _houseLevel.getOriginalPrice();
    }

    public void setOwner(RichPlayer player) {
        _owner = player;
    }

    public RichPlayer getOwner() {
        return _owner;
    }

    public String display() {
        return _houseLevel.display();
    }
}
