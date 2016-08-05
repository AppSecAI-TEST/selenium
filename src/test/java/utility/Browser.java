package utility;

/**
 * Created by ivanxue on 3/08/2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

    public static WebDriver driver;

    public static WebDriver getBrowser(String browserType) {
        switch (browserType) {
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", Constant.driverPath + "geckodriver");
                return	driver = new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constant.driverPath + "chromedriver");
                return	driver = new ChromeDriver();
            case "safari":
                return	driver = new SafariDriver();
            case "IE":
                System.setProperty("webdriver.ie.driver", Constant.driverPath + "IEDriverServer.exe");
                return	driver = new InternetExplorerDriver();
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return driver = new FirefoxDriver();
        }
    }
}