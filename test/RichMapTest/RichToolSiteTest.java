package RichMapTest;

import RichMap.RichToolSite;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import RichTool.RichToolFactory;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichToolSiteTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;
    private static final RichToolFactory dummyFactory = null;

    public void test_should_return_T_for_display() {
        RichToolSite site = new RichToolSite(dummyReader, dummyWriter, dummyFactory);
        assertEquals("T", site.display());
    }

    public void test_should_return_player_exit_rich_tool_site_automatically() {
        RichPoint originalNotEnoughPoint = new RichPoint(10);
        RichPlayer player = new RichPlayer(dummyMoney, originalNotEnoughPoint);

        RichToolSite site = new RichToolSite(dummyReader, dummyWriter, dummyFactory);
        site.doAcceptPlayer(player);

        assertEquals(originalNotEnoughPoint, player.getPoints());
    }

    public void test_should_return_player_buy_1_roadblock_2_robot_3_bomb() {
        String buy1Block2Robot3BombString = "3\n2\n1\n3\n2\n3\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(buy1Block2Robot3BombString));

        RichPoint initPoint = new RichPoint(1000);
        RichPlayer player = new RichPlayer(dummyMoney, initPoint);

        RichToolSite site = new RichToolSite(reader, dummyWriter, new RichToolFactory(null));
        site.doAcceptPlayer(player);

        RichPoint expectPoint = new RichPoint(740);
        assertEquals(expectPoint, player.getPoints());
        assertEquals(6, player.getToolsNumber());
    }

    public void test_should_return_invalid_tool_() {
        String invalidToolTypeString = "invalid tool tool type\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(invalidToolTypeString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint originalPoint = new RichPoint(1000);
        RichPlayer player = new RichPlayer(dummyMoney, originalPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichToolFactory(null));
        site.doAcceptPlayer(player);

        assertEquals(originalPoint, player.getPoints());
        assertEquals(0, player.getToolsNumber());
        assertEquals("错误的道具类型\n", writerStream.toString());
    }

    public void test_should_return_not_have_enough_points_buy_bomb() {
        String buyBombString = "3\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(buyBombString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint originalPoint = new RichPoint(40);
        RichPlayer player = new RichPlayer(dummyMoney, originalPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichToolFactory(null));
        site.doAcceptPlayer(player);

        assertEquals(originalPoint, player.getPoints());
        assertEquals(0, player.getToolsNumber());
        assertEquals("您当前剩余的点数为40， 不足以购买炸弹道具.\n", writerStream.toString());
    }
}
