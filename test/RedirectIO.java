import java.io.*;

public class RedirectIO {
    private static PrintStream _console;
    private static InputStream _keyboard;

    public static boolean set_input(String inputFileName) {
        try {
            _keyboard = System.in;
            System.setIn(new FileInputStream(inputFileName));
        } catch (FileNotFoundException e) {
            return false;    
        }
        return true;
    }

    protected static void reset_input() {
        System.setIn(_keyboard);
    }

    protected static boolean set_output(String outputFileName) {
        try {
            _console = System.out;
            System.setOut(new PrintStream(new FileOutputStream(outputFileName)));
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    protected static void reset_output() {
        System.setOut(_console);
    }

    protected static boolean compareFile(String answer, String test) {
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
}
