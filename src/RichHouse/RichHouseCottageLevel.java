package RichHouse;

import RichPlayer.RichMoney;

public class RichHouseCottageLevel extends RichHouseLevel {
    public RichHouseCottageLevel(RichMoney originalPrice) {
        super(originalPrice);
    }

    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseVillaLevel(_originalPrice));
    }

    public RichMoney getPrice() {
        return new RichHousePlatLevel(_originalPrice).getPrice().add(_originalPrice);
    }

    public RichMoney getToll() {
        return new RichHousePlatLevel(_originalPrice).getToll().times(2);
    }

    public boolean isSameLevel(RichHouseLevel level) {
        return level instanceof RichHouseCottageLevel;
    }

    public String display() {
        return "1";
    }

    public void sell(RichHouse richHouse) {
        richHouse.setLevel(new RichHousePlatLevel(_originalPrice));
    }
}
