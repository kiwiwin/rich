package RichColor;

public class RichRedColor implements RichColor {
    public String decorate(String s) {
        return (char) 27 + "[01;31m" + s + (char) 27 + "[00;00m";
    }
}
