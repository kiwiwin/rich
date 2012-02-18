package RichHouse;

import RichCore.RichHouse;
import RichCore.RichHouseLevel;
import RichCore.RichMoney;

public class RichHousePlatLevel extends RichHouseLevel {
    public RichHousePlatLevel(RichMoney originalPrice) {
        super(originalPrice);
    }

    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseCottageLevel(_originalPrice));
    }

    public RichMoney getPrice() {
        return _originalPrice;
    }

    public RichMoney getToll() {
        return _originalPrice.divide(2);
    }

    public boolean isSameLevel(RichHouseLevel level) {
        return level instanceof RichHousePlatLevel;
    }

    public String display() {
        return "0";
    }

    public void sell(RichHouse house) {
    }
}
