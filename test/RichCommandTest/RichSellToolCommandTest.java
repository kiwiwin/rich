package RichCommandTest;

import RichCommand.RichSellToolCommand;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichTool;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

public class RichSellToolCommandTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_sell_tool_success(){
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        RichTool tool = new RoadBlockTool();
        player.addTool(tool);
        RichSellToolCommand command = new RichSellToolCommand(player, tool);
        command.executeCommand();

        assertEquals(new RichPoint(50), player.getPoints());
        assertEquals(0, player.getToolsNumber());
    }
}
