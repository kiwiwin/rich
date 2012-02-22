package RichHouse;

import RichCore.RichHouse;
import RichCore.RichHouseLevel;
import RichCore.RichMoney;

public class RichHouseSkyscraperLevel extends RichHouseLevel {
    public RichHouseSkyscraperLevel(RichMoney originalPrice) {
        super(originalPrice);
    }

    public void upgrade(RichHouse house) {
    }

    public RichMoney getPrice() {
        return new RichHouseVillaLevel(_originalPrice).getPrice().add(_originalPrice);
    }

    public RichMoney getToll() {
        return new RichHouseVillaLevel(_originalPrice).getToll().times(2);
    }

    public boolean isSameLevel(RichHouseLevel level) {
        return level instanceof RichHouseSkyscraperLevel;
    }

    public String display() {
        return "3";
    }

    public void reInitialize(RichHouse house) {
        house.setLevel(new RichHousePlatLevel(_originalPrice));
    }

    public boolean canUpgrade() {
        return false;
    }
}
