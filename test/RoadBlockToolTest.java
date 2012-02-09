import RichTool.*;
import RichMap.*;
import RichPlayer.*;
import junit.framework.TestCase;

public class RoadBlockToolTest extends TestCase {
    public void test_should_display_sharp_for_roadblock_tool() {
        assertEquals("#", RichToolFactory.createTool(RichToolFactory.ROADBLOCK).display());
    }

    public void test_should_return_50_for_roadblock_get_points() {
        assertEquals(50, RichToolFactory.createTool(RichToolFactory.ROADBLOCK).getPoints());
    }

    public void test_should_return_路障_for_getName() {
        ITool tool = RichToolFactory.createTool(RichToolFactory.ROADBLOCK);
        assertEquals("路障", tool.getName());
    }

    public void test_should_roadblock_block_player() {
        RichDeferredTool tool = (RichDeferredTool)RichToolFactory.createTool(RichToolFactory.ROADBLOCK);
        RichMap map = RichMap.instance();
        RichPlayer player= new RichPlayer();
        player.setPosition(new RichSitePosition(map, 63));

        tool.installTool(player, 1);
        player.setRemainStep(7);
        player.stepForward();

        assertEquals(64, player.getPosition().getIndex());
    }
}
