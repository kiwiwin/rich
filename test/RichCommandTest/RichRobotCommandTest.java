package RichCommandTest;

import RichCommand.RichRobotCommand;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.*;
import RichTool.RichDeferredTool;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

public class RichRobotCommandTest extends TestCase {
    public void test_should_clean_tools() {
        RichPlayer player = new RichPlayer(new RichMoney(0), null);
        RichMap map = RichMap.buildMap();
    
        player.setPosition(new RichSitePosition(map, 0));
        
        map.getSite(10).installDeferredTool((RichDeferredTool)RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        
        RichRobotCommand command = new RichRobotCommand(player);
        command.executeCommand();

        assertFalse(map.getSite(10).hasDeferredToolInstalled());
    }
}