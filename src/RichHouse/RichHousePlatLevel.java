package RichHouse;

public class RichHousePlatLevel extends RichHouseLevel {
    public RichHousePlatLevel(int originalPrice){
        _originalPrice = originalPrice;
    }

    public void upgrade(RichHouse house){
        setHouseLevel(house, new RichHouseCottageLevel(_originalPrice));
    }

    public int getPrice() {
        return _originalPrice;
    }

    public int getToll() {
        return _originalPrice/2;
    }
}
