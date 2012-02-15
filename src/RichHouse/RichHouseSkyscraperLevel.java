package RichHouse;

import RichPlayer.RichMoney;

public class RichHouseSkyscraperLevel extends RichHouseLevel {
    public RichHouseSkyscraperLevel(RichMoney originalPrice) {
        super(originalPrice);
    }

    public void upgrade(RichHouse house) {
        throw new HouseLevelOverflowException();
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

    public void sell(RichHouse house) {
        house.setLevel(new RichHousePlatLevel(_originalPrice));
    }

    public boolean canUpgrade() {
        return false;
    }
}
