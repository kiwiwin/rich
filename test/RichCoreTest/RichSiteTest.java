package RichCoreTest;

import DummyObject.DummyDeferredTool;
import DummyObject.RichDummySite;
import RichColor.RichRedColor;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichCore.RichSite;
import RichTool.RoadBlockTool;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichSiteTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;

    public void test_should_return_sharp_for_display_when_road_block_installed() {
        RichSite site = createDummySite();
        site.installDeferredTool(new RoadBlockTool());

        assertEquals("#", site.display());
    }

    public void test_should_display_player_when_player_is_at_site() {
        RichSite site = createDummySite();

        RichPlayer player = createDummyPlayer();
        player.setName("Q");
        player.setColor(new RichRedColor());

        String expectString = new RichRedColor().decorate("Q");

        site.addPlayer(player);

        assertEquals(expectString, site.display());
    }

    public void test_should_display_dummy_when_site_without_player_or_tool_installed() {
        RichSite site = createDummySite();

        assertEquals("Dummy Site", site.display());
    }

    public void test_should_return_true_for_install_block_without_player_or_tool_installed() {
        RichSite site = createDummySite();

        assertTrue(site.installDeferredTool(new RoadBlockTool()));
    }

    public void test_should_return_false_for_install_block_with_another_tool_installed() {
        RichSite site = createDummySite();

        assertTrue(site.installDeferredTool(new RoadBlockTool()));
        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }

    public void test_should_return_false_for_install_block_with_player_has_stand() {
        RichSite site = createDummySite();

        RichPlayer player = createDummyPlayer();
        site.addPlayer(player);

        assertFalse(site.installDeferredTool(new RoadBlockTool()));
    }

    private RichPlayer createDummyPlayer() {
        return new RichPlayer(dummyMoney, dummyPoint);
    }

    public void test_should_has_no_deferred_tool_when_remove_it() {
        RichSite site = createDummySite();

        assertTrue(site.installDeferredTool(new RoadBlockTool()));
        assertTrue(site.hasDeferredToolInstalled());

        site.removeDeferredTool();

        assertFalse(site.hasDeferredToolInstalled());
    }

    public void test_should_return_true_for_has_player_stand_without_punished() {
        RichSite site = createDummySite();

        RichPlayer player = createDummyPlayer();
        site.addPlayer(player);

        assertTrue(site.hasPlayerStand());
    }

    public void test_should_return_false_for_has_player_punished() {
        RichSite site = createDummySite();

        RichPlayer player = createDummyPlayer();
        player.setPunishDays(5);
        site.addPlayer(player);

        assertTrue(player.isPunished());
        assertFalse(site.hasPlayerStand());
    }

    public void test_should_return_dummy_deferred_tool_has_been_used_for_a_passenger_pass_by() {
        RichSite site = createDummySite();

        DummyDeferredTool dummyTool = new DummyDeferredTool();
        site.installDeferredTool(dummyTool);

        assertFalse(dummyTool.isUsed());

        RichPlayer player = createDummyPlayer();

        site.acceptPassenger(player);

        assertTrue(dummyTool.isUsed());
        assertFalse(site.hasDeferredToolInstalled());
    }

    private RichSite createDummySite() {
        return new RichDummySite(dummyReader, dummyWriter);
    }
}
