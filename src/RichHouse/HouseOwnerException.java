package RichHouse;

public class HouseOwnerException extends HouseException{
    public String getMessage(){
        return "House has already been occupied";
    }
}
