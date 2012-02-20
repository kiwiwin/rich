package RichCommandTest;

import RichCommand.*;
import RichCore.RichMap;
import RichCore.RichSitePosition;
import RichCore.RichToolFactory;
import RichSite.RichDefaultMap;
import RichSite.RichDefaultMapBuilder;
import RichTool.RichDefaultToolFactory;
import junit.framework.TestCase;

public class RichCommandFactoryTest extends TestCase {
    public void test_create_roll_command() {
        assertTrue(new RichCommandFactory().createCommand("roll", null) instanceof RichRollCommand);
    }

    public void test_create_block_command() {
        assertTrue(new RichCommandFactory().createCommand("block 3", null) instanceof RichBlockCommand);
    }

    public void test_create_bomb_command() {
        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setHospitalSitePosition(new RichSitePosition(null, 0));
        assertTrue(commandFactory.createCommand("bomb 5", null) instanceof RichBombCommand);
    }

    public void test_create_robot_command() {
        assertTrue(new RichCommandFactory().createCommand("robot", null) instanceof RichRobotCommand);
    }

    public void test_create_sell_house_command() {
        RichMap map = new RichDefaultMap(new RichDefaultMapBuilder(null, null));
        map.buildMap();

        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setMap(map);
        assertTrue(commandFactory.createCommand("sell 34", null) instanceof RichSellHouseCommand);
    }

    public void test_create_sell_tool_command() {
        RichToolFactory toolFactory = new RichDefaultToolFactory();

        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setToolFactory(toolFactory);
        assertTrue(commandFactory.createCommand("selltool 1", null) instanceof RichSellToolCommand);
    }

    public void test_create_help_command() {
        RichCommandFactory commandFactory = new RichCommandFactory();
        commandFactory.setWriter(null);
        assertTrue(commandFactory.createCommand("help", null) instanceof RichHelpCommand);
    }

    public void test_create_query_command() {
        assertTrue(new RichCommandFactory().createCommand("query", null) instanceof RichQueryCommand);
    }

    public void test_create_quit_command() {
        assertTrue(new RichCommandFactory().createCommand("quit", null) instanceof RichQuitCommand);
    }

    public void test_create_invalid_command() {
        try {
            new RichCommandFactory().createCommand("invalid command", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }


    public void test_should_be_exception_for_block_invalid_offset(){
        try {
            new RichCommandFactory().createCommand("block invalid offset", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_block_12(){
        try {
            new RichCommandFactory().createCommand("block 12", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_invalid_offset(){
        try {
            new RichCommandFactory().createCommand("bomb invalid offset", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }

    public void test_should_be_exception_for_bomb_12(){
        try {
            new RichCommandFactory().createCommand("bomb 12", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid command", ex.getMessage());
        }
    }
}
