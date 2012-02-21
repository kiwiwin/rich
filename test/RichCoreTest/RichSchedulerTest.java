package RichCoreTest;

import DummyObject.RichDummyMapBuilder;
import RichColor.RichBlueColor;
import RichColor.RichRedColor;
import RichCommand.RichCommandFactory;
import RichCore.RichMap;
import RichCore.RichMoney;
import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichMain.RichDefaultPlayerFactory;
import RichSite.RichDefaultMap;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

public class RichSchedulerTest extends TestCase {
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

        }
    }

    public void test_should_return_qa_for_input_12() {
        BufferedReader reader = new BufferedReader(new StringReader("12\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(reader, writer));
        map.buildMap();

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);
        scheduler.setPlayerFactory(new RichDefaultPlayerFactory());
        scheduler.setMap(map);
        scheduler.initPlayers();

        assertEquals(2, scheduler.getPlayersNumber());
    }

    public void test_should_be_exception_for_create_45() {
        BufferedReader reader = new BufferedReader(new StringReader("45\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);
        scheduler.setPlayerFactory(new RichDefaultPlayerFactory());
        try {
            scheduler.initPlayers();
            fail();
        } catch (IllegalArgumentException ex) {
        }
    }


    public void test_should_return_A_win_for_only_one_player() {
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, writer));
        map.buildMap();

        RichTestUseScheduler scheduler = new RichTestUseScheduler(null, writer);
        RichPlayer player = new RichPlayer(null, null);
        player.setName("A");
        player.setColor(new RichRedColor());
        scheduler.addPlayer(player);
        scheduler.schedule();

        String expectString = "Winner is: " + (char) 27 + "[01;31mA" + (char) 27 + "[00;00m\n";
        assertEquals(expectString, writerStream.toString());
    }

    public void test_return_2_for_get_players_number_when_one_player_run_out_money() {
        BufferedReader reader = new BufferedReader(new StringReader("roll\nquit\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        map.buildMap();

        RichPlayer playerWithoutMoney = new RichPlayer(new RichMoney(-100), null);
        playerWithoutMoney.setName("dummy name");
        playerWithoutMoney.setColor(new RichRedColor());
        playerWithoutMoney.initPosition(new RichSitePosition(map, 0));
        RichPlayer dummyPlayer1 = new RichPlayer(new RichMoney(1000), null);
        dummyPlayer1.setName("dummy name 1");
        dummyPlayer1.setColor(new RichBlueColor());
        RichPlayer dummyPlayer2 = new RichPlayer(new RichMoney(1000), null);
        dummyPlayer2.setName("dummy name 2");
        dummyPlayer2.setColor(new RichBlueColor());


        RichCommandFactory commandFactory = new RichCommandFactory();

        scheduler.addPlayer(playerWithoutMoney);
        scheduler.addPlayer(dummyPlayer1);
        scheduler.addPlayer(dummyPlayer2);
        scheduler.setMap(map);
        scheduler.setCommandFactory(commandFactory);

        scheduler.schedule();
        assertEquals(2, scheduler.getPlayersNumber());
    }

    public void test_return_false_for_player_is_punished_for_his_day() {
        BufferedReader reader = new BufferedReader(new StringReader("quit\n"));
        ByteArrayOutputStream writerStream = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(writerStream);

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        RichPlayer playerBePunished = new RichPlayer(new RichMoney(1000), null);
        playerBePunished.setName("dummy name");
        playerBePunished.setColor(new RichRedColor());
        playerBePunished.setPunishDays(5);
        RichPlayer dummyPlayer = new RichPlayer(new RichMoney(1000), null);
        dummyPlayer.setName("dummy name 2");
        dummyPlayer.setColor(new RichBlueColor());

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        map.buildMap();
        RichCommandFactory commandFactory = new RichCommandFactory();

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

        RichMap map = new RichDefaultMap(new RichDummyMapBuilder(null, null));
        map.buildMap();

        RichPlayer dummyPlayer1 = new RichPlayer(new RichMoney(1000), null);
        dummyPlayer1.setName("dummy name 1");
        dummyPlayer1.setColor(new RichBlueColor());
        RichPlayer dummyPlayer2 = new RichPlayer(new RichMoney(1000), null);
        dummyPlayer2.setName("dummy name 2");
        dummyPlayer2.setColor(new RichBlueColor());

        RichTestUseScheduler scheduler = new RichTestUseScheduler(reader, writer);

        scheduler.addPlayer(dummyPlayer1);
        scheduler.addPlayer(dummyPlayer2);
        scheduler.setCommandFactory(new RichCommandFactory());
        scheduler.setMap(map);

        scheduler.schedule();

        assertEquals(2, scheduler.getPlayersNumber());
    }
}
