import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openjfx.Business.*;
import org.openjfx.Workflow.*;


public class ReviewTest {
    Immigrant immigrant = new Immigrant();
    Dependent dependent = new Dependent();
    Form form = new Form();

    @BeforeAll
    public static void init(Immigrant immigrant, Dependent dependent, Form form) {
        immigrant.setFirstName("John");
        immigrant.setMiddleName("Alex");
        immigrant.setLastName("Doe");
        immigrant.setAge(37);
        immigrant.setBirthMonth(6);
        immigrant.setBirthDay(17);
        immigrant.setBirthYear(1987);
        immigrant.setSSNumber(122334444);
        immigrant.setImmigrantPid(5555);
        immigrant.setDependentPid(4444);
        immigrant.setRace("Caucasian");
        immigrant.setGender("male");
        immigrant.setMarried(false);
        immigrant.setPhoneNumber("1234560000");
        immigrant.setFather("James Doe");
        immigrant.setMother("Katherine Doe");
        immigrant.setAddress("145 Callands Dr. Alexandria, Va");
        immigrant.setemploymentStatus(true);
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
        form = new Form();
        form.setImmigrant(immigrant);
        form.setDependent(dependent);
    }

    public static void main(String[] args) {
        ReviewTest review = new ReviewTest();
    }

    @Test
    void TestFirstName(){
        assertNotNull(immigrant.getFirstName());
    }
    @Test
    void TestMiddleName(){
        assertNotNull(immigrant.getMiddleName());
    }
    @Test
    void TestLastName(){
        assertNotNull(immigrant.getLastName());
    }
    @Test
    void TestAge(){
        assertTrue(immigrant.getAge()>18);
    }
}