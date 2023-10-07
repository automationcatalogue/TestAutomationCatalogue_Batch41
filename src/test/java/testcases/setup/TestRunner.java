package testcases.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.CommonUtils;

import java.io.File;
import java.io.FileInputStream;

public class TestRunner {
    public static FileInputStream fis;
    public static XSSFWorkbook wbk;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void getExcelPath() throws Exception{
        String projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        wbk = new XSSFWorkbook(fis);
    }

    static File file;
    public static String screenshotsPath;
    @BeforeSuite
    public void screenshot(){
        System.out.println("Before Suite Execution");
        String projectPath = System.getProperty("user.dir");
        String dateTime = CommonUtils.generateFolderNameWithTmeStamp();
        screenshotsPath = projectPath+"\\screenshots\\"+dateTime;
        file = new File(screenshotsPath);
        file.mkdir();
        System.out.println("New Folder for Screenshots is created with timestamp "+dateTime);
        sparkReporter = new ExtentSparkReporter(projectPath+"//reports//TestAutomation_"+dateTime+".html");
        sparkReporter.config().setDocumentTitle("TestAutomationCatalogue_batch41");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("OrangeHRM TestCases Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS","Windows11");
        extent.setSystemInfo("Author","Batch41");
        extent.setSystemInfo("Browser","Chrome");
    }

    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
