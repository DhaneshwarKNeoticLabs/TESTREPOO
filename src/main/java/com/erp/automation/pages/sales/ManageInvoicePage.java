package com.erp.automation.pages.sales;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.materialTransaction.AllMaterialTransactionSubModules;
import com.erp.automation.pages.materialTransaction.OutwardRegister;
import com.erp.automation.utils.ExcelUtils;
import com.erp.automation.utils.TestDataStorage;

public class ManageInvoicePage {

	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

	InvoicePage invoicePage;
	AllMaterialTransactionSubModules allMaterialTransactionSubModules;
	OutwardRegister outwardRegister;
	ToggleMenus toggleMenus;
	AllSalesSubModules allSalesSubModules;
	Set<String> windowHandles;

	@FindBy(xpath = "//input[@id='CustName']")
	private WebElement customerField;

	@FindBy(xpath = "//label[@id='CustName-error']")
	private WebElement customerErrorField;

	@FindBy(xpath = "/html[1]/body[1]/ul[2]/li[1]/div[1]")
	private WebElement firstResultCustomerField;

	// SO Type

	@FindBy(xpath = "//span[@id='select2-ddlSOType-container']")
	private WebElement soTypefield;

	@FindBy(xpath = "//label[@id='ddlSOType-error']")
	private WebElement soNoTypeErrorField;

	@FindBy(xpath = "//li[text()=' Sample SO ']")
	private WebElement sampleSoOption;

	@FindBy(xpath = "//span[@id='select2-SoNo-container']")
	private WebElement soNoField;

	@FindBy(xpath = "//label[@id='SoNo-error']")
	private WebElement soNoErrorField;

	@FindBy(xpath = "//input[@id='CustomerPoNo']")
	private WebElement customerPoNoField;

	@FindBy(xpath = "//label[@id='CustomerPoNo-error']")
	private WebElement customerPoNoerrorField;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement soNoInputField;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	private WebElement soNoFirstResult;

	@FindBy(xpath = "//input[@id='InvoiceDate']")
	private WebElement invoiceDateField;

	//Financial Year
	@FindBy(xpath = "//input[@id='txtFinancialyr']")
	private WebElement financialYearField;

	@FindBy(xpath = "//label[@id='ddlTransporterId-error']")
	private WebElement transporterError;

	@FindBy(xpath = "//span[@id='select2-ddlTransporterMode-container']")
	private WebElement transporterMode;

	@FindBy(xpath = "//li[text()=' By Air ']")
	private WebElement transporterModeByAirResult;


	@FindBy(xpath = "//label[@id='ddlTransporterMode-error']")
	private WebElement transporterModeError;

	@FindBy(xpath = "//label[@id='ShippingStateCode-error']")
	private WebElement shippingStateCodeError;

	@FindBy(xpath = "//label[@id='ddlShiState-error']")
	private WebElement shippingStateError;

	@FindBy(xpath = "//label[@id='ddlShiCity-error']")
	private WebElement shippingCityError;

	@FindBy(xpath = "//input[@id='ShippingCustName']")
	private WebElement shippingCustomerField;

	@FindBy(xpath = "//textarea[@id='ShippingAddress']")
	private WebElement shippingAddressField;

	@FindBy(xpath = "//input[@id='ShippingStateCode']")
	private WebElement shippingStateCodeField;

	@FindBy(xpath = "//input[@name='GST']")
	private WebElement gstField;

	@FindBy(xpath = "//span[@id='select2-ddlFreight-container']")
	private WebElement freightField;

	@FindBy(xpath = "//input[@id='CustomerPoNo']")
	private WebElement customerPoField;

	@FindBy(xpath = "//h2[text()='Warning']")
	private WebElement warningPopUpText;

	@FindBy(xpath = "//h2[text()='Success!']")
	private WebElement successPopUpText;


	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement ErrorToastMessageText;


