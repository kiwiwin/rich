import RichCommand.RichBlockCommand;
import RichPlayer.RichPlayer;
import RichMap.*;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

public class RichBlockCommandTest extends TestCase{
    public void test_should_return_has_road_block_at_site_10()
    {
        RichMap map = RichMap.instance();
        RichPlayer player = new RichPlayer();
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
        RichPlayer player = new RichPlayer();
        player.addTool(RichToolFactory.createTool(RichToolFactory.ROADBLOCK));
        player.setPosition(new RichSitePosition(map, 0));
        RichBlockCommand command = new RichBlockCommand(player, -10);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }
}
