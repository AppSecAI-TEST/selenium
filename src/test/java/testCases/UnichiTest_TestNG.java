package testCases;

import actions.AddProducts_Action;
import actions.Checkout_Action;
import actions.ExploreProducts_Action;
import actions.Verification_Action;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class UnichiTest_TestNG {

    public static WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    @BeforeMethod
    public void beforeMethod() throws Exception {

        sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);

        ExcelUtils.setExcelFile(Constant.dataPath + Constant.dataFile, "Sheet1");

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

        driver = Utils.OpenBrowser(iTestCaseRow);

        new BaseClass(driver);
    }

    @Test
    public void main() throws Exception {
        try {
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
        } catch (Exception error) {
            ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
            Utils.takeScreenshot(driver, sTestCaseName);
            Log.error(error.getMessage());
            throw (error);
        }
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Log.endTestCase(sTestCaseName);
        if (driver != null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }

}