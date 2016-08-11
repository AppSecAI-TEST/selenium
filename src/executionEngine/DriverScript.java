package executionEngine;

/**
 * Created by ivanxue on 11/08/2016.
 */

import config.Constants;
import config.Keywords;
import org.apache.log4j.xml.DOMConfigurator;
import utility.ExcelUtils;
import utility.Log;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class DriverScript {

    public static Properties objects;
    public static Keywords keywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method method[];
    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String sRunMode;
    public static String sData;
    public static boolean bResult;

    public DriverScript() throws NoSuchMethodException, SecurityException {
        keywords = new Keywords();
        method = keywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        ExcelUtils.loadExcelFile(Constants.testPlanPath);
        DOMConfigurator.configure("log4j.xml");
        String objectsPath = Constants.objectsPath;
        FileInputStream fs = new FileInputStream(objectsPath);
        objects = new Properties(System.getProperties());
        objects.load(fs);

        DriverScript startEngine = new DriverScript();
        startEngine.execute_TestCase();
    }

    private void execute_TestCase() throws Exception {
        int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
        for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
            bResult = true;
            sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
            sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
            if (sRunMode.equals("Yes")) {
                iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
                iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
                Log.startTestCase(sTestCaseID);
                bResult = true;
                for (; iTestStep < iTestLastStep; iTestStep++) {
                    sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword, Constants.Sheet_TestSteps);
                    sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
                    //Now we will use the data value and pass it to the methods
                    sData = ExcelUtils.getCellData(iTestStep, Constants.Col_DataSet, Constants.Sheet_TestSteps);
                    execute_Actions();
                    if (bResult == false) {
                        ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                        Log.endTestCase();
                        break;
                    }
                }
                if (bResult == true) {
                    ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                    Log.endTestCase();
                }

            }

        }
    }

    private static void execute_Actions() throws Exception {

        for (int i = 0; i < method.length; i++) {

            if (method[i].getName().equals(sActionKeyword)) {
                //This code will pass three parameters to every invoke method
                method[i].invoke(keywords, sPageObject, sData);
                if (bResult == true) {
                    ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
                    break;
                } else {
                    ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
                    Keywords.closeBrowser("", "");
                    break;
                }
            }
        }
    }
}