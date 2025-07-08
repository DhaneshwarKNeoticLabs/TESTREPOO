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
import com.erp.automation.pages.materialTransaction.AllMaterialTransactionSubModules;
import com.erp.automation.pages.materialTransaction.OutwardRegister;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.InvoicePage;
import com.erp.automation.pages.sales.ManageInvoicePage;
import com.erp.automation.utils.ConfigReader;

public class InvoiceCreationTestDomesticAndOutward {

	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	InvoicePage invoicePage;
	ManageInvoicePage manageInvoicePage;
	String sheetName;
	String excelPath;
	AllMaterialTransactionSubModules allMaterialTransactionSubModules;
	OutwardRegister outwardRegister;

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

		invoicePage = new InvoicePage(driver);

		manageInvoicePage = new ManageInvoicePage(driver);

		allMaterialTransactionSubModules =new AllMaterialTransactionSubModules(driver);

		outwardRegister =new OutwardRegister(driver);

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

	// Domestic Invoice

	@Test  //(enabled = false)
	public void invoiceCreationFromExcelBulkDomesticAndOutward() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();


		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "Invoice";

		manageInvoicePage.createInvoice(excelPath, sheetName, driver);

		System.out.println("invoice saved successfully");

	}

	@Test  //(enabled = false)
	public void invoiceCreationFromExcelSingleitemDomesticAndOutward() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();


		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "Invoice Single Item";

		manageInvoicePage.createInvoice(excelPath, sheetName, driver);

		System.out.println("invoice saved successfully");

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
