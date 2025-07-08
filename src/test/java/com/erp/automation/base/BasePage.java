package com.erp.automation.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage  {

	 protected WebDriver driver; // Protected for access by subclasses

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initializes WebElements

	    }

	    // Common actions applicable to all pages
	    public String getPageTitle() {
	        return driver.getTitle();
	    }

	    public void navigateTo(String url) {
	        driver.get(url);
	    }

	    // ... other common methods like waitForElement, clickElement, etc.


	 // Scroll to bottom of the page
	    public void scrollToBottom() {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }

	 // Scroll to top of the page
	    public void scrollToTop() {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollTo(0, 0)");
	  }
	    public WebDriver getDriver() {
	        return driver;
	    }



}
