package RichSiteTest;

import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichMineSite;
import junit.framework.TestCase;

public class RichMineSiteTest extends TestCase {
    public void test_should_return_$_for_display_mine_site() {
        assertEquals("$", new RichMineSite(null, null, null).display());
    }

    public void test_player_should_gain_40_points_for_enter_mine_site() {
        RichPoint playerPointBefore = new RichPoint(10);
        RichPlayer player = new RichPlayer(null, playerPointBefore);
        
        RichPoint bonusPoint =  new RichPoint(40);
        RichMineSite mineSite = new RichMineSite(null, null, bonusPoint);

        mineSite.acceptPlayer(player);

        RichPoint expectPlayerPointAfter = playerPointBefore.add(bonusPoint);
        assertEquals(expectPlayerPointAfter, player.getPoints());
    }
}
