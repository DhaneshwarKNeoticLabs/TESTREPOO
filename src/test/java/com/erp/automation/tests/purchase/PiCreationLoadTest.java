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
import com.erp.automation.pages.purchase.PiPopUpItemType;
import com.erp.automation.pages.purchase.PurchaseIndentPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.utils.ConfigReader;

public class PiCreationLoadTest {

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

	    @BeforeClass
	    public void launchErpSite() {
	        driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
	       
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
	    public void piCreationLoadTest() throws InterruptedException {
	        selectPlant.selectPlantTwo();
	        System.out.println("Selected plant two");

	        toggleMenus.clickOnToggleMenu();
	        toggleMenus.clickOnPurchaseMenuIcon();
	        allPurchaseSubModules.clickOnpurchaseIndentMenu();
	       purchaseIndentPage.clickOnAddPurchaseIndent();

	       purchaseIndentPage.selctioinOfPlantTwoAfterAddPurchaseIndent();
	       //Selecting Pi Good Item Type
	       piPopUpItemType.clickOnPiPopUpItemTypePiGoods();
	       piPopUpItemType.clickOnSelectOption();
	       //Select Consumable option
	       piPopUpItemType.selectConsumableOption();
	       //select central option under store section
	       managePurchaseIndentPage.clickOnStoreDropdown();
	       managePurchaseIndentPage.clickOnStoreDropdownOptionsSelectCentral();
	       //-----------------
	       managePurchaseIndentPage.clickOnManagementUnitDropdown();
	       managePurchaseIndentPage.ClickOnProjectDropdownOptionsSelectSSPLS002Project_S_2();

	       managePurchaseIndentPage.clickOnProjectDropdown();
	       managePurchaseIndentPage.clickOnprojectDropdownOptionsSelectSSPLS002Project_S_2();

	       //selecting Pi items under item code by parameterization and for loop

	       managePurchaseIndentPage.deleteExtraSecondAndThirdRows();


	 //    managePurchaseIndentPage.enterInItemCodeField();
	    // Provide the Excel file path
	         excelPath = "src/test/resources/ExcelTestData.xlsx";
	         sheetName = "ItemCode";

	       managePurchaseIndentPage.itemCodesFromExcel(excelPath, sheetName, driver);
//      managePurchaseIndentPage.enterValuesInQtyRemPurpose();
	       managePurchaseIndentPage.clickOnSaveAndSendForApprovalButton();

	       managePurchaseIndentPage.clickOnOkButtonFromWarningPopUp();

	    }

	    @AfterMethod
	    public void afterMethod() {
	    	logOutPage.clickOnProfileIconAndLogOut();
	    	  // Delete cookies to avoid data persistence issues
//	        if (driver != null) {
//	            driver.manage().deleteAllCookies();
//	        }
//	        System.out.println("After method execution");
//
	    }

	    @AfterClass
	    public void afterClass() {
	       WebDriverManagerClass.quitDriver(); // Quit the WebDriver
	        System.out.println("Browser closed");
	    }





}
