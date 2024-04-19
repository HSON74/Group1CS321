import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openjfx.Workflow.*;

public class HelperTest {
    static Helper helper = new Helper();
    public static void main (String args[]) {
        HelperTest test = new HelperTest();
        test.TestAge();
        test.TestIntToMonth();
    }

    @Test
    void TestAge(){
        assertEquals(10, helper.checkAge(10));
        assertEquals(50, helper.checkAge(50));
        assertEquals(100, helper.checkAge(100));
        assertEquals(0, helper.checkAge(0));
        assertEquals(0, helper.checkAge(101));
    }

    @Test
    void TestIntToMonth(){
        assertNotNull(helper.intToMonth(1));
        assertNotNull(helper.intToMonth(7));
        assertNotNull(helper.intToMonth(10));
        assertNotNull(helper.intToMonth(12));
        assertNull(helper.intToMonth(13));
    }

    @Test
    void TestLastName(){
        assertEquals(1, helper.monthToInt("January"));
        assertEquals(7, helper.monthToInt("July"));
        assertEquals(10, helper.monthToInt("October"));
        assertEquals(12, helper.monthToInt("December"));
        assertEquals(-1, helper.monthToInt("Oyster"));
    }
}
