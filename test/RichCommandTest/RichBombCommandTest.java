package RichCommandTest;

import RichCommand.RichBombCommand;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichPlayer;
import RichTool.RichToolFactory;
import junit.framework.TestCase;
import RichPlayer.RichMoney;

public class RichBombCommandTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);


    public void test_should_return_has_bomb_at_site_5() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        player.setPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, 10);

        command.executeCommand();

        assertTrue(map.getSite(10).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }

    public void test_should_return_has_bomb_at_negative_site_5() {
        RichMap map = RichMap.buildMap();
        RichPlayer player = new RichPlayer(dummyMoney, null);
        player.addTool(RichToolFactory.createTool(RichToolFactory.BOMB));
        player.setPosition(new RichSitePosition(map, 0));
        RichBombCommand command = new RichBombCommand(player, -10);

        command.executeCommand();

        assertTrue(map.getSite(60).hasDeferredToolInstalled());
        assertEquals(0, player.getPosition().getIndex());
    }
}
