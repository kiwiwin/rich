package RichHouse;

public class RichHouseSkyscraperLevel extends RichHouseLevel {
    public RichHouseSkyscraperLevel(int originalPrice) {
        _originalPrice = originalPrice;
    }

    public void upgrade(RichHouse house) {
        throw new HouseLevelOverflowException();
    }

    public int getPrice() {
        return new RichHouseVillaLevel(_originalPrice).getPrice() + _originalPrice;
    }

    public int getToll() {
        return new RichHouseVillaLevel(_originalPrice).getToll() * 2;
    }
}
