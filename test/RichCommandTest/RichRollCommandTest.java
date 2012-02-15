package RichCommandTest;

import RichCommand.RichRollCommand;
import RichMap.RichMap;
import RichMap.RichSitePosition;
import RichPlayer.*;
import junit.framework.TestCase;

public class RichRollCommandTest extends TestCase {
    private static final RichMoney dummyMoney = new RichMoney(0);

    public void test_should_return_number_range_from_1_to_6_inclusively() {
        RichPlayer player = new RichPlayer(dummyMoney, new RichPoint(0));
        
        RichSitePosition position = new RichSitePosition(RichMap.instance(), 63); //magic position
        player.setPosition(position);
        
        RichRollCommand command = new RichRollCommand(player);

        command.executeCommand();

        assertTrue(player.getPosition().getIndex() <= 69 && player.getPosition().getIndex() >= 64);
    }
}
