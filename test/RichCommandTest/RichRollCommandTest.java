package RichCommandTest;

import DummyObject.RichDummyMapBuilder;
import RichCommand.RichRollCommand;
import RichCore.*;
import RichSite.RichDefaultMap;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichRollCommandTest extends TestCase {
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_should_return_number_range_from_1_to_6_inclusively_for_roll_number() {
        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        RichSitePosition position = new RichSitePosition(map, 63);
        player.initPosition(position);

        RichRollCommand command = new RichRollCommand(player);

        command.executeCommand();

        assertTrue(player.getPosition().getIndex() <= 69 && player.getPosition().getIndex() >= 64);
    }
}
