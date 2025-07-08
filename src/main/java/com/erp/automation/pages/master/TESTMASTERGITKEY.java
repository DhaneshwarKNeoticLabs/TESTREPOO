package com.erp.automation.pages.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TESTMASTERGITKEY {

	//Variables
		private WebDriver driver;
		private WebDriverWait wait;


		@FindBy (xpath="/html[1]/body[1]/div[2]/div[2]/div[11]/ul[1]/li[10]/a[1]")
		private WebElement invoice;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[11]/ul/li[1]/a")
		private WebElement customer;


	//private Object invoice;

	// Methods
	public void clickOnInvoiceMenu() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOf(emailId));
	//git key mapping issue checking
		Thread.sleep(5000);


	}









}
