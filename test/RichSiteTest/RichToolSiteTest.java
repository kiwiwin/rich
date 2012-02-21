package RichSiteTest;

import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichSite.RichToolSite;
import RichTool.RichDefaultToolFactory;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichToolSiteTest extends TestCase {
    private final RichMoney dummyMoney = new RichMoney(0);
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichDefaultToolFactory dummyToolFactory = null;
    private final String toolSiteNoteMessage = "请选择你想要购买的道具：1.路障（50点）；2.机器娃娃（30点）；3.炸弹（50点）：\n";

    public void test_should_return_T_for_display_without_player_or_tool_installed() {
        assertEquals("T", new RichToolSite(dummyReader, dummyWriter, dummyToolFactory).display());
    }

    public void test_should_return_player_exit_rich_tool_site_automatically() {
        RichPoint originalNotEnoughPoint = new RichPoint(10);
        RichPlayer player = new RichPlayer(dummyMoney, originalNotEnoughPoint);

        RichToolSite site = new RichToolSite(dummyReader, dummyWriter, dummyToolFactory);
        site.acceptPlayer(player);

        assertEquals(originalNotEnoughPoint, player.getPoints());
    }

    public void test_should_return_player_buy_1_roadblock_2_robot_3_bomb() {
        String buy1Block2Robot3BombString = "3\n2\n1\n3\n2\n3\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(buy1Block2Robot3BombString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint initPoint = new RichPoint(1000);
        RichPlayer player = new RichPlayer(dummyMoney, initPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichDefaultToolFactory());
        site.acceptPlayer(player);

        RichPoint expectPoint = new RichPoint(740);
        assertEquals(expectPoint, player.getPoints());
        assertEquals(6, player.getToolsNumber());
        assertEquals(toolSiteNoteMessage, writerStream.toString());
    }

    public void test_should_return_player_buy_1_roadblock_and_exit_automatically() {
        String buy1BlockString = "1\n";
        BufferedReader reader = new BufferedReader(new StringReader(buy1BlockString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint initPoint = new RichPoint(60);
        RichPlayer player = new RichPlayer(dummyMoney, initPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichDefaultToolFactory());
        site.acceptPlayer(player);

        RichPoint expectPoint = new RichPoint(10);
        assertEquals(expectPoint, player.getPoints());
        assertEquals(1, player.getToolsNumber());
        assertEquals(toolSiteNoteMessage, writerStream.toString());
    }

    public void test_should_be_exception_create_invalid_tool() {
        String invalidToolTypeString = "invalid tool tool type\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(invalidToolTypeString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint originalPoint = new RichPoint(1000);
        RichPlayer player = new RichPlayer(dummyMoney, originalPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichDefaultToolFactory());
        site.acceptPlayer(player);

        assertEquals(originalPoint, player.getPoints());
        assertEquals(0, player.getToolsNumber());
        assertEquals(toolSiteNoteMessage + "错误的道具类型\n", writerStream.toString());
    }

    public void test_should_return_not_have_enough_points_buy_bomb() {
        String buyBombString = "3\nF\n";
        BufferedReader reader = new BufferedReader(new StringReader(buyBombString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPoint originalPoint = new RichPoint(40);
        RichPlayer player = new RichPlayer(dummyMoney, originalPoint);

        RichToolSite site = new RichToolSite(reader, writer, new RichDefaultToolFactory());
        site.acceptPlayer(player);

        assertEquals(originalPoint, player.getPoints());
        assertEquals(0, player.getToolsNumber());
        assertEquals(toolSiteNoteMessage + "您当前剩余的点数为40， 不足以购买炸弹道具.\n", writerStream.toString());
    }
}
