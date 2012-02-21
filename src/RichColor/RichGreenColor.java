package RichColor;

public class RichGreenColor implements RichColor {
    public String decorate(String s) {
        return (char) 27 + "[01;32m" + s + (char) 27 + "[00;00m";
    }
}
