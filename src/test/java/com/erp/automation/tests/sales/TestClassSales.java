package com.erp.automation.tests.sales;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.InvoicePage;
import com.erp.automation.pages.sales.ManageInvoicePage;

public class TestClassSales {


	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	InvoicePage invoicePage;
	ManageInvoicePage manageInvoicePage;
	String sheetName;
	String excelPath;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		//driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
	//	options.addArguments("plugins.always_open_pdf_externally=true"); // Forces PDFs to download
		 driver = new ChromeDriver(options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.manage().window().maximize();

		driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");

		Thread.sleep(3000);

		selectPlant = new SelectPlant(driver);

		toggleMenus = new ToggleMenus(driver);

		logOutPage = new LogOutPage(driver);

		allSalesSubModules = new AllSalesSubModules(driver);

		invoicePage = new InvoicePage(driver);

		manageInvoicePage = new ManageInvoicePage(driver);

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
	public void invoiceCreationFromExcel() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();
//		invoicePage.clickOnAddInvoice();
//		invoicePage.selectDomesticInvoiceTypeFromPopUp();

		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "Invoice";

		manageInvoicePage.createInvoice(excelPath, sheetName, driver);
		System.out.println("invoice saved successfully");



	}


}
