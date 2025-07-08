package com.erp.automation.pages.accountFinance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllAccountFinanceSubModules {



	//Variables
	private WebDriver driver;
	private WebDriverWait wait;

	//Revenue Section
	@FindBy (xpath="/html/body/div[2]/div[2]/div[26]/ul/li[8]/a[1]")
	private WebElement revenue;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[31]/ul/li[1]/a")
	private WebElement receiptVoucher;


	//Account Report Section



	@FindBy (xpath="/html/body/div[2]/div[2]/div[26]/ul/li[10]/a[1]")
	private WebElement accountReport;

	@FindBy (xpath="//span[text()='Customer Outstanding Report']")
	private WebElement customerOutstandingReport;


	//Expense Section

	@FindBy (xpath="/html/body/div[2]/div[2]/div[26]/ul/li[9]/a[1]")
	private WebElement expenseMenu;

	@FindBy (xpath="/html/body/div[2]/div[2]/div[32]/ul/li[12]/a")
	private WebElement journalVoucher;


		// Constructor
	public  AllAccountFinanceSubModules (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnRevenueMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(revenue));
		revenue.click();
//		Thread.sleep(2000);
	}

	public void clickOnReceiptVoucherMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(receiptVoucher));
		receiptVoucher.click();

	}

	public void clickOnAccountReportMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(accountReport));
		accountReport.click();

	}

	public void clickOnCustomerOutsatnadingReportMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(customerOutstandingReport));
		customerOutstandingReport.click();

	}

	public void clickOnExpenseAndJournalVoucherMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(expenseMenu));
		expenseMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(journalVoucher));
		journalVoucher.click();

	}


}
