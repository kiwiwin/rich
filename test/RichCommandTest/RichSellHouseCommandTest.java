package RichCommandTest;

import RichCommand.RichSellHouseCommand;
import RichHouse.*;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;
import RichPlayer.RichMoney;

public class RichSellHouseCommandTest extends TestCase {
    public void test_should_return_sell_house_success() {
        RichMoney playerMoneyBeforeSell = new RichMoney(0);
        RichPlayer player = new RichPlayer();
        player.setMoney(playerMoneyBeforeSell);
        
        RichMoney originalHousePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(originalHousePrice));

        player.addHouse(house);

        RichSellHouseCommand command = new RichSellHouseCommand(player, house);
        command.executeCommand();

        RichMoney expectPlayerMoneyAfterSell = playerMoneyBeforeSell.add(originalHousePrice.times(2));
        
        assertEquals(expectPlayerMoneyAfterSell, player.getMoney());
        assertEquals(0, player.getHousesNumber());
    }
}
