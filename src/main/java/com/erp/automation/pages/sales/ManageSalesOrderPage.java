package com.erp.automation.pages.sales;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;
import com.erp.automation.utils.TestDataStorage;

public class ManageSalesOrderPage {

	//Variables
	private WebDriver driver;
	private WebDriverWait wait;
	SalesOrderPage salesOrderPage;
	String soNumberr;

	//SO DETAILS

	@FindBy(xpath = "//span[@id='select2-ddlManagmentUnit-container']")
	WebElement managmentUnitField;

	@FindBy(xpath = "//li[text()='M03-Job Work']")
	WebElement jobWorkOptionFromManagmentUnitDD;

	//CUSTOMER DETAILS

	@FindBy(xpath = "//span[@aria-labelledby='select2-ddlCustId-container']")
	WebElement customerField;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
	WebElement customerInputTextField;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li[1]")
	WebElement customerFirstResult;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[5]")
	WebElement transportMode;

	@FindBy(xpath = "//li[text()=' By Bus ']")
	WebElement byBusOptionTransportDD;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[7]")
	WebElement freight;

	@FindBy(xpath = "//li[text()=' To Pay ']")
	WebElement toPayOptionfreight;

	@FindBy(xpath = "//input[@id='CustomerPoNo']")
	WebElement customerPO;

	@FindBy(xpath = "//input[@id='ModelFile']")
	WebElement uploadFileButton;

	//ITEM DETAILS
	//Manage Item

	@FindBy(xpath = "//button[@id='btnAddItem']")
	WebElement addItemButton;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[14]")
	WebElement itemCode;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
	WebElement itemCodeInputText;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	WebElement itemCodeFirstResultFromSuggestion;

	@FindBy(xpath = "//input[@id='SrNo']")
	WebElement srNo;

	@FindBy(xpath = "//input[@id='Quantity']")
	WebElement quantity;

	@FindBy(xpath = "//button[@id='btnSaveItem']")
	WebElement saveButton;

	@FindBy(xpath = "//textarea[@id='TransportRemark']")
	WebElement remark;

	@FindBy(xpath = "//button[@id='btnMasterSaveAndSend']")
	WebElement saveAndSubmitForApprovalButton;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement okButtonFromWarningPopUp;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement okButtonFromSucessPopUpOne;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement okButtonFromSucessPopUpTwo;

	@FindBy(xpath = "/html/body/div[9]/p/b[1]")
	WebElement soNumberStoring;

	@FindBy(xpath = "//textarea[@id='RemarkFromApprover']")
	WebElement approveRejectRemark;

	@FindBy(xpath = "//button[@id='btnApprovePo']")
	WebElement approveButton;

	@FindBy(xpath = "//button[@id='btnRejectPo']")
	WebElement rejectButton;

	@FindBy(xpath = "//button[@title='Edit']")
	WebElement editItemRow;

	// Constructor
	public ManageSalesOrderPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		salesOrderPage = new SalesOrderPage(driver);
	}

	// Methods
	public void creatingSalesOrderFromExcel(String excelPath, String sheetName, WebDriver driver)
			throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {

			salesOrderPage.clickOnAddSoButton();
			salesOrderPage.selectSOTypeDomesticFromPopUpAndNext();
			wait.until(ExpectedConditions.elementToBeClickable(managmentUnitField));
			managmentUnitField.click();
			wait.until(ExpectedConditions.elementToBeClickable(jobWorkOptionFromManagmentUnitDD));
			jobWorkOptionFromManagmentUnitDD.click();
			wait.until(ExpectedConditions.elementToBeClickable(customerField));
			customerField.click();
			String customerName = excel.getCellData(i, 0);
			wait.until(ExpectedConditions.elementToBeClickable(customerInputTextField));
			customerInputTextField.sendKeys(customerName);
			Thread.sleep(2000);
			customerFirstResult.click();
			wait.until(ExpectedConditions.elementToBeClickable(transportMode));
			transportMode.click();
			wait.until(ExpectedConditions.elementToBeClickable(byBusOptionTransportDD));
			byBusOptionTransportDD.click();
			wait.until(ExpectedConditions.elementToBeClickable(freight));
			freight.click();
			wait.until(ExpectedConditions.elementToBeClickable(toPayOptionfreight));
			toPayOptionfreight.click();
			wait.until(ExpectedConditions.elementToBeClickable(customerPO));
			customerPO.click();
			String customerpoo = excel.getCellData(i, 1);
			customerPO.sendKeys(customerpoo);
			File uploadFile = new File(
					"C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\GeneralInvoiceReportt.pdf");
			// Wait until the file input element is clickable
			WebElement custFileName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ModelFile")));
			// Send the file path to the hidden input field
			custFileName.sendKeys(uploadFile.getAbsolutePath());
			System.out.println("File uploaded successfully!-Customer PO FileName");
			wait.until(ExpectedConditions.elementToBeClickable(addItemButton));
			addItemButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(itemCode));
			itemCode.click();
			String itemcodee = excel.getCellData(i, 2);
			itemCodeInputText.sendKeys(itemcodee);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(itemCodeFirstResultFromSuggestion));
			itemCodeFirstResultFromSuggestion.click();
			srNo.click();
			String srNoo = excel.getCellData(i, 3);
			srNo.sendKeys(srNoo);
			quantity.click();
			String quantityy = excel.getCellData(i, 4);
			quantity.sendKeys(quantityy);
			saveButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(remark));
			remark.sendKeys("SO creation by Automation Script");
			saveAndSubmitForApprovalButton.click();
			// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
			Thread.sleep(4000);
			okButtonFromWarningPopUp.click();
			Thread.sleep(4000);
			String soNumber = soNumberStoring.getText();
			// Store it
			TestDataStorage.soNumber = soNumber;
			System.out.println("SO Created successfully" + TestDataStorage.soNumber);
			// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSucessPopUpOne));
			okButtonFromSucessPopUpOne.click();
			Thread.sleep(3500);
			// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSucessPopUpTwo));
			okButtonFromSucessPopUpTwo.click();
			Thread.sleep(2500);

		}

	}

	public void sendRemarkOnApprove() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(approveRejectRemark));
		approveRejectRemark.sendKeys(" Automation remark for approval");
		wait.until(ExpectedConditions.elementToBeClickable(approveButton));
		approveButton.click();
		Thread.sleep(4000);
		okButtonFromWarningPopUp.click();

	}

	public void sendRemarkOnReject() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(approveRejectRemark));
		approveRejectRemark.sendKeys(" Automation remark for Reject");
		wait.until(ExpectedConditions.elementToBeClickable(rejectButton));
		rejectButton.click();
		Thread.sleep(4000);
		okButtonFromWarningPopUp.click();
	}

	public void soModification() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(editItemRow));
		editItemRow.click();
		wait.until(ExpectedConditions.elementToBeClickable(quantity));
		quantity.clear();
		Thread.sleep(1000);
		quantity.sendKeys("500");
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(remark));
		remark.clear();
		remark.sendKeys("SO Modification by Automation Script First Approval");
		saveAndSubmitForApprovalButton.click();
		// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
		Thread.sleep(4000);
		okButtonFromWarningPopUp.click();
		Thread.sleep(4000);
		String soNumber = soNumberStoring.getText();
		// Store it
		TestDataStorage.soNumber = soNumber;
		System.out.println("SO Created successfully" + TestDataStorage.soNumber);
		// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSucessPopUpOne));
		okButtonFromSucessPopUpOne.click();
		Thread.sleep(3500);
		// wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSucessPopUpTwo));
		okButtonFromSucessPopUpTwo.click();
		Thread.sleep(2500);

	}

}
