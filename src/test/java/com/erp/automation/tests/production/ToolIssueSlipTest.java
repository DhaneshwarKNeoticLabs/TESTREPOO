package com.erp.automation.tests.production;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.master.AllMasterSubModules;
import com.erp.automation.pages.master.CustomersForApprovalPage;
import com.erp.automation.pages.master.ItemPage;
import com.erp.automation.pages.production.AllProductionSubModules;
import com.erp.automation.pages.production.IssueAndRequisitionPage;
import com.erp.automation.pages.production.ToolIssueSlipPage;
import com.erp.automation.pages.production.ToolReturnPage;
import com.erp.automation.pages.production.ToolReturnSlipPage;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.reports.AllProductionReportSubModules;
import com.erp.automation.pages.reports.OEESummeryReportPage;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.CustomersPage;
import com.erp.automation.pages.tooling.AllToolingSubModules;
import com.erp.automation.pages.tooling.ToolAcceptancePage;
import com.erp.automation.utils.ConfigReader;

public class ToolIssueSlipTest {


	WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	String sheetName;
	String excelPath;
	CustomersPage customersPage;
	ToolIssueSlipPage toolIssueSlipPage;
	AllMasterSubModules allMasterSubModules;
	CustomersForApprovalPage customersForApprovalPage;
	ItemPage itemPage;
	SoftAssert softAssert;
	AllProductionSubModules allProductionSubModules;
	AllProductionReportSubModules allProductionReportSubModules;
	OEESummeryReportPage oEESummeryReportPage;
	String reportURL;
	AllToolingSubModules allToolingSubModules;
	IssueAndRequisitionPage issueAndRequisitionPage;
	ToolAcceptancePage toolAcceptancePage;
	ToolReturnSlipPage toolReturnSlipPage;
	ToolReturnPage toolReturnPage;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);

		toggleMenus = new ToggleMenus(driver);

		allProductionSubModules= new AllProductionSubModules(driver);

		toolIssueSlipPage =new ToolIssueSlipPage(driver);

		issueAndRequisitionPage = new IssueAndRequisitionPage(driver);

		allProductionReportSubModules =new AllProductionReportSubModules(driver);

		oEESummeryReportPage = new OEESummeryReportPage(driver);

		logOutPage = new LogOutPage(driver);

		customersPage = new CustomersPage(driver);

		allMasterSubModules = new AllMasterSubModules(driver);

		allToolingSubModules = new AllToolingSubModules(driver);

		customersForApprovalPage = new CustomersForApprovalPage(driver);

		toolAcceptancePage = new ToolAcceptancePage(driver);

		toolReturnSlipPage = new ToolReturnSlipPage(driver);

		toolReturnPage =new ToolReturnPage(driver);
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

	}

	@Test (priority =0,enabled = true)
	public void toolIssueSlipTest () throws InterruptedException {
		System.out.println("--Test Case 001 _ Tool Issue Slip Test_Running--");
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.productionMenu();
		allProductionSubModules.clickOnIssueAndRequisitionMenu();

		System.out.println("================//===========");
		issueAndRequisitionPage.clickOnAddButton();
		toolIssueSlipPage.enterToolIssueSlipDetails();


		System.out.println("================//===========");
	}


	@Test (priority =0,enabled = true)
	public void toolReturnTest () throws InterruptedException {
		System.out.println("--Test Case 002 _ Tool Return Test_Running--");
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.productionMenu();

		allProductionSubModules.clickOnToolReturnMenu();

		toolReturnSlipPage.addNewToolReturnRecord();
		System.out.println("--Tool Issue Details Pop Up--");
		toolReturnPage.enterDetailsinToolIssueDetailsPopUp();
		toolReturnPage.enterDetailsInToolReturnPage();
		System.out.println("================//===========");


		System.out.println("================//===========");
	}
 

	@Test (priority =0,enabled = true)
	public void toolSlipAcceptance () throws InterruptedException {

		System.out.println("--Test Case 002 _ Tool Slip Acceptance Test_Running--");
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.toolingMenu();
		allToolingSubModules.clickOnToolAcceptanceMenu();
		toolAcceptancePage.openToolReturnForSearchedRecord();
		System.out.println("================/11111/===========");

		allProductionSubModules.clickOnIssueAndRequisitionMenu();

		System.out.println("================//===========");
		issueAndRequisitionPage.clickOnAddButton();
		toolIssueSlipPage.enterToolIssueSlipDetails();

		System.out.println("================//===========");
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

	//	WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}






}
