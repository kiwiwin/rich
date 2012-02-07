import RichTool.*;
import junit.framework.TestCase;

public class RobotToolTest extends TestCase {
    public void test_should_return_机器娃娃_for_getName(){
        RichTool tool = RichTool.createTool(2);
        assertEquals("机器娃娃", tool.getName());
    }
}
