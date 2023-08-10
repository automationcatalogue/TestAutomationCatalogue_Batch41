package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {
    static FileInputStream fis;
    static  XSSFWorkbook wbk;
    static XSSFSheet sh;
    static XSSFRow row;
    static XSSFCell col;
    static String excelPath;

    public static XSSFWorkbook setExcelFilePath() throws Exception{
        String projectPath = System.getProperty("user.dir");
        excelPath = projectPath+"\\src\\main\\resources\\AutomationCatalogue_Batch41_TestData.xlsx";
        fis = new FileInputStream(excelPath);
        wbk = new XSSFWorkbook(fis);
        return wbk;
    }

    public static String getCellData(String sheetName, int rowNum, int colNum){
        sh = wbk.getSheet(sheetName);
        row= sh.getRow(rowNum);
        col = row.getCell(colNum);
        String excelData = col.getStringCellValue();
        return excelData;
    }

    public static int getRowNumber(String testId, String sheetName){
        sh = wbk.getSheet(sheetName);
        int rowSize= sh.getLastRowNum();
        int finalRowNumber=0;
        for(int i=0;i<rowSize;i++){
            String actualTestId = sh.getRow(i).getCell(Config.col_TestId).getStringCellValue();
            if(actualTestId.equals(testId)){
                finalRowNumber=i;
                break;
            }
        }
        BaseClass.failureReason = "TestId is not found";
        Assert.assertTrue(finalRowNumber!=0,"TestId "+testId+" is not found in the sheetName "+sheetName);

        System.out.println("TestId "+testId+" is found in the row number "+finalRowNumber+" for sheetName "+sheetName);

        return finalRowNumber;
    }

    public static void setCellData(String data, String sheetName, int rowNum, int colNum) throws Exception{
        sh = wbk.getSheet(sheetName);
        row = sh.getRow(rowNum);
        if(row==null){
            row = sh.createRow(rowNum);
        }
        col = row.getCell(colNum);
        if(col==null){
            col = row.createCell(colNum);
        }
        col.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(excelPath);
        wbk.write(fos);
        fos.close();
    }

    public static void closeExcelFile() throws Exception{
        fis.close();
    }
}