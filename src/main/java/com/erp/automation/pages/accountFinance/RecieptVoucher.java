package com.erp.automation.pages.accountFinance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class RecieptVoucher {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;
	String searchFieldInvoiceNo;
	Receipt receipt;

	//Add
	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div[2]/div[1]/span/span[1]/span/span[1]")
	private WebElement partyType;

	@FindBy (xpath="//li[text()='Customer']")
	private WebElement customerOptionFromDD;

	@FindBy (xpath="//input[@name='CRLedgerNo']")
	private WebElement ledger;

	@FindBy (xpath="/html/body/ul[2]")
	private WebElement ledgerFirstResult;

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div[2]/div[3]/button[2]")
	private WebElement addButton;

	//Open Invoice PopUp
	@FindBy (xpath="//input[@id='search']")
	private WebElement searchField;

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div[10]/div/div/div[2]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[7]/div/input")
	private WebElement firstCheckBox;

	@FindBy (xpath="(//input[@type='text'])[12]")
	private WebElement balanceAmount;

	@FindBy (xpath="//button[@id='btnModalAdd']")
	private WebElement addButtonFromOpenInvoicePopUp;

	//MainPage
	// Debit Transaction

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div[6]/div/table/tfoot/tr[1]/td[1]/span/span[1]/span")
	private WebElement ledgerDroopdown;

	@FindBy (xpath="/html/body/span/span/span[1]/input")
	private WebElement LedgersearchField;

	@FindBy (xpath="/html/body/span/span/span[2]/ul/li")
	private WebElement LedgerHdfcOption;

	//Common Element
	@FindBy (xpath="//input[@id='ChequeUTRNo']")
	private WebElement cheque;

	@FindBy (xpath="//textarea[@id='Remark']")
	private WebElement remark;

	@FindBy (xpath="//button[@id='btnSave']")
	private WebElement savebutton;

	@FindBy (xpath="//button[text()='OK']")
	private WebElement okButtonFromSuccessPopUp;

	// Constructor
	public  RecieptVoucher (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	receipt =new Receipt(driver);
	}


	// Methods
	public void selectPartyType() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(partyType));
		partyType.click();
		wait.until(ExpectedConditions.elementToBeClickable(customerOptionFromDD));
		customerOptionFromDD.click();
	}

	public void selectLedger() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ledger));
		ledger.sendKeys("");

		wait.until(ExpectedConditions.elementToBeClickable(ledgerFirstResult));
		ledgerFirstResult.click();


	}



		public void selectCheckBox2() throws InterruptedException {
			 // Locate the table
		    WebElement table = driver.findElement(By.id("tblmodalinvoice"));

		    // Get all rows from the table body
		    List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		    System.out.println("Total Rows Found: " + rows.size());

		    for (WebElement row : rows) {
		        // Locate the invoice number cell and serial number cell
		        WebElement invoiceCell = row.findElement(By.xpath("./td[2]"));
		        WebElement srNoCell = row.findElement(By.xpath("./td[1]"));

		        // Ensure invoiceCell and srNoCell are not null
		        String invoiceNumber = invoiceCell.getText().trim();
		        String srNumber = srNoCell.getText().trim();

		        // Debugging logs
		        System.out.println("Checking Row: Serial No. " + srNumber + " | Invoice No. " + invoiceNumber);

		        // Check if invoiceNumber is empty
		        if (invoiceNumber.isEmpty()) {
		            System.out.println("Skipping row as Invoice Number is empty.");
		            continue;
		        }

		        // If the invoice number matches the target
		        if (!invoiceNumber.isEmpty()) {
		            System.out.println("Row found successfully");

		            // Select the checkbox within the same row
		            WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
		            System.out.println(srNumber);
		           // WebElement checkbox = row.findElement(By.xpath("/html/body/section/div/div[2]/div/div/div/div/div/div[10]/div/div/div[2]/div/div[1]/div[2]/div/table/tbody/tr[" + srNumber + "]/td[7]/div/input"));

		            Thread.sleep(3000);
		            // Ensure the checkbox is not already selected before clicking
		            if (!checkbox.isSelected()) {
		                checkbox.click();
		                System.out.println("Invoice  selected.");
		            } else {
		                System.out.println("Invoice " + searchFieldInvoiceNo + " is already selected.");
		            }

		            break; // Stop iteration after finding and selecting the correct checkbox
		        }
		    }
		}



	public void fillreceiptVoucherWithPartialAmount(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {

			receipt.clickOnAddButton();
			receipt.clickOnNextButton();
		wait.until(ExpectedConditions.elementToBeClickable(partyType));
		partyType.click();
		wait.until(ExpectedConditions.elementToBeClickable(customerOptionFromDD));
		customerOptionFromDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(ledger));
		String ledgerName =excel.getCellData(i, 0);
		ledger.sendKeys(ledgerName);

		wait.until(ExpectedConditions.elementToBeClickable(ledgerFirstResult));
		ledgerFirstResult.click();

		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		String searchFieldInvoiceNo =excel.getCellData(i, 1);
		searchField.sendKeys(searchFieldInvoiceNo);
		selectCheckBox2();


		System.out.println("pause");
//		wait.until(ExpectedConditions.elementToBeClickable(firstCheckBox));
//		firstCheckBox.click();

		wait.until(ExpectedConditions.elementToBeClickable(balanceAmount));
		String balanceAmounts =excel.getCellData(i, 2);
		System.out.println("balance Amount =" + balanceAmounts);
		balanceAmount.clear();
		Thread.sleep(1000);
		balanceAmount.sendKeys(balanceAmounts);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(addButtonFromOpenInvoicePopUp));
    	addButtonFromOpenInvoicePopUp.click();


		wait.until(ExpectedConditions.elementToBeClickable(ledgerDroopdown));

    	ledgerDroopdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(LedgersearchField));

    	LedgersearchField.sendKeys("834");
		wait.until(ExpectedConditions.elementToBeClickable(LedgerHdfcOption));

    	LedgerHdfcOption.click();




    	wait.until(ExpectedConditions.elementToBeClickable(cheque));
    	cheque.sendKeys("123456");


    	wait.until(ExpectedConditions.elementToBeClickable(remark));
    	remark.sendKeys("Test Remark For Automation");

    	wait.until(ExpectedConditions.elementToBeClickable(savebutton));
    	savebutton.click();
    	Thread.sleep(2000);

    	wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSuccessPopUp));
    	okButtonFromSuccessPopUp.click();
    	Thread.sleep(2000);




		}
	}


	public void fillreceiptVoucherWithFullAmount(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {

			receipt.clickOnAddButton();
			receipt.clickOnNextButton();
		wait.until(ExpectedConditions.elementToBeClickable(partyType));
		partyType.click();
		wait.until(ExpectedConditions.elementToBeClickable(customerOptionFromDD));
		customerOptionFromDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(ledger));
		String ledgerName =excel.getCellData(i, 0);
		ledger.sendKeys(ledgerName);

		wait.until(ExpectedConditions.elementToBeClickable(ledgerFirstResult));
		ledgerFirstResult.click();

		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		String searchFieldInvoiceNo =excel.getCellData(i, 1);
		searchField.sendKeys(searchFieldInvoiceNo);
		selectCheckBox2();


		System.out.println("pause");

		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(balanceAmount));
//		String balanceAmounts =excel.getCellData(i, 2);
//		balanceAmount.clear();
//		balanceAmount.sendKeys(balanceAmounts);

		wait.until(ExpectedConditions.elementToBeClickable(addButtonFromOpenInvoicePopUp));
    	addButtonFromOpenInvoicePopUp.click();


		wait.until(ExpectedConditions.elementToBeClickable(ledgerDroopdown));

    	ledgerDroopdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(LedgersearchField));

    	LedgersearchField.sendKeys("834");
		wait.until(ExpectedConditions.elementToBeClickable(LedgerHdfcOption));

    	LedgerHdfcOption.click();




    	wait.until(ExpectedConditions.elementToBeClickable(cheque));
    	cheque.sendKeys("123456");


    	wait.until(ExpectedConditions.elementToBeClickable(remark));
    	remark.sendKeys("Test Remark For Automation");

    	wait.until(ExpectedConditions.elementToBeClickable(savebutton));
    	savebutton.click();
    	Thread.sleep(3000);

    	wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSuccessPopUp));
    	okButtonFromSuccessPopUp.click();
    	Thread.sleep(3000);




		}
	}

}
