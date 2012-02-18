package RichCore;

public class RichPoint {

    private int _amount;

    public RichPoint(int amount) {
        _amount = amount;
    }

    public RichPoint add(RichPoint addend) {
        return new RichPoint(_amount + addend._amount);
    }

    public boolean equals(Object arg) {
        if (!(arg instanceof RichPoint)) return false;
        RichPoint point = (RichPoint) arg;
        return _amount == point._amount;
    }

    public RichPoint subtract(RichPoint subtrahend) {
        return new RichPoint(_amount - subtrahend._amount);
    }

    public RichPoint times(int time) {
        return new RichPoint(_amount * time);
    }

    public RichPoint divide(int divisor) {
        return new RichPoint(_amount / divisor);
    }

    public boolean isLessThan(RichPoint point) {
        return _amount < point._amount;
    }

    public int toInt() {
        return _amount;
    }
}
