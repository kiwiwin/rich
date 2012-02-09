import RichMap.RichToolSite;
import RichPlayer.RichPlayer;

public class RichToolSiteTest extends RichSiteTest {
    public void test_should_return_T_for_display(){
        RichToolSite site = new RichToolSite();
        assertEquals("T", site.display());
    }

    public void test_should_return_player_exit_rich_tool_site_automatically(){
        RichPlayer player = new RichPlayer();
        player.setPoints(10);

        RichToolSite site = new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(10, player.getPoints());
    }

    public void test_should_return_player_buy_1_roadblock_2_robot_3_bomb(){
        set_input("./test/player_buy_1_roadblock_2_robot_3_bomb.txt");

        RichPlayer player = new RichPlayer();
        player.setPoints(1000);

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(740, player.getPoints());
        assertEquals(6, player.getToolsNumber());
    }

    public void test_should_return_invalid_tool_(){
        set_input("./test/player_buy_invalid_tool.txt");
        set_output("./test/player_buy_invalid_tool_test.txt");
        
        RichPlayer player = new RichPlayer();
        player.setPoints(1000);

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(1000, player.getPoints());
        assertEquals(0, player.getToolsNumber());

        reset_input();
        reset_output();

        assertTrue(compareFile("./test/player_buy_invalid_tool_answer.txt", "./test/player_buy_invalid_tool_test.txt"));
    }

    public void test_should_return_not_have_enough_points_buy_tools(){
        set_input("./test/player_buy_1_roadblock_2_robot_3_bomb.txt");
        set_output("./test/player_have_not_enough_points_buy_tool_test.txt");

        RichPlayer player = new RichPlayer();
        player.setPoints(250);

        RichToolSite site= new RichToolSite();
        site.doAcceptPlayer(player);

        assertEquals(40, player.getPoints());
        assertEquals(5, player.getToolsNumber());

        reset_input();
        reset_output();

        assertTrue(compareFile("./test/player_have_not_enough_points_buy_tool_answer.txt", "./test/player_have_not_enough_points_buy_tool_test.txt"));
    }
}
