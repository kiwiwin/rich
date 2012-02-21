package RichSiteTest;

import DummyObject.DummyColor;
import RichColor.RichColor;
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

    public void test_should_return_player_buy_house_for_1000_money() {
        String buyHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(buyHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney moneyBeforeBuyHouse = new RichMoney(5000);
        RichPlayer player = new RichPlayer(moneyBeforeBuyHouse, dummyPoint);


        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        RichMoney expectMoneyAfterHouse = moneyBeforeBuyHouse.subtract(housePrice);
        assertEquals(player, house.getOwner());
        assertEquals(expectMoneyAfterHouse, player.getMoney());
        assertEquals("是否购买该处空地，1000元（Y/N）?\n", writerStream.toString());
    }

    public void test_should_return_player_not_buy_house() {
        String notBuyHouseString = "N\n";
        BufferedReader reader = new BufferedReader(new StringReader(notBuyHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney playerOriginalMoney = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerOriginalMoney, dummyPoint);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        RichHouseSite site = new RichHouseSite(reader, writer, house);

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

        RichMoney moneyBeforeBuyHouse = new RichMoney(500);
        RichPlayer player = new RichPlayer(moneyBeforeBuyHouse, dummyPoint);

        RichMoney housePrice = new RichMoney(1000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));
        RichHouseSite site = new RichHouseSite(reader, writer, house);

        site.acceptPlayer(player);

        String expectString = "是否购买该处空地，1000元（Y/N）?\n" + "你现金不足\n";

        assertFalse(house.hasOwner());
        assertEquals(moneyBeforeBuyHouse, player.getMoney());
        assertEquals(expectString, writerStream.toString());
    }

    public void test_should_return_player_upgrade_house_cost_2000_money() {
        String upgradeHouseString = "Y\n";
        BufferedReader reader = new BufferedReader(new StringReader(upgradeHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);


        RichMoney moneyBeforeUpgrade = new RichMoney(5000);
        RichPlayer player = new RichPlayer(moneyBeforeUpgrade, dummyPoint);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        RichMoney expectMoneyAfterUpgrade = moneyBeforeUpgrade.subtract(housePrice);

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(expectMoneyAfterUpgrade, player.getMoney());
        assertEquals("是否升级该处地产，2000元（Y/N）?\n", writerStream.toString());
    }


    public void test_should_return_player_not_upgrade_house() {
        String notUpgradeHouseString = "N\n";
        BufferedReader reader = new BufferedReader(new StringReader(notUpgradeHouseString));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney playerOriginalMoney = new RichMoney(5000);
        RichPlayer player = new RichPlayer(playerOriginalMoney, dummyPoint);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

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

        RichMoney moneyBeforeUpgrade = new RichMoney(0);
        RichPlayer player = new RichPlayer(moneyBeforeUpgrade, dummyPoint);

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        player.addHouse(house);

        RichHouseSite site = new RichHouseSite(reader, writer, house);
        site.acceptPlayer(player);

        String expectString = "是否升级该处地产，2000元（Y/N）?\n" + "你现金不足\n";

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(moneyBeforeUpgrade, player.getMoney());
        assertEquals(expectString, writerStream.toString());
    }

    public void test_should_return_player_pay_for_toll_1000() {
        RichMoney ownerMoneyBefore = new RichMoney(5000);
        RichPlayer owner = createPlayerWithDummyPoint(ownerMoneyBefore, "Q", new DummyColor());

        RichMoney housePrice = new RichMoney(2000);
        RichHouse house = new RichHouse(new RichHousePlatLevel(housePrice));

        owner.addHouse(house);

        RichMoney visitorMoneyBefore = new RichMoney(5000);
        RichPlayer visitor = createPlayerWithDummyPoint(visitorMoneyBefore, "A", new DummyColor());

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichHouseSite site = new RichHouseSite(dummyReader, writer, house);
        site.acceptPlayer(visitor);

        RichMoney expectOwnerMoneyAfter = new RichMoney(6000);
        RichMoney expectVisitorMoneyAfter = new RichMoney(4000);

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(expectOwnerMoneyAfter, owner.getMoney());
        assertEquals(expectVisitorMoneyAfter, visitor.getMoney());
        assertEquals("A付给Q过路费1000元\n", writerStream.toString());
    }

    private RichPlayer createPlayerWithDummyPoint(RichMoney ownerMoneyBefore, String name, RichColor color) {
        RichPlayer owner = new RichPlayer(ownerMoneyBefore, dummyPoint);
        owner.setName(name);
        owner.setColor(color);
        return owner;
    }

    public void test_should_return_0_for_toll_of_plat_original_price_is_1000_if_house_owner_is_at_prison_or_hospital() {
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMoney ownerMoneyBefore = new RichMoney(500);
        RichPlayer owner = createPlayerWithDummyPoint(ownerMoneyBefore, "Q", new DummyColor());
        owner.setPunishDays(3);

        RichHouse house = new RichHouse(new RichHousePlatLevel(new RichMoney(1000)));
        RichHouseSite site = new RichHouseSite(dummyReader, writer, house);

        owner.addHouse(house);

        RichMoney visitorMoneyBefore = new RichMoney(600);
        RichPlayer visitor = createPlayerWithDummyPoint(visitorMoneyBefore, "A", new DummyColor());
        site.acceptPlayer(visitor);

        assertEquals(ownerMoneyBefore, owner.getMoney());
        assertEquals(visitorMoneyBefore, visitor.getMoney());
        assertEquals("Q受罚中，无需过路费\n", writerStream.toString());
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
