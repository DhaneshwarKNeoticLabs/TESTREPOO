package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageVendorApprovePriceListPage {

	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		//Select Vendor Price List Type pop up

		@FindBy (xpath="//button[@id='approve']")
		private WebElement approveButton;

		@FindBy (xpath="//button[@class='confirm']")
		private WebElement okButtonFromSuccessPopUp;


		// Constructor
		public  ManageVendorApprovePriceListPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void clickOnApproveButtonAndSuccessPopup() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='approve']")));
		approveButton.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm']")));
		okButtonFromSuccessPopUp.click();


		}

}
