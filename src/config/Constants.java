package config;

import java.io.File;

/**
 * Created by ivanxue on 11/08/2016.
 */
public class Constants {

    //List of System Variables
    public static File rootDir = new File(System.getProperty("user.dir"));
    public static final String Path_TestPlan = rootDir + "//test-data//TestPlan.xlsx";
    public static final String Path_Objects = rootDir + "//src//config//Objects.properties";
    public static final int Time_Wait = 20;

    //List of Data Sheet Column Numbers
    public static final int Col_TestCaseID = 0;
    public static final int Col_RunMode = 2;
    public static final int Col_Result = 3;

    public static final int Col_ActionKeyword = 3;
    public static final int Col_PageObject = 4;
    public static final int Col_DataSet = 5;
    public static final int Col_TestStepResult = 6;

    //List of Data Engine Excel sheets
    public static final String Sheet_TestSteps = "Test Steps";
    public static final String Sheet_TestCases = "Test Cases";

    public static final String KEYWORD_FAIL = "FAIL";
    public static final String KEYWORD_PASS = "PASS";

}