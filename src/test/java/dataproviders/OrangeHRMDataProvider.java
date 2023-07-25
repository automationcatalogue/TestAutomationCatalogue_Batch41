package dataproviders;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class OrangeHRMDataProvider {

    @DataProvider(name="loginData")
    public Object[][] provideLoginData() throws Exception{
        String projectPath = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh = wbk.getSheet("OrangeHRM_Login");

        int rowCount = sh.getLastRowNum();
        System.out.println("Total number of rows present is :"+rowCount);

        Object[][] ob = new Object[rowCount][2];

        for(int i=1; i<=rowCount;++i){
            ob[i][0] = sh.getRow(i).getCell(3).getStringCellValue();
            ob[i][1] = sh.getRow(i).getCell(4).getStringCellValue();
        }
        return ob;
    }
}
