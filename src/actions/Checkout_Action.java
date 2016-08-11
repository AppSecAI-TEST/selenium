package actions;

import org.testng.Reporter;
import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

/**
 * Created by ivanxue on 29/07/2016.
 */
public class Checkout_Action {
    public static void execute(int iTestCaseRowNo) throws Exception {

        String sBrowserName = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Browser, "Unichi");
        String name = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Name, "Unichi");
        String mobile = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Mobile, "Unichi");
        String email = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Email, "Unichi");
        String street = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Street, "Unichi");
        String city = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_City, "Unichi");
        String state = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_State, "Unichi");
        String country = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Country, "Unichi");
        String postalCode = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Postalcode, "Unichi");

        Utils.waitForElement(Unichi_Page.checkOutBtn());
        Unichi_Page.checkOutBtn().click();

        Utils.waitForElement(Unichi_Page.nameField());
        Unichi_Page.nameField().clear();
        Unichi_Page.nameField().sendKeys(name);

        Unichi_Page.mobileField().clear();
        Unichi_Page.mobileField().sendKeys(mobile);

        Unichi_Page.emailField().clear();
        Unichi_Page.emailField().sendKeys(email);

        Unichi_Page.streetField().clear();
        Unichi_Page.streetField().sendKeys(street);

        Unichi_Page.cityField().clear();
        Unichi_Page.cityField().sendKeys(city);

        if(sBrowserName.contentEquals("chrome")) {
            Unichi_Page.stateField().clear();
            Unichi_Page.stateField().sendKeys(state);
        } else {
            Unichi_Page.stateList().selectByValue(state);
        }

        Unichi_Page.countryList().selectByValue(country);

//        List<WebElement> options = Unichi_Page.countryList().getOptions();
//
//        for(int i = 0; i < options.size(); i++) {
//            System.out.println(options.get(i).getText());
//        }

        Unichi_Page.postalCodeField().sendKeys(postalCode);

        Reporter.log("Checkout Products Action is successfully perfomred");
    }
}
