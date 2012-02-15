package RichCommandTest;

import RichCommand.RichQueryCommand;
import RichPlayer.RichPlayer;
import TestHelper.RedirectIO;
import junit.framework.TestCase;

public class RichQueryCommandTest extends TestCase {
    public void test_query_initialize_player() {
        RedirectIO.set_output("./test/query_initialize_player_test.txt");

        RichPlayer player = new RichPlayer();
        RichQueryCommand command = new RichQueryCommand(player);

        command.executeCommand();

        RedirectIO.reset_output();
        assertTrue(RedirectIO.compareFile("./test/query_initialize_player_answer.txt", "./test/query_initialize_player_test.txt"));
    }
}
