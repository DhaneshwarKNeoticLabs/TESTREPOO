package com.erp.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		@FindBy (xpath="//a[@class='nav-link navbar-avatar waves-effect waves-light waves-round']")
		private WebElement profileIcon;

		@FindBy (xpath="//a[normalize-space()='Logout']")
		private WebElement logOutIcon;



		// Constructor
		public LogOutPage(WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		}

		// Methods
		public void clickOnProfileIconAndLogOut() {
			wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
		profileIcon.click();
		wait.until(ExpectedConditions.elementToBeClickable(logOutIcon));
		logOutIcon.click();

		}


}
