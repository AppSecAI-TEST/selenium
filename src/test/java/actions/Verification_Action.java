package actions;

import org.testng.Reporter;
import pageObjects.BaseClass;
import pageObjects.Unichi_Page;
import utility.Utils;

/**
 * Created by ivanxue on 5/08/2016.
 */
public class Verification_Action {

    public static void execute() throws Exception{

        Utils.waitForElement(Unichi_Page.purchaseDetails());

        if(Unichi_Page.purchaseDetails().getAttribute("innerText").contains("Purchase details")){

            Reporter.log("Purchase passed successfully");

        }else{

            Reporter.log("Purchase failed");
            BaseClass.bResult=false;
        }
    }

}
