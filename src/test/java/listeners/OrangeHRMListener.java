package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.CommonUtils;

public class OrangeHRMListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test is started :"+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is passed :"+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        try{
            CommonUtils.takeScreenshot("OrangeHRM_Failed");
            System.out.println("Screenshot is captured for failed testcase");
        }catch(Exception e){
            System.out.println("Screenshot is not captured for failed testcase");
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is skipped :"+result.getName());
    }

}
