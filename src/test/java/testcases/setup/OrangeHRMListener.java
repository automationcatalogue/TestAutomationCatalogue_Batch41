package testcases.setup;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class OrangeHRMListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test is started :"+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is passed :"+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        try{
           // CommonUtils.takeScreenshot();
            System.out.println("Screenshot is captured for failed testcase");
        }catch(Exception e){
            System.out.println("Screenshot is not captured for failed testcase");
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is skipped :"+result.getName());
    }

}
