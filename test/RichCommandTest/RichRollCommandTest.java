package RichCommandTest;

import RichCommand.RichRollCommand;
import RichMap.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RichRollCommandTest extends TestCase {
    public void test_should_return_number_range_from_1_to_6_inclusively() {
        RichPlayer player = new RichPlayer();
        
        RichSitePosition position = new RichSitePosition(RichMap.instance(), 63); //magic position
        player.setPosition(position);
        
        RichRollCommand command = new RichRollCommand(player);

        command.executeCommand();

        assertTrue(player.getPosition().getIndex() <= 69 && player.getPosition().getIndex() >= 64);
    }
}
