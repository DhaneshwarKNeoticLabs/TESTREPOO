package com.erp.automation.pages.production;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductionSubModules {

	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="/html/body/div[2]/div[2]/div[12]/ul/li[9]/a/span")
	private WebElement issueAndRequisition;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[12]/ul/li[8]/a")
	private WebElement toolReturnSlipMenu;

	// Constructor
	public  AllProductionSubModules (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnIssueAndRequisitionMenu() throws InterruptedException {

	wait.until(ExpectedConditions.elementToBeClickable(issueAndRequisition));
		issueAndRequisition.click();
		Thread.sleep(3000);
	}

	public void clickOnToolReturnMenu() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(toolReturnSlipMenu));
		toolReturnSlipMenu.click();
			Thread.sleep(3000);
		}



}
