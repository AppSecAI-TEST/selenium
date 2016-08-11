package utility;

import java.io.File;

/**
 * Created by ivanxue on 29/07/2016.
 */
public class Constant {

    public static File rootDir = new File(System.getProperty("user.dir"));

    public static final String dataPath = rootDir + "//test-data//";
    public static final String dataFile = "TestData.xlsx";

    public static final String driverPath = rootDir + "//drivers//";

    //Test Data Sheet Columns
    public static final int Col_TestCaseName = 0;
    public static final int Col_Browser = 1;
    public static final int Col_SearchKeyword =2 ;
    public static final int Col_Quality =2 ;
    public static final int Col_Name = 3;
    public static final int Col_Mobile = 4;
    public static final int Col_Email = 5;
    public static final int Col_Street = 6;
    public static final int Col_City = 7;
    public static final int Col_State = 8;
    public static final int Col_Country = 9;
    public static final int Col_Postalcode = 10;
    public static final int Col_Result = 11;
    public static final String Path_ScreenShot = rootDir + "//Screenshots//";
}