package testCases;

import actions.AddProducts_Action;
import actions.ExploreProducts_Action;
import org.junit.*;
import org.testng.Reporter;
import pageObjects.BaseClass;
import pageObjects.Unichi_Page;
import actions.Checkout_Action;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import utility.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnichiTest_JUnit {

    public static WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRowNo;
    private String sBrowserName;

    @Before
    public void setUp() throws Exception {

        sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);

        ExcelUtils.loadExcelFile(Constant.dataPath + Constant.dataFile);

        iTestCaseRowNo = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName, "Unichi");
        sBrowserName = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Browser, "Unichi");

        driver = Utils.openBrowser(iTestCaseRowNo, "https://unichi.com.au",sBrowserName);

        new BaseClass(driver);
    }

    @Test
    public void main() throws Exception {

        ExploreProducts_Action.execute();

        AddProducts_Action.execute(iTestCaseRowNo);

        Checkout_Action.execute(iTestCaseRowNo);

        Thread.sleep(5000);

        Unichi_Page.calculateBtn().click();

        System.out.println(Unichi_Page.purchaseDetails().getAttribute("innerText"));

        Utils.waitForElement(Unichi_Page.purchaseDetails());

        if(Unichi_Page.purchaseDetails().getAttribute("innerText").contains("Purchase details")) {
            Reporter.log("Purchase detail page is displayed successfully");
        } else {
            Reporter.log("Purchase detail failed to display");
            BaseClass.bResult = false;
        }

        if(BaseClass.bResult == true) {
            ExcelUtils.setCellData("Pass", iTestCaseRowNo, Constant.Col_Result, "Unichi");
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