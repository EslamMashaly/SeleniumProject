package base;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentReportNG;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener  {
    ExtentReports extent=ExtentReportNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        try {
            TakeScreenShot.screenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
