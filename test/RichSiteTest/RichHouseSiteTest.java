package RichSiteTest;

import RichCore.RichHouse;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichPoint;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichSite.RichHouseSite;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichHouseSiteTest extends TestCase {
    private static final RichPoint dummyPoint = null;
    private static final BufferedReader dummyReader = null;
    private static final PrintStream dummyWritter = null;

    public void test_should_return_player_buy_house_for_1000_money() {
        String buyHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(buyHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichHouseSite site = new RichHouseSite(reader, writer, house);
        RichMoney playerMoneyBeforeBuyHouse = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeBuyHouse, dummyPoint);
        site.acceptPlayer(player);

        assertEquals(player, house.getOwner());
        RichMoney expectPlayerMoneyAfterHouse = playerMoneyBeforeBuyHouse.subtract(housePrice);
        assertEquals(expectPlayerMoneyAfterHouse, player.getMoney());
        assertEquals("是否购买该处空地，1000元（Y/N）?\n", writerStream.toString());
    }

    public void test_should_return_player_not_buy_house() {
        String notBuyHouseString = "N\n";
        BufferedReader reader = new BufferedReader(new StringReader(notBuyHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichHouseSite site = new RichHouseSite(reader, writer, house);
        RichMoney playerOriginalMoney = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerOriginalMoney, dummyPoint);

        site.acceptPlayer(player);

        assertFalse(house.hasOwner());
        assertEquals(playerOriginalMoney, player.getMoney());
        assertEquals("是否购买该处空地，1000元（Y/N）?\n", writerStream.toString());
    }

    public void test_should_return_player_has_enough_money_buy_house() {
        String buyHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(buyHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichHouseSite site = new RichHouseSite(reader, writer, house);
        RichMoney playerMoneyBeforeBuyHouse = new RichMoney(500);
        RichPlayer player = new RichPlayer(playerMoneyBeforeBuyHouse, dummyPoint);
        site.acceptPlayer(player);

        String expectString = "是否购买该处空地，1000元（Y/N）?\n" + "You do not have enough money\n";

        assertFalse(house.hasOwner());
        assertEquals(playerMoneyBeforeBuyHouse, player.getMoney());
        assertEquals(expectString, writerStream.toString());
    }

    public void test_should_return_player_upgrade_house_cost_2000_money() {
        String upgradeHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(upgradeHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichMoney playerMoneyBeforeUpgradeHouse = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerMoneyBeforeUpgradeHouse, null);
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        RichMoney expectPlayerMoneyAfterUpgradeHouse = playerMoneyBeforeUpgradeHouse.subtract(housePrice);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(expectPlayerMoneyAfterUpgradeHouse, player.getMoney());
        assertEquals("是否升级该处地产，2000元（Y/N）?\n", writerStream.toString());
    }


    public void test_should_return_player_not_upgrade_house() {
        String notUpgradeHouseString = "N\n";
        BufferedReader reader = new BufferedReader(new StringReader(notUpgradeHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichMoney playerOriginalMoney = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerOriginalMoney, dummyPoint);
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(playerOriginalMoney, player.getMoney());
        assertEquals("是否升级该处地产，2000元（Y/N）?\n", writerStream.toString());
    }

    public void test_should_return_player_has_not_enough_money_upgrade_house() {
        String upgradeHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(upgradeHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichMoney playerMoneyBeforeUpgradeHouse = new RichMoney(0);
        RichPlayer player = new RichPlayer(playerMoneyBeforeUpgradeHouse, null);
        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        String expectString = "是否升级该处地产，2000元（Y/N）?\n" + "You do not have enough money\n";

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(playerMoneyBeforeUpgradeHouse, player.getMoney());
        assertEquals(expectString, writerStream.toString());
    }

    public void test_should_return_player_pay_for_toll_1000() {
        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichMoney ownerMoneyBefore = new RichMoney(5000);
        RichPlayer owner = new RichPlayer(ownerMoneyBefore, dummyPoint);
        owner.addHouse(house);
        RichMoney visitorMoneyBefore = new RichMoney(5000);
        RichPlayer visitor = new RichPlayer(visitorMoneyBefore, dummyPoint);

        RichHouseSite site = new RichHouseSite(dummyReader, dummyWritter, house);
        site.acceptPlayer(visitor);

        RichMoney toll = housePrice.divide(2);
        RichMoney expectOwnerMoneyAfter = ownerMoneyBefore.add(toll);
        RichMoney expectVisitorMoneyAfter = visitorMoneyBefore.subtract(toll);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(expectOwnerMoneyAfter, owner.getMoney());
        assertEquals(expectVisitorMoneyAfter, visitor.getMoney());
    }

    public void test_should_return_0_for_toll_of_plat_original_price_is_1000_if_house_owner_is_at_prison_or_hospital() {
        RichMoney anonymousHousePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(anonymousHousePrice));
        RichHouseSite site = new RichHouseSite(dummyReader, dummyWritter, house);
        RichMoney ownerMoneyBefore = new RichMoney(500);
        RichPlayer owner = new RichPlayer(ownerMoneyBefore, dummyPoint);
        owner.setPunishDays(3);
        owner.addHouse(house);

        RichMoney visitorMoneyBefore = new RichMoney(600);
        RichPlayer visitor = new RichPlayer(visitorMoneyBefore, dummyPoint);
        site.acceptPlayer(visitor);

        assertEquals(ownerMoneyBefore, owner.getMoney());
        assertEquals(visitorMoneyBefore, visitor.getMoney());
    }

    public void test_should_return_0_for_toll_of_plat_original_price_is_1000_if_visitor_has_blessing_god() {
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(dummyReader, writer, house);

        RichMoney ownerMoneyBefore = new RichMoney(500);
        RichPlayer owner = new RichPlayer(ownerMoneyBefore, dummyPoint);
        owner.addHouse(house);

        RichMoney visitorMoneyBefore = new RichMoney(600);
        RichPlayer visitor = new RichPlayer(visitorMoneyBefore, dummyPoint);
        visitor.setBlessingGod();
        site.acceptPlayer(visitor);

        assertEquals(ownerMoneyBefore, owner.getMoney());
        assertEquals(visitorMoneyBefore, visitor.getMoney());
        assertEquals("福神附身，可免过路费\n", writerStream.toString());
    }
}
