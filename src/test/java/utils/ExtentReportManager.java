package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static String reportFilePath = System.getProperty("user.dir") + "/test-output/NdosiAutomationReport.html";

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    public static ExtentReports generateExtentReport(){
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(reportFilePath));
        extent.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Ndosi Automation Test Report Title");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Ndosi Automation Report");

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Execution Machine", System.getProperty("user.name"));
        return extent;
    }

}
