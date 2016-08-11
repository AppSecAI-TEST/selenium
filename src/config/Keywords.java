package config;

/**
 * Created by ivanxue on 11/08/2016.
 */
import executionEngine.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Constant;
import utility.Log;

import java.util.concurrent.TimeUnit;

import static executionEngine.DriverScript.OR;

public class Keywords {

    public static WebDriver driver;

    public static void openBrowser(String object, String data){
        driver = utility.Browser.getBrowser(data);
    }

    public static void navigate(String object, String data){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(data);
    }

    public static void click(String object, String data){
        try{
            Log.info("Clicking on Webelement "+ object);
            driver.findElement(By.xpath(OR.getProperty(object))).click();
        }catch(Exception e){
            Log.error("Not able to click --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    //Now this method accepts two value (Object name & Data)
    public static void input(String object, String data){
        try{
            Log.info("Entering the text in " + object);
            driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
        }catch(Exception e){
            Log.error("Not able to Enter UserName --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void waitFor(String object, String data) throws Exception{
        try{
            Log.info("Wait for 5 seconds");
            Thread.sleep(5000);
        }catch(Exception e){
            Log.error("Not able to Wait --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }

    public static void closeBrowser(String object, String data){
        try{
            Log.info("Closing the browser");
            driver.quit();
        }catch(Exception e){
            Log.error("Not able to Close the Browser --- " + e.getMessage());
            DriverScript.bResult = false;
        }
    }
}