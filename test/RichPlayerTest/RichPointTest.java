package RichPlayerTest;


import RichPlayer.RichPoint;
import junit.framework.TestCase;

public class RichPointTest extends TestCase {
    public void test_should_return_3_for_point_1_plus_2() {
        RichPoint money1 = new RichPoint(1);
        RichPoint money2 = new RichPoint(2);

        assertEquals(new RichPoint(3), money1.add(money2));
    }

    public void test_should_return_6_for_point_7_minus_1() {
        RichPoint money7 = new RichPoint(7);
        RichPoint money1 = new RichPoint(1);

        assertEquals(new RichPoint(6), money7.subtract(money1));
    }

    public void test_should_return_8_for_point_2_times_4() {
        RichPoint money2 = new RichPoint(2);

        assertEquals(new RichPoint(8), money2.times(4));
    }

    public void test_should_return_3_for_point_9_divide_3() {
        RichPoint money9 = new RichPoint(9);

        assertEquals(new RichPoint(3), money9.divide(3));
    }

    public void test_should_return_true_for_point_3_is_less_than_5() {
        RichPoint money3 = new RichPoint(3);
        RichPoint money5 = new RichPoint(5);

        assertTrue(money3.isLessThan(money5));
    }

    public void test_should_return_false_for_point_5_is_less_than_3() {
        RichPoint money3 = new RichPoint(3);
        RichPoint money5 = new RichPoint(5);

        assertFalse(money5.isLessThan(money3));
    }
}
