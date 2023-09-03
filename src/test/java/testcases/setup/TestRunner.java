package testcases.setup;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeSuite;
import utilities.CommonUtils;

import java.io.File;
import java.io.FileInputStream;

public class TestRunner {
    public static FileInputStream fis;
    public static XSSFWorkbook wbk;
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
    }
}
