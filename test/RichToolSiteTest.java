import RichPlayer.RichPlayer;
import RichTool.*;
import junit.framework.TestCase;

import java.io.*;

public class RichToolSiteTest extends TestCase {
    public void test_should_display_T() {
        RichToolSite richToolSite = new RichToolSite();
        assertEquals("T", richToolSite.display());
    }

    public void test_should_return_automatic_for_not_enough_points() {
        //TODO
    }

    public void test_player_has_enough_points_to_buy_tools() throws IOException {
        RichToolSite richToolSite = new RichToolSite();
        RichPlayer player = new RichPlayer();
        player.setPoints(1000);

        richToolSite.acceptPlayerCommand(new ToolBuyCommand(player, RichTool.createTool(2)));


        assertEquals(970, player.getPoints());
    }

    public void test_player_has_not_enough_points_to_buy_tools() throws IOException {
        RichToolSite richToolSite = new RichToolSite();
        RichPlayer player = new RichPlayer();
        player.setPoints(20);

        try {
            richToolSite.acceptPlayerCommand(new ToolBuyCommand(player, RichTool.createTool(3)));
        } catch (ToolPointsNotEnoughException ex) {
            assertTrue(true);
            assertEquals("You have 20 points, not enough to buy Bomb tool.", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(false);
        }

        assertEquals(20, player.getPoints());
    }

    public void test_player_has_no_enough_room_for_new_tools() {
        RichToolSite richToolSite = new RichToolSite();
        RichPlayer player = new RichPlayer();
        player.setPoints(10000);
        for (int i = 0; i < 10; i++) {
            player.buyTool(RichTool.createTool(1));
        }
        player.setPoints(10000);

        boolean isException = false;
        try {
            richToolSite.acceptPlayerCommand(new ToolBuyCommand(player, RichTool.createTool(1)));
        } catch (ToolOverflowException ex) {
            assertTrue(true);
            isException = true;
        }

        assertTrue(isException);
        assertEquals(10000, player.getPoints());
    }
}
