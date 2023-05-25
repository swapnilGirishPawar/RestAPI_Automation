package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Arrays;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest;


    @Override
    public void onStart(ITestContext var1){
        System.out.println("Before");
        System.out.println("extentTest:- "+extentTest);
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "Test API Automation Report", "Test ExecutionReport");
    }
    @Override
    public void onFinish(ITestContext var1){
        // after completion -> flush the report
        if (extentReports != null)
            extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTest test = extentReports.createTest("Test Name " + iTestResult.getTestClass().getName() + " - " + iTestResult.getMethod().getMethodName(),
                iTestResult.getMethod().getDescription());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentReportManager.logFailDetails(iTestResult.getThrowable().getMessage());
        String stackTrace = Arrays.toString(iTestResult.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formmatedTrace = "<details>\n" +
                "    <summary>Click Here To See Exception Logs</summary>\n" +
                "    " + stackTrace + "\n" +
                "</details>\n";
        ExtentReportManager.logExceptionDetails(formmatedTrace);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
