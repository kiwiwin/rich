package RichHouse;

import RichPlayer.RichPlayer;
import RichPlayer.RichMoney;

public class RichHouse {
    private RichHouseLevel _houseLevel;
    private RichPlayer _owner;

    public RichHouse(RichHouseLevel originalPrice) {
        _houseLevel = originalPrice;
        _owner = null;
    }

    public void setOwner(RichPlayer player) {
        _owner = player;
    }

    public RichPlayer getOwner() {
        return _owner;
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

    private RichMoney getCost() {
        return _houseLevel.getPrice();
    }

    public RichMoney getPriceForSell() {
        return getCost().times(2);
    }

    public RichMoney getToll() {
        return _houseLevel.getToll();
    }

    public void setOriginalPrice(RichMoney price) {
        _houseLevel.setOriginalPrice(price);
    }

    public RichMoney getOriginalPrice() {
        return _houseLevel.getOriginalPrice();
    }

    public String display() {
        return _houseLevel.display();
    }

    public void sell() {
        _owner = null;
        _houseLevel.sell(this);
    }

    public boolean isSameLevel(RichHouse house) {
        return _houseLevel.isSameLevel(house.getLevel());
    }

    public boolean hasOwner() {
        return getOwner() != null;
    }

    public boolean canUpgrade() {
        return _houseLevel.canUpgrade();
    }
}
