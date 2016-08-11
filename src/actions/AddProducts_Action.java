package actions;

import org.testng.Reporter;
import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * Created by ivanxue on 5/08/2016.
 */
public class AddProducts_Action {

    public static void execute(int iTestCaseRowNo) throws Exception {

        String quantity = ExcelUtils.getCellData(iTestCaseRowNo, Constant.Col_Quality, "Unichi");

        Utils.waitForElement(Unichi_Page.quantityField());
        Unichi_Page.quantityField().sendKeys(quantity);
        Log.info(quantity + " is input in the quantity field");

        Unichi_Page.addToCartBtn().click();
        Log.info("Click action is performed on Add to cart button");

        Reporter.log("Add Products Action is successfully perfomred");
    }
}
