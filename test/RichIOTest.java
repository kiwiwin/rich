import RichUtil.RichIO;
import junit.framework.TestCase;

import java.io.IOException;

public class RichIOTest extends TestCase {
    public void test_should_return_xxx_for_readline() {
        RedirectIO.set_input("./test/rich_io_input.txt");
        try {
            assertEquals("xxx", RichIO.readLine());
            assertEquals("yyy", RichIO.readLine());
            assertEquals("zzz", RichIO.readLine());
        } catch (IOException e) {
            assertTrue(false);
        }

        RedirectIO.reset_input();
    }
}
