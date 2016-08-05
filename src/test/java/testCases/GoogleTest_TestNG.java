package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Google_Page;
import utility.Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by ivanxue on 3/08/2016.
 */
public class GoogleTest_TestNG {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {

        driver = Browser.getBrowser("safari");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void step1_checkPageTitle() {
        driver.get("http://www.google.com");

        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
    }

    @Test
    public void step2_checkSearchResult() throws InterruptedException {
        Google_Page.keywordField(driver).sendKeys("Selenium");
        //Google_Page.searchBtn(driver).click();

        Thread.sleep(5000);

        Assert.assertTrue(driver.getPageSource().contains("Selenium"), "Search result doesn't match");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (driver != null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }
}
