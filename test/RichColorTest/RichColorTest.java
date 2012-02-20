package RichColorTest;

import RichColor.*;
import RichColor.RichRedColor;
import RichCore.RichColor;
import junit.framework.TestCase;

public class RichColorTest extends TestCase {
    public void test_decorate_red_color() {
        RichColor color = new RichRedColor();
        String expectString = (char) 27 + "[01;31m111" + (char) 27 + "[00;00m";
        assertEquals(expectString, color.decorate("111"));
    }

    public void test_decorate_green_color() {
        RichColor color = new RichGreenColor();
        String expectString = (char) 27 + "[01;32m111" + (char) 27 + "[00;00m";
        assertEquals(expectString, color.decorate("111"));
    }

    public void test_decorate_yellow_color() {
        RichColor color = new RichYellowColor();
        String expectString = (char) 27 + "[01;33m111" + (char) 27 + "[00;00m";
        assertEquals(expectString, color.decorate("111"));
    }

    public void test_decorate_blue_color() {
        RichColor color = new RichBlueColor();
        String expectString = (char) 27 + "[01;34m111" + (char) 27 + "[00;00m";
        assertEquals(expectString, color.decorate("111"));
    }
}
