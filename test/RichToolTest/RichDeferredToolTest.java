package RichToolTest;

import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichTool.RichDeferredTool;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;
import RichPlayer.RichMoney;

public class RichDeferredToolTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_cannot_install_tool_if_the_site_already_has_one() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPosition(new RichSitePosition(map, 0));

        RichDeferredTool deferredTool = new RoadBlockTool();
        assertTrue(deferredTool.installTool(player, 1));
        assertFalse(deferredTool.installTool(player, 1));
    }
    
    public void test_cannot_install_tool_if_the_site_already_stand_a_person() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPosition(new RichSitePosition(map, 0));
        RichPlayer stander = new RichPlayer(dummyMoney);
        stander.setPosition(new RichSitePosition(map, 69));

        RichDeferredTool deferredTool = new RoadBlockTool();
        assertFalse(deferredTool.installTool(player, 69));
    }
}
