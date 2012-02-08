import RichTool.*;
import RichMap.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class BombToolTest extends TestCase {
    public void test_should_return_炸弹_for_getName() {
        RichTool tool = RichTool.createTool(RichTool.BOMB);
        assertEquals("炸弹", tool.getName());
    }

    public void test_should_return_player_at_hospital() {
        RichTool tool = RichTool.createTool(RichTool.BOMB);
        RichMap map = RichMap.instance();

        map.getSite(1).installTool(tool);

        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));
        player.stepForward();

        assertEquals(map.getHospitalSitePosition().getIndex(), player.getPosition().getIndex());
    }
}