	@FindBy(xpath = "/html/body/div[8]/p/b")
	private WebElement invoiceNumberStoring;

	@FindBy(xpath = "//label[@id='ddlShiPinCode-error']")
	private WebElement shippingPinCodeError;

	@FindBy(xpath = "//label[@id='RejectRemark-error']")
	private WebElement specialInstructionError;

	@FindBy(xpath = "//span[@id='select2-ddlTransporterId-container']")
	private WebElement transporter;




	@FindBy(xpath = "//li[text()=' Amol Transport ']")
	private WebElement amolTransportTransporter;

	@FindBy(xpath = "//textarea[@id='RejectRemark']")
	private WebElement specialInstructions;

	// ITEM DETAILS section

	@FindBy(xpath = "//span[@id='ErrorTable']")
	private WebElement errorMessageField;

	@FindBy(xpath = "//span[@id='select2-SearchItem-container']")
	private WebElement itemdropdown;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement inputFieldItemdropdown;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	private WebElement firstResultItemdropdown;

	@FindBy(xpath = "//input[@class='form-control InvQty number text-right']")
	private WebElement invoiceQty;// click

	@FindBy(xpath = "//input[@id='mdlTxtBarcode']")
	private WebElement enteredQty;

	@FindBy(xpath = "//button[@id='LotnewBtn']")
	private WebElement confirmButton;

	@FindBy(xpath = "//button[@id='BtnSave']")
	private WebElement saveButton;

	// popUps
	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement okButtonFromWarningPopUp;

	@FindBy(xpath = "/html/body/div[8]/p/b")
	private WebElement generatedInvoiceNo;

