package com.erp.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


	//Variables
	private WebDriver driver;
	//private WebDriverWait wait;

	@FindBy (xpath="//input[@id='UserName']")
	private WebElement userName;

	@FindBy (xpath="//input[@id='PassWord']")
	private WebElement password;

	@FindBy (xpath="//input[@id='UserName']")
	private WebElement userNamee;

	@FindBy (xpath="//input[@id='PassWord']")
	private WebElement passwordd;

	@FindBy (xpath="//button[normalize-space()='Sign in']")
	WebElement signInButton;

	// Constructor
	public LoginPage(WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	  // wait=new WebDriverWait(driver,10);
	}

	// Methods
	public void sendUserName() {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("sujit");
	}

	public void sendPassword() {
	password.sendKeys("sspl");
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	// Methods
	public void sendUserNamePiApproval() {
		// wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("sharad");
	}

	public void sendUserNamepoApproval() {
		// wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("sharad");
	}

	public void sendUserNameCustomerApproval() {
		// wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("sachinp");
	}

	public void sendUserNameFinalCustomerApproval() {
		// wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("ankitaa");
	}

	public void sendUserNameCustomerPriceApproval() {
		// wait.until(ExpectedConditions.visibilityOf(emailId));
		userName.sendKeys("lalit");
	}


	public void sendUserName(String username) {
		userName.sendKeys(username);
	}

	public void sendPassword(String passWord) {
		password.sendKeys(passWord);
	}
	}


