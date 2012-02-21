package RichCommandTest;

import RichCommand.*;
import RichCore.RichMap;
import RichCore.RichPlayer;
import RichCore.RichToolFactory;
import RichSite.RichDefaultMap;
import RichSite.RichDefaultMapBuilder;
import RichTool.RichDefaultToolFactory;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichCommandFactoryTest extends TestCase {
    private final RichPlayer dummyPlayer = null;
    private final BufferedReader dummyReader = null;
    private final PrintStream dummyWriter = null;

    public void test_create_roll_command() {
        assertTrue(new RichCommandFactory().createCommand("roll", dummyPlayer) instanceof RichRollCommand);
    }

    public void test_create_block_command() {
        assertTrue(new RichCommandFactory().createCommand("block 3", dummyPlayer) instanceof RichBlockCommand);
    }

    public void test_create_bomb_command() {
        assertTrue(new RichCommandFactory().createCommand("bomb 5", dummyPlayer) instanceof RichBombCommand);
    }

    public void test_create_robot_command() {
        assertTrue(new RichCommandFactory().createCommand("robot", dummyPlayer) instanceof RichRobotCommand);
    }

    public void test_create_sell_house_command() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setMap(map);

        assertTrue(commandFactory.createCommand("sell 34", dummyPlayer) instanceof RichSellHouseCommand);
    }

    public void test_should_be_exception_create_sell_house_command_which_the_site_is_not_house_site() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(dummyReader, dummyWriter));
        map.buildMap();

        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setMap(map);
        
        try{
            commandFactory.createCommand("sell 0", dummyPlayer);
            fail("cannot sell house which index is start site");
        }catch(Exception ex){
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_create_sell_tool_command() {
        RichToolFactory toolFactory = new RichDefaultToolFactory();

        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setToolFactory(toolFactory);
        assertTrue(commandFactory.createCommand("selltool 1", dummyPlayer) instanceof RichSellToolCommand);
    }

    public void test_create_help_command() {
        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setWriter(null);
        assertTrue(commandFactory.createCommand("help", dummyPlayer) instanceof RichHelpCommand);
    }

    public void test_create_query_command() {
        assertTrue(new RichCommandFactory().createCommand("query", dummyPlayer) instanceof RichQueryCommand);
    }

    public void test_create_quit_command() {
        assertTrue(new RichCommandFactory().createCommand("quit", dummyPlayer) instanceof RichQuitCommand);
    }

    public void test_create_invalid_command() {
        try {
            new RichCommandFactory().createCommand("invalid command", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }


    public void test_should_be_exception_for_block_invalid_offset() {
        try {
            new RichCommandFactory().createCommand("block invalid offset", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_block_12() {
        try {
            new RichCommandFactory().createCommand("block 12", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_invalid_offset() {
        try {
            new RichCommandFactory().createCommand("bomb invalid offset", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_12() {
        try {
            new RichCommandFactory().createCommand("bomb 12", dummyPlayer);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }
}
