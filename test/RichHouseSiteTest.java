import RichHouse.RichHouse;
import RichMap.RichHouseSite;
import RichPlayer.RichPlayer;
import RichHouse.RichHouseCottageLevel;
import RichHouse.RichHousePlatLevel;

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

    public void test_should_return_player_buy_house() {
        set_input("./test/player_buy_house_input.txt");
        set_output("./test/buy_empty_play_test.txt");

        RichHouse house = new RichHouse(1000);
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertEquals(player, house.getOwner());
        assertEquals(4000, player.getMoney());
        assertTrue(compareFile("./test/note_for_empty_plat_answer.txt", "./test/buy_empty_play_test.txt"));
    }

    public void test_should_return_player_not_buy_house() {
        set_input("./test/player_not_buy_house_input.txt");
        set_output("./test/not_buy_empty_play_test.txt");

        RichHouse house = new RichHouse(1000);
        RichHouseSite site = new RichHouseSite(house);
        RichPlayer player = new RichPlayer();
        player.setMoney(5000);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertEquals(null, house.getOwner());
        assertEquals(5000, player.getMoney());
        assertTrue(compareFile("./test/note_for_empty_plat_answer.txt", "./test/not_buy_empty_play_test.txt"));
    }

    public void test_should_return_player_upgrade_house() {
        set_input("./test/player_upgrade_house_input.txt");
        set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(2000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);
        player.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertTrue(house.getLevel() instanceof RichHouseCottageLevel);
        assertEquals(3000, player.getMoney());
        assertTrue(compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }

    public void test_should_return_player_not_upgrade_house() {
        set_input("./test/player_not_upgrade_house_input.txt");
        set_output("./test/note_for_upgrade_house_test.txt");

        RichHouse house = new RichHouse(2000);
        RichPlayer player = new RichPlayer();
        player.addHouse(house);
        player.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(player);

        reset_input();
        reset_output();

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(5000, player.getMoney());
        assertTrue(compareFile("./test/note_for_upgrade_house_answer.txt", "./test/note_for_upgrade_house_test.txt"));
    }

    public void test_should_return_player_pay_for_toll() {
        RichHouse house = new RichHouse(2000);
        RichPlayer owner = new RichPlayer();
        owner.addHouse(house);
        owner.setMoney(5000);
        RichPlayer visitor = new RichPlayer();
        visitor.setMoney(5000);

        RichHouseSite site = new RichHouseSite(house);
        site.acceptPlayer(visitor);

        reset_input();
        reset_output();

        assertTrue(house.getLevel() instanceof RichHousePlatLevel);
        assertEquals(6000, owner.getMoney());
        assertEquals(4000, visitor.getMoney());
    }
}
