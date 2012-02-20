package RichCommandTest;

import RichCommand.RichQuitCommand;
import junit.framework.TestCase;

public class RichQuitCommandTest extends TestCase {
    public void test_execute_command() {
        RichQuitCommand command = new RichQuitCommand();
        command.executeCommand();
    }
}
