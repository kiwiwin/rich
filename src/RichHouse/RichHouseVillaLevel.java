package RichHouse;

public class RichHouseVillaLevel extends RichHouseLevel {
    public RichHouseVillaLevel(int originalPrice) {
        _originalPrice = originalPrice;
    }

    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseSkyscraperLevel(_originalPrice));
    }

    public int getPrice() {
        return new RichHouseCottageLevel(_originalPrice).getPrice() + _originalPrice;
    }

    public int getToll() {
        return new RichHouseCottageLevel(_originalPrice).getToll() * 2;
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
