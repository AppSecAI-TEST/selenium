package actions;

import pageObjects.Unichi_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * Created by ivanxue on 5/08/2016.
 */
public class AddProducts_Action {

    public static void execute(int iTestCaseRow) throws Exception {

        String quantity = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Quality);

        Utils.waitForElement(Unichi_Page.quantityField());
        Unichi_Page.quantityField().sendKeys(quantity);
        Log.info(quantity + " is input in the quantity field");

        Unichi_Page.addToCartBtn().click();
        Log.info("Click action is performed on Add to cart button");
    }
}
