package com.erp.automation.tests.purchase;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.ExcelTestLogIn;
import com.erp.automation.utils.ConfigReader;




public class LogInExcelTestClass {


	ExcelTestLogIn excelloginPage;
	 WebDriver driver;
	 String sheetName;
	 String excelPath;


	@Test
    public void LoginWithWrongCredsexcelSheetTest() throws InterruptedException {
        // Set up WebDriver (Ensure chromedriver.exe is in your system PATH)
     //   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\chromedriver.exe");
      //  driver = new ChromeDriver();
		driver=WebDriverManagerClass.getDriver();

        // Open the application
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // driver.get("http://192.168.2.5/ACCSSPLDRYRUN/"); // Replace with your actual login URL
        String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
        
        // Create LoginPage object
         excelloginPage = new ExcelTestLogIn(driver);

         Alert alert = driver.switchTo().alert();
     	alert.accept();
        // Provide the Excel file path
         excelPath = "src/test/resources/ExcelTestData.xlsx";
         sheetName = "LoginCreds";

        // Perform login using data from Excel
        excelloginPage.loginFromExcel(excelPath,sheetName);

        // Close the browser
        driver.quit();
    }
}
