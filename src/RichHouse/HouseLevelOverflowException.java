package RichHouse;

public class HouseLevelOverflowException extends HouseException {
    public String getMessage(){
        return "You cannot upgrade skyscraper";
    }
}
