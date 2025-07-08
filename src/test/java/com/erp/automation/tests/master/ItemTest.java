package com.erp.automation.tests.master;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.master.AllMasterSubModules;
import com.erp.automation.pages.master.CustomersForApprovalPage;
import com.erp.automation.pages.master.ItemPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.CustomersPage;
import com.erp.automation.utils.ConfigReader;

public class ItemTest {

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
	ItemPage itemPage;
	SoftAssert softAssert;


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

		allMasterSubModules = new AllMasterSubModules(driver);

		customersForApprovalPage = new CustomersForApprovalPage(driver);

		 itemPage =new ItemPage(driver);
		 softAssert =new SoftAssert();

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
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnMasterMenuIcon();
		allMasterSubModules.clickOnItemMastersAndClickOnItem();
	}

	@Test (dataProvider="ItemNames")
	public void itemCreationTest(String NewItemName) throws InterruptedException {


		Assert.assertTrue(itemPage.addItemButton.isDisplayed(),"--Add Item Button is not visible--");
		System.out.println("--Add Item Button is visible--");
		itemPage.clickOnAddItem();
		Assert.assertTrue(driver.getCurrentUrl().contains("Master/ManageItems"),"---Current URL Assertion fails---");
		System.out.println("current url is =" + driver.getCurrentUrl());

		String actualText=itemPage.getItemTypeTitle();
		Assert.assertEquals(actualText,"Item Type" );
		System.out.println("--Item Type Title Verifies with assertion--");
		itemPage.itemTypeSelection();
		Assert.assertTrue(itemPage.itemTypeSelection(),"\"CONSUMABLES\" option not found in dropdown");
		itemPage.selectItemType();
		System.out.println("--CONSUMABLE Option is selected sucessfully--");

		itemPage.subItemTypeSelection();
		Assert.assertTrue(itemPage.subItemTypeSelection(), "'Calulator' option not found in dropdown");
		itemPage.selectItemSubType();
		System.out.println("--CALCULATOR Option is selected sucessfully--");
		itemPage.selectItemAttribute();
		itemPage.selectPlantDD();
		itemPage.selectPlantDD();
		itemPage.selectProcess();
		//itemPage.enterItemName();

		itemPage.enterItemNameByUsingDataProvider(NewItemName);

		System.out.println("successfully DataProvider implementation");

		itemPage.selectShape();
		itemPage.selectMaterial();
		itemPage.selectUOM();
		itemPage.ToolMaterial();
		itemPage.enterPredictedQty();
		itemPage.selectProductGroup();
		itemPage.selectGreenScrap();
		itemPage.selectWeightPerUnit();
		itemPage.EnterExpectedToolLife();
		itemPage.EnterActualToolLife();
		itemPage.selectPhase();
		itemPage.checkItemStatusRadioButton();
		//System.out.println(itemPage.isCheckBoxSelectedForItemStatusRadioButton());
		System.out.println("testttttt");
		softAssert.assertTrue(itemPage.isCheckBoxSelectedForItemStatusRadioButton(), "Scrap checkbox should be selected");
		softAssert.assertAll();
		itemPage.selectScrapCheckBoxCheckRadioOption();
		itemPage.selectIsQualityCheckRadioOption();
		itemPage.selectIsImportCapexCheckRadioOption();
		itemPage.selectIsBOMRequiredCheckRadioOption();
		itemPage.enterGSTDetails();
		itemPage.enterInventoryDetails();
		itemPage.enterManufacturingDetails();
		itemPage.uploadFileDocument();
		itemPage.saveAndSubmitActionMethod();

	}


	@DataProvider(name="ItemNames")

	 public Object[][] itemNames() {
        return new Object[][] {
            {"IPad 0011"},
//            {"IPad 002"},
//            {"IPad 003"},
//            {"IPad 004"},
   //         {"IPad 005"}

        };
    }


	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
	//	logOutPage.clickOnProfileIconAndLogOut();
		Thread.sleep(1000);

		System.out.println("After method execution-logout successfully done");

	}

	@AfterClass
	public void afterClass() {

//		Alert alert = driver.switchTo().alert();
//		alert.accept();
	//	WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}

}