	// Constructor
	public ManageInvoicePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		invoicePage = new InvoicePage(driver);
		toggleMenus = new ToggleMenus(driver);
		allMaterialTransactionSubModules = new AllMaterialTransactionSubModules(driver);
		outwardRegister = new OutwardRegister(driver);
		allSalesSubModules = new AllSalesSubModules(driver);
	}

	// Methods
	public void enterCustomerNameFromExcel(String excelPath, String sheetName, WebDriver driver)
			throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		customerField.click();
		String customerName = excel.getCellData(1, 0);
		customerField.sendKeys(customerName);
		Thread.sleep(2000);
		firstResultCustomerField.click();

	}

	public void enterSoNoFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		soNoField.click();
		String soNo = excel.getCellData(1, 1);
		soNoInputField.sendKeys(soNo);
		Thread.sleep(2000);
		soNoFirstResult.click();

	}

	public void selectTransporter() {
		transporter.click();
		wait.until(ExpectedConditions.elementToBeClickable(amolTransportTransporter));
		amolTransportTransporter.click();

	}
	//transporterModeByAirResult
	public void selectTransporterModeDD() throws InterruptedException {
		transporterMode.click();
		Thread.sleep(2000);
		transporterModeByAirResult.click();

	}






	public void selectTransporterOption() {
		transporter.click();
		wait.until(ExpectedConditions.elementToBeClickable(amolTransportTransporter));
		amolTransportTransporter.click();
	}


	public void enterSpecialInstruction() {

		specialInstructions.sendKeys("Sample Invoice for automation Testing");

	}





	public void selectitem(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		itemdropdown.click();
		String itemName = excel.getCellData(1, 2);
		inputFieldItemdropdown.sendKeys(itemName);
		Thread.sleep(2000);
		firstResultItemdropdown.click();

	}

	public void enterQtyForInvoice(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

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
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transporter);

	}

	public WebElement getTransporterElement() {

		return transporter;
	}





	public void performActionOnPopupafterSave() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
		Thread.sleep(3000);
		okButtonFromWarningPopUp.click();
		Thread.sleep(2000);
	}
	// ----------------------------------------------------------------------------

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
		try (FileInputStream input = new FileInputStream(
				"C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\config.properties")) {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty("invoiceNumber");

	}

	// ----------------------------------------------------------------------------

	public void FinalPopupOkButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
		Thread.sleep(2000);
		okButtonFromWarningPopUp.click();
		Thread.sleep(500);
	}

	public void createInvoice(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(5000);
			invoicePage.clickOnAddInvoice();
			invoicePage.selectDomesticInvoiceTypeFromPopUp();
			// invoicePage.selectExportInvoiceTypeFromPopUp();

			customerField.click();
			Thread.sleep(2000);
			String customerName = excel.getCellData(i, 0);
			customerField.sendKeys(customerName);
			Thread.sleep(2000);
			firstResultCustomerField.click();

			soNoField.click();
			String soNo = excel.getCellData(i, 1);
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

			WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
			String invoiceNumber = invoiceNumberStoring.getText();
			System.out.println(invoiceNumber);

			TestDataStorage.invoiceNumber = invoiceNumber;

			FinalPopupOkButton();
			Thread.sleep(6000);

			invoicePage.searchField.sendKeys(invoiceNumber);
			invoicePage.firstResultAfterSearch.click();
			invoicePage.firstResultAfterSearch.click();

			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
			Thread.sleep(2000);
			invoicePage.printButton.click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.okButtonWarningPopUp));
			invoicePage.okButtonWarningPopUp.click();

			Thread.sleep(3000);

			// In each loop iteration:
			windowHandles = driver.getWindowHandles(); // Refresh the window handles
			String parentWindow = driver.getWindowHandle(); // Get parent window handle

			// Switch to the child window
			for (String handle : windowHandles) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);

					String Url = driver.getCurrentUrl();
					System.out.println(Url);
					// Wait until the title is available (or any other indicator of full loading)
					new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(Url));

					try {
						// Handle any potential alert
						Alert alert = driver.switchTo().alert();
						alert.accept(); // Accept the alert
					} catch (NoAlertPresentException e) {
						// No alert present, proceed with closing
					}

					// Attempt to close the window using standard method
					try {
						Thread.sleep(5000); // Small delay before closing
						driver.close();
					} catch (WebDriverException e) {
						System.out.println("Standard close failed, using JavaScript.");
						Thread.sleep(4000); // Small delay before closing
						((JavascriptExecutor) driver).executeScript("window.close();");
					}

					break; // Exit the loop after closing the window
				}
			}

			// Switch back to the parent window

			driver.switchTo().window(parentWindow);

			Thread.sleep(3000);
			toggleMenus.clickOnToggleMenu();
			toggleMenus.clickOnmaterialTransactionMenuIcon();
			allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
			outwardRegister.clickOnAddOutwardButton();
			outwardRegister.newenterInvoiceNoToBarcodeField();

			toggleMenus.clickOnToggleMenu();
			toggleMenus.clickOnsalesMenuIcon();
			allSalesSubModules.clickOnInvoiceMenu();
		}
	}

	public void createInvoiceSamplePo(String excelPath, String sheetName, WebDriver driver)
			throws InterruptedException {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(5000);
			invoicePage.clickOnAddInvoice();
			invoicePage.selectDomesticInvoiceTypeFromPopUp();
			// invoicePage.selectExportInvoiceTypeFromPopUp();

			customerField.click();
			Thread.sleep(2000);
			String customerName = excel.getCellData(i, 0);
			customerField.sendKeys(customerName);
			Thread.sleep(2000);
			firstResultCustomerField.click();

			soTypefield.click();
			sampleSoOption.click();

			soNoField.click();
			String soNo = excel.getCellData(i, 1);
			soNoInputField.sendKeys(soNo);
			Thread.sleep(2000);
			soNoFirstResult.click();
//----------
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

			WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
			String invoiceNumber = invoiceNumberStoring.getText();
			System.out.println("Invoice Number is = "+invoiceNumber);

			TestDataStorage.invoiceNumber = invoiceNumber;

			FinalPopupOkButton();
			Thread.sleep(4000);

			invoicePage.searchField.sendKeys(invoiceNumber);
			invoicePage.firstResultAfterSearch.click();
			invoicePage.firstResultAfterSearch.click();

			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
			Thread.sleep(2000);
			invoicePage.printButton.click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.okButtonWarningPopUp));
			invoicePage.okButtonWarningPopUp.click();

			Thread.sleep(3000);

			// In each loop iteration:
			windowHandles = driver.getWindowHandles(); // Refresh the window handles
			String parentWindow = driver.getWindowHandle(); // Get parent window handle

			// Switch to the child window
			for (String handle : windowHandles) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);

					String Url = driver.getCurrentUrl();
					System.out.println(Url);
					// Wait until the title is available (or any other indicator of full loading)
					new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(Url));

					try {
						// Handle any potential alert
						Alert alert = driver.switchTo().alert();
						alert.accept(); // Accept the alert
					} catch (NoAlertPresentException e) {
						// No alert present, proceed with closing
					}

					// Attempt to close the window using standard method
					try {
						Thread.sleep(5000); // Small delay before closing
						driver.close();
					} catch (WebDriverException e) {
						System.out.println("Standard close failed, using JavaScript.");
						Thread.sleep(4000); // Small delay before closing
						((JavascriptExecutor) driver).executeScript("window.close();");
					}

					break; // Exit the loop after closing the window
				}
			}

			// Switch back to the parent window

			driver.switchTo().window(parentWindow);

			Thread.sleep(3000);
			toggleMenus.clickOnToggleMenu();
			toggleMenus.clickOnmaterialTransactionMenuIcon();
			allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
			outwardRegister.clickOnAddOutwardButton();
			outwardRegister.newenterInvoiceNoToBarcodeField();

			toggleMenus.clickOnToggleMenu();
			toggleMenus.clickOnsalesMenuIcon();
			allSalesSubModules.clickOnInvoiceMenu();
		}

	}



	//Validations:-
	//customer
	  public String getCustomerFieldError() {
	        return customerErrorField.getText();
	    }

		// SO NO Type
		public String getSONOTypeFieldError() {
			return soNoTypeErrorField.getText();
		}

		// SO
		public String getSONOFieldError() {
			return soNoErrorField.getText();
		}

		// CustomerPO
		public String customerPoNoerrorFieldError() {
			return customerPoNoerrorField.getText();
		}

		public boolean isCustomerPoNoFieldDisabled() {
			return !customerPoNoField.isEnabled();
		}

		// invoice Date
		public String getInvoiceDateFromField() {
			return invoiceDateField.getDomProperty("value");// returns "dd/MM/yyyy" or similar
		}

		//FY

		public boolean isfinancialYearFieldDisabled() {
			return !financialYearField.isEnabled();
		}

		public String getTextFincialYearField(){
			return financialYearField.getDomProperty("value");
		}

		//Transporter
		public String getTransporterFieldError() {

			return transporterError.getText();
		}

		//Transporter Mode
		public String getTransporterModeFieldError() {

			return transporterModeError.getText();
		}

		public void selectTransporterModeField() {

			 transporterModeError.getText();
		}



		//Please Enter Shipping State Code
		public String getShippingStateCodeFieldError() {

			return shippingStateCodeError.getText();
		}

		//Please Select Shipping State
public String getShippingStateFieldError() {

			return shippingStateError.getText();
		}

// Please Select Shipping City
public String getShippingCityFieldError() {

	return shippingCityError.getText();
}

//Shipping PinCode:-

public String getShippingPinCodeFieldError() {

	return shippingPinCodeError.getText();
}

//special Instruction

public String getSpecialInstructionFieldError() {

	return specialInstructionError.getText();
}

//Enter value in customer field
public void enterValueInCustomerField() throws InterruptedException{


	customerField.click();
	Thread.sleep(2000);
	//String customerName = excel.getCellData(i, 0);
	customerField.sendKeys("ZF India");
	Thread.sleep(2000);
	firstResultCustomerField.click();
}

//select SO field
public void selectSOField() throws InterruptedException{

	soNoField.click();
//	String soNo = excel.getCellData(i, 1);
	soNoInputField.sendKeys("11055");
	Thread.sleep(2000);
	soNoFirstResult.click();

}

//get value from shipping customer field
public String enterShippingCustomerField() {

	return shippingCustomerField.getDomProperty("value");

}

//get value from shipping Address field
public String getShippingAddressField() {

	return shippingAddressField.getDomProperty("value");

}

//get value from shipping State Code field
public String getShippingCodeStateField() {

	return shippingStateCodeField.getDomProperty("value");

}

