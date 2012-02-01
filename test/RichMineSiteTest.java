import RichMine.MineCommand;
import RichMine.RichMineSite;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RichMineSiteTest extends TestCase {
    public void test_get_20_points_pass_the_site(){
        RichPlayer player = new RichPlayer();
        player.setPoints(100);
        RichMineSite site = new RichMineSite(20);
        site.acceptPlayerCommand(new MineCommand(player, site.getMinePoints()));

        assertEquals(120, player.getPoints());
    }
}
