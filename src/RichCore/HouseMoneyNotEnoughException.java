package RichCore;

public class HouseMoneyNotEnoughException extends HouseException {
    public String getMessage(){
        return "You do not have enough money";
    }
}
