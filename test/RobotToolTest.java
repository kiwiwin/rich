import RichTool.*;
import RichMap.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RobotToolTest extends TestCase {
    public void test_should_return_机器娃娃_for_getName() {
        RichTool tool = RichTool.createTool(2);
        assertEquals("机器娃娃", tool.getName());
    }

    public void test_should_return_no_tool_for_nearest_10_sites() {
        RichTool tool = RichTool.createTool(RichTool.ROBOT);
        RichMap map = RichMap.instance();
        RichPlayer player = new RichPlayer();
        player.setPosition(new RichSitePosition(map, 0));

        map.getSite(1).installTool(RichTool.createTool(RichTool.BOMB));
        map.getSite(10).installTool(RichTool.createTool(RichTool.ROADBLOCK));
        
        tool.executeTool(player);
        
        for(int i = 1; i <= 10; i++){
            assertFalse(map.getSite(i).hasToolInstalled());
        }
    }
}
