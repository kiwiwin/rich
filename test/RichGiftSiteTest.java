import RichGift.GiftMoneyCommand;
import RichGift.GiftPointsCommand;
import RichGift.RichGiftSite;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RichGiftSiteTest extends TestCase {
    public void test_get_money_as_gift() {
        RichPlayer player = new RichPlayer();
        player.setMoney(1000);
        RichGiftSite site = new RichGiftSite();
        site.acceptPlayerCommand(new GiftMoneyCommand(player));

        assertEquals(3000, player.getMoney());
    }

    public void test_get_points_as_gift() {
        RichPlayer player = new RichPlayer();
        player.setPoints(1000);
        RichGiftSite site = new RichGiftSite();
        site.acceptPlayerCommand(new GiftPointsCommand(player));

        assertEquals(1200, player.getPoints());
    }


    public void test_get_blessing_god_as_gift() {
        //TODO
    }
}
