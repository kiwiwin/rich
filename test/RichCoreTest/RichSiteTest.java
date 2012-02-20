package RichCoreTest;

import RichColor.RichRedColor;
import RichCommandTest.RichDummySite;
import RichCore.RichPlayer;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import RichCore.RichSite;

public class RichSiteTest extends TestCase {
    public void test_should_return_sharp_for_display() {
        RichSite site = new RichDummySite(null, null);
        site.installDeferredTool(new RoadBlockTool());

        assertEquals("#", site.display());
    }

    public void test_should_display_player() {
        RichSite site = new RichDummySite(null, null);
        RichPlayer player = new RichPlayer(null, null);
        player.setName("Q");
        player.setColor(new RichRedColor());
        
        String expectString = new RichRedColor().decorate("Q");
        
        site.addPlayer(player);

        assertEquals(expectString, site.display());
    }
}
