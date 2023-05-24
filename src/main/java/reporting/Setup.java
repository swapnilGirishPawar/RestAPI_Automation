package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extentReport;
    @Override
    public void onStart(ITestContext var1){
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") +"\\Reports\\"+ fileName;
        extentReport = ExtentReportManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
    }

    public void onFinish(ITestContext var1){
        // after completion -> flush the report
        if(extentReport != null)
            extentReport.flush();
    }

    public void onTestStart(ITestResult iTestResult) {
        ExtentTest test =  extentReport.createTest("Test Name = "+iTestResult.getTestClass().getName() + " - " + iTestResult.getMethod().getMethodName());
        extentTest.set(test); // this will set the thread which is currently running.
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}