//get value from GST Field

public String getGSTField() {

	return gstField.getDomProperty("value");

}

//get value from Freight Field
public String getFreightField() {

	return freightField.getDomAttribute("title");
}


//get value from Customer PO field
public String getCustomerPoField() {

	return customerPoField.getDomProperty("value");

}

public void selectItemDropdownAndFillItemDetails() throws InterruptedException {

	itemdropdown.click();
//	String itemName = excel.getCellData(i, 2);
	inputFieldItemdropdown.sendKeys("11055");
	Thread.sleep(2000);
	firstResultItemdropdown.click();

	wait.until(ExpectedConditions.elementToBeClickable(invoiceQty));
	invoiceQty.click();
//	String qty = excel.getCellData(i, 3);
	wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
	enteredQty.sendKeys("10");
	Thread.sleep(2000);
	confirmButton.click();

}

// Warning Pop Up validation
public String getTextFromWarningPopUp() {

	 return warningPopUpText.getText();
}

public boolean getVisibilityOfWarningPopUp() {

	return warningPopUpText.isDisplayed();
}

//success pop up Validation

public String getTextFromSuccessPopUp() {

	 return successPopUpText.getText();
}

public boolean getVisibilityOfSuccessPopUp() {

	return successPopUpText.isDisplayed();
}

public void getInvoiceNumberFromSuccessPopUp() throws InterruptedException {


	WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
	String invoiceNumber = invoiceNumberStoring.getText();
	System.out.println("Invoice Number is = "+invoiceNumber);

	TestDataStorage.invoiceNumber = invoiceNumber;

	FinalPopupOkButton();
	Thread.sleep(4000);

}


public boolean invoiceNoVisibility() {

return invoiceNumberStoring.isDisplayed();

}

public void getOnlyInvoiceNumberFromSuccessPopUp() throws InterruptedException {


	WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
	String invoiceNumber = invoiceNumberStoring.getText();
	System.out.println("Invoice Number is = "+invoiceNumber);

	TestDataStorage.invoiceNumber = invoiceNumber;

}

//"Enter Atleast 1 Item" Error message validation

public String getErrorTextFromErrorText() {

	 return errorMessageField.getText();
}

public boolean getVisibilityOfErrorText() {

	return errorMessageField.isDisplayed();
}


//Verify Error message-"Invoice Qty can not be Zero"
public void selectItemDropdownAndFillItemDetails_ZeroQTY() throws InterruptedException {

	itemdropdown.click();
//	String itemName = excel.getCellData(i, 2);
	inputFieldItemdropdown.sendKeys("11055");
	Thread.sleep(2000);
	firstResultItemdropdown.click();

	wait.until(ExpectedConditions.elementToBeClickable(invoiceQty));
	invoiceQty.click();
//	String qty = excel.getCellData(i, 3);
	wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
	enteredQty.sendKeys("0");
	Thread.sleep(2000);
	confirmButton.click();

}


public String getTextFromErrorToastMessage() {

	 return ErrorToastMessageText.getText();
}

public boolean getVisibilityOfErrorToastMessage() {

	return ErrorToastMessageText.isDisplayed();
}






}
















