package testCases;

import actions.AddProducts_Action;
import actions.Checkout_Action;
import actions.ExploreProducts_Action;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
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
    private int iTestCaseRowNo;

    @BeforeMethod
    public void beforeMethod() throws Exception {

        DOMConfigurator.configure("log4j.xml");

        sTestCaseName = Utils.getTestCaseName(this.toString());
        Log.startTestCase(sTestCaseName);

        ExcelUtils.loadExcelFile(Constant.dataPath + Constant.dataFile);

        iTestCaseRowNo = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName, "Unichi");

        driver = Utils.openBrowser(iTestCaseRowNo, "https://unichi.com.au");

        new BaseClass(driver);
    }

    @Test
    public void main() throws Exception {
        try {
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

            if (BaseClass.bResult == true) {
                ExcelUtils.setCellData("Pass", iTestCaseRowNo, Constant.Col_Result, "Unichi");
            } else {
                throw new Exception("Test cases failed because of verification");
            }
        } catch(Exception error) {
            ExcelUtils.setCellData("Fail", iTestCaseRowNo, Constant.Col_Result, "Unichi");
            Utils.takeScreenshot(driver, sTestCaseName);
            Log.error(error.getMessage());
            throw (error);
        }
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Log.endTestCase();
        if (driver != null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }

}