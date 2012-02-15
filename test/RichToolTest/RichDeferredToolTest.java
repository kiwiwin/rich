package RichToolTest;

import RichPlayer.RichPlayer;
import RichMap.*;
import RichTool.*;
import junit.framework.TestCase;

public class RichDeferredToolTest extends TestCase {
    public void test_cannot_install_tool_if_the_site_already_has_one() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));

        RichDeferredTool deferredTool = new RoadBlockTool();
        assertTrue(deferredTool.installTool(player, 1));
        assertFalse(deferredTool.installTool(player, 1));
    }
    
    public void test_cannot_install_tool_if_the_site_already_stand_a_person() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));
        RichPlayer stander = new RichPlayer();
        stander.setPosition(new RichSitePosition(map, 69));

        RichDeferredTool deferredTool = new RoadBlockTool();
        assertFalse(deferredTool.installTool(player, 69));
    }
}
