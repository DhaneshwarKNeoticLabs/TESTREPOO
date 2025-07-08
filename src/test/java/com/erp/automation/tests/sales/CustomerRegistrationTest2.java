package com.erp.automation.tests.sales;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
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
import com.erp.automation.pages.sales.CustomersPage;
import com.erp.automation.utils.ConfigReader;
import com.erp.automation.utils.ExcelDataGenerator;

public class CustomerRegistrationTest2 {

    WebDriver driver;
    SelectPlant selectPlant;
    ToggleMenus toggleMenus;
    LogOutPage logOutPage;
    AllSalesSubModules allSalesSubModules;
    CustomersPage customersPage;
    String sheetName;
    String excelPath;

    @BeforeClass
    public void launchErpSite() throws InterruptedException {

        excelPath = "src/test/resources/RandomExcelTestData.xlsx";
        sheetName = "CustomerRegistrationRandomExcel";

        // Step 1: Generate fresh test data
        ExcelDataGenerator.writeRandomDataToExcel(excelPath, sheetName);

        // Step 2: Launch ERP
        driver = WebDriverManagerClass.getDriver();
        String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
        // driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
        Thread.sleep(3000);

        selectPlant = new SelectPlant(driver);
        toggleMenus = new ToggleMenus(driver);
        logOutPage = new LogOutPage(driver);
        allSalesSubModules = new AllSalesSubModules(driver);
        customersPage = new CustomersPage(driver);

        System.out.println("ERP site launched with fresh test data");
    }

    @BeforeMethod
    public void loginToApplication() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }

        loginPage.sendUserName();
        loginPage.sendPassword();
        loginPage.clickOnSignInButton();

        Thread.sleep(3000);
        System.out.println("Logged in to application");
    }

    @Test
    public void customerRegistrationTest() throws InterruptedException {
        selectPlant.selectPlantTwo();
        System.out.println("Selected plant two");

        toggleMenus.clickOnToggleMenu();
        toggleMenus.clickOnsalesMenuIcon();
        allSalesSubModules.clickOnCustomerMenu();
        customersPage.clickOnAddNewCustomerMenu();

        customersPage.fillingCustomerProfile(excelPath, sheetName, driver);

        System.out.println("customerRegistrationTest successfully passed with fresh data");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        logOutPage.clickOnProfileIconAndLogOut();
        Thread.sleep(1000);
        System.out.println("Logged out successfully");
    }

    @AfterClass
    public void afterClass() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert while closing browser.");
        }

        WebDriverManagerClass.quitDriver();
        System.out.println("Browser closed");
    }
}
