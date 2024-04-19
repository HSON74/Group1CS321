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
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);

        assertNotNull(myForm, "Form is null");
        Dependent approvaDependent = new Dependent();
        approvaDependent.setFirstName("Moe");
        approvaDependent.setMiddleName("");
        approvaDependent.setLastName("Thomspon");
        approvaDependent.setAge(25);
        approvaDependent.setAddress("4400 Elm Street");
        approvaDependent.setBirthMonth(06);
        approvaDependent.setBirthDay(3);
        approvaDependent.setBirthYear(1992);
        approvaDependent.setMarried(false);
        approvaDependent.setemploymentStatus(false);
        approvaDependent.setSSNumber(1013931243);
        approvaDependent.setGender("Male");
        approvaDependent.setRace("Asian");
        approvaDependent.setFather("Your Father");
        approvaDependent.setMother("Your Mother");
        approvaDependent.setImmigrantPid(4);
        approvaDependent.setDependentPid(7);
        assertNotNull(approvaDependent, "The Dependent Form is null");
        myForm.setImmigrant(approvalImmigrant);
        myForm.setDependent(approvaDependent);
        myDatabase = new Database("DatabaseTestRecordForImmigrant", "DatabaseTestRecordForDepenedent");
    }

    @Test
    void databaseTestCase1() {
        // addData(Form form)
    }

    @Test
    void databaseTestCase2() {
        // checkData(int iPID, int dPID)
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
        // removeImmigrant(int pid)
    }

    @Test
    void databaseTestCase6() {
        // removeDependent(int pid)
    }

    @Test
    void databaseTestCase7() {
        // updateImmigrant(Immigrant immigrant)
    }

    @Test
    void databaseTestCase8() {
        // updateDependent(Dependent dependent)

    }

}
