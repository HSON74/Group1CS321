import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openjfx.Workflow.*;

public class CountWFItemsTest {
    @Test
    void TestNewWFCout() {
        Workflow wfobj = new Workflow();
        int totalwf = wfobj.countWFItems("null");
        assertEquals(totalwf, 0);
        System.out.println("Hellow test");
    }

    public static void main(String[] args) {
        CountWFItemsTest c = new CountWFItemsTest();
        c.TestNewWFCout();
    }
}
