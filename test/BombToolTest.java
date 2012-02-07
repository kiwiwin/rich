import RichTool.*;
import junit.framework.TestCase;

public class BombToolTest extends TestCase {
    public void test_should_return_炸弹_for_getName() {
        RichTool tool = RichTool.createTool(3);
        assertEquals("炸弹", tool.getName());
    }
}
