import RichTool.*;
import RichMap.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RobotToolTest extends TestCase {
    public void test_should_return_机器娃娃_for_getName() {
        ITool tool = RichToolFactory.createTool(2);
        assertEquals("机器娃娃", tool.getName());
    }

    public void test_should_return_clean_site() {
        RichRealTimeTool robot = (RichRealTimeTool) RichToolFactory.createTool(RichToolFactory.ROBOT);
        RichDeferredTool bomb = (RichDeferredTool) RichToolFactory.createTool(RichToolFactory.BOMB);
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));

        bomb.installTool(player, 10);
        robot.useTool(player);

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}
