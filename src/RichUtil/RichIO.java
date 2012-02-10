package RichUtil;

import java.io.IOException;

public class RichIO {
    public static String readLine() throws IOException {
        String res = "";
        int c;
        while ((c = System.in.read()) != '\n') {
            res += (char) c;
        }
        return res;
    }
}
