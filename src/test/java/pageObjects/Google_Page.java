package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivanxue on 4/08/2016.
 */
public class Google_Page {
    private static WebElement element = null;
    private static WebDriverWait wait = null;

    public static WebElement keywordField(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));

        return element;
    }

    public static WebElement searchBtn(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));

        return element;
    }
}
