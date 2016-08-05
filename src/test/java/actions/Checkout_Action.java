package actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

/**
 * Created by ivanxue on 29/07/2016.
 */
public class Checkout_Action {
    public static void execute(int iTestCaseRow) throws Exception {

        String name = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Name);
        String mobile = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Mobile);
        String email = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
        String street = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Street);
        String city = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_City);
        String state = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_State);
        String country = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Country);
        String postalCode = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Postalcode);

        Utils.waitForElement(Unichi_Page.checkOutBtn());
        Unichi_Page.checkOutBtn().click();

        Utils.waitForElement(Unichi_Page.nameField());
        Unichi_Page.nameField().sendKeys(name);

        Unichi_Page.mobileField().sendKeys(mobile);

        Unichi_Page.emailField().sendKeys(email);

        Unichi_Page.streetField().sendKeys(street);

        Unichi_Page.cityField().sendKeys(city);

        Unichi_Page.stateList().sendKeys(state);

        Unichi_Page.countryList().selectByValue(country);

//        List<WebElement> options = Unichi_Page.countryList().getOptions();
//
//        for(int i = 0; i < options.size(); i++) {
//            System.out.println(options.get(i).getText());
//        }

        Unichi_Page.postalCodeField().sendKeys(postalCode);
    }
}
