package com.erp.automation.pages.accountFinance;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class JournalVoucherPage {


		//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		//List page of Journal Voucher

		@FindBy (xpath="//a[@id='AddDiv']")
		private WebElement addJournalVoucher;


		//Main Journal Voucher Page

		// Debit Section

		@FindBy (xpath="//input[@id='txtDRParty_Input']")
		public WebElement partyDDField;

		@FindBy (xpath="/html/body/ul[2]/li[1]/div")
		public WebElement firstResultOfDropDown;

		@FindBy (xpath="(//span[@role='combobox'])[2]")
		public WebElement debitReferenceDD;

		@FindBy (xpath="(//option[text()='Against Invoice'])[1]")
		public WebElement debitReferenceDDAgainstInvoice;

		@FindBy (xpath="/html/body/section/div/div[2]/div/div/div[3]/div[4]/label")
		public WebElement randomClick;

		@FindBy (xpath="//input[@id='DRRefrenceNo']")
		public WebElement debitReferenceNo;

		@FindBy (xpath="//input[@id='DebitAmount']")
		public WebElement debitAmount;

		@FindBy (xpath="(//span[@role='combobox'])[3]")
		public WebElement managementUnitDDDebit;

		@FindBy (xpath="//li[text()='M04-Service']")
		public WebElement managementUnitDDService;

		@FindBy (xpath="(//input[@class='form-control ManagementUnitAmount allownumericwithdecimal text-right'])[1]")
		public WebElement managementUnitAmountDebit;



		@FindBy (xpath="(//span[@role='combobox'])[4]")
		public WebElement costCentreDD;

		@FindBy (xpath="//li[text()='C01-Accounts ']")
		public WebElement costCentreDDAccounts;

		@FindBy (xpath="(//input[@class='form-control CostCenterAmount allownumericwithdecimal text-right'])[1]")
		public WebElement costCentreAmount;

		@FindBy (xpath="(//span[@role='combobox'])[5]")
		public WebElement productCodeDD;

		@FindBy (xpath="//li[text()='Homeappl-Home Appliances  ']")
		public WebElement productCodeDDHomeApp;

		@FindBy (xpath="(//input[@class='form-control ProductCodeAmount allownumericwithdecimal text-right'])[1]")
		public WebElement productCodeAmount;

		@FindBy (xpath="(//span[@role='combobox'])[6]")
		public WebElement customerSegmentDD;

		@FindBy (xpath="//li[text()='APAC-Asia pacific']")
		public WebElement customerSegmentDDAsiaSpecific;

		@FindBy (xpath="(//input[@class='form-control CustSegmentAmount allownumericwithdecimal text-right'])[1]")
		public WebElement customerSegmentAmount;

		@FindBy (xpath="//button[@id='BtnSaveDebitEntry']")
		public WebElement saveButtonDebitSection;


		// Credit Section

		@FindBy (xpath="//input[@id='txtCRParty_Input']")
		public WebElement partyDDFieldcredit;

		@FindBy (xpath="/html/body/ul[3]/li[1]/div")
		public WebElement firstResultOfDropDowncredit;

		@FindBy (xpath="(//span[@role='combobox'])[7]")
		public WebElement CreditReferenceDD;

		@FindBy (xpath="//li[text()='Against Invoice']")
		public WebElement creditReferenceDDAgainstInvoice;

		@FindBy (xpath="/html/body/section/div/div[2]/div/div/div[7]/div[4]/table/tfoot/tr/td[1]")
		public WebElement randomClick2;

		@FindBy (xpath="//input[@id='CRRefrenceNo']")
		public WebElement creditReferenceNo;

		@FindBy (xpath="//input[@id='CreditAmount']")
		public WebElement creditAmount;

		@FindBy (xpath="(//span[@role='combobox'])[8]")
		public WebElement managementUnitDDCredit;

		@FindBy (xpath="//li[text()='M04-Service']")
		public WebElement managementUnitDDServicecredit;

		@FindBy (xpath="(//input[@class='form-control ManagementUnitAmount allownumericwithdecimal text-right'])[2]")
		public WebElement managementUnitAmountCredit;



		@FindBy (xpath="(//span[@role='combobox'])[9]")
		public WebElement costCentreDDCredit;

		@FindBy (xpath="//li[text()='C18-IT']")
		public WebElement costCentreDDITCredit;

		@FindBy (xpath="(//input[@class='form-control CostCenterAmount allownumericwithdecimal text-right'])[2]")
		public WebElement costCentreAmountCredit;

		@FindBy (xpath="(//span[@role='combobox'])[10]")
		public WebElement productCodeDDcredit;

		@FindBy (xpath="//li[text()='Homeappl-Home Appliances  ']")
		public WebElement productCodeDDHomeAppcredit;

		@FindBy (xpath="(//input[@class='form-control ProductCodeAmount allownumericwithdecimal text-right'])[2]")
		public WebElement productCodeAmountCredit;

		@FindBy (xpath="(//span[@role='combobox'])[11]")
		public WebElement customerSegmentDDCredit;

		@FindBy (xpath="//li[text()='APAC-Asia pacific']")
		public WebElement customerSegmentDDAsiaSpecificCredit;

		@FindBy (xpath="(//input[@class='form-control CustSegmentAmount allownumericwithdecimal text-right'])[2]")
		public WebElement customerSegmentAmountCredit;

		@FindBy (xpath="//button[@id='BtnSaveCreditEntry']")
		public WebElement saveButtonCreditSection;


		//over all
//
		@FindBy (xpath="//textarea[@id='Remarks']")
		public WebElement remark;

		@FindBy (xpath="//textarea[@id='Comment']")
		public WebElement comment;

		@FindBy (xpath="//button[@id='btnSaveSaveForApproval']")
		public WebElement saveAndSendForApproval;


		@FindBy (xpath="//button[@class='confirm']")
		public WebElement okButtonPopup;





		// Constructor
		public  JournalVoucherPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 //   this.manageInvoicePage = manageInvoicePage;

		}


		// Methods
		public void clickOnAddJournalVoucher() {
		wait.until(ExpectedConditions.elementToBeClickable(addJournalVoucher));
		addJournalVoucher.click();
		}


		public void creatMultipleDebitAndCreditRecordsForSingleJVByUsingExcel(String excelPath, String sheetName,WebDriver driver) throws InterruptedException {
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
			int rowCount = excel.getRowCount(); // Get total number of rows

			for (int i = 1; i < rowCount; i++) {

//				wait.until(ExpectedConditions.elementToBeClickable(partyDDField));
//				partyDDField.click();

				String partyName = excel.getCellData(i, 0);
				wait.until(ExpectedConditions.elementToBeClickable(partyDDField));
				partyDDField.click();
				partyDDField.sendKeys(partyName);
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(firstResultOfDropDown));
				firstResultOfDropDown.click();
				// variable with random 4 digit value
				int random4Digit = new Random().nextInt(9000) + 1000; // Range: 1000 to 9999
				System.out.println("Generated random value: " + random4Digit);
				String random4DigitStr = String.valueOf(random4Digit); // Convert int to String
				debitReferenceDD.click();
				wait.until(ExpectedConditions.elementToBeClickable(debitReferenceDDAgainstInvoice));
				debitReferenceDDAgainstInvoice.click();
				randomClick.click();
				wait.until(ExpectedConditions.elementToBeClickable(debitReferenceNo));
				debitReferenceNo.sendKeys(random4DigitStr);

				wait.until(ExpectedConditions.elementToBeClickable(debitAmount));

				String debitAmountd = excel.getCellData(i, 1);
				wait.until(ExpectedConditions.elementToBeClickable(debitAmount));
				debitAmount.sendKeys(debitAmountd);
				//Thread.sleep(2000);

				wait.until(ExpectedConditions.elementToBeClickable(managementUnitDDDebit));
				managementUnitDDDebit.click();
				wait.until(ExpectedConditions.elementToBeClickable(managementUnitDDService));
				managementUnitDDService.click();
				managementUnitAmountDebit.sendKeys(debitAmountd);
				randomClick2.click();

				wait.until(ExpectedConditions.elementToBeClickable(costCentreDD));
				costCentreDD.click();
				wait.until(ExpectedConditions.elementToBeClickable(costCentreDDAccounts));
				costCentreDDAccounts.click();
				costCentreAmount.sendKeys(debitAmountd);
				randomClick.click();

				wait.until(ExpectedConditions.elementToBeClickable(productCodeDD));
				productCodeDD.click();
				wait.until(ExpectedConditions.elementToBeClickable(productCodeDDHomeApp));
				productCodeDDHomeApp.click();
				productCodeAmount.sendKeys(debitAmountd);
				randomClick.click();

				wait.until(ExpectedConditions.elementToBeClickable(customerSegmentDD));
				customerSegmentDD.click();
				wait.until(ExpectedConditions.elementToBeClickable(customerSegmentDDAsiaSpecific));
				customerSegmentDDAsiaSpecific.click();
				customerSegmentAmount.sendKeys(debitAmountd);
				randomClick.click();

				saveButtonDebitSection.click();
				Thread.sleep(500);

				//=======================================================================================

				String partyName2 = excel.getCellData(i, 2);
				wait.until(ExpectedConditions.elementToBeClickable(partyDDFieldcredit));
				partyDDFieldcredit.click();
				partyDDFieldcredit.sendKeys(partyName2);
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(firstResultOfDropDowncredit));
				firstResultOfDropDowncredit.click();
				// variable with random 4 digit value
				int random4Digit2 = new Random().nextInt(9000) + 1000; // Range: 1000 to 9999
				System.out.println("Generated random value: " + random4Digit2);
				String random4DigitStr2 = String.valueOf(random4Digit2); // Convert int to String
				CreditReferenceDD.click();
				wait.until(ExpectedConditions.elementToBeClickable(creditReferenceDDAgainstInvoice));
				creditReferenceDDAgainstInvoice.click();
				randomClick.click();
				wait.until(ExpectedConditions.elementToBeClickable(creditReferenceNo));
				creditReferenceNo.sendKeys(random4DigitStr2);

				wait.until(ExpectedConditions.elementToBeClickable(creditAmount));

