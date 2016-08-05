package pageObjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

public class Unichi_Page extends BaseClass{

    private static WebElement element = null;

    public Unichi_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement exploreBtn(){
        try {
            element = driver.findElement(By.cssSelector("a[class=\"button-link\"]"));
            Log.info("Explore button is found on the page");
        } catch(Exception error) {
            Log.error("Explore button is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement exploreImg(){
        try {
            element = driver.findElement(By.cssSelector("img.img-responsive"));
            Log.info("Explore image is found on the page");
        } catch(Exception error) {
            Log.error("Explore image is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement buyNowBtn(){
        try {
            element = driver.findElement(By.cssSelector("div:nth-child(6) > button"));
            Log.info("Buy Now button is found on the page");
        } catch(Exception error) {
            Log.error("Buy Now button is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement quantityField(){
        try {
            element = driver.findElement(By.cssSelector("input.ng-pristine"));
            Log.info("Quality field is found on the page");
        } catch(Exception error) {
            Log.error("Quality field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement addToCartBtn(){
        try {
            element = driver.findElement(By.cssSelector("div:nth-child(3) > div > span > button"));
            Log.info("Add to cart button is found on the page");
        } catch(Exception error) {
            Log.error("Add to cart button is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement checkOutBtn(){
        try {
            element = driver.findElement(By.cssSelector("#right-sidebar-checkout > button"));
            Log.info("Check out button is found on the page");
        } catch(Exception error) {
            Log.error("Check out button is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement nameField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.recipient\"]"));
            Log.info("Name field is found on the page");
        } catch(Exception error) {
            Log.error("Name field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement mobileField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.contactNumber\"]"));
            Log.info("Mobile field is found on the page");
        } catch(Exception error) {
            Log.error("Mobile field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement emailField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.email\"]"));
            Log.info("Email field is found on the page");
        } catch(Exception error) {
            Log.error("Email field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement streetField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.streetAddress\"]"));
            Log.info("Street field is found on the page");
        } catch(Exception error) {
            Log.error("Street field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement cityField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.city\"]"));
            Log.info("City field is found on the page");
        } catch(Exception error) {
            Log.error("City field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement stateList(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.state\"]"));
            Log.info("State list is found on the page");
        } catch(Exception error) {
            Log.error("State list is not found on the page");
            throw (error);
        }
        return element;
    }

    public static Select countryList(){
        Select list;
        try {
            element = driver.findElement(By.cssSelector("select[ng-model=\"currentUser.address.country\"]"));
            list = new Select(element);
            Log.info("Country list is found on the page");
        } catch(Exception error) {
            Log.error("Country list is not found on the page");
            throw (error);
        }
        return list;
    }

    public static WebElement postalCodeField(){
        try {
            element = driver.findElement(By.cssSelector("input[ng-model=\"currentUser.address.postalCode\"]"));
            Log.info("Postal code field is found on the page");
        } catch(Exception error) {
            Log.error("Postal code field is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement calculateBtn(){
        try {
            element = driver.findElement(By.cssSelector("div.modal-footer.ng-scope > button"));
            Log.info("Calculate postage button is found on the page");
        } catch(Exception error) {
            Log.error("Calculate postage button is not found on the page");
            throw (error);
        }
        return element;
    }

    public static WebElement purchaseDetails(){
        try {
            element = driver.findElement(By.cssSelector("#custom-invoice > table > tbody > tr > td > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td"));
            Log.info("Purchase detail is found on the page");
        } catch(Exception error) {
            Log.error("Purchase detail is not found on the page");
            throw (error);
        }
        return element;
    }
}
