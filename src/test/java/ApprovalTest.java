
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;
import org.openjfx.Workflow.Approval;

public class ApprovalTest {
    static Approval myApproval;
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
        approvalImmigrant.setPhoneNumber("703-703-7033");
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
        approvaDependent.setPhoneNumber("571-571-5711");
        approvaDependent.setGender("Male");
        approvaDependent.setRace("Asian");
        approvaDependent.setFather("Your Father");
        approvaDependent.setMother("Your Mother");
        approvaDependent.setImmigrantPid(4);
        approvaDependent.setDependentPid(7);
        assertNotNull(approvaDependent, "The Dependent Form is null");
        myForm.setImmigrant(approvalImmigrant);
        myForm.setDependent(approvaDependent);
        myApproval = new Approval("ApprovalTestRecordForImmigrant", "ApprovalTestRecordForDependent", myForm);
    }

    @Test
    void approvalTestCase1() {
        boolean connectionTest = myApproval.connection();
        int score = 0;
        assertTrue(connectionTest, "The connection is not working may be the form is null");
        System.out.print("Connect Test Passed(1/1)");

    }

    @Test
    void approvalTestCase2() {
        Form newForm = new Form();
        assertNotNull(myForm, "Form is null");
        Immigrant approvalImmigrant = new Immigrant();
        approvalImmigrant.setFirstName("Alex");
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
        approvalImmigrant.setPhoneNumber("571-571-5711");
        approvalImmigrant.setGender("Male");
        approvalImmigrant.setRace("Asian");
        approvalImmigrant.setFather("Your Father");
        approvalImmigrant.setMother("Your Mother");
        approvalImmigrant.setImmigrantPid(4);
        approvalImmigrant.setDependentPid(7);

        assertNotNull(myForm, "Form is null");
        Dependent approvaDependent = new Dependent();
        approvaDependent.setFirstName("Sam");
        approvaDependent.setMiddleName("");
        approvaDependent.setLastName("Thomspon");
        approvaDependent.setAge(25);
        approvaDependent.setAddress("4400 Elm Street");
        approvaDependent.setPhoneNumber("703-703-7033");
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
        myApproval.setForm(newForm);
        boolean connectionTest = myApproval.connection();
        assertNotNull(myApproval, "Form don't exist");
        assertTrue(connectionTest, "The connection is not working may be the form is null");
        System.out.print("New Connect Test Passed(1/1)");
    }

}