package seleniumPrograms.sagarTeachings;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelDemo {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch41\\src\\main\\resources\\AutomationCatalogue_TestData.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh = wbk.getSheet("OrangeHRM_AddEmployee");
        XSSFRow row = sh.getRow(3);
        XSSFCell cell = row.getCell(4);
        String s = cell.getStringCellValue();
        System.out.println("Data from excel file is "+s);


        FileOutputStream fos = new FileOutputStream("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch41\\src\\main\\resources\\AutomationCatalogue_TestData.xlsx");
        cell.setCellValue("Ramya");
        fos.close();
        fis.close();


    }
}
