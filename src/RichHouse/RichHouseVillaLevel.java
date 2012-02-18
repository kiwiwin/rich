package RichHouse;

import RichCore.RichHouse;
import RichCore.RichHouseLevel;
import RichCore.RichMoney;

public class RichHouseVillaLevel extends RichHouseLevel {
    public RichHouseVillaLevel(RichMoney originalPrice) {
        super(originalPrice);
    }

    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseSkyscraperLevel(_originalPrice));
    }

    public RichMoney getPrice() {
        return new RichHouseCottageLevel(_originalPrice).getPrice().add(_originalPrice);
    }

    public RichMoney getToll() {
        return new RichHouseCottageLevel(_originalPrice).getToll().times(2);
    }

    public boolean isSameLevel(RichHouseLevel level) {
        return level instanceof RichHouseVillaLevel;
    }

    public String display() {
        return "2";
    }

    public void sell(RichHouse house) {
        setHouseLevel(house, new RichHousePlatLevel(_originalPrice));
    }
}
