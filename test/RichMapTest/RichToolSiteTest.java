package RichMapTest;

import RichMap.RichToolSite;
import RichPlayer.RichPlayer;
import RichPlayer.RichMoney;
import RichPlayer.RichPoint;
import TestHelper.RedirectIO;
import junit.framework.TestCase;

public class RichToolSiteTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_should_return_T_for_display(){
        RichToolSite site = new RichToolSite();
        assertEquals("T", site.display());
    }

    public void test_should_return_player_exit_rich_tool_site_automatically(){
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(10));

        RichToolSite site = new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(new RichPoint(10), player.getPoints());
    }

    public void test_should_return_player_buy_1_roadblock_2_robot_3_bomb(){
        RedirectIO.set_input("./test/player_buy_1_roadblock_2_robot_3_bomb.txt");

        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(1000));

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(new RichPoint(740), player.getPoints());
        assertEquals(6, player.getToolsNumber());
    }

    public void test_should_return_invalid_tool_(){
        RedirectIO.set_input("./test/player_buy_invalid_tool.txt");
        RedirectIO.set_output("./test/player_buy_invalid_tool_test.txt");
        
        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(1000));

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(new RichPoint(1000), player.getPoints());
        assertEquals(0, player.getToolsNumber());

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertTrue(RedirectIO.compareFile("./test/player_buy_invalid_tool_answer.txt", "./test/player_buy_invalid_tool_test.txt"));
    }

    public void test_should_return_not_have_enough_points_buy_tools(){
        RedirectIO.set_input("./test/player_buy_1_roadblock_2_robot_3_bomb.txt");
        RedirectIO.set_output("./test/player_have_not_enough_points_buy_tool_test.txt");

        RichPlayer player = new RichPlayer(dummyMoney);
        player.setPoints(new RichPoint(250));

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(new RichPoint(40), player.getPoints());
        assertEquals(5, player.getToolsNumber());

        RedirectIO.reset_input();
        RedirectIO.reset_output();

        assertTrue(RedirectIO.compareFile("./test/player_have_not_enough_points_buy_tool_answer.txt", "./test/player_have_not_enough_points_buy_tool_test.txt"));
    }
}
