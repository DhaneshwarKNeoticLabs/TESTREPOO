package com.erp.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;  // ✅ ChromeOptions fix
import java.util.UUID;                            // ✅ UUID fix

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerClass {

	  private static WebDriver driver;

//	    public static WebDriver getDriver() {
//	        if (driver == null) {
//	            System.setProperty("webdriver.chrome.driver",
//	                "C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\chromedriver.exe");
//
//	            driver = new ChromeDriver();
//	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	            driver.manage().window().maximize();
//	        }
//	        return driver;
//	    }

	 //  public static WebDriver getDriver() {
		//     if (driver == null) {
		//         WebDriverManager.chromedriver().setup(); // auto-downloads compatible ChromeDriver
		//         driver = new ChromeDriver();
		//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//         driver.manage().window().maximize();
		//     }
		//     return driver;
		// }
	public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Always safe for CI/CD and local
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");

            // ✅ Fixes session conflict error
            options.addArguments("--user-data-dir=/tmp/unique-profile-" + UUID.randomUUID());

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        }

        return driver;
    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }

	    }





}
