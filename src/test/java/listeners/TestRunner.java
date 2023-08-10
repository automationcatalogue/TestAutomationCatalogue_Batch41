package listeners;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;

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
}
