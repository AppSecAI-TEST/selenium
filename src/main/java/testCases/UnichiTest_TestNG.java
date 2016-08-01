package testCases;

import appModule.Checkout_Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtility;

import java.io.File;

public class UnichiTest_TestNG {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", Constant.driverPath + Constant.driverFile);

        ExcelUtility.setExcelFile(Constant.dataPath + Constant.dataFile, "Sheet1");

        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 30000);
    }

    @Test
    public void step1_browseProducts() {
        driver.get(Constant.URL);

        Unichi_Page.exploreBtn(driver).click();

        Unichi_Page.exploreImg(driver).click();

        Unichi_Page.buyNowBtn(driver).click();
    }

    @Test
    public void step2_addProducts() {

        Unichi_Page.quantityField(driver).sendKeys("5");

        Unichi_Page.addToCartBtn(driver).click();
    }

    @Test
    public void step3_checkoutProducts() throws Exception {

        Checkout_Action.execute(driver);
    }

    @Test
    public void step4_calculatePostage() throws InterruptedException {

        Thread.sleep(5000);

        Unichi_Page.calculateBtn(driver).click();

        System.out.println(Unichi_Page.purchaseDetails(driver).getAttribute("innerText"));

        Assert.assertEquals(true, Unichi_Page.purchaseDetails(driver).getAttribute("innerText").contains("Purchase details"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (driver != null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }

        ExcelUtility.setCellData("Pass", 1, 9);
    }

}