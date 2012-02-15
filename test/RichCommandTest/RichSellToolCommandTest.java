package RichCommandTest;

import RichCommand.RichSellToolCommand;
import RichPlayer.RichPlayer;
import RichTool.RichTool;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

public class RichSellToolCommandTest extends TestCase {
    public void test_sell_tool_success(){
        RichPlayer player = new RichPlayer();
        RichTool tool = RichToolFactory.createTool(RichToolFactory.ROADBLOCK);
        player.addTool(tool);
        player.setPoints(0);
        RichSellToolCommand command = new RichSellToolCommand(player, tool);
        command.executeCommand();

        assertEquals(50, player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }
}
