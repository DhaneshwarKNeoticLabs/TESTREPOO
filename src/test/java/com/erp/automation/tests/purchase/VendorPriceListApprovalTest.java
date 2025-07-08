package com.erp.automation.tests.purchase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.purchase.AllPurchaseSubModules;
import com.erp.automation.pages.purchase.ApprovalVendorPriceListPage;
import com.erp.automation.pages.purchase.ManageVendorApprovePriceListPage;
import com.erp.automation.pages.purchase.PiApprovalPage;
import com.erp.automation.pages.purchase.PoApprovalPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.utils.ConfigReader;

public class VendorPriceListApprovalTest {


	WebDriver driver;
	SelectPlant selectPlant;
	AllPurchaseSubModules allPurchaseSubModules;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	PiApprovalPage piApprovalPage;
	PoApprovalPage poApprovalPage;
	String sheetName;
	String excelPath;
	ApprovalVendorPriceListPage approvalVendorPriceListPage;
	ManageVendorApprovePriceListPage manageVendorApprovePriceListPage;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);
		allPurchaseSubModules = new AllPurchaseSubModules(driver);
		toggleMenus = new ToggleMenus(driver);
		approvalVendorPriceListPage=new ApprovalVendorPriceListPage(driver);
		manageVendorApprovePriceListPage =new ManageVendorApprovePriceListPage (driver);

		logOutPage = new LogOutPage(driver);
		System.out.println("ERP site launched");
		// -------------------------------------

		poApprovalPage =new PoApprovalPage(driver);
		System.out.println("ERP site launched");
	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserNamepoApproval();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");
	}

	@Test
	public void vendorPriceListApprovalTest() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();
		allPurchaseSubModules.clickOnApprovalVendorPriceListMenu();

		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "vendorList";

		approvalVendorPriceListPage.clickOnSearchField();
		approvalVendorPriceListPage.enterItemCodesFromExcel(excelPath, sheetName, driver);




		//		allPurchaseSubModules.clickOnPoApprovalMenu();
//
//		poApprovalPage.sendPoNumberToSearchField();
//		poApprovalPage.selectFirstResultAndViewPo();
//		poApprovalPage.sendRemarkAndPoApproval();
//
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		logOutPage.clickOnProfileIconAndLogOut();
		Thread.sleep(1000);

		System.out.println("After method execution");

	}

	@AfterClass
	public void afterClass() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}

}
