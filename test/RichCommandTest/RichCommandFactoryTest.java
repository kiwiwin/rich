package RichCommandTest;

import RichCommand.*;
import junit.framework.TestCase;

public class RichCommandFactoryTest extends TestCase {
    public void test_create_roll_command() {
        assertTrue(new RichCommandFactory(null).createCommand("roll", null) instanceof RichRollCommand);
    }

    public void test_create_block_command() {
        assertTrue(new RichCommandFactory(null).createCommand("block 3", null) instanceof RichBlockCommand);
    }

    public void test_create_bomb_command() {
        assertTrue(new RichCommandFactory(null).createCommand("bomb 5", null) instanceof RichBombCommand);
    }

    public void test_create_robot_command() {
        assertTrue(new RichCommandFactory(null).createCommand("robot", null) instanceof RichRobotCommand);
    }

    public void test_create_sell_house_command() {
        assertTrue(new RichCommandFactory(null).createCommand("sell 34", null) instanceof RichSellHouseCommand);
    }

    public void test_create_sell_tool_command() {
        assertTrue(new RichCommandFactory(null).createCommand("selltool 1", null) instanceof RichSellToolCommand);
    }

    public void test_create_help_command() {
        assertTrue(new RichCommandFactory(null).createCommand("help", null) instanceof RichHelpCommand);
    }

    public void test_create_query_command() {
        assertTrue(new RichCommandFactory(null).createCommand("query", null) instanceof RichQueryCommand);
    }

    public void test_create_quit_command() {
        assertTrue(new RichCommandFactory(null).createCommand("quit", null) instanceof RichQuitCommand);
    }

    public void test_create_invalid_command() {
        try {
            new RichCommandFactory(null).createCommand("invalid command", null);
            fail("there should have an exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid Command", ex.getMessage());
        }
    }

}
