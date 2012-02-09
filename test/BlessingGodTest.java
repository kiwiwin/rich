import RichGift.BlessingGodGift;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class BlessingGodTest extends TestCase {
    public void test_should_return_player_has_blessing_god() {
        RichPlayer player = new RichPlayer();
        player.acceptGift(new BlessingGodGift());
        assertTrue(player.hasBlessingGod());
    }
}
