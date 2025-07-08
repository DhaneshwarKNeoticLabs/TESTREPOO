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
import com.erp.automation.pages.purchase.ManagePurchaseIndentPage;
import com.erp.automation.pages.purchase.ManagePurchaseOrderPage;
import com.erp.automation.pages.purchase.PiApprovalPage;
import com.erp.automation.pages.purchase.PiPopUpItemType;
import com.erp.automation.pages.purchase.PreviewPiManagePurchaseIndent;
import com.erp.automation.pages.purchase.PurchaseIndentPage;
import com.erp.automation.pages.purchase.PurchaseOrderPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.utils.ConfigReader;

public class PoCloseProcessTest {

	WebDriver driver;
	SelectPlant selectPlant;
	AllPurchaseSubModules allPurchaseSubModules;
	ToggleMenus toggleMenus;
	PurchaseIndentPage purchaseIndentPage;
	PiPopUpItemType piPopUpItemType;
	ManagePurchaseIndentPage managePurchaseIndentPage;
	String sheetName;
	String excelPath;
	LogOutPage logOutPage;
	PiApprovalPage piApprovalPage;
	PreviewPiManagePurchaseIndent previewManagePurchaseIndent;
	ManagePurchaseOrderPage managePurchaseOrderPage;
	PurchaseOrderPage purchaseOrderPage;

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
		purchaseIndentPage = new PurchaseIndentPage(driver);
		piPopUpItemType = new PiPopUpItemType(driver);
		managePurchaseIndentPage = new ManagePurchaseIndentPage(driver);
		logOutPage = new LogOutPage(driver);
		System.out.println("ERP site launched");
		// -------------------------------------
		purchaseOrderPage=new PurchaseOrderPage(driver);
		previewManagePurchaseIndent = new PreviewPiManagePurchaseIndent(driver);
		managePurchaseOrderPage = new ManagePurchaseOrderPage(driver);
		System.out.println("ERP site launched");
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
	public void poCloseProcessTest() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();
		allPurchaseSubModules.clickOnPurchaseOrderMenu();

		purchaseOrderPage.purchaseOrderPage();

		purchaseOrderPage.sendPoNumberToSearchField();

		purchaseOrderPage.slectFirstRowAndClickOnClosedButton();




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
