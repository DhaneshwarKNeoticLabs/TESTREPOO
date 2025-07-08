package com.erp.automation.pages.sales;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllSalesSubModules {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;



	@FindBy (xpath="/html[1]/body[1]/div[2]/div[2]/div[11]/ul[1]/li[10]/a[1]")
	private WebElement invoice;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[11]/ul/li[1]/a")
	private WebElement customer;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[11]/ul/li[6]/a")
	private WebElement customerPriceList;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[7]/ul/li[7]/a")
	private WebElement approvalPriceList; //Lalit sir

	@FindBy (xpath="/html/body/div[2]/div[2]/div[11]/ul/li[3]/a")
	private WebElement salsOrder;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[7]/ul/li[5]/a")
	private WebElement soApprovalLalit;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[11]/ul/li[5]")
	private WebElement soApprovalSandip;

	// Constructor
	public  AllSalesSubModules (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnInvoiceMenu() throws InterruptedException {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
		invoice.click();
		Thread.sleep(5000);
	}

	public void clickOnCustomerMenu() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		customer.click();
			Thread.sleep(5000);
		}

	public void clickOnCustomerPriceListMenu() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		wait.until(ExpectedConditions.elementToBeClickable(customerPriceList));
		customerPriceList.click();
			Thread.sleep(3000);
		}

	public void clickOnApprovalCustomerPriceListMenu() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(approvalPriceList));
		approvalPriceList.click();
			Thread.sleep(3000);
		}

public void clickOnSalesOrderMenu() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(salsOrder));
		salsOrder.click();
			Thread.sleep(2000);
		}

public void clickOnSalesOrderApprovalFirstMenu() throws InterruptedException {

	wait.until(ExpectedConditions.elementToBeClickable(soApprovalLalit));
	soApprovalLalit.click();
		Thread.sleep(2000);
	}

public void clickOnSalesOrderApprovalSecondMenu() throws InterruptedException {

	wait.until(ExpectedConditions.elementToBeClickable(soApprovalSandip));
	soApprovalSandip.click();
		Thread.sleep(2000);
	}

}
