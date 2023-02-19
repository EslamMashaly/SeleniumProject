package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentReportNG;

import java.io.IOException;

import static base.TakeScreenShot.screenShot;

public class Listeners extends BaseTest implements ITestListener  {

    ExtentTest test;
    ExtentReports extent=ExtentReportNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
            String filepath;
            try {
                filepath = screenShot(result.getMethod().getMethodName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName()); //to attach screenshots to report
        }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
