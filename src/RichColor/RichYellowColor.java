package RichColor;

import RichCore.RichColor;

public class RichYellowColor implements RichColor {
    public String decorate(String s) {
        return (char) 27 + "[01;33m" + s + (char) 27 + "[00;00m";
    }
}
