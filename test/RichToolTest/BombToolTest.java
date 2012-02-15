package RichToolTest;

import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import RichTool.RichDeferredTool;
import RichTool.RichTool;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

public class BombToolTest extends TestCase {
    public void test_should_display_at_for_bomb_tool() {
        assertEquals("@", RichToolFactory.createTool(RichToolFactory.BOMB).display());
    }

    public void test_should_return_50_for_bomb_get_points() {
        assertEquals(new RichPoint(50), RichToolFactory.createTool(RichToolFactory.BOMB).getPoints());
    }

    public void test_should_return_炸弹_for_getName() {
        RichTool tool = RichToolFactory.createTool(RichToolFactory.BOMB);
        assertEquals("炸弹", tool.getName());
    }

    public void test_should_return_player_at_hospital() {
        RichDeferredTool tool = (RichDeferredTool)RichToolFactory.createTool(RichToolFactory.BOMB);
        RichMap map = RichMap.instance();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));

        tool.installTool(player, 1);

        player.stepForward(1);

        assertEquals(map.getHospitalSitePosition().getIndex(), player.getPosition().getIndex());
        assertFalse(map.getHospitalSitePosition().getSite().hasPlayerStand());
    }
}
