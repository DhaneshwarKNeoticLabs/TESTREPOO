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
import com.erp.automation.pages.sales.CustomerPriceListPage;
import com.erp.automation.utils.ConfigReader;

public class CustomerPriceListTest {

	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	AllSalesSubModules allSalesSubModules;
	CustomerPriceListPage customerPriceListPage;
	LogOutPage logOutPage;
	String sheetName;
	String excelPath;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);
		allSalesSubModules = new AllSalesSubModules(driver);
		toggleMenus = new ToggleMenus(driver);

		logOutPage = new LogOutPage(driver);
		customerPriceListPage =new CustomerPriceListPage(driver);
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
	public void customerPriceListUpdate() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnCustomerPriceListMenu();

		customerPriceListPage.clickOnSelectCustomerPriceListTypeFieldAndSelectRegularOption();


		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
	//	excelPath = "C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\ExcelTestData.xlsx";

		sheetName = "CustomerPriceList";

		customerPriceListPage.customerCodesFromExcel(excelPath, sheetName, driver);
	//	vendorPriceListPage.itemCodesFromExcel(excelPath, sheetName, driver);

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
