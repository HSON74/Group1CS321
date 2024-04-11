import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openjfx.Business.Immigrant;


public class ImmigrantTest {
    Immigrant immigrant = new Immigrant();
    @BeforeAll
    public static void init(Immigrant immigrant){
        
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
@Test
void TestBirthMonth(){
    assertTrue(immigrant.getbirthMonth() > 0);
    assertTrue(immigrant.getbirthMonth() < 13);
}
@Test
void TestBirthDay(){
    assertTrue(immigrant.getbirthDay() <= 31);
    assertTrue(immigrant.getbirthDay() > 0);
}
@Test
void TestBirthYear(){
    assertTrue(immigrant.getbirthYear() < 2003);
    assertTrue(immigrant.getbirthYear() > 0);
}
/*@Test
void TestSSNumber(){
    assertTrue(immigrant.getSSNumber()>=100000000); //valid 9 digit
    assertTrue(immigrant.getSSNumber()<=999999999);
}*/

@Test
void TestImmigrantPid(){
    assertTrue(immigrant.getImmigrantPid()>=1000); //valid 4 digit
    assertTrue(immigrant.getImmigrantPid()<=9999);
}

@Test
void TestDependentPid(){
    assertTrue(immigrant.getDependentPid()>=1000); //valid 4 digit
    assertTrue(immigrant.getDependentPid()<=9999);
}
@Test
void TestRace(){
    assertNotNull(immigrant.getRace());
}
@Test
void TestGender(){
    assertNotNull(immigrant.getGender());
}
@Test
void TestMarried(){
    assertEquals(immigrant.getMarriedStatus(), immigrant.getMarriedStatus());
}
@Test
void TestPhoneNumber(){
    int valid = immigrant.getPhoneNumber().length();
    assertNotNull(immigrant.getPhoneNumber());
    assertEquals(valid, 9);
}
@Test
void TestFatherName(){
    assertNotNull(immigrant.getFatherName());
}
@Test
void TestMotherName(){
    assertNotNull(immigrant.getMotherName());
}
@Test
void TestAddress(){
    assertNotNull(immigrant.getAddress());
}
@Test
void TestEmploymentStatus(){
    assertEquals(immigrant.getemploymentStatus(), immigrant.getemploymentStatus());
}
public static void main(String[] args) {
        ImmigrantTest a = new ImmigrantTest();
        a.TestFirstName();
        a.TestMiddleName();
        a.TestLastName();
        a.TestAge();
        a.TestBirthMonth();
        a.TestBirthDay();
        a.TestBirthYear();
        //a.TestSSNumber();
        a.TestImmigrantPid();
        a.TestDependentPid();
        a.TestRace();
        a.TestGender();
        a.TestMarried();
        a.TestPhoneNumber();
        a.TestFatherName();
        a.TestMotherName();
        a.TestAddress();
        a.TestEmploymentStatus();
    }
}