package pageObjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Unichi_Page {

    private static WebElement element = null;
    private static WebDriverWait wait = null;

    public static WebElement exploreBtn(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class=\"button-link\"]")));
        element = driver.findElement(By.cssSelector("a[class=\"button-link\"]"));

        return element;
    }

    public static WebElement exploreImg(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.img-responsive")));
        element = driver.findElement(By.cssSelector("img.img-responsive"));

        return element;
    }

    public static WebElement buyNowBtn(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(6) > button")));
        element = driver.findElement(By.cssSelector("div:nth-child(6) > button"));

        return element;
    }

    public static WebElement quantityField(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-pristine")));
        element = driver.findElement(By.cssSelector("input.ng-pristine"));

        return element;
    }

    public static WebElement addToCartBtn(WebDriver driver){

        element = driver.findElement(By.cssSelector("div:nth-child(3) > div > span > button"));

        return element;
    }

    public static WebElement checkOutBtn(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#right-sidebar-checkout > button")));
        element = driver.findElement(By.cssSelector("#right-sidebar-checkout > button"));

        return element;
    }

    public static WebElement nameField(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model=\"currentUser.address.recipient\"]")));
        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.recipient\"]"));

        return element;
    }

    public static WebElement mobileField(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.contactNumber\"]"));

        return element;
    }

    public static WebElement emailField(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.email\"]"));

        return element;
    }

    public static WebElement streetField(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.streetAddress\"]"));

        return element;
    }

    public static WebElement cityField(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.city\"]"));

        return element;
    }

    public static WebElement stateList(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.state\"]"));

        return element;
    }

    public static WebElement countryList(WebDriver driver){

        element = driver.findElement(By.cssSelector("select[ng-model=\"currentUser.address.country\"]"));

        return element;
    }

    public static WebElement postalCodeField(WebDriver driver){

        element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.postalCode\"]"));

        return element;
    }

    public static WebElement calculateBtn(WebDriver driver){

        element = driver.findElement(By.cssSelector("div.modal-footer.ng-scope > button"));

        return element;
    }

    public static WebElement purchaseDetails(WebDriver driver){

        wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#custom-invoice > table > tbody > tr > td > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td")));
        element = driver.findElement(By.cssSelector("#custom-invoice > table > tbody > tr > td > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td"));

        return element;
    }


}
