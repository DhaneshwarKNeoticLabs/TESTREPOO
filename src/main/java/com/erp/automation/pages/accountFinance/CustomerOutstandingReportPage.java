package com.erp.automation.pages.accountFinance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerOutstandingReportPage {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div[1]/div[1]/div[3]/div/span/span[1]/span/ul")
	private WebElement customer;

	@FindBy (xpath="//input[@class='select2-search__field']")
	private WebElement customerInput;

	@FindBy (xpath="/html/body/span/span/span/ul/li")
	private WebElement firstCustomerResult;

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div[1]/div[1]/div[4]/div/button[2]")
	private WebElement reportButton;


	// Constructor
		public  CustomerOutstandingReportPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void selectCustomerAndSeeReport() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(customer));
			customer.click();
			customerInput.sendKeys("Think");
			wait.until(ExpectedConditions.elementToBeClickable(firstCustomerResult));
			firstCustomerResult.click();
			wait.until(ExpectedConditions.elementToBeClickable(reportButton));
			reportButton.click();
		}





}
