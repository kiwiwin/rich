package RichCore;

public class HouseOwnerException extends HouseException {
    public String getMessage() {
        return "房屋拥有权不正确";
    }
}
