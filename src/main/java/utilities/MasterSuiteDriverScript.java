package utilities;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Method;

public class MasterSuiteDriverScript {
    public static Method[] method;
    public static int iTestCase;
    public static int iTestLastCase;
    public static String sTestName;
    public static String iTestNumber;
    public static String sTestID;
    public static String sRunMode;

    public static int count=0,pos=0;
    public static int[] TestPosition=new int[10];
    public static boolean isSkipfalse;

    public static void main(String args[]) throws Exception{
        String projectPath=System.getProperty("user.dir");
        System.out.println("Project Path is :"+projectPath);

        ExcelUtils.setExcelFilePath();
        MasterSuiteDriverScript startEngine=new MasterSuiteDriverScript();
        startEngine.execute_TestCase();
    }

    public void execute_TestCase() throws Exception{
        String projectPath=System.getProperty("user.dir");
        System.out.println("Project Path is :"+projectPath);

        int iTotalTestCases=ExcelUtils.getRowUsed("Index");
        System.out.println("Total TestCases :"+iTotalTestCases);
        XmlSuite suite=new XmlSuite();
        try{
            File file=new File(projectPath+"MasterSuite.xml");
            file.delete();
            System.out.println("Test results for previous cycle were removed from the directory");
        }catch(Exception e){
            System.out.println("No Previous test results are available. "+e);
        }
        for(int iTestCase=1;iTestCase<=iTotalTestCases;iTestCase++){
            sTestName=ExcelUtils.getCellData("Index", iTestCase, Config.col_TestName);
            sTestID=ExcelUtils.getCellData("Index", iTestCase, Config.col_TestId);
            iTestNumber=ExcelUtils.getCellData("Index", iTestCase, Config.col_Sno);
            sRunMode=ExcelUtils.getCellData("Index", iTestCase, Config.col_RunMode);
            if(sRunMode.equalsIgnoreCase("Yes")){
                iTestCase=ExcelUtils.getRowNumber(sTestID, "Index");
                suite.setName("OrangeHRM_Regression_Suite");
                Map<String, String> parameters=new HashMap<>();
                parameters.put("browserName","Chrome");
                XmlTest test=new XmlTest(suite);
                test.setName(sTestName+"-"+sTestID);
                parameters.put("testID",sTestID);
                test.setParameters(parameters);
                List<XmlClass> classes=new ArrayList<>();
                if(sTestName.contains("OrangeHRM")){
                    classes.add(new XmlClass(sTestName));
                }else{
                    classes.add(new XmlClass(sTestName));
                }
                test.setXmlClasses(classes);
            }
        }
        FileWriter writer=new FileWriter(new File(projectPath,"MasterSuite.xml"));
        writer.write(suite.toXml());
        writer.flush();
        writer.close();
        System.out.println("MasterSuite.xml file is generated");
    }

}
