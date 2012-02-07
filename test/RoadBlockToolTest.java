import RichTool.*;
import junit.framework.TestCase;

public class RoadBlockToolTest extends TestCase{
    public void test_should_return_路障_for_getName(){
        RichTool tool = RichTool.createTool(1);
        assertEquals("路障", tool.getName());
    }
}
