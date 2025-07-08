package com.erp.automation.pages.sales;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class TestCSalePage {


	//Variables
			private WebDriver driver;
			private WebDriverWait wait;

			InvoicePage invoicePage;


			@FindBy (xpath="//input[@id='CustName']")
			private WebElement customerField;

			@FindBy (xpath="/html[1]/body[1]/ul[2]/li[1]/div[1]")
			private WebElement firstResultCustomerField;

			@FindBy (xpath="//span[@id='select2-SoNo-container']")
			private WebElement soNoField;

			@FindBy (xpath="//input[@type='search']")
			private WebElement soNoInputField;

			@FindBy (xpath="/html/body/span/span/span[2]/ul/li")
			private WebElement soNoFirstResult;

			@FindBy (xpath="//span[@id='select2-ddlTransporterId-container']")
			private WebElement transporter;

			@FindBy (xpath="//li[text()=' Amol Transport ']")
			private WebElement amolTransportTransporter;

			@FindBy (xpath="//textarea[@id='RejectRemark']")
			private WebElement specialInstructions;


			//ITEM DETAILS section

			@FindBy (xpath="//span[@id='select2-SearchItem-container']")
			private WebElement itemdropdown;

			@FindBy (xpath="//input[@class='select2-search__field']")
			private WebElement inputFieldItemdropdown;

			@FindBy (xpath="/html/body/span/span/span[2]/ul/li")
			private WebElement firstResultItemdropdown;

			@FindBy (xpath="//input[@class='form-control InvQty number text-right']")
			private WebElement invoiceQty;//click

			@FindBy (xpath="//input[@id='mdlTxtBarcode']")
			private WebElement enteredQty;

			@FindBy (xpath="//button[@id='LotnewBtn']")
			private WebElement confirmButton;

			@FindBy (xpath="//button[@id='BtnSave']")
			private WebElement saveButton;

			//popUps
			@FindBy (xpath="//button[@class='confirm']")
			private WebElement okButtonFromWarningPopUp;

			@FindBy (xpath="/html/body/div[8]/p/b")
			private WebElement generatedInvoiceNo;


			// Constructor
			public  TestCSalePage (WebDriver driver){

			PageFactory.initElements(driver, this);
			this.driver=driver;
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			invoicePage = new InvoicePage(driver);
			}


			// Methods
			public void enterCustomerNameFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

				ExcelUtils excel = new ExcelUtils(excelPath, sheetName);


				customerField.click();
				String customerName =excel.getCellData(1, 0);
				customerField.sendKeys(customerName);
				Thread.sleep(2000);
				firstResultCustomerField.click();

			}

			public void enterSoNoFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

				ExcelUtils excel = new ExcelUtils(excelPath, sheetName);


				soNoField.click();
				String soNo =excel.getCellData(1, 1);
				soNoInputField.sendKeys(soNo);
				Thread.sleep(2000);
				soNoFirstResult.click();

			}

			public void selectTransporter() {
				transporter.click();
				wait.until(ExpectedConditions.elementToBeClickable(amolTransportTransporter));
				amolTransportTransporter.click();

			}

			public void enterSpecialInstruction() {

				specialInstructions.sendKeys("Sample Invoice for automation Testing");

			}

			public void selectitem(String excelPath, String sheetName, WebDriver driver)
					throws InterruptedException {

				ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

				itemdropdown.click();
				String itemName = excel.getCellData(1, 2);
				inputFieldItemdropdown.sendKeys(itemName);
				Thread.sleep(2000);
				firstResultItemdropdown.click();

			}

			public void enterQtyForInvoice(String excelPath, String sheetName, WebDriver driver)
					throws InterruptedException {

				ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
				wait.until(ExpectedConditions.elementToBeClickable(invoiceQty));
				invoiceQty.click();
				String qty = excel.getCellData(1, 3);
				wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
				enteredQty.sendKeys(qty);
				Thread.sleep(2000);
				confirmButton.click();

			}

		public void saveInvoice() {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			saveButton.click();

			}
		public void performActionOnPopupafterSave() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
			Thread.sleep(3000);
			okButtonFromWarningPopUp.click();
			Thread.sleep(2000);
		}
		  //----------------------------------------------------------------------------

		 // Locator for the Invoice Number (modify with actual locator)

	    By invoicePopup = By.xpath("/html/body/div[8]/p/b");

	    // Method to get the invoice number and store it in config.properties

	    public String captureInvoiceNumber() {
	        String invoiceNumber = driver.findElement(invoicePopup).getText();

	        // Store the invoice number in config.properties
	        try (OutputStream output = new FileOutputStream("src/test/resources/config.properties")) {
	            Properties prop = new Properties();
	            prop.setProperty("invoiceNumber", invoiceNumber);
	            prop.store(output, null);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return invoiceNumber;
	    }

	    // Method to read the invoice number from config.properties
	    public String getStoredInvoiceNumber() {
	        Properties prop = new Properties();
	        try (FileInputStream input = new FileInputStream("C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\config.properties")) {
	            prop.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop.getProperty("invoiceNumber");
	    }



			//----------------------------------------------------------------------------

	    public void FinalPopupOkButton() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
			Thread.sleep(2000);
			okButtonFromWarningPopUp.click();
			Thread.sleep(500);
		}

////			String invoiceNumberGenerated=generatedInvoiceNo.getText();
////			// Store it
////			TestDataStorage.invoiceNumberGenerated = invoiceNumberGenerated;
////			System.out.println(" Invoice number generated is as  " + TestDataStorage.invoiceNumberGenerated);
//			Thread.sleep(3000);
//			//success popup Xpath is same as warning PopUp
//			//wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
//			okButtonFromWarningPopUp.click();
//
//			}

		public void createInvoice(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
			int rowCount = excel.getRowCount(); // Get total number of rows

			for (int i = 1; i < rowCount; i++) {

				invoicePage.clickOnAddInvoice();
				invoicePage.selectDomesticInvoiceTypeFromPopUp();

			//	ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

				customerField.click();
				Thread.sleep(2000);
				String customerName =excel.getCellData(i, 0);
				customerField.sendKeys(customerName);
				Thread.sleep(2000);
				firstResultCustomerField.click();

				soNoField.click();
				String soNo =excel.getCellData(i, 1);
				soNoInputField.sendKeys(soNo);
				Thread.sleep(2000);
				soNoFirstResult.click();

				selectTransporter();
				enterSpecialInstruction();

				itemdropdown.click();
				String itemName = excel.getCellData(i, 2);
				inputFieldItemdropdown.sendKeys(itemName);
				Thread.sleep(2000);
				firstResultItemdropdown.click();

				wait.until(ExpectedConditions.elementToBeClickable(invoiceQty));
				invoiceQty.click();
				String qty = excel.getCellData(i, 3);
				wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
				enteredQty.sendKeys(qty);
				Thread.sleep(2000);
				confirmButton.click();

				saveInvoice();
				performActionOnPopupafterSave();
				Thread.sleep(4000);
			}
		}

}
