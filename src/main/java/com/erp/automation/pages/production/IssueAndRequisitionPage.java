package com.erp.automation.pages.production;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssueAndRequisitionPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;


		@FindBy (xpath="//a[@id='AddDiv']")
		private WebElement AddButton;


		// Constructor
		public  IssueAndRequisitionPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void clickOnAddButton() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(AddButton));
		AddButton.click();

		}



}
