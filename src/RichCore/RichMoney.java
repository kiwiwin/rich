package RichCore;

public class RichMoney {

    private int _amount;

    public RichMoney(int amount) {
        _amount = amount;
    }

    public RichMoney add(RichMoney addend) {
        return new RichMoney(_amount + addend._amount);
    }

    public boolean equals(Object arg) {
        if (!(arg instanceof RichMoney)) return false;
        RichMoney money = (RichMoney) arg;
        return _amount == money._amount;
    }

    public RichMoney subtract(RichMoney subtrahend) {
        return new RichMoney(_amount - subtrahend._amount);
    }

    public RichMoney times(int time) {
        return new RichMoney(_amount * time);
    }

    public RichMoney divide(int divisor) {
        return new RichMoney(_amount / divisor);
    }

    public boolean isLessThan(RichMoney money) {
        return _amount < money._amount;
    }

    public int toInt() {
        return _amount;
    }
}
