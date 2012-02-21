package RichCore;

public class HouseMoneyNotEnoughException extends HouseException {
    public String getMessage() {
        return "你现金不足";
    }
}
