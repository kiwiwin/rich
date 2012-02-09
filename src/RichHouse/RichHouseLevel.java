package RichHouse;

public abstract class RichHouseLevel {
    protected int _originalPrice;

    public abstract void upgrade(RichHouse house);

    protected void setHouseLevel(RichHouse house, RichHouseLevel level) {
        house.setLevel(level);
    }

    public void setOriginalPrice(int price) {
        _originalPrice = price;
    }

    public abstract int getPrice();

    public abstract int getToll();

    public abstract boolean isSameLevel(RichHouseLevel level);

    public int getOriginalPrice() {
        return _originalPrice;
    }

    public abstract String display();
}
