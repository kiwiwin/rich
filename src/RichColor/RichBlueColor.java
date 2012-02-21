package RichColor;

public class RichBlueColor implements RichColor {
    public String decorate(String s) {
        return (char) 27 + "[01;34m" + s + (char) 27 + "[00;00m";
    }
}
