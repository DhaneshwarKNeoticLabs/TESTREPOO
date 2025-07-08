package com.erp.automation.pages.master;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class CustomersForApprovalPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		//Customer for Approval List Page

		@FindBy (xpath="//input[@type='search']")
		private WebElement search;

		@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr")
		private WebElement firstRecordAfterSearch;


		//Customer for Approval Detail Page

		@FindBy (xpath="/html/body/section/div/form/div[1]/div[1]/div[2]/div[3]/div[2]/span/span[1]/span/span[1]")
		private WebElement generalLedger;

		@FindBy (xpath="/html/body/span/span/span[2]/ul/li[2]")
		private WebElement debtorDomesticOption;

		@FindBy (xpath="//textarea[@id='txtRejectedRemark']")
		private WebElement approversRemark1;

		@FindBy (xpath="//textarea[@id='txtRejectedRemark1']")
		private WebElement approversRemark2;

		@FindBy (xpath="//button[@id='btnApprove']")
		private WebElement saveAndApprove;

		@FindBy (xpath="//button[@class='confirm']")
		private WebElement okButtonFromSuccessPopup;


		// Constructor
		public  CustomersForApprovalPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}

		// Methods
		public void enterCustomerNameInSearchFieldAndOpenCustomer(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
			ExcelUtils excel =new ExcelUtils(excelPath, sheetName);
			wait.until(ExpectedConditions.elementToBeClickable(search));
			search.click();
			String searchh = excel.getCellData(1, 0);
			search.sendKeys(searchh);
			Thread.sleep(1200);
			wait.until(ExpectedConditions.elementToBeClickable(firstRecordAfterSearch));
			firstRecordAfterSearch.click();
		}

		public void firstApproveCustomer() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(generalLedger));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(generalLedger));
			generalLedger.click();
			wait.until(ExpectedConditions.elementToBeClickable(debtorDomesticOption));
			Thread.sleep(2000);
			debtorDomesticOption.click();
			wait.until(ExpectedConditions.elementToBeClickable(approversRemark1));
			approversRemark1.sendKeys("Automation Approval One Found OK");
			Thread.sleep(2000);
			saveAndApprove.click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(okButtonFromSuccessPopup));
			wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSuccessPopup));
			okButtonFromSuccessPopup.click();
			Thread.sleep(3000);


	}

		public void finalApproveCustomer() throws InterruptedException {


			wait.until(ExpectedConditions.elementToBeClickable(approversRemark2));
			approversRemark2.sendKeys("Automation Approval Final Found OK");
			Thread.sleep(2000);
			saveAndApprove.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(okButtonFromSuccessPopup));
			okButtonFromSuccessPopup.click();
			Thread.sleep(2000);


	}






}
