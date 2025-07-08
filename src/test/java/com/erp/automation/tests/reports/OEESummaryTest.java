package com.erp.automation.tests.reports;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.master.AllMasterSubModules;
import com.erp.automation.pages.master.CustomersForApprovalPage;
import com.erp.automation.pages.master.ItemPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.reports.AllProductionReportSubModules;
import com.erp.automation.pages.reports.AllReportSubModules;
import com.erp.automation.pages.reports.OEESummeryReportPage;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.CustomersPage;
import com.erp.automation.utils.ConfigReader;

public class OEESummaryTest {

	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	String sheetName;
	String excelPath;
	CustomersPage customersPage;
	AllMasterSubModules allMasterSubModules;
	CustomersForApprovalPage customersForApprovalPage;
	ItemPage itemPage;
	SoftAssert softAssert;
	AllReportSubModules allReportSubModules;
	AllProductionReportSubModules allProductionReportSubModules;
	OEESummeryReportPage oEESummeryReportPage;
	String reportURL;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);

		toggleMenus = new ToggleMenus(driver);

		allReportSubModules= new AllReportSubModules(driver);

		allProductionReportSubModules =new AllProductionReportSubModules(driver);

		oEESummeryReportPage = new OEESummeryReportPage(driver);

		logOutPage = new LogOutPage(driver);

		customersPage = new CustomersPage(driver);

		allMasterSubModules = new AllMasterSubModules(driver);

		customersForApprovalPage = new CustomersForApprovalPage(driver);

		 itemPage =new ItemPage(driver);
		 softAssert =new SoftAssert();

		System.out.println("ERP site launched");
		// -------------------------------------

	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");

	}

	@Test (priority =0,enabled = true)
	public void getOEESummaryReport () throws InterruptedException {

		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnReportsMenuIcon();
		allReportSubModules.clickOnProductionReport();
		allProductionReportSubModules.clickOnOEESummaryReportMenu();
		oEESummeryReportPage.selectMonth();
		oEESummeryReportPage.selectYear();
		oEESummeryReportPage.selectFormingOptionFromDropDown();
		oEESummeryReportPage.clickOnPrintButton();
		String reportURL = driver.getCurrentUrl();
		Assert.assertTrue(reportURL.contains("Month=4&Year=2025&Process=FRM&PlantId=2&Fromdate=&Todate="),"Unable to see report");
		System.out.println("--Report Visible sucessfully--");
		Thread.sleep(5000);
		driver.navigate().back();

	}

	@Test (priority =1,enabled = true)
	public void getOEESummaryReporteforCustomDateRangeOne () throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnReportsMenuIcon();
		allReportSubModules.clickOnProductionReport();
		allProductionReportSubModules.clickOnOEESummaryReportMenu();
		oEESummeryReportPage.selectCustomFromDate();
		driver.navigate().back();
	}



 ///Need to Fix below @test
	@Test(priority = 2, enabled = false)
	public void getOEESummaryReportForCustomDateRangeTwo() throws InterruptedException {

	    selectPlant.selectPlantTwo();
	    System.out.println("Selected plant two");

	    toggleMenus.clickOnToggleMenu();
	    toggleMenus.clickOnReportsMenuIcon();
	    allReportSubModules.clickOnProductionReport();
	    allProductionReportSubModules.clickOnOEESummaryReportMenu();

	    // Year you want to select in the From-Date picker
	    String yearValue = "2022";
	    oEESummeryReportPage.selectCustomFromDateTwo(yearValue);

	    // Optional: Add assertions or further actions
	    driver.navigate().back();
	}



	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		logOutPage.clickOnProfileIconAndLogOut();
		Thread.sleep(1000);

		System.out.println("After method execution-logout successfully done");

	}

	@AfterClass
	public void afterClass() {

		WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}





}
