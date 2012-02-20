package RichCore;

public abstract class RichHouseLevel {
    protected final RichMoney _originalPrice;

    protected RichHouseLevel(RichMoney originalPrice) {
        _originalPrice = originalPrice;
    }

    public abstract void upgrade(RichHouse house);

    protected void setHouseLevel(RichHouse house, RichHouseLevel level) {
        house.setLevel(level);
    }

    public abstract RichMoney getPrice();

    public abstract RichMoney getToll();

    public abstract boolean isSameLevel(RichHouseLevel level);

    public RichMoney getOriginalPrice() {
        return _originalPrice;
    }

    public abstract String display();

    public abstract void sell(RichHouse richHouse);

    public boolean canUpgrade() {
        return true;
    }
}
