import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;
import org.openjfx.Workflow.Approval;
import org.openjfx.Workflow.Database;

public class DatabaseTest {
    static Database myDatabase;
    static Form myForm;

    @BeforeAll
    public static void BeforeAllTest() {
        myForm = new Form();
        assertNotNull(myForm, "Form is null");
        Immigrant approvalImmigrant = new Immigrant();
        approvalImmigrant.setFirstName("Elf");
        approvalImmigrant.setMiddleName("");
        approvalImmigrant.setLastName("Thomspon");
        approvalImmigrant.setAge(25);
        approvalImmigrant.setAddress("4400 Elm Street");
        approvalImmigrant.setBirthMonth(06);
        approvalImmigrant.setBirthDay(3);
        approvalImmigrant.setBirthYear(2001);
        approvalImmigrant.setMarried(false);
        approvalImmigrant.setemploymentStatus(false);
        approvalImmigrant.setSSNumber(1013931242);
        approvalImmigrant.setPhoneNumber("Hello Hello Hello");
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);

        assertNotNull(myForm, "Form is null");
        Dependent approvalDependent = new Dependent();
        approvalDependent.setFirstName("Moe");
        approvalDependent.setMiddleName("");
        approvalDependent.setLastName("Thomspon");
        approvalDependent.setAge(25);
        approvalDependent.setAddress("4400 Elm Street");
        approvalDependent.setBirthMonth(06);
        approvalDependent.setBirthDay(3);
        approvalDependent.setBirthYear(1992);
        approvalDependent.setMarried(false);
        approvalDependent.setemploymentStatus(false);
        approvalDependent.setPhoneNumber("Hello Hello Hello");
        approvalDependent.setSSNumber(1013931243);
        approvalDependent.setGender("Male");
        approvalDependent.setRace("Asian");
        approvalDependent.setFather("Your Father");
        approvalDependent.setMother("Your Mother");
        approvalDependent.setImmigrantPid(4);
        approvalDependent.setDependentPid(7);
        assertNotNull(approvalDependent, "The Dependent Form is null");
        myForm.setImmigrant(approvalImmigrant);
        myForm.setDependent(approvalDependent);
        myDatabase = new Database("DatabaseTestRecordForImmigrant", "DatabaseTestRecordForDepenedent");
    }

    @Test
    void databaseTestCase1() {
        myForm = new Form();
        assertNotNull(myForm, "Form is null");
        Immigrant approvalImmigrant = new Immigrant();
        approvalImmigrant.setFirstName("Elf");
        approvalImmigrant.setMiddleName("");
        approvalImmigrant.setLastName("Thomspon");
        approvalImmigrant.setAge(25);
        approvalImmigrant.setAddress("4400 Elm Street");
        approvalImmigrant.setBirthMonth(06);
        approvalImmigrant.setBirthDay(3);
        approvalImmigrant.setBirthYear(2001);
        approvalImmigrant.setMarried(false);
        approvalImmigrant.setemploymentStatus(false);
        approvalImmigrant.setSSNumber(1013931242);
        approvalImmigrant.setPhoneNumber("Hello Hello Hello");
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);

        assertNotNull(myForm, "Form is null");
        Dependent approvalDependent = new Dependent();
        approvalDependent.setFirstName("Moe");
        approvalDependent.setMiddleName("");
        approvalDependent.setLastName("Thomspon");
        approvalDependent.setAge(25);
        approvalDependent.setAddress("4400 Elm Street");
        approvalDependent.setBirthMonth(06);
        approvalDependent.setBirthDay(3);
        approvalDependent.setBirthYear(1992);
        approvalDependent.setMarried(false);
        approvalDependent.setemploymentStatus(false);
        approvalDependent.setPhoneNumber("Hello Hello Hello");
        approvalDependent.setSSNumber(1013931243);
        approvalDependent.setGender("Male");
        approvalDependent.setRace("Asian");
        approvalDependent.setFather("Your Father");
        approvalDependent.setMother("Your Mother");
        approvalDependent.setImmigrantPid(4);
        approvalDependent.setDependentPid(7);
        approvalDependent.setPrevClaim(true);
        assertNotNull(approvalDependent, "The Dependent Form is null");
        myForm.setImmigrant(approvalImmigrant);
        myForm.setDependent(approvalDependent);
        assertTrue(myDatabase.addData(myForm));

    }

    @Test
    void databaseTestCase2() {
        assertEquals(myDatabase.checkData(4, 7), "", "Failed Test: 4 for Immigrant and 7 in Dependent exist in file");
        assertEquals(myDatabase.checkData(4, 6), "", "Failed Test: 4 for Immigrant exist and 6 in Dependent sure not");
        assertEquals(myDatabase.checkData(6, 7), "Immigrant is not system",
                "Failed Test: 6 for Immigrant don't exist and 7 in Dependent exist in file");
        assertEquals(myDatabase.checkData(6, 8), "",
                "Failed Test: 6 for Immigrant and 8 in Dependent don't exist in file");

    }

    @Test
    void databaseTestCase3() {
        // getDataImmigrant(int iPID)
    }

    @Test
    void databaseTestCase4() {
        // getDataDependent(int iPID)
    }

    @Test
    void databaseTestCase5() {
        assertNotNull(myForm, "Form is null");
        Immigrant approvalImmigrant = new Immigrant();
        approvalImmigrant.setFirstName("Elf");
        approvalImmigrant.setMiddleName("");
        approvalImmigrant.setLastName("Thomspon");
        approvalImmigrant.setAge(25);
        approvalImmigrant.setAddress("4400 Elm Street");
        approvalImmigrant.setBirthMonth(06);
        approvalImmigrant.setBirthDay(3);
        approvalImmigrant.setBirthYear(2001);
        approvalImmigrant.setMarried(false);
        approvalImmigrant.setemploymentStatus(false);
        approvalImmigrant.setSSNumber(1013931242);
        approvalImmigrant.setPhoneNumber("Hello Hello Hello");
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);
        // updateImmigrant(Immigrant immigrant)
    }

    @Test
    void databaseTestCase6() {
        assertNotNull(myForm, "Form is null");
        Immigrant approvalImmigrant = new Immigrant();
        approvalImmigrant.setFirstName("Elf");
        approvalImmigrant.setMiddleName("");
        approvalImmigrant.setLastName("Thomspon");
        approvalImmigrant.setAge(25);
        approvalImmigrant.setAddress("4400 Elm Street");
        approvalImmigrant.setBirthMonth(06);
        approvalImmigrant.setBirthDay(3);
        approvalImmigrant.setBirthYear(2001);
        approvalImmigrant.setMarried(false);
        approvalImmigrant.setemploymentStatus(false);
        approvalImmigrant.setSSNumber(1013931242);
        approvalImmigrant.setPhoneNumber("Hello Hello Hello");
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);
        // updateDependent(Dependent dependent)

    }

    @Test
    void databaseTestCase7() {
        // removeImmigrant(int pid)
    }

    @Test
    void databaseTestCase8() {
        // removeDependent(int pid)
    }

}
