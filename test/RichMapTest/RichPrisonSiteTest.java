package RichMapTest;

import RichMap.RichMap;
import RichMap.RichPrisonSite;
import RichMap.RichSite;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;
import RichPlayer.RichMoney;

public class RichPrisonSiteTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);


    public void test_should_return_P_for_display() {
        RichPrisonSite site = new RichPrisonSite();
        assertEquals("P", site.display());
    }

    public void test_should_punish_for_2_days() {
        RichMap map = RichMap.buildMap();
        RichSite site = map.getSite(49);
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPosition(new RichSitePosition(map, 49));
        site.acceptPlayer(player);

        assertEquals(2, player.getPunishDays());
    }
}
