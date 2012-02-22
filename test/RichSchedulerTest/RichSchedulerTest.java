package RichSchedulerTest;

import DummyObject.RichDummyMapBuilder;
import RichColor.RichBlueColor;
import RichColor.RichRedColor;
import RichCommand.RichDefaultCommandFactory;
import RichCore.*;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;
import RichScheduler.RichCommandFactory;
import RichScheduler.RichPlayerFactory;
import RichSite.RichDefaultMap;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichSchedulerTest extends TestCase {
    private final BufferedReader dummyReader = null;
    private final RichMoney dummyMoney = null;
    private final RichPoint dummyPoint = null;
    private final PrintStream dummyWriter = null;

    public void test_should_return_10000_for_default_player_money() {
        BufferedReader reader = new BufferedReader(new StringReader("\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        scheduler.initMoney();

        assertEquals(new RichMoney(10000), scheduler.getInitMoney());
    }

    public void test_should_return_1000_for_input_player_money() {
        BufferedReader reader = new BufferedReader(new StringReader("1000\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        scheduler.initMoney();

        assertEquals(new RichMoney(1000), scheduler.getInitMoney());
    }

    public void test_should_be_exception_for_input_player_money_10() {
        BufferedReader reader = new BufferedReader(new StringReader("10\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        try {
            scheduler.initMoney();
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的初始金钱，请重新输入：（1000~50000）", ex.getMessage());
        }
    }

    public void test_should_return_qa_for_input_12() {
        BufferedReader reader = new BufferedReader(new StringReader("12\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(reader, writer));
        map.buildMap();

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);
        scheduler.setPlayerFactory(new RichPlayerFactory());
        scheduler.setMap(map);

        scheduler.initPlayers();

        assertEquals(2, scheduler.getPlayersNumber());
    }

    public void test_should_be_exception_for_input_11_duplicate_player() {
        BufferedReader reader = new BufferedReader(new StringReader("11\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(reader, writer));
        map.buildMap();

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);
        scheduler.setPlayerFactory(new RichPlayerFactory());
        scheduler.setMap(map);

        try {
            scheduler.initPlayers();
            fail("player cannot be duplicate");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的玩家编号", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_create_45() {
        BufferedReader reader = new BufferedReader(new StringReader("45\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);
        scheduler.setPlayerFactory(new RichPlayerFactory());
        try {
            scheduler.initPlayers();
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的玩家编号", ex.getMessage());
        }
    }


    public void test_should_return_A_win_for_only_one_player() {
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, writer));
        map.buildMap();

        RichTestUseScheduler scheduler = new RichTestUseScheduler(dummyReader, writer);
        RichPlayer player = new RichPlayer(dummyMoney, dummyPoint);
        player.setName("A");
        player.setColor(new RichRedColor());
        scheduler.addPlayer(player);
        scheduler.schedule();

        String expectString = "胜利者是: " + (char) 27 + "[01;31mA" + (char) 27 + "[00;00m\n";
        assertEquals(expectString, writerStream.toString());
    }

    public void test_return_2_for_get_players_number_when_one_player_run_out_money() {
        BufferedReader reader = new BufferedReader(new StringReader("roll\nquit\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer poorPlayer = new RichPlayer(new RichMoney(-100), dummyPoint);
        poorPlayer.setName("dummy name");
        poorPlayer.setColor(new RichRedColor());
        poorPlayer.initPosition(new RichSitePosition(map, 0));

        RichPlayer dummyPlayer1 = new RichPlayer(new RichMoney(1000), dummyPoint);
        dummyPlayer1.setName("dummy name 1");
        dummyPlayer1.setColor(new RichBlueColor());
        RichPlayer dummyPlayer2 = new RichPlayer(new RichMoney(1000), dummyPoint);
        dummyPlayer2.setName("dummy name 2");
        dummyPlayer2.setColor(new RichBlueColor());


        RichCommandFactory commandFactory = new RichDefaultCommandFactory();

        scheduler.addPlayer(poorPlayer);
        scheduler.addPlayer(dummyPlayer1);
        scheduler.addPlayer(dummyPlayer2);
        scheduler.setMap(map);
        scheduler.setCommandFactory(commandFactory);

        scheduler.schedule();
        assertEquals(2, scheduler.getPlayersNumber());
    }

    public void test_player_house_should_be_reinitialized_for_player_lost() {
        BufferedReader reader = new BufferedReader(new StringReader("roll\nquit\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichHouse houseOfPoor = new RichHouse(new RichHouseCottageLevel(dummyMoney));

        RichPlayer poorPlayer = new RichPlayer(new RichMoney(-100), dummyPoint);
        poorPlayer.setName("dummy name");
        poorPlayer.setColor(new RichRedColor());
        poorPlayer.initPosition(new RichSitePosition(map, 0));
        poorPlayer.addHouse(houseOfPoor);

        scheduler.checkPlayerHasMoney(poorPlayer);

        assertEquals(0, poorPlayer.getHousesNumber());
        assertFalse(houseOfPoor.hasOwner());
        assertTrue(houseOfPoor.getLevel() instanceof RichHousePlatLevel);
    }

    public void test_return_false_for_player_is_punished_for_his_day() {
        BufferedReader reader = new BufferedReader(new StringReader("quit\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        RichPlayer playerBePunished = new RichPlayer(new RichMoney(1000), dummyPoint);
        playerBePunished.setName("dummy name");
        playerBePunished.setColor(new RichRedColor());
        playerBePunished.setPunishDays(5);
        RichPlayer dummyPlayer = new RichPlayer(new RichMoney(1000), dummyPoint);
        dummyPlayer.setName("dummy name 2");
        dummyPlayer.setColor(new RichBlueColor());

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();
        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();

        scheduler.addPlayer(playerBePunished);
        scheduler.addPlayer(dummyPlayer);
        scheduler.setMap(map);
        scheduler.setCommandFactory(commandFactory);

        scheduler.schedule();

        assertEquals(4, playerBePunished.getPunishDays());
    }

    public void test_input_invalid_command() {
        BufferedReader reader = new BufferedReader(new StringReader("invalid command\nquit\n"));

        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichPlayer dummyPlayer1 = new RichPlayer(new RichMoney(1000), dummyPoint);
        dummyPlayer1.setName("dummy name 1");
        dummyPlayer1.setColor(new RichBlueColor());
        RichPlayer dummyPlayer2 = new RichPlayer(new RichMoney(1000), dummyPoint);
        dummyPlayer2.setName("dummy name 2");
        dummyPlayer2.setColor(new RichBlueColor());

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        scheduler.addPlayer(dummyPlayer1);
        scheduler.addPlayer(dummyPlayer2);
        scheduler.setCommandFactory(new RichDefaultCommandFactory());
        scheduler.setMap(map);

        scheduler.schedule();

        assertEquals(2, scheduler.getPlayersNumber());
    }
}
