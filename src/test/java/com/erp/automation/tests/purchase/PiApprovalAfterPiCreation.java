package com.erp.automation.tests.purchase;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

public class PiApprovalAfterPiCreation {

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
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		
	//	driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
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
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");
	}

	@Test
	public void piCreationLoadTest() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();
		allPurchaseSubModules.clickOnpurchaseIndentMenu();
		purchaseIndentPage.clickOnAddPurchaseIndent();

		purchaseIndentPage.selctioinOfPlantTwoAfterAddPurchaseIndent();
		// Selecting Pi Good Item Type
		piPopUpItemType.clickOnPiPopUpItemTypePiGoods();
		piPopUpItemType.clickOnSelectOption();
		// Select Consumable option
		piPopUpItemType.selectConsumableOption();
		// select central option under store section
		managePurchaseIndentPage.clickOnStoreDropdown();
		managePurchaseIndentPage.clickOnStoreDropdownOptionsSelectCentral();
		// -----------------
		managePurchaseIndentPage.clickOnManagementUnitDropdown();
		managePurchaseIndentPage.ClickOnProjectDropdownOptionsSelectSSPLS002Project_S_2();

		managePurchaseIndentPage.clickOnProjectDropdown();
		managePurchaseIndentPage.clickOnprojectDropdownOptionsSelectSSPLS002Project_S_2();

		// selecting Pi items under item code by parameterization and for loop

		managePurchaseIndentPage.deleteExtraSecondAndThirdRows();

		// managePurchaseIndentPage.enterInItemCodeField();
		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "SampleItemCode";

		managePurchaseIndentPage.itemCodesFromExcel(excelPath, sheetName, driver);
//   managePurchaseIndentPage.enterValuesInQtyRemPurpose();
		managePurchaseIndentPage.clickOnSaveAndSendForApprovalButton();

		managePurchaseIndentPage.clickOnOkButtonFromWarningPopUp();

		WebElement piNumberStoring = driver.findElement(By.xpath("//p[contains(text(), 'PI #')]/b[1]"));
		String piNumber = piNumberStoring.getText();
		System.out.println(piNumber);
		managePurchaseIndentPage.okButtonFromFinalSuccessPopUp();



		logOutPage.clickOnProfileIconAndLogOut();
		// driver.manage().deleteAllCookies();

		System.out.println("hiiiiiiiii1");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow
		System.out.println("hiiiiiiiii2");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		System.out.println("hiiiiiiiii3");
//	       driver = WebDriverManagerClass.getDriver();
//	       System.out.println("Second Browser Open");

//	       driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
//	       System.out.println("hiiiiiiiii");
//	       System.out.println("Second browser URL open");
		Thread.sleep(3000);
//

		Alert alert = driver.switchTo().alert();
		alert.accept();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUserNamePiApproval();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application by Approval");

		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnPurchaseMenuIcon();
		allPurchaseSubModules.clickOnPiApprovalMenu();
		piApprovalPage.sendPiNumberInSearchField(piNumber);
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
		driver.quit(); // Quit the WebDriver
		System.out.println("Browser closed");
	}

}
