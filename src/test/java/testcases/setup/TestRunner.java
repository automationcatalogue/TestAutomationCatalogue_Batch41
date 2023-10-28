package testcases.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.CommonUtils;
import utilities.ExcelUtils;

public class TestRunner {
    public static XSSFWorkbook wbk;
    public static ExtentReports extent;
    public static ExtentTest logger;
    private static String projectPath;
    public static String screenshotsPath;

    @BeforeSuite
    public void beforeSuite() throws Exception{
        System.out.println("Before Suite Execution");
        projectPath = System.getProperty("user.dir");
        wbk = ExcelUtils.setExcelFilePath(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        screenshotsPath = CommonUtils.generateScreenshotsFolder(projectPath);
        extent = CommonUtils.generateExtentReport(projectPath);
    }

    @AfterSuite
    public void tearDown() throws Exception{
        extent.flush();
        ExcelUtils.closeExcelFile();
    }

}
