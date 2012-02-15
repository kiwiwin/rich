package RichCommandTest;

import RichCommand.RichBlockCommand;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;
import junit.framework.TestCase;
import RichPlayer.RichMoney;

public class RichBlockCommandTest extends TestCase{
    private static final RichMoney dummyMoney = new RichMoney(0);
    
    public void test_should_return_has_road_block_at_site_10()
    {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        player.setPosition(new RichSitePosition(map, 0));
        RichBlockCommand command = new RichBlockCommand(player, 10);

        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }

    public void test_should_return_has_road_block_at_negative_site_10()
    {
        RichMap map = RichMap.instance();
        RichPlayer player = new RichPlayer(dummyMoney);
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        player.setPosition(new RichSitePosition(map, 0));
        RichBlockCommand command = new RichBlockCommand(player, -10);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }
}
