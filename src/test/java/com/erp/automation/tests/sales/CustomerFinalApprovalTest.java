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
import com.erp.automation.pages.master.AllMasterSubModules;
import com.erp.automation.pages.master.CustomersForApprovalPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.CustomersPage;
import com.erp.automation.utils.ConfigReader;

public class CustomerFinalApprovalTest {


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

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);

		toggleMenus = new ToggleMenus(driver);

		logOutPage = new LogOutPage(driver);

		allSalesSubModules = new AllSalesSubModules(driver);

		customersPage = new CustomersPage(driver);

		allMasterSubModules =new AllMasterSubModules(driver);

		customersForApprovalPage = new CustomersForApprovalPage(driver);
		System.out.println("ERP site launched");
		// -------------------------------------

	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserNameFinalCustomerApproval();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");
	}



	@Test
	public void customerFinalApprovalTest() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnMasterMenuIcon();

		allMasterSubModules.clickOnOtherMasterMenuFinalApproval();
		allMasterSubModules.clickOnCustomersForApprovalMenuFinalApproval();
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "CustomerRegistration";
		customersForApprovalPage.enterCustomerNameInSearchFieldAndOpenCustomer(excelPath, sheetName, driver);
		customersForApprovalPage.finalApproveCustomer();

	}

	@Test
	public void customerFinalApprovalTest2() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnMasterMenuIcon();

		allMasterSubModules.clickOnOtherMasterMenuFinalApproval();
		allMasterSubModules.clickOnCustomersForApprovalMenuFinalApproval();
		excelPath = "src/test/resources/RandomExcelTestData.xlsx";
		sheetName = "CustomerRegistrationRandomExcel";
		customersForApprovalPage.enterCustomerNameInSearchFieldAndOpenCustomer(excelPath, sheetName, driver);
		customersForApprovalPage.finalApproveCustomer();
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
