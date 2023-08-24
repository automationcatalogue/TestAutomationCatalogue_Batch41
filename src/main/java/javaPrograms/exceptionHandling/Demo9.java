package javaPrograms.exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Demo9 {
    static FileInputStream ob1;
    public static void main(String[] args)  {
        String path = System.getProperty("user.dir");

        try{
            ob1 = new FileInputStream(path+"\\src\\resources\\AutomationCatalogue_Batch41_TestData.xlsx");
        }catch (FileNotFoundException fe){
            System.out.println("Given File path is not correct");
        }finally {

        }
    }
}