//				String debitAmountd = excel.getCellData(i, 1);
//				wait.until(ExpectedConditions.elementToBeClickable(debitAmount));
				creditAmount.sendKeys(debitAmountd);
			//	Thread.sleep(2000);

				wait.until(ExpectedConditions.elementToBeClickable(managementUnitDDCredit));
				managementUnitDDCredit.click();
				//Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(managementUnitDDServicecredit));
				managementUnitDDServicecredit.click();
				managementUnitAmountCredit.sendKeys(debitAmountd);
				randomClick.click();

				wait.until(ExpectedConditions.elementToBeClickable(costCentreDDCredit));
				costCentreDDCredit.click();
				//Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(costCentreDDITCredit));
				costCentreDDITCredit.click();

				costCentreAmountCredit.sendKeys(debitAmountd);
			//	Thread.sleep(500);
				randomClick2.click();

				wait.until(ExpectedConditions.elementToBeClickable(productCodeDDcredit));
				productCodeDDcredit.click();
			//	Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(productCodeDDHomeAppcredit));
				productCodeDDHomeAppcredit.click();
				productCodeAmountCredit.sendKeys(debitAmountd);
				randomClick.click();

				wait.until(ExpectedConditions.elementToBeClickable(customerSegmentDDCredit));
				customerSegmentDDCredit.click();
			//	Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(customerSegmentDDAsiaSpecificCredit));
				customerSegmentDDAsiaSpecificCredit.click();
				customerSegmentAmountCredit.sendKeys(debitAmountd);
				randomClick.click();

//				Thread.sleep(1000);
				saveButtonCreditSection.click();
				Thread.sleep(2000);

			}

		}



		public void addRemarkCommentAndSendJournalVoucher() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(remark));
			remark.sendKeys("Automation Test Remark");

			wait.until(ExpectedConditions.elementToBeClickable(comment));
			comment.sendKeys("Automation Test comment");

			wait.until(ExpectedConditions.elementToBeClickable(saveAndSendForApproval));
			saveAndSendForApproval.click();

			wait.until(ExpectedConditions.elementToBeClickable(okButtonPopup));
			okButtonPopup.click();
			Thread.sleep(2000);
			okButtonPopup.click();


			}



}
