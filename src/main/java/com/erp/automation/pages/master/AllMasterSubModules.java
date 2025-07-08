package com.erp.automation.pages.master;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllMasterSubModules {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;

	//Other Master
	//First Approval
	@FindBy (xpath="/html/body/div[2]/div[2]/div[2]/ul/li[4]/a[1]")
	private WebElement otherMaster;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[6]/ul/li[4]/a/span")
	private WebElement customersForApproval;

	//Second i.e. Final Approval
	@FindBy (xpath="/html/body/div[2]/div[2]/div[2]/ul/li[3]/a[1]")
	private WebElement otherMasterFinalApproval;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[4]/ul/li/a/span")
	private WebElement customersForApprovalFinalApproval;


// Item Master subsection:-

	@FindBy (xpath="/html[1]/body[1]/div[2]/div[2]/div[2]/ul[1]/li[1]/a[1]")
	private WebElement itemMasterMenu;

	@FindBy (xpath="/html[1]/body[1]/div[2]/div[2]/div[3]/ul[1]/li[5]/a[1]")
	private WebElement items;



	// Constructor
	public  AllMasterSubModules (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnOtherMasterMenu() throws InterruptedException {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
		otherMaster.click();
		Thread.sleep(3000);
	}

	public void clickOnCustomersForApprovalMenu() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		customersForApproval.click();
			Thread.sleep(2000);
		}

	//Final Approval= Ankita

	public void clickOnOtherMasterMenuFinalApproval() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		otherMasterFinalApproval.click();
			Thread.sleep(3000);
		}
	public void clickOnCustomersForApprovalMenuFinalApproval() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		customersForApprovalFinalApproval.click();
			Thread.sleep(2000);
		}

	public void clickOnItemMastersAndClickOnItem() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		itemMasterMenu.click();
		Thread.sleep(1000);
		items.click();

		}




}
