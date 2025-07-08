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
import com.erp.automation.pages.purchase.ManagePurchaseOrderPage;
import com.erp.automation.pages.purchase.PiApprovalPage;
import com.erp.automation.pages.purchase.PoApprovalPage;
import com.erp.automation.pages.purchase.PurchaseOrderPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.purchase.VendorPriceListPage;
import com.erp.automation.utils.ConfigReader;

public class POCreateTest {

	WebDriver driver;
	SelectPlant selectPlant;
	AllPurchaseSubModules allPurchaseSubModules;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	PiApprovalPage piApprovalPage;
	PoApprovalPage poApprovalPage;
	VendorPriceListPage vendorPriceListPage;
	PurchaseOrderPage purchaseOrderPage;
	ManagePurchaseOrderPage managePurchaseOrderPage;

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

		logOutPage = new LogOutPage(driver);
		vendorPriceListPage =new VendorPriceListPage(driver);
		purchaseOrderPage =new PurchaseOrderPage(driver);
		managePurchaseOrderPage = new ManagePurchaseOrderPage(driver);
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
	public void poCreatTest() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();

		allPurchaseSubModules.clickOnPurchaseOrderMenu();
		purchaseOrderPage.selectPlantTwofromPopUp();
		purchaseOrderPage.selectSecondaryTypeOfPOfromPopUp();
		purchaseOrderPage.selectOneTimeTypeOfPOfromPopUp();

		managePurchaseOrderPage.selectManagementUnitDropDownOption();
		managePurchaseOrderPage.enterVendorName();
		managePurchaseOrderPage.clickOndeliveryDropDownOption();
		managePurchaseOrderPage.selectWarehouseDropDownOption();
		managePurchaseOrderPage.selectManagementUnitDropDownOption();
		managePurchaseOrderPage.clickOnaddPurchaseButton();
		managePurchaseOrderPage.enterDetailsForItems();
		managePurchaseOrderPage.saveAndSubmitForPoApproval();
		managePurchaseOrderPage.finalSuccessPopupConfirmation();

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
