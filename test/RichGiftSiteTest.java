import RichMap.RichGiftSite;
import RichPlayer.RichPlayer;

public class RichGiftSiteTest extends RichSiteTest {
//    public void test_should_display_welcome_message() {
//        set_output("./test/rich_gift_site_welcome_message_test.txt");
//
//        RichPlayer player = new RichPlayer();
//        RichGiftSite site = new RichGiftSite();
//
//        site.acceptPlayer(player);
//
//        reset_output();
//
//        assertTrue(compareFile("./test/rich_gift_site_welcome_message_answer.txt", "./test/rich_gift_site_welcome_message_test.txt"));
//    }
    public void test_should_return_G_for_display(){
        RichGiftSite site = new RichGiftSite();
        assertEquals("G", site.display());
    }


    public void test_should_return_get_money_gift() {
        set_input("./test/player_get_money_gift_input.txt");
        set_output("./test/rich_gift_site_get_money_gift_test.txt");

        RichPlayer player = new RichPlayer();
        RichGiftSite site = new RichGiftSite();
        player.setMoney(1000);

        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertEquals(3000, player.getMoney());
        assertTrue(compareFile("./test/rich_gift_site_welcome_message_answer.txt", "./test/rich_gift_site_get_money_gift_test.txt"));
    }
}
