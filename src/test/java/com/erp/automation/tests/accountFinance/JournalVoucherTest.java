package com.erp.automation.tests.accountFinance;

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
import com.erp.automation.pages.accountFinance.AllAccountFinanceSubModules;
import com.erp.automation.pages.accountFinance.CustomerOutstandingReportPage;
import com.erp.automation.pages.accountFinance.JournalVoucherPage;
import com.erp.automation.pages.materialTransaction.OutwardRegister;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.InvoicePage;
import com.erp.automation.pages.sales.ManageInvoicePage;
import com.erp.automation.utils.ConfigReader;

public class JournalVoucherTest {

	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	InvoicePage invoicePage;
	ManageInvoicePage manageInvoicePage;
	String sheetName;
	String excelPath;
	AllAccountFinanceSubModules allAccountFinanceSubModules;
	OutwardRegister outwardRegister;
	CustomerOutstandingReportPage customerOutstandingReportPage;
	JournalVoucherPage journalVoucherPage;
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

		allAccountFinanceSubModules =new AllAccountFinanceSubModules(driver);

		outwardRegister =new OutwardRegister(driver);

		customerOutstandingReportPage = new CustomerOutstandingReportPage (driver);
		journalVoucherPage =new JournalVoucherPage(driver);

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



	@Test
	public void creationOfJournalVoucherMethod() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnAccountFinanceMenuIcon();


		allAccountFinanceSubModules.clickOnExpenseAndJournalVoucherMenu();
		journalVoucherPage.clickOnAddJournalVoucher();

		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "JournalVoucher";

		journalVoucherPage.creatMultipleDebitAndCreditRecordsForSingleJVByUsingExcel(excelPath, sheetName, driver);

		journalVoucherPage.addRemarkCommentAndSendJournalVoucher();

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
