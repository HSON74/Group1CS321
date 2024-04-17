import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeAll;
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
        ;
        approvalImmigrant.setemploymentStatus(false);
        ;
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");
        approvalImmigrant.setFirstName("User Name");

        assertNotNull(myForm, "Form is null");
        Dependent approvaDependent = new Dependent();
        approvaDependent.setFirstName("User Name");
        assertNotNull(myForm, "Form is null");
        myApproval = new Approval("ApprovalTestRecordForImmigrant", "ApprovalTestRecordForDependent", new Form());
    }

    @Test
    void ApprovalTestCase1() {

    }

}