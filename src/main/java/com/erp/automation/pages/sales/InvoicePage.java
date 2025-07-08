package com.erp.automation.pages.sales;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;
	//	ManageInvoicePage manageInvoicePage;




		@FindBy (xpath="//a[@id='AddSO']")
		private WebElement addInvoice;

		@FindBy (xpath="//input[@id='searchtable']")
		public WebElement searchField;

		@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/div[4]/div/table/tbody/tr")
		public WebElement firstResultAfterSearch;

		@FindBy (xpath="//a[text()='Print']")
		public WebElement printButton;

		@FindBy (xpath="//div[@class='sa-confirm-button-container']")
		public WebElement okButtonWarningPopUp;

		@FindBy (xpath="//span[@id='select2-InvoiceType-container']")
		public WebElement selectDDFieldInvoiceTypePopup;

		@FindBy (xpath="//li[text()=' Domestic ']")
		public WebElement domesticOption;

		@FindBy (xpath="//li[text()=' Export ']")
		public WebElement exportOption;

		@FindBy (xpath="//button[@id='btnCloseNext']")
		public WebElement nextButtonFromPopUp;


		// Constructor
		public  InvoicePage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 //   this.manageInvoicePage = manageInvoicePage;

		}


		// Methods
		public void clickOnAddInvoice() {
		wait.until(ExpectedConditions.elementToBeClickable(addInvoice));
			addInvoice.click();
		}

		//Select invoice Type pop up

		public void selectDomesticInvoiceTypeFromPopUp() {
			wait.until(ExpectedConditions.elementToBeClickable(selectDDFieldInvoiceTypePopup));
			selectDDFieldInvoiceTypePopup.click();
			wait.until(ExpectedConditions.elementToBeClickable(domesticOption));
			domesticOption.click();
			wait.until(ExpectedConditions.elementToBeClickable(nextButtonFromPopUp));
			nextButtonFromPopUp.click();

			}

		public void selectExportInvoiceTypeFromPopUp() {
			wait.until(ExpectedConditions.elementToBeClickable(selectDDFieldInvoiceTypePopup));
			selectDDFieldInvoiceTypePopup.click();
			wait.until(ExpectedConditions.elementToBeClickable(exportOption));
			exportOption.click();
			wait.until(ExpectedConditions.elementToBeClickable(nextButtonFromPopUp));
			nextButtonFromPopUp.click();

			}

		public void selectInvoiceAndPrint(String invoiceNumber, int i) throws InterruptedException {


		searchField.sendKeys(invoiceNumber);
		firstResultAfterSearch.click();
		firstResultAfterSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(printButton));
		Thread.sleep(2000);
		printButton.click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(okButtonWarningPopUp));
		okButtonWarningPopUp.click();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();

		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(windowHandlesList.get(i)); // Index 1 for the second tab
		Thread.sleep(3000);
		driver.close(); // Close the child window
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow); // Return to the parent window



		}


		public void selectExportInvoiceAndPrint(String invoiceNumber, int i) throws InterruptedException {

	/*
			searchField.sendKeys(invoiceNumber);
			firstResultAfterSearch.click();
			firstResultAfterSearch.click();
			wait.until(ExpectedConditions.elementToBeClickable(printButton));
			Thread.sleep(2000);
			printButton.click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(okButtonWarningPopUp));
			okButtonWarningPopUp.click();
			Thread.sleep(3000);
			String parentWindow = driver.getWindowHandle();

			List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
			Thread.sleep(2000);
			driver.switchTo().window(windowHandlesList.get(i)); // Index 1 for the second tab
			Thread.sleep(3000);
			driver.close(); // Close the child window
			Thread.sleep(2000);
			driver.switchTo().window(parentWindow); // Return to the parent window

		*/

			}


}
