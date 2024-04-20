import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openjfx.Business.Dependent;

public class DependentTest {
    Dependent dependent = new Dependent();

    @BeforeAll
    public static void init(Dependent dependent) {

        dependent.setFirstName("James");
        dependent.setMiddleName("William");
        dependent.setLastName("Doe");
        dependent.setAge(37);
        dependent.setBirthMonth(8);
        dependent.setBirthDay(25);
        dependent.setBirthYear(2014);
        dependent.setSSNumber(111332222);
        dependent.setDependentPid(4444);
        dependent.setRace("Caucasian");
        dependent.setGender("male");
        dependent.setMarried(false);
        dependent.setPhoneNumber("0000000000");
        dependent.setFather("John Doe");
        dependent.setMother("Susan Doe");
        dependent.setAddress("145 Callands Dr. Alexandria, Va");
        dependent.setemploymentStatus(false);
    }

    @Test
    void TestFirstName() {
        assertNotNull(dependent.getFirstName());
    }

    @Test
    void TestMiddleName() {
        assertNotNull(dependent.getMiddleName());
    }

    @Test
    void TestLastName() {
        assertNotNull(dependent.getLastName());
    }

    @Test
    void TestAge() {
        assertTrue(dependent.getAge() > 18);
    }

    @Test
    void TestBirthMonth() {
        assertTrue(dependent.getbirthMonth() > 0);
        assertTrue(dependent.getbirthMonth() < 13);
    }

    @Test
    void TestBirthDay() {
        assertTrue(dependent.getbirthDay() <= 31);
        assertTrue(dependent.getbirthDay() > 0);
    }

    @Test
    void TestBirthYear() {
        assertTrue(dependent.getbirthYear() <= 2024);
        assertTrue(dependent.getbirthYear() > 0);
    }
    /*
     * @Test
     * void TestSSNumber(){
     * assertTrue(dependent.getSSNumber()>=100000000); //valid 9 digit
     * assertTrue(dependent.getSSNumber()<=999999999);
     * }
     */

    @Test
    void TestDependentPid() {
        assertTrue(dependent.getDependentPid() >= 1000); // valid 4 digit
        assertTrue(dependent.getDependentPid() <= 9999);
    }

    @Test
    void TestRace() {
        assertNotNull(dependent.getRace());
    }

    @Test
    void TestGender() {
        assertNotNull(dependent.getGender());
    }

    @Test
    void TestMarried() {
        assertEquals(dependent.getMarriedStatus(), dependent.getMarriedStatus());
    }

    @Test
    void TestPhoneNumber() {
        int valid = dependent.getPhoneNumber().length();
        assertNotNull(dependent.getPhoneNumber());
        assertEquals(valid, 9);
    }

    @Test
    void TestFatherName() {
        assertNotNull(dependent.getFatherName());
    }

    @Test
    void TestMotherName() {
        assertNotNull(dependent.getMotherName());
    }

    @Test
    void TestAddress() {
        assertNotNull(dependent.getAddress());
    }

    @Test
    void TestEmploymentStatus() {
        assertEquals(dependent.getemploymentStatus(), dependent.getemploymentStatus());
    }

    @Test
    void TestPrevClaim() {
        assertEquals(false, dependent.getPrevClaim());
    }

    public static void main(String[] args) {
        DependentTest b = new DependentTest();
        b.TestFirstName();
        b.TestMiddleName();
        b.TestLastName();
        b.TestAge();
        b.TestBirthMonth();
        b.TestBirthDay();
        b.TestBirthYear();
        // b.TestSSNumber();
        b.TestDependentPid();
        b.TestRace();
        b.TestGender();
        b.TestMarried();
        b.TestPhoneNumber();
        b.TestFatherName();
        b.TestMotherName();
        b.TestAddress();
        b.TestEmploymentStatus();
        b.TestPrevClaim();
    }
}
