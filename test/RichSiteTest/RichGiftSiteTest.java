package RichSiteTest;

import RichCore.RichGiftFactory;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichGift.RichGiftDefaultFactory;
import RichSite.RichGiftSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichGiftSiteTest extends TestCase {
    private final String welcomeMessage = "欢迎光临礼品屋，请选择一件您喜欢的礼品：\n";
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichGiftFactory dummyGiftFactory = null;
    private final RichMoney dummyMoney = null;

    public void test_should_return_G_for_display_without_player_and_tool_installed() {
        assertEquals("G", new RichGiftSite(dummyReader, dummyWriter, dummyGiftFactory).display());
    }

    public void test_should_return_get_money_gift_add_2000_money() {
        String getMoneyGiftInputString = "1\n";

        BufferedReader reader = new BufferedReader(new StringReader(getMoneyGiftInputString));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney moneyBeforeGift = new RichMoney(1000);
        RichPlayer player = new RichPlayer(moneyBeforeGift, dummyPoint);

        RichGiftSite site = new RichGiftSite(reader, writer, new RichGiftDefaultFactory());

        site.acceptPlayer(player);

        RichMoney expectMoneyAfterGift = moneyBeforeGift.add(new RichMoney(2000));
        assertEquals(expectMoneyAfterGift, player.getMoney());
        assertEquals(welcomeMessage, writerStream.toString());
    }


    public void test_should_be_exception_for_invalid_gift() {
        String getMoneyGiftInputString = "gr\n";

        BufferedReader reader = new BufferedReader(new StringReader(getMoneyGiftInputString));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichGiftSite site = new RichGiftSite(reader, writer, new RichGiftDefaultFactory());

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);

        site.acceptPlayer(player);

        String expectOutput = welcomeMessage + "错误的礼物类型\n";
        assertEquals(expectOutput, writerStream.toString());
    }
}
