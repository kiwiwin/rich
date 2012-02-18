package RichMapTest;

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
    private static final String welcomeMessage = "欢迎光临礼品屋，请选择一件您喜欢的礼品：\n";
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;
    private static final RichGiftFactory dummyGiftFactory = null;

    public void test_should_return_G_for_display(){
        RichGiftSite site = new RichGiftSite(dummyReader, dummyWriter, dummyGiftFactory);
        assertEquals("G", site.display());
    }


    public void test_should_return_get_money_gift_add_2000_money() {
        String getMoneyGiftInputString = "1\n";
        
        BufferedReader reader = new BufferedReader(new StringReader(getMoneyGiftInputString));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);
        
        RichPlayer player = new RichPlayer(new RichMoney(1000), dummyPoint);
        RichGiftSite site = new RichGiftSite(reader, writer, new RichGiftDefaultFactory());

        site.doAcceptPlayer(player);

        String expectMessage = welcomeMessage;
        
        assertEquals(new RichMoney(3000), player.getMoney());
        assertEquals(expectMessage, writerStream.toString());
    }
}
