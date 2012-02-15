package RichCommandTest;

import RichCommand.RichHelpCommand;
import TestHelper.RedirectIO;
import junit.framework.TestCase;

public class RichHelpCommandTest extends TestCase {
    public void test_help_information(){
        RedirectIO.set_output("./test/help_command_display_test.txt");

        RichHelpCommand command = new RichHelpCommand();
        command.executeCommand();

        RedirectIO.reset_output();

        assertTrue(RedirectIO.compareFile("./test/help_command_display_answer.txt", "./test/help_command_display_test.txt"));
    }
}
