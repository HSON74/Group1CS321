
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openjfx.Business.Form;
import org.openjfx.Workflow.*;

//This is the template for the testing. 
public class ModuleCase {
    public static DataEntry case1;
    Form testForm;

    @BeforeAll
    public static void inti() {

        case1 = new DataEntry(new Workflow());
    }

    @AfterAll
    public static void dispose() {
        case1 = null;
    }

    // Data Entry
    @Test
    public void testCase1() {
        testForm = case1.systemInitiate.convertToForm();
        assertNotNull(testForm, "");
    }

    @Test
    public void testCase2() {
        testForm = case1.systemInitiate.convertToForm();
        assertNotNull(testForm, "");
    }

    @Test
    public void testCase3() {
        testForm = case1.systemInitiate.convertToForm();
        assertNotNull(testForm, "");
    }

    // Review & Approval
    @AfterEach
    public void ReviewandApprovalTest() {
        // Approval Section
        Approval tApproval = new Approval("table", testForm);
        case1.systemInitiate.registerPerson(testForm);
        assertNotNull(testForm, "");

    }
}
