package com.erp.automation.tests.sales;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.ManageSalesOrderPage;
import com.erp.automation.pages.sales.SalesOrderPage;
import com.erp.automation.utils.ConfigReader;

public class SalesOrderFirstApproval {



  	WebDriver driver;
    SelectPlant selectPlant;
    ToggleMenus toggleMenus;
    AllSalesSubModules  allSalesSubModules;
    SalesOrderPage salesOrderPage;
    ManageSalesOrderPage manageSalesOrderPage;
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
        allSalesSubModules = new AllSalesSubModules(driver);
        toggleMenus = new ToggleMenus(driver);
        salesOrderPage = new SalesOrderPage(driver);
        manageSalesOrderPage = new ManageSalesOrderPage(driver);
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
    public void soFirstApprovalTest() throws InterruptedException {

    	System.out.println("First Approval login");
    }

    @Test
    public void soSecondApprovalTest() throws InterruptedException {

    	System.out.println("Second Approval login");
    }






    /*	selectPlant.selectPlantTwo();
        System.out.println("Selected plant two");
        toggleMenus.clickOnToggleMenu();
        toggleMenus.clickOnsalesMenuIcon();
        allSalesSubModules.clickOnSalesOrderMenu();
        // Provide the Excel file path
		excelPath = "C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\ExcelTestData.xlsx";
		sheetName = "SOCreation";
		manageSalesOrderPage.creatingSalesOrderFromExcel(excelPath, sheetName, driver);
*/

/*
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
*/


}


