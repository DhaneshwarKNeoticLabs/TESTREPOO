package com.erp.automation.tests.purchase;

import java.time.Duration;

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
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.utils.ConfigReader;

public class ReleaseNote {

	WebDriver driver;
	WebDriver driver1;
   	SelectPlant selectPlant;
    LogOutPage logOutPage;
	//ApplicationHeaders applicationHeaders;


	@BeforeClass
	public void lauchingErpSite() {
	//launching code
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\chromedriver.exe");
	 driver = WebDriverManagerClass.getDriver();


	// driver =new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 selectPlant =new SelectPlant(driver);
	 logOutPage = new LogOutPage(driver);
//	applicationHeaders=new ApplicationHeaders (driver);
//
	//open url
	 String baseUrl = ConfigReader.get("baseUrl");
     driver.get(baseUrl);
	//  driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
	  System.out.println("beforeClass");
	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {

	LoginPage loginPage =new LoginPage(driver);

	Alert alert = driver.switchTo().alert();
	alert.accept();
	loginPage.sendUserName();
	loginPage.sendPassword();
	loginPage.clickOnSignInButton();
	//plantselection.selectPlantTwo();
	Thread.sleep(3000);

	System.out.println("beforeMehtod");
	}

	@Test
	public void test1() throws InterruptedException  {

		selectPlant.selectPlantTwo();

	// options.addArguments("--disable-notifications");
	System.out.println("selectPlantTwo");

	}

//	@Test
//	public void toVerifyCreatPost()  {
//
//	//applicationHeaders.clickOnHomeIcon();
//	// options.addArguments("--disable-notifications");
//	System.out.println("test2");
//	}

	  @AfterMethod
	    public void afterMethod() {

//		  try {
//		        // Handle unexpected alert if present
//		        Alert alert = driver.switchTo().alert();
//		        System.out.println("Unexpected alert detected: " + alert.getText());
//		        alert.accept(); // or alert.accept() if you want to proceed
//		        System.out.println("Alert dismissed.");
//		    } catch (NoAlertPresentException e) {
//		        System.out.println("No alert present, proceeding with logout.");
//		    }
//
	    	logOutPage.clickOnProfileIconAndLogOut();
	    	  // Delete cookies to avoid data persistence issues
//	        if (driver != null) {
//	            driver.manage().deleteAllCookies();
//	        }
//	        System.out.println("After method execution");

	    }

	    @AfterClass
	    public void afterClass() {
	       WebDriverManagerClass.quitDriver(); // Quit the WebDriver
	        System.out.println("Browser closed");
	    }




}
