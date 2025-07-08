package com.erp.automation.tests.sales;

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
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.ManageSalesOrderPage;
import com.erp.automation.pages.sales.SalesOrderPage;
import com.erp.automation.pages.sales.SoApprovalPage;
import com.erp.automation.utils.ConfigReader;

public class SalesOrderCreationTestCAA1 {
// CAA -create, Approve1,Approve2
	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	AllSalesSubModules allSalesSubModules;
	SalesOrderPage salesOrderPage;
	ManageSalesOrderPage manageSalesOrderPage;
	String sheetName;
	String excelPath;
	LogOutPage logOutPage;
	LoginPage loginPage;
	SoApprovalPage soApprovalPage;

	@BeforeClass
	public void launchErpSite() {
		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		selectPlant = new SelectPlant(driver);
		allSalesSubModules = new AllSalesSubModules(driver);
		toggleMenus = new ToggleMenus(driver);
		salesOrderPage = new SalesOrderPage(driver);
		manageSalesOrderPage = new ManageSalesOrderPage(driver);
		logOutPage = new LogOutPage(driver);
		loginPage = new LoginPage(driver);
		soApprovalPage = new SoApprovalPage(driver);
		System.out.println("ERP site launched");
	}

	@BeforeMethod
	public void loginToApplicationBeforeMethod() throws InterruptedException {

		System.out.println("Before Method- pass ");
	}

	@Test(priority = 1)
	public void salesOrderCreationTest() throws InterruptedException {

		loginToApplication("sujit", "sspl");
		System.out.println("First Approval login");

		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnSalesOrderMenu();
		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "SOCreation";
		manageSalesOrderPage.creatingSalesOrderFromExcel(excelPath, sheetName, driver);

	}

	@Test(priority = 2)
	public void soFirstApprovalTest() throws InterruptedException {

		loginToApplication("lalit", "sspl");
		selectPlant.selectPlantTwo();
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnSalesOrderApprovalFirstMenu();
		soApprovalPage.sendSoNoInSearchFieldToOpenSo();
		manageSalesOrderPage.sendRemarkOnApprove();

		System.out.println("Selected plant two");
		System.out.println("First Approval login");
		System.out.println("First Approval login");
	}

	@Test(priority = 3, enabled = true)
	public void soSecondApprovalTest() throws InterruptedException {

		loginToApplication("sandipm", "sspl");
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnSalesOrderApprovalSecondMenu();
		soApprovalPage.sendSoNoInSearchFieldToOpenSo();
		manageSalesOrderPage.sendRemarkOnApprove();

		System.out.println("Second Approval login");
		System.out.println("Second Approval login");
	}

	@Test (priority = 4, enabled = false)
	public void salesOrderCloseTest() throws InterruptedException {

		loginToApplication("sujit", "sspl");
		System.out.println("First Approval login");

		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnSalesOrderMenu();
		soApprovalPage.sendSoNoInSearchFieldToOpenSoOnSOpage();
		soApprovalPage.closingTheSO();



	}

	public void loginToApplication(String username, String passWord) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserName(username);
		loginPage.sendPassword(passWord);
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in with: " + username);
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

		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}

}
