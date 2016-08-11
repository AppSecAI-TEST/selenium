package actions;

import org.testng.Reporter;
import pageObjects.Unichi_Page;
import utility.Utils;

/**
 * Created by ivanxue on 5/08/2016.
 */
public class ExploreProducts_Action {
    public static void execute() throws Exception {

        Utils.waitForElement(Unichi_Page.exploreBtn());
        Unichi_Page.exploreBtn().click();

        Utils.waitForElement(Unichi_Page.exploreImg());
        Unichi_Page.exploreImg().click();

        Utils.waitForElement(Unichi_Page.buyNowBtn());
        Unichi_Page.buyNowBtn().click();

        Reporter.log("Explore Products Action is successfully perfomred");
    }
}
