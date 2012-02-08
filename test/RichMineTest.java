import RichMap.RichMineSite;
import RichMine.RichMine;
import junit.framework.TestCase;

public class RichMineTest extends TestCase {
    public void test_should_return_$_for_display(){
        RichMineSite site = new RichMineSite(100);
        assertEquals("$", site.display());
    }
    
    public void test_should_return_20_points_for_mine_get_bonus_points(){
        RichMine mine = new RichMine(20);
        assertEquals(20, mine.getBonusPoints());
    }
}
