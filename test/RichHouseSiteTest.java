import RichHouse.RichHouse;
import RichMap.RichHouseSite;
import RichPlayer.RichPlayer;
import junit.framework.TestCase;

import java.io.*;


public class RichHouseSiteTest extends TestCase {
    private PrintStream _console;
    private InputStream _keyboard;

    private void set_input(String inputFileName) {
        try {
            _keyboard = System.in;
            System.setIn(new FileInputStream(inputFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void reset_input() {
        System.setIn(_keyboard);
    }

    private void set_output(String outputFileName) {
        try {
            _console = System.out;
            System.setOut(new PrintStream(new FileOutputStream(outputFileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void reset_output() {
        System.setOut(_console);
    }

    private boolean compareFile(String answer, String test) {
        try {
            BufferedReader answerReader = new BufferedReader(new FileReader(answer));
            BufferedReader testReader = new BufferedReader(new FileReader(test));

            int lineNumber = 1;
            while (true) {
                String answerLine = answerReader.readLine();
                String testLine = testReader.readLine();

                if (answerLine == null && testLine == null)
                    return true;

                if (answerLine == null) {
                    System.out.println("answer should have " + lineNumber + " line.");
                    return false;
                }
                if (testLine == null) {
                    System.out.println("answer should have " + lineNumber + " line.");
                    return false;
                }

                if (!answerLine.equals(testLine)) {
                    System.out.println("Line " + lineNumber + " should be :" + answerLine + ", but actual: " + testLine);
                    return false;
                }

                lineNumber++;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public void test_should_return_do_you_want_buy_house() {
        set_output("./test/note_for_empty_plat_test.txt");
        RichHouseSite site = new RichHouseSite(new RichHouse(1000));
        site.acceptPlayer(new RichPlayer());
        reset_output();
        assertTrue(compareFile("./test/note_for_empty_plat_answer.txt", "./test/note_for_empty_plat_test.txt"));
    }



    public void test_should_return_player_buy_house() {
        assertTrue("should redirect input today", false);
//        set_input();
//        set_output("./test/buy_empty_play_test.txt");
//        RichHouse house = new RichHouse(2000);
//        RichHouseSite site = new RichHouseSite(house);
//        RichPlayer player = new RichPlayer();
//        player.setMoney(5000);
//        site.acceptPlayer(player);
    }

    public void test_should_return_do_you_want_upgrade_house() {
        set_output("./test/note_for_upgrade_house_test.txt");
        RichHouse house = new RichHouse(2000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);
        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(player);
        reset_output();
        assertTrue(compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }
}
