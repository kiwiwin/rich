package RichCommandTest;

import RichCommand.RichBlockCommand;
import RichCommand.RichCommandFactory;
import junit.framework.TestCase;

public class RichCommandFactoryTest extends TestCase {
    public void test_create_block_command() {
        assertTrue(new RichCommandFactory(null).createCommand("block 3", null) instanceof RichBlockCommand);
    }

    public void test_create_bomb_command() {

    }

    public void test_create_help_command() {

    }

    public void test_create_query_command() {

    }

    public void test_create_robot_command() {

    }

    public void test_create_roll_command() {

    }

    public void test_create_sell_house_command() {

    }

    public void test_create_sell_tool_command() {

    }
}
