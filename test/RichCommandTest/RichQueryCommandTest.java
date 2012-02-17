package RichCommandTest;

import RichCommand.RichQueryCommand;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RichQueryCommandTest extends TestCase {

    public void test_query_initialize_player() {
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichPlayer player = new RichPlayer(new RichMoney(10000), new RichPoint(0));
        RichQueryCommand command = new RichQueryCommand(writer, player);

        command.executeCommand();

        String expectDisplay = "资金：10000元\n" +
                "点数：0点\n" +
                "地产：空地0处；茅屋0处；洋房0处；摩天楼0处\n" +
                "道具：路障0个；炸弹0个；机器娃娃0个\n";

        assertEquals(expectDisplay, writerStream.toString());
  }
}
