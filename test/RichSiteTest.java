import junit.framework.TestCase;

import java.io.*;

public class RichSiteTest extends TestCase {
    private PrintStream _console;
    private InputStream _keyboard;

    protected void set_input(String inputFileName) {
        try {
            _keyboard = System.in;
            System.setIn(new FileInputStream(inputFileName));
        } catch (FileNotFoundException e) {
            assertTrue(e.getMessage(), false);
        }
    }

    protected void reset_input() {
        System.setIn(_keyboard);
    }

    protected void set_output(String outputFileName) {
        try {
            _console = System.out;
            System.setOut(new PrintStream(new FileOutputStream(outputFileName)));
        } catch (FileNotFoundException e) {
            assertTrue(e.getMessage(), false);
        }
    }

    protected void reset_output() {
        System.setOut(_console);
    }

    protected boolean compareFile(String answer, String test) {
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
                    System.err.println("answer should have " + lineNumber + " line.");
                    return false;
                }
                if (testLine == null) {
                    System.err.println("answer should have " + lineNumber + " line.");
                    return false;
                }

                if (!answerLine.equals(testLine)) {
                    System.err.println("Line " + lineNumber + " should be :" + answerLine + ", but actual: " + testLine);
                    return false;
                }

                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void test_display_player_on_site(){
        assertTrue(true);
    }
}
