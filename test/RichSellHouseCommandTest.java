import RichCommand.RichSellHouseCommand;
import RichHouse.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

public class RichSellHouseCommandTest extends TestCase {
    public void test_should_return_sell_house_success() {
        RichPlayer player = new RichPlayer();
        RichHouse house = new RichHouse(new RichHousePlatLevel(1000));
        player.setMoney(0);

        player.addHouse(house);

        RichSellHouseCommand command = new RichSellHouseCommand(player, house);
        command.executeCommand();

        assertEquals(2000, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }
}
