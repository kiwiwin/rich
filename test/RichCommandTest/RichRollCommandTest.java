package RichCommandTest;

import RichCommand.RichRollCommand;
import RichMap.RichDefaultMap;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.RichMoney;
import RichPlayer.RichPlayer;
import RichPlayer.RichPoint;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichRollCommandTest extends TestCase {
    private static final RichMoney dummyMoney = null;
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWriter = null;

    public void test_should_return_number_range_from_1_to_6_inclusively() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        RichSitePosition position = new RichSitePosition(map, 63);
        player.setPosition(position);
        
        RichRollCommand command = new RichRollCommand(player);

        command.executeCommand();

        assertTrue(player.getPosition().getIndex() <= 69 && player.getPosition().getIndex() >= 64);
    }
}
