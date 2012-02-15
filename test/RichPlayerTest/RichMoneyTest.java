package RichPlayerTest;

import RichPlayer.RichMoney;
import junit.framework.TestCase;

public class RichMoneyTest extends TestCase {
    public void test_should_return_3_for_money_1_plus_2() {
        RichMoney money1 = new RichMoney(1);
        RichMoney money2 = new RichMoney(2);

        assertEquals(new RichMoney(3), money1.add(money2));
    }

    public void test_should_return_6_for_money_7_minus_1() {
        RichMoney money7 = new RichMoney(7);
        RichMoney money1 = new RichMoney(1);

        assertEquals(new RichMoney(6), money7.subtract(money1));
    }

    public void test_should_return_8_for_money_2_times_4() {
        RichMoney money2 = new RichMoney(2);

        assertEquals(new RichMoney(8), money2.times(4));
    }

    public void test_should_return_3_for_money_9_divide_3() {
        RichMoney money9 = new RichMoney(9);

        assertEquals(new RichMoney(3), money9.divide(3));
    }

    public void test_should_return_true_for_money_3_is_less_than_5() {
        RichMoney money3 = new RichMoney(3);
        RichMoney money5 = new RichMoney(5);

        assertTrue(money3.isLessThan(money5));
    }

    public void test_should_return_false_for_money_5_is_less_than_3() {
        RichMoney money3 = new RichMoney(3);
        RichMoney money5 = new RichMoney(5);

        assertFalse(money5.isLessThan(money3));
    }
}
