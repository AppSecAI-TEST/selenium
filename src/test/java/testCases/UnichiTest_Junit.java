package testCases;

import actions.AddProducts_Action;
import actions.ExploreProducts_Action;
import actions.Verification_Action;
import org.junit.*;
import pageObjects.BaseClass;
import pageObjects.Unichi_Page;
import actions.Checkout_Action;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnichiTest_Junit {

    public static WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    @Before
    public void setUp() throws Exception {

        sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);

        ExcelUtils.setExcelFile(Constant.dataPath + Constant.dataFile, "Sheet1");

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

        driver = Utils.OpenBrowser(iTestCaseRow);

        new BaseClass(driver);
    }

    @Test
    public void main() throws Exception {

        ExploreProducts_Action.execute();

        AddProducts_Action.execute(iTestCaseRow);

        Checkout_Action.execute(iTestCaseRow);

        Thread.sleep(5000);

        Unichi_Page.calculateBtn().click();

        System.out.println(Unichi_Page.purchaseDetails().getAttribute("innerText"));

        Verification_Action.execute();

        if (BaseClass.bResult == true) {
            ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
        } else {
            throw new Exception("Test cases failed because of verification");
        }
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }
}