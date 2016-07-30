package appModule;

import org.openqa.selenium.WebDriver;
import pageObjects.Unichi_Page;
import utility.ExcelUtility;

/**
 * Created by ivanxue on 29/07/2016.
 */
public class Checkout_Action {
    public static void execute(WebDriver driver) throws Exception {

        String name = ExcelUtility.getCellData(1, 1);
        String mobile = ExcelUtility.getCellData(1, 2);
        String email = ExcelUtility.getCellData(1, 3);
        String street = ExcelUtility.getCellData(1, 4);
        String city = ExcelUtility.getCellData(1, 5);
        String state = ExcelUtility.getCellData(1, 6);
        String country = ExcelUtility.getCellData(1, 7);
        String postalCode = ExcelUtility.getCellData(1, 8);

        Unichi_Page.checkOutBtn(driver).click();

        Unichi_Page.nameField(driver).sendKeys(name);

        Unichi_Page.mobileField(driver).sendKeys(mobile);

        Unichi_Page.emailField(driver).sendKeys(email);

        Unichi_Page.streetField(driver).sendKeys(street);

        Unichi_Page.cityField(driver).sendKeys(city);

        Unichi_Page.stateList(driver).sendKeys(state);

        Unichi_Page.countryList(driver).sendKeys(country);

        Unichi_Page.postalCodeField(driver).sendKeys(postalCode);
    }
}
