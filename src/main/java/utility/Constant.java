package utility;

import java.io.File;

/**
 * Created by ivanxue on 29/07/2016.
 */
public class Constant {

    public static File rootDir = new File(System.getProperty("user.dir"));

    public static final String dataPath = rootDir + "//src//main//java//testData//";
    public static final String dataFile = "TestData.xlsx";

    public static final String driverPath = rootDir + "//src//main//resources//";
    public static final String driverFile = "chromedriver";

    public static final String URL = "https://unichi.com.au/";
}
