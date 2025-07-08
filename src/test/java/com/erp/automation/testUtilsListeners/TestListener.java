package com.erp.automation.testUtilsListeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.erp.automation.base.BaseTest;
import com.erp.automation.utils.ExtentManager;
import com.erp.automation.utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	  private ExtentReports extent = ExtentManager.getInstance();
	    private ExtentTest test;




	    @Override
	    public void onTestStart(ITestResult result) {
	        test = ExtentManager.createTest(result.getMethod().getMethodName());
	        test.info("Test Started: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test Passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail("Test Failed: " + result.getMethod().getMethodName());
	        test.fail(result.getThrowable()); // Log error



	        // Capture screenshot on failure
	        Object testClass = result.getInstance();
	        // Assuming your test classes extend BaseTest and have a getDriver() method
	       // WebDriver driver = ((com.erp.automation.base.BasePage) testClass).getDriver();


	        WebDriver driver = ((BaseTest) testClass).getDriver();


	        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

	        // Attach screenshot to Extent report
	        try {
	            test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
	        } catch (Exception e) {
	            e.printStackTrace();
	            test.warning("Failed to attach screenshot");
	        }



	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip("Test Skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush(); // Save the report
	    }

}
