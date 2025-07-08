package com.erp.automation.pages.accountFinance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Receipt {

	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		//Add
		@FindBy (xpath="//button[@id='Add']")
		private WebElement addButton;

		// Voucher Type PopUp
		@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div[12]/div/div/div[3]/button")
		private WebElement nextButtonFromPopUp;


		// Constructor
		public  Receipt (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void clickOnAddButton() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			addButton.click();
//			Thread.sleep(2000);
		}

		public void clickOnNextButton() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(nextButtonFromPopUp));
			nextButtonFromPopUp.click();
//			Thread.sleep(2000);
		}



}
