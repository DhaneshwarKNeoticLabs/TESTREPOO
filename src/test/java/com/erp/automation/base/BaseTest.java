package com.erp.automation.base;

import org.openqa.selenium.WebDriver;

public class BaseTest {


	protected WebDriver driver;

 //   @BeforeMethod
    public void setUp() {
        driver = WebDriverManagerClass.getDriver();
    }

 //   @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


}
