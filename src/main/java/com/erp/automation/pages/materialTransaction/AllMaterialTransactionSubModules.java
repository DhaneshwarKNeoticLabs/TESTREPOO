package com.erp.automation.pages.materialTransaction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllMaterialTransactionSubModules {



	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//span[text()='Outward Register']")
	private WebElement outwardRegisterMenu;


	// Constructor
	public  AllMaterialTransactionSubModules (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnOutwardRegisterMenu() throws InterruptedException {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
		outwardRegisterMenu.click();
		Thread.sleep(2000);
	}

}
