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
import com.erp.automation.pages.purchase.PiApprovalPage;
import com.erp.automation.pages.purchase.PiPopUpItemType;
import com.erp.automation.pages.purchase.PreviewPiManagePurchaseIndent;
import com.erp.automation.pages.purchase.PurchaseIndentPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.utils.ConfigReader;

public class PiApproval {


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

	@BeforeClass
	public void launchErpSite() {
		// driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		// Enable location access using ChromeOptions
//		Map<String, Object> prefs = new HashMap<>();
//		prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow
//
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", prefs);
//
//		driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();

		driver = WebDriverManagerClass.getDriver();
		
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		selectPlant = new SelectPlant(driver);
		allPurchaseSubModules = new AllPurchaseSubModules(driver);
		toggleMenus = new ToggleMenus(driver);
		purchaseIndentPage = new PurchaseIndentPage(driver);
		piPopUpItemType = new PiPopUpItemType(driver);
		managePurchaseIndentPage = new ManagePurchaseIndentPage(driver);
		logOutPage = new LogOutPage(driver);
		piApprovalPage = new PiApprovalPage(driver);
		previewManagePurchaseIndent = new PreviewPiManagePurchaseIndent(driver);
		System.out.println("ERP site launched");
	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserNamePiApproval();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");
	}

	@Test
	public void piApprovalTest() throws InterruptedException {
		System.out.println("Logged in to application by Sharad for Approving Pi");
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();
		allPurchaseSubModules.clickOnPiApprovalMenu();
		piApprovalPage.sendPiNumberInSearchFieldFromUtilsClass();
		piApprovalPage.selectFirstResultOfPiAfterSearch();
		previewManagePurchaseIndent.clickOnPiApprove();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		logOutPage.clickOnProfileIconAndLogOut();
		Thread.sleep(1000);

		System.out.println("After method execution");

	}

	@AfterClass
	public void afterClass() throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		WebDriverManagerClass.quitDriver();
	//	driver.quit(); // Quit the WebDriver
		System.out.println("Browser closed");
	}


}
