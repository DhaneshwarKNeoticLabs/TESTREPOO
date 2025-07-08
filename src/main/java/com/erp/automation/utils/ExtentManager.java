package com.erp.automation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize Extent Report
    public static ExtentReports getInstance() {

    	  // Date
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));


        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Automation Tester", "Dhaneshwar Kamane");
            extent.setSystemInfo("Environment", "DryRun or Testing Environment");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome 125");
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Execution Type", "UI Automation");
            extent.setSystemInfo("Execution Date", currentDate);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
