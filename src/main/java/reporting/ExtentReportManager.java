package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class ExtentReportManager {
    public static ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" + formattedTime + ".html";
        return reportName;
    }

//    private static final Logger logger = LogManager.getLogManager().getLogger(LoggerUtil.class);



    public static void logPassDetails(String log){
        Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailDetails(String log){
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfoDetails(String log){
        System.out.println("LogInfoDetails");
//        logger.info(log);
//        Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log){
        Setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
    public static void logExceptionDetails(String log) {
        Setup.extentTest.get().fail(log);
    }
}
