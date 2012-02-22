package RichCommandTest;

import RichCommand.*;
import RichCore.RichMap;
import RichCore.RichPlayer;
import RichCore.RichSitePosition;
import RichCore.RichToolFactory;
import RichSite.RichDefaultMap;
import RichSite.RichDefaultMapBuilder;
import RichTool.RichDefaultToolFactory;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichDefaultCommandFactoryTest extends TestCase {
    private final RichPlayer dummyPlayer = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;
    private final RichSitePosition dummyHospitalPosition = null;

    public void test_create_roll_command() {
        assertTrue(new RichDefaultCommandFactory().createCommand("roll", dummyPlayer) instanceof RichRollCommand);
    }

    public void test_create_block_command() {
        assertTrue(new RichDefaultCommandFactory().createCommand("block 3", dummyPlayer) instanceof RichBlockCommand);
    }

    public void test_create_bomb_command() {
        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setHospitalSitePosition(dummyHospitalPosition);
        assertTrue(commandFactory.createCommand("bomb 5", dummyPlayer) instanceof RichBombCommand);
    }

    public void test_create_robot_command() {
        assertTrue(new RichDefaultCommandFactory().createCommand("robot", dummyPlayer) instanceof RichRobotCommand);
    }

    public void test_create_sell_house_command() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setMap(map);

        assertTrue(commandFactory.createCommand("sell 34", dummyPlayer) instanceof RichSellHouseCommand);
    }

    public void test_should_be_exception_create_sell_house_command_which_the_site_is_not_house_site() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setMap(map);

        try {
            commandFactory.createCommand("sell 0", dummyPlayer);
            fail("cannot sell house which index is start site");
        } catch (Exception ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }

    public void test_create_sell_tool_command() {
        RichToolFactory toolFactory = new RichDefaultToolFactory();

        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setToolFactory(toolFactory);
        assertTrue(commandFactory.createCommand("selltool 1", dummyPlayer) instanceof RichSellToolCommand);
    }

    public void test_create_help_command() {
        RichDefaultCommandFactory commandFactory = new RichDefaultCommandFactory();
        commandFactory.setWriter(dummyWriter);
        assertTrue(commandFactory.createCommand("help", dummyPlayer) instanceof RichHelpCommand);
    }

    public void test_create_query_command() {
        assertTrue(new RichDefaultCommandFactory().createCommand("query", dummyPlayer) instanceof RichQueryCommand);
    }

    public void test_create_quit_command() {
        assertTrue(new RichDefaultCommandFactory().createCommand("quit", dummyPlayer) instanceof RichQuitCommand);
    }

    public void test_create_invalid_command() {
        try {
            new RichDefaultCommandFactory().createCommand("invalid command", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }


    public void test_should_be_exception_for_block_invalid_offset() {
        try {
            new RichDefaultCommandFactory().createCommand("block invalid offset", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_block_12() {
        try {
            new RichDefaultCommandFactory().createCommand("block 12", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_invalid_offset() {
        try {
            new RichDefaultCommandFactory().createCommand("bomb invalid offset", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_12() {
        try {
            new RichDefaultCommandFactory().createCommand("bomb 12", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("错误的命令", ex.getMessage());
        }
    }
}
