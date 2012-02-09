package RichHouse;

public class RichHouseCottageLevel extends RichHouseLevel {
    public RichHouseCottageLevel(int originalPrice) {
        _originalPrice = originalPrice;
    }

    public void upgrade(RichHouse house) {
        setHouseLevel(house, new RichHouseVillaLevel(_originalPrice));
    }

    public int getPrice() {
        return new RichHousePlatLevel(_originalPrice).getPrice() + _originalPrice;
    }

    public int getToll() {
        return new RichHousePlatLevel(_originalPrice).getToll() * 2;
    }

    public boolean isSameLevel(RichHouseLevel level) {
        return level instanceof RichHouseCottageLevel;
    }

    public String display() {
        return "1";
    }
}
