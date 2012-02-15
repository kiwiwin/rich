package RichMapTest;

import RichMap.RichGiftSite;
import RichPlayer.RichPlayer;
import RichPlayer.RichMoney;
import TestHelper.RedirectIO;
import junit.framework.TestCase;

public class RichGiftSiteTest extends TestCase {
    public void test_should_return_G_for_display(){
        RichGiftSite site = new RichGiftSite();
        assertEquals("G", site.display());
    }


    public void test_should_return_get_money_gift() {
        RedirectIO.set_input("./test/player_get_money_gift_input.txt");
        RedirectIO.set_output("./test/rich_gift_site_get_money_gift_test.txt");

        RichPlayer player = new RichPlayer();
        RichGiftSite site = new RichGiftSite();
        player.setMoney(new RichMoney(1000));

        site.doAcceptPlayer(player);

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertEquals(new RichMoney(3000), player.getMoney());
        assertTrue(RedirectIO.compareFile("./test/rich_gift_site_welcome_message_answer.txt", "./test/rich_gift_site_get_money_gift_test.txt"));
    }
}
