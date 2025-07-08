package com.erp.automation.pages.sales;

import java.time.Duration;
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
import com.erp.automation.pages.accountFinance.Receipt;
import com.erp.automation.pages.materialTransaction.AllMaterialTransactionSubModules;
import com.erp.automation.pages.materialTransaction.OutwardRegister;
import com.erp.automation.utils.ExcelUtils;
import com.erp.automation.utils.TestDataStorage;

public class ManageExportInvoicePage {



	//Variables
	private WebDriver driver;
	private WebDriverWait wait;
	String searchFieldInvoiceNo;
	Receipt receipt;
	InvoicePage invoicePage;
	ManageInvoicePage manageInvoicePage;
	Set<String> windowHandles;
	AllMaterialTransactionSubModules allMaterialTransactionSubModules;
	OutwardRegister outwardRegister;
	ToggleMenus toggleMenus;
	AllSalesSubModules allSalesSubModules;



	@FindBy(xpath = "//input[@id='CustName']")
	private WebElement customerField;

	@FindBy(xpath = "/html[1]/body[1]/ul[2]/li[1]/div[1]")
	private WebElement firstResultCustomerField;

	@FindBy(xpath = "/html[1]/body[1]/ul[2]/li[3]/div[1]")
	private WebElement thirdTennocoBrasilOption;

	@FindBy(xpath = "//span[@id='select2-SoNo-container']")
	private WebElement soNoField;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement soNoInputField;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	private WebElement soNoFirstResult;

	@FindBy(xpath = "")
	private WebElement transporterMode;

	@FindBy(xpath = "//span[@id='select2-ddlTransporterId-container']")
	private WebElement transporter;

	@FindBy(xpath = "//label[@id='ddlTransporterMode-error']")
	private WebElement transporterErrorMessage;


	@FindBy(xpath = "//li[text()=' Amol Transport ']")
	private WebElement amolTransportTransporter;

	//Other References
	@FindBy (xpath="//input[@id='otherRef']")
	private WebElement OtherReferences;

	@FindBy (xpath="//label[@id='otherRef-error']")
	private WebElement OtherReferencesErrorMessage;

	//shippingCustomerErrorMessage
	@FindBy (xpath="//span[@id='spShippingCustId']")
	private WebElement shippingCustomerErrorMessage;


	//Pre-Carriage By
	@FindBy (xpath="//input[@id='PreCarriage']")
	private WebElement preCarriageBy;

	@FindBy (xpath="//label[@id='PreCarriage-error']")
	private WebElement preCarriageByErrorMessage;

	//Place Of Receipt Of Pre-Carrier
	@FindBy (xpath="//input[@id='ReceiptPreCarrier']")
	private WebElement placeOfReceiptOfPreCarrier;

	@FindBy (xpath="//label[@id='ReceiptPreCarrier-error']")
	private WebElement PlaceOfReceiptOfPreCarrierErrorMessage;

	//Vessel/Voyage
	@FindBy (xpath="//input[@id='vesselNo']")
	private WebElement vesselOrVoyage;

	@FindBy (xpath="//label[@id='vesselNo-error']")
	private WebElement vesselOrVoyageErrorMessage;

	//Port of Loading
	@FindBy (xpath="//input[@id='PortLoding']")
	private WebElement portOfLoading;

	@FindBy (xpath="//label[@id='PortLoding-error']")
	private WebElement portofLoadingFieldErrorMessage;

	//Port of Discharge
	@FindBy (xpath="//input[@id='portDischarge']")
	private WebElement portOfDischarge;

	@FindBy (xpath="//label[@id='portDischarge-error']")
	private WebElement portofDischargeFieldErrorMessage;


	//Place Of Delivery
	@FindBy (xpath="//input[@id='PlaceofDelivery']")
	private WebElement placeOfDelivery;

	@FindBy (xpath="//label[@id='PlaceofDelivery-error']")
	private WebElement placeOfDeliveryFieldErrorMessage;

	//Country of Origin of Goods
	@FindBy (xpath="//input[@id='origingoodsCountry']")
	private WebElement countryOfOriginOfGoods;

	@FindBy (xpath="//label[@id='origingoodsCountry-error']")
	private WebElement countryofOriginofGoodsFieldErrorMessage;

	//Country of Final Destination
	@FindBy (xpath="//input[@id='FinalDestinationCountyr']")
	private WebElement countryOfFinalDestination;

	@FindBy (xpath="//label[@id='FinalDestinationCountyr-error']")
	private WebElement countryofFinalDestinationFieldErrorMessage;

	//Terms of Delivery
	@FindBy (xpath="//input[@id='delivryTerms']")
	private WebElement termsOfDelivery;

	@FindBy (xpath="//label[@id='delivryTerms-error']")
	private WebElement TermsofDeliveryFieldErrorMessage;


	//Container
	@FindBy (xpath="//input[@id='ConatinerNo']")
	private WebElement container;

	@FindBy (xpath="//label[@id='ConatinerNo-error']")
	private WebElement containerFieldErrorMessage;

	//Container Seal
	@FindBy (xpath="//input[@id='ContainerSealNo']")
	private WebElement containerSeal;

	@FindBy (xpath="//label[@id='ContainerSealNo-error']")
	private WebElement containerSealFieldErrorMessage;

	//E-Seal
	@FindBy (xpath="//input[@id='ESealNo']")
	private WebElement eSeal;

	@FindBy (xpath="//label[@id='ESealNo-error']")
	private WebElement eSealFieldErrorMessage;

	//Size (cm)
	@FindBy (xpath="//input[@id='Size']")
	private WebElement size;

	@FindBy (xpath="//label[@id='Size-error']")
	private WebElement sizeFieldErrorMessage;

	//Packing List / Delivery Note
	@FindBy (xpath="//input[@id='PackingListDeliveryNoteNo']")
	private WebElement packingListOrDeliveryNote;

	@FindBy (xpath="//label[@id='PackingListDeliveryNoteNo-error']")
	private WebElement packingListOrDeliveryNoteFieldErrorMessage;

	//Port
	@FindBy (xpath="//span[@id='select2-ddlPort-container']")
	private WebElement portDD;

	@FindBy (xpath="//li[text()=' sahar air cargo ']")
	private WebElement saharAirCargoPortDDOption;


	//SpecialInstruction

	@FindBy(xpath = "//textarea[@id='RejectRemark']")
	private WebElement specialInstructions;

	@FindBy (xpath="//label[@id='RejectRemark-error']")
	private WebElement specialInstructionFieldErrorMessage;


	//port

	@FindBy (xpath="//label[@id='ddlPort-error']")
	private WebElement portFieldErrorMessage;


	//Remark
	@FindBy(xpath = "//input[@id='EPCGRemark']")
	private WebElement remark1;

	@FindBy(xpath = "//input[@id='UTRemark']")
	private WebElement remark2;

	// ITEM DETAILS section

	@FindBy (xpath="//span[@id='ErrorTable']")
	private WebElement itemDetailsFieldErrorMessage;

	@FindBy (xpath="//div[text()='Invoice Qty cannot be zero']")
	private WebElement errorToastMessageInvoiceQtyCannotBeZero;

	@FindBy (xpath="//div[text()='Please Enter net Weight']")
	private WebElement errorToastMessagePleaseEnternetWeight;

	@FindBy (xpath="//div[text()='Please Enter gross Weight']")
	private WebElement errorToastMessagePleaseEnterGrossWeight;

	@FindBy (xpath="//div[text()='Enter package se no for item code- 41700']")
	private WebElement errorToastMessagePackageSrNoForItemCode;


	@FindBy (xpath="//div[text()='Packing List mismatch for item code- 41700']")
	private WebElement errorToastMessagePackingListMismatchForItemCode;



	@FindBy (xpath="//div[text()='Enter Gross Weight for item code- 41700']")
	private WebElement errorToastMessageEnterGrossWeightForItemCode;


	@FindBy (xpath="//div[text()='Enter Net Weight for item code- 41700']")
	private WebElement errorToastMessageEnterNetWeightForItemCode;

	@FindBy (xpath="//div[text()='Enter Qty for item code- 41700']")
	private WebElement errorToastMessageEnterQtyForItemCode ;

	@FindBy (xpath="//p[@style='display: block;']")
	private WebElement warningPopUpmessageText ;

	@FindBy (xpath="//h2[text()='Success!']")
	private WebElement successPopUpmessageText ;

	@FindBy (xpath="//p[@style='display: block;']")
	private WebElement successPopUpMessageAllText ;

	@FindBy(xpath = "/html/body/section/div/form/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]/div")//div[text()='41700-HUB 1-2-8-9-10-R CLU']")
	private WebElement selectedItem;


	@FindBy(xpath = "//span[@id='select2-SearchItem-container']")
	private WebElement itemdropdown;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement inputFieldItemdropdown;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	private WebElement firstResultItemdropdown;

	//enter qty
	@FindBy(xpath = "/html/body/section/div/form/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/table/tbody/tr/td[6]/a")
	private WebElement stockQty;// click

	@FindBy(xpath = "//input[@id='mdlTxtBarcode']")
	private WebElement enteredQty;

	//Net Weight & Gross Weight
	@FindBy (xpath="//tbody/tr/td[16]/input[1]")
	private WebElement netWeight;

	@FindBy (xpath="//input[@class='form-control text-right GrossWeight IsValidnumber']")
	private WebElement grossWeight;


	//package Sr No Table
	//item Code -package Details Section
	@FindBy (xpath="//input[@class='form-control pckgesrno']")
	private WebElement packageSrNoR1;

	@FindBy (xpath="//input[@class='form-control pckgeqty text-right IsValidnumber']")
	private WebElement Qty1;

	@FindBy (xpath="//input[@class='form-control pckgeNetWeight text-right IsValidnumber']")
	private WebElement netWeight1;

	@FindBy (xpath="//input[@class='form-control pckgeGrossWeight text-right IsValidnumber']")
	private WebElement grossWeight1;

	@FindBy (xpath="/html/body/div[8]/p/b")
	public WebElement invoiceNumberStoring;

	@FindBy(xpath = "//button[@id='LotnewBtn']")
	private WebElement confirmButton;


	// popUps
		@FindBy(xpath = "//button[@class='confirm']")
		private WebElement okButtonFromWarningPopUp;

		@FindBy(xpath = "/html/body/div[8]/p/b")
		private WebElement generatedInvoiceNo;


	@FindBy(xpath = "//button[@id='BtnSave']")
	private WebElement saveButton;

	@FindBy (xpath="//h1[text()='Manage Export Invoice']")
	private WebElement exportInvoiceHeader;

	@FindBy (xpath="//textarea[@id='ShippingAddress']")
	private WebElement shippingAddress;

	@FindBy (xpath="//input[@id='BillingAddress']")
	private WebElement shippingAddress1;

	//validation

	@FindBy (xpath="//input[@id='txtFinancialyr']")
	private WebElement financialYearField;

	@FindBy (xpath="//input[@id='InvoiceDate']")
	private WebElement invoiceDateField;

	@FindBy (xpath="//input[@id='CustomerPoNo']")
	private WebElement customerPONOField;

	@FindBy (xpath="//input[@id='ShippingCustName']")
	private WebElement shippingCustomerField;

	@FindBy (xpath="//textarea[@id='ShippingAddress']")
	private WebElement shippingAddressField;

	@FindBy (xpath="//input[@id='ShippingStateCode']")
	private WebElement shippingStateCodeField;

	@FindBy (xpath="//span[@id='select2-ddlFreight-container']")
	private WebElement freightField;

	@FindBy (xpath="//button[text()='Cancel']")
	private WebElement CancelButtonFromWarningPopUp;

	@FindBy (xpath="//button[text()='OK']")
	private WebElement okButtonSuccessPopUp;


	// Constructor
	public  ManageExportInvoicePage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	receipt =new Receipt(driver);
	invoicePage = new InvoicePage(driver);
	manageInvoicePage =new ManageInvoicePage(driver);
    allMaterialTransactionSubModules = new AllMaterialTransactionSubModules(driver);
    outwardRegister = new OutwardRegister(driver);
    toggleMenus = new ToggleMenus(driver);
	allSalesSubModules= new AllSalesSubModules(driver);

	}


	// Methods

	// invoice Date
	public String getInvoiceDateFromField() {
		return invoiceDateField.getDomProperty("value");// returns "dd/MM/yyyy" or similar
	}

	public String getTextFincialYearField(){
		return financialYearField.getDomProperty("value");
	}


	public void enterCustomerField() throws InterruptedException {

		//Customer
		customerField.click();
		Thread.sleep(2000);
	//	String customerName = excel.getCellData(i, 0);
		customerField.sendKeys("C158-Powercor");
		Thread.sleep(2000);
		firstResultCustomerField.click();

	}


public void selectSoNoField() throws InterruptedException {

	//SO No
	soNoField.click();
//	String soNo = excel.getCellData(i, 1);
	soNoInputField.sendKeys("41700");
	Thread.sleep(2000);
	soNoFirstResult.click();
	}

public void selectTransporterField() {
	//selectTransporter - Amol
	manageInvoicePage.selectTransporter();

	}

public void selectTransporterModeField() throws InterruptedException {
	//selectTransporterMode - By Air
	manageInvoicePage.selectTransporterModeDD();

	}

public void selectport() {

	//Port
	portDD.click();
	wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
	saharAirCargoPortDDOption.click();

}


public WebElement getOtherReferenceElement() {

	return OtherReferences;
}


public String getErrorMessageFromOtherReferencesField() {

	return OtherReferencesErrorMessage.getText();

}


public String getErrorMessageFromShippingCustomerField() {

	return shippingCustomerErrorMessage.getText();

}

public String getErrorMessageFromPreCarriageByField() {

	return preCarriageByErrorMessage.getText();

}


public String getErrorMessageFromPlaceOfReceiptOfPreCarrierField() {

	return PlaceOfReceiptOfPreCarrierErrorMessage.getText();

}
//Vessel/Voyage
public String getErrorMessageFromVesselVoyageField() {

	return vesselOrVoyageErrorMessage.getText();

}

//port of Loading
public String getErrorMessageFromPortofLoadingField() {

	return portofLoadingFieldErrorMessage.getText();

}

//port of Discharge
public String getErrorMessageFromPortofDischargeField() {

	return portofDischargeFieldErrorMessage.getText();

}

//Place Of Delivery
public String getErrorMessageFromPlaceOfDeliveryField() {

	return placeOfDeliveryFieldErrorMessage.getText();

}

//Country of Origin of Goods

public String getErrorMessageFromCountryofOriginofGoodsField() {

	return countryofOriginofGoodsFieldErrorMessage.getText();

}

//Country of Final Destination

public String getErrorMessageFromCountryofFinalDestinationField() {

	return countryofFinalDestinationFieldErrorMessage.getText();

}

//Terms of Delivery
public String getErrorMessageFromTermsofDeliveryField() {

	return TermsofDeliveryFieldErrorMessage.getText();

}


//Container
public String getErrorMessageFromContainerField() {

	return containerFieldErrorMessage.getText();

}

//Container Seal
public String getErrorMessageFromContainerSealField() {

	return containerSealFieldErrorMessage.getText();

}
//E-Seal
public String getErrorMessageFromESealField() {

	return eSealFieldErrorMessage.getText();

}

//size
public String getErrorMessageFromSizeField() {

	return sizeFieldErrorMessage.getText();

}

//packingList / Delivery Note Field
public String getErrorMessageFrompackingListOrDeliveryNoteField() {

	return packingListOrDeliveryNoteFieldErrorMessage.getText();

}

//special Instruction

public String getErrorMessageFromSpecialInstructionField() {

	return specialInstructionFieldErrorMessage.getText();

}

//port

public String getErrorMessageFromPortField() {

	return portFieldErrorMessage.getText();

}

//Item Details

public String getErrorMessageFromItemDetailsField() {

	return itemDetailsFieldErrorMessage.getText();

}
//Invoice Qty Can not Be Zero
public String getToastmessage_InvoiceQtyCannotBeZero() {

	return errorToastMessageInvoiceQtyCannotBeZero.getText();
}

//PleaseEnternetWeight
public String getToastmessage_PleaseEnternetWeight() {

	return errorToastMessagePleaseEnternetWeight.getText();
}

//PleaseEnternetWeight
public String getToastmessage_PleaseEnterGrossWeight() {

	return errorToastMessagePleaseEnterGrossWeight.getText();
}

//Enter package se no for item code- 41700

public String getToastmessage_PackageSrNoForItemCode() {

	return errorToastMessagePackageSrNoForItemCode.getText();
}

//Packing List mismatch for item code- 41700
public String getToastmessage_PackingListMismatchForItemCode() {

	return errorToastMessagePackingListMismatchForItemCode.getText();
}

//EnterGrossWeightForItemCode
public String getToastmessage_EnterGrossWeightForItemCode() {

	return errorToastMessageEnterGrossWeightForItemCode.getText();
}

//Enter Net Weight for item code- 41700
public String getToastmessage_EnterNetWeightForItemCode() {

	return errorToastMessageEnterNetWeightForItemCode.getText();
}

//Enter QTY for item code- 41700
public String getToastmessage_EnterQtyForItemCode() {

	return errorToastMessageEnterQtyForItemCode.getText();
}

//Validation of visibility of Warning Popup

public String getWarningPopUpmessageText() {

	return warningPopUpmessageText.getText();
}

// Success popUp
public String getSuccessPopUpmessageText() {

	return successPopUpmessageText.getText();
}


public String getSuccessPopUpMessageAllText() {

	return successPopUpMessageAllText.getText();
}

public void clickOnCancelWarningPopup() throws InterruptedException{
	Thread.sleep(3000);
	CancelButtonFromWarningPopUp.click();
}

public void clickOnOkButtonFromSuccessPopup() throws InterruptedException{
	Thread.sleep(3000);
	okButtonSuccessPopUp.click();
}

//----------------------------------------
public String getValueFromCustomerPONoField() {

	return customerPONOField.getDomProperty("value");
}

public String getValueFromShippingCustomerField() {

	return shippingCustomerField.getDomProperty("value");
}


public String getValueFromShippingAddressField() {

	return shippingAddressField.getDomProperty("value");
}

public String getValueFromShippingStateCodeField() {

	return shippingStateCodeField.getDomProperty("value");
}


public String getValueFromFreightField() {

	return freightField.getDomProperty("title");
}

public String getTransporterErrorMessageValidation() {

	return transporterErrorMessage.getText();
}



//-------------------------------------------------------
	public void createExportInvoicePowerCor(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(3000);

			//Add Invoice and select Domestic Invoice TypeFromPopUp
			invoicePage.clickOnAddInvoice();
			invoicePage.selectExportInvoiceTypeFromPopUp();


			//Customer
			customerField.click();
			Thread.sleep(2000);
			String customerName = excel.getCellData(i, 0);
			customerField.sendKeys(customerName);
			Thread.sleep(2000);
			firstResultCustomerField.click();

			//SO No
			soNoField.click();
			String soNo = excel.getCellData(i, 1);
			soNoInputField.sendKeys(soNo);
			Thread.sleep(2000);
			soNoFirstResult.click();

			//selectTransporter - Amol
			manageInvoicePage.selectTransporter();

			//Other References
			OtherReferences.click();
			String otherReference = excel.getCellData(i, 2);
			OtherReferences.sendKeys(otherReference);


			//Pre-Carriage By
			preCarriageBy.click();
			String preCarriageByy = excel.getCellData(i, 3);
			preCarriageBy.sendKeys(preCarriageByy);

			//Place Of Receipt Of Pre-Carrier
			placeOfReceiptOfPreCarrier.click();
			String placeOfReceiptOfPreCarrierr = excel.getCellData(i, 4);
			placeOfReceiptOfPreCarrier.sendKeys(placeOfReceiptOfPreCarrierr);


			//Vessel/Voyage
			vesselOrVoyage.click();
			String vesselOrVoyagee = excel.getCellData(i, 5);
			vesselOrVoyage.sendKeys(vesselOrVoyagee);

			//Port of Loading
			portOfLoading.click();
			String portOfLoadingg = excel.getCellData(i, 6);
			portOfLoading.sendKeys(portOfLoadingg);

			//Port of Discharge
			portOfDischarge.click();
			String portOfDischargee = excel.getCellData(i, 7);
			portOfDischarge.sendKeys(portOfDischargee);


			//Place Of Delivery
			placeOfDelivery.click();
			String placeOfDeliveryy = excel.getCellData(i, 8);
			placeOfDelivery.sendKeys(placeOfDeliveryy);

			//Country of Origin of Goods
			countryOfOriginOfGoods.click();
			String countryOfOriginOfGoodss = excel.getCellData(i, 9);
			countryOfOriginOfGoods.sendKeys(countryOfOriginOfGoodss);

			//Country of Final Destination
			countryOfFinalDestination.click();
			String countryOfFinalDestinationn = excel.getCellData(i, 10);
			countryOfFinalDestination.sendKeys(countryOfFinalDestinationn);

			//Terms of Delivery
			termsOfDelivery.click();
			String termsOfDeliveryy = excel.getCellData(i, 11);
			termsOfDelivery.sendKeys(termsOfDeliveryy);

			//Container
			container.click();
			String containerr = excel.getCellData(i, 12);
			container.sendKeys(containerr);

			//Container Seal
			containerSeal.click();
			String containerSeall = excel.getCellData(i, 13);
			containerSeal.sendKeys(containerSeall);

			//E-Seal
			eSeal.click();
			String eSeall = excel.getCellData(i, 14);
			eSeal.sendKeys(eSeall);

			//Size (cm)
			size.click();
			String sizee = excel.getCellData(i, 15);
			size.sendKeys(sizee);


			//Packing List / Delivery Note
			packingListOrDeliveryNote.click();
			String packingListOrDeliveryNotee = excel.getCellData(i, 16);
			packingListOrDeliveryNote.sendKeys(packingListOrDeliveryNotee);

			//Port
			portDD.click();
			wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
			saharAirCargoPortDDOption.click();

			//SpecialInstruction
			manageInvoicePage.enterSpecialInstruction();

		//	remarks
			remark1.sendKeys("Testing Remark1 Found ok");
			remark2.sendKeys("Testing Remark2 Found ok");


			itemdropdown.click();
			String itemName = excel.getCellData(i, 17);
			inputFieldItemdropdown.sendKeys(itemName);
			Thread.sleep(2000);
			firstResultItemdropdown.click();

			wait.until(ExpectedConditions.elementToBeClickable(stockQty));
			stockQty.click();
			String qty = excel.getCellData(i, 18);
			wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
			enteredQty.sendKeys(qty);

			Thread.sleep(2000);
			confirmButton.click();


			//net weight & Gross weight
			netWeight.sendKeys("500");
			grossWeight.sendKeys("700");



			//package Sr No Table

			packageSrNoR1.click();
			String packageSrNoR11 = excel.getCellData(i, 19);
			packageSrNoR1.sendKeys(packageSrNoR11);

			Qty1.click();
			String Qty11 = excel.getCellData(i, 20);
			Qty1.sendKeys(Qty11);

			netWeight1.click();
			String netWeight11 = excel.getCellData(i, 21);
			netWeight1.sendKeys(netWeight11);

			grossWeight1.click();
			String grossWeight11 = excel.getCellData(i, 22);
			grossWeight1.sendKeys(grossWeight11);



			manageInvoicePage.saveInvoice();
			manageInvoicePage.performActionOnPopupafterSave();

			WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
			String invoiceNumber = invoiceNumberStoring.getText();
			System.out.println(invoiceNumber);

			TestDataStorage.invoiceNumber = invoiceNumber;

			manageInvoicePage.FinalPopupOkButton();
			Thread.sleep(4000);

			invoicePage.searchField.sendKeys(invoiceNumber);
			invoicePage.firstResultAfterSearch.click();
			invoicePage.firstResultAfterSearch.click();

			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
			Thread.sleep(2000);
			invoicePage.printButton.click();

//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.okButtonWarningPopUp));
//			invoicePage.okButtonWarningPopUp.click();

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

			Thread.sleep(2000);
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnmaterialTransactionMenuIcon();
//			allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
//			outwardRegister.clickOnAddOutwardButton();
//			outwardRegister.newenterInvoiceNoToBarcodeField();
//
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnsalesMenuIcon();
//			allSalesSubModules.clickOnInvoiceMenu();
		}
	}



	public void invoiceCreationTestExportTennecoBrasil(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(3000);

			//Add Invoice and select Domestic Invoice TypeFromPopUp
			invoicePage.clickOnAddInvoice();
			invoicePage.selectExportInvoiceTypeFromPopUp();


			//Customer
			customerField.click();
			Thread.sleep(2000);
			String customerName = excel.getCellData(i, 0);
			customerField.sendKeys(customerName);
			Thread.sleep(2000);
			thirdTennocoBrasilOption.click();

			//SO No
			soNoField.click();
			String soNo = excel.getCellData(i, 1);
			soNoInputField.sendKeys(soNo);
			Thread.sleep(2000);
			soNoFirstResult.click();

			//selectTransporter - Amol
			manageInvoicePage.selectTransporter();

			//Other References
			OtherReferences.click();
			String otherReference = excel.getCellData(i, 2);
			OtherReferences.sendKeys(otherReference);


			//Pre-Carriage By
			preCarriageBy.click();
			String preCarriageByy = excel.getCellData(i, 3);
			preCarriageBy.sendKeys(preCarriageByy);

			//Place Of Receipt Of Pre-Carrier
			placeOfReceiptOfPreCarrier.click();
			String placeOfReceiptOfPreCarrierr = excel.getCellData(i, 4);
			placeOfReceiptOfPreCarrier.sendKeys(placeOfReceiptOfPreCarrierr);


			//Vessel/Voyage
			vesselOrVoyage.click();
			String vesselOrVoyagee = excel.getCellData(i, 5);
			vesselOrVoyage.sendKeys(vesselOrVoyagee);

			//Port of Loading
			portOfLoading.click();
			String portOfLoadingg = excel.getCellData(i, 6);
			portOfLoading.sendKeys(portOfLoadingg);

			//Port of Discharge
			portOfDischarge.click();
			String portOfDischargee = excel.getCellData(i, 7);
			portOfDischarge.sendKeys(portOfDischargee);


			//Place Of Delivery
			placeOfDelivery.click();
			String placeOfDeliveryy = excel.getCellData(i, 8);
			placeOfDelivery.sendKeys(placeOfDeliveryy);

			//Country of Origin of Goods
			countryOfOriginOfGoods.click();
			String countryOfOriginOfGoodss = excel.getCellData(i, 9);
			countryOfOriginOfGoods.sendKeys(countryOfOriginOfGoodss);

			//Country of Final Destination
			countryOfFinalDestination.click();
			String countryOfFinalDestinationn = excel.getCellData(i, 10);
			countryOfFinalDestination.sendKeys(countryOfFinalDestinationn);

			//Terms of Delivery
			termsOfDelivery.click();
			String termsOfDeliveryy = excel.getCellData(i, 11);
			termsOfDelivery.sendKeys(termsOfDeliveryy);

			//Container
			container.click();
			String containerr = excel.getCellData(i, 12);
			container.sendKeys(containerr);

			//Container Seal
			containerSeal.click();
			String containerSeall = excel.getCellData(i, 13);
			containerSeal.sendKeys(containerSeall);

			//E-Seal
			eSeal.click();
			String eSeall = excel.getCellData(i, 14);
			eSeal.sendKeys(eSeall);

			//Size (cm)
			size.click();
			String sizee = excel.getCellData(i, 15);
			size.sendKeys(sizee);


			//Packing List / Delivery Note
			packingListOrDeliveryNote.click();
			String packingListOrDeliveryNotee = excel.getCellData(i, 16);
			packingListOrDeliveryNote.sendKeys(packingListOrDeliveryNotee);

			//Port
			portDD.click();
			wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
			saharAirCargoPortDDOption.click();

			//SpecialInstruction
			manageInvoicePage.enterSpecialInstruction();

		//	remarks
			remark1.sendKeys("Testing Remark1 Found ok");
			remark2.sendKeys("Testing Remark2 Found ok");


			itemdropdown.click();
			String itemName = excel.getCellData(i, 17);
			inputFieldItemdropdown.sendKeys(itemName);
			Thread.sleep(2000);
			firstResultItemdropdown.click();

			wait.until(ExpectedConditions.elementToBeClickable(stockQty));
			stockQty.click();
			String qty = excel.getCellData(i, 18);
			wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
			enteredQty.sendKeys(qty);

			Thread.sleep(2000);
			confirmButton.click();


			//net weight & Gross weight
			netWeight.sendKeys("500");
			grossWeight.sendKeys("700");






			//package Sr No Table

			packageSrNoR1.click();
			String packageSrNoR11 = excel.getCellData(i, 19);
			packageSrNoR1.sendKeys(packageSrNoR11);

			Qty1.click();
			String Qty11 = excel.getCellData(i, 20);
			Qty1.sendKeys(Qty11);

			netWeight1.click();
			String netWeight11 = excel.getCellData(i, 21);
			netWeight1.sendKeys(netWeight11);

			grossWeight1.click();
			String grossWeight11 = excel.getCellData(i, 22);
			grossWeight1.sendKeys(grossWeight11);



			manageInvoicePage.saveInvoice();
			manageInvoicePage.performActionOnPopupafterSave();

			WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
			String invoiceNumber = invoiceNumberStoring.getText();
			System.out.println(invoiceNumber);

			TestDataStorage.invoiceNumber = invoiceNumber;

			manageInvoicePage.FinalPopupOkButton();
			Thread.sleep(4000);

			invoicePage.searchField.sendKeys(invoiceNumber);
			invoicePage.firstResultAfterSearch.click();
			invoicePage.firstResultAfterSearch.click();

			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
			Thread.sleep(2000);
			invoicePage.printButton.click();

//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.okButtonWarningPopUp));
//			invoicePage.okButtonWarningPopUp.click();

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

			Thread.sleep(2000);
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnmaterialTransactionMenuIcon();
//			allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
//			outwardRegister.clickOnAddOutwardButton();
//			outwardRegister.newenterInvoiceNoToBarcodeField();
//
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnsalesMenuIcon();
//			allSalesSubModules.clickOnInvoiceMenu();
		}
	}

	//===================================================================================================================================================


	public void ExportInvoicePowerCorCreationWithAssertions(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(3000);

			//Add Invoice and select Domestic Invoice TypeFromPopUp
			invoicePage.clickOnAddInvoice();
			invoicePage.selectExportInvoiceTypeFromPopUp();


			//Customer
			customerField.click();
			Thread.sleep(2000);
			String customerName = excel.getCellData(i, 0);
			customerField.sendKeys(customerName);
			Thread.sleep(2000);
			firstResultCustomerField.click();

			//SO No
			soNoField.click();
			String soNo = excel.getCellData(i, 1);
			soNoInputField.sendKeys(soNo);
			Thread.sleep(2000);
			soNoFirstResult.click();

			//selectTransporter - Amol
			manageInvoicePage.selectTransporter();

			//Other References
			OtherReferences.click();
			String otherReference = excel.getCellData(i, 2);
			OtherReferences.sendKeys(otherReference);


			//Pre-Carriage By
			preCarriageBy.click();
			String preCarriageByy = excel.getCellData(i, 3);
			preCarriageBy.sendKeys(preCarriageByy);

			//Place Of Receipt Of Pre-Carrier
			placeOfReceiptOfPreCarrier.click();
			String placeOfReceiptOfPreCarrierr = excel.getCellData(i, 4);
			placeOfReceiptOfPreCarrier.sendKeys(placeOfReceiptOfPreCarrierr);


			//Vessel/Voyage
			vesselOrVoyage.click();
			String vesselOrVoyagee = excel.getCellData(i, 5);
			vesselOrVoyage.sendKeys(vesselOrVoyagee);

			//Port of Loading
			portOfLoading.click();
			String portOfLoadingg = excel.getCellData(i, 6);
			portOfLoading.sendKeys(portOfLoadingg);

			//Port of Discharge
			portOfDischarge.click();
			String portOfDischargee = excel.getCellData(i, 7);
			portOfDischarge.sendKeys(portOfDischargee);


			//Place Of Delivery
			placeOfDelivery.click();
			String placeOfDeliveryy = excel.getCellData(i, 8);
			placeOfDelivery.sendKeys(placeOfDeliveryy);

			//Country of Origin of Goods
			countryOfOriginOfGoods.click();
			String countryOfOriginOfGoodss = excel.getCellData(i, 9);
			countryOfOriginOfGoods.sendKeys(countryOfOriginOfGoodss);

			//Country of Final Destination
			countryOfFinalDestination.click();
			String countryOfFinalDestinationn = excel.getCellData(i, 10);
			countryOfFinalDestination.sendKeys(countryOfFinalDestinationn);

			//Terms of Delivery
			termsOfDelivery.click();
			String termsOfDeliveryy = excel.getCellData(i, 11);
			termsOfDelivery.sendKeys(termsOfDeliveryy);

			//Container
			container.click();
			String containerr = excel.getCellData(i, 12);
			container.sendKeys(containerr);

			//Container Seal
			containerSeal.click();
			String containerSeall = excel.getCellData(i, 13);
			containerSeal.sendKeys(containerSeall);

			//E-Seal
			eSeal.click();
			String eSeall = excel.getCellData(i, 14);
			eSeal.sendKeys(eSeall);

			//Size (cm)
			size.click();
			String sizee = excel.getCellData(i, 15);
			size.sendKeys(sizee);


			//Packing List / Delivery Note
			packingListOrDeliveryNote.click();
			String packingListOrDeliveryNotee = excel.getCellData(i, 16);
			packingListOrDeliveryNote.sendKeys(packingListOrDeliveryNotee);

			//Port
			portDD.click();
			wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
			saharAirCargoPortDDOption.click();

			//SpecialInstruction
			manageInvoicePage.enterSpecialInstruction();

		//	remarks
			remark1.sendKeys("Testing Remark1 Found ok");
			remark2.sendKeys("Testing Remark2 Found ok");


			itemdropdown.click();
			String itemName = excel.getCellData(i, 17);
			inputFieldItemdropdown.sendKeys(itemName);
			Thread.sleep(2000);
			firstResultItemdropdown.click();

			wait.until(ExpectedConditions.elementToBeClickable(stockQty));
			stockQty.click();
			String qty = excel.getCellData(i, 18);
			wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
			enteredQty.sendKeys(qty);

			Thread.sleep(2000);
			confirmButton.click();


			//net weight & Gross weight
			netWeight.sendKeys("500");
			grossWeight.sendKeys("700");






			//package Sr No Table

			packageSrNoR1.click();
			String packageSrNoR11 = excel.getCellData(i, 19);
			packageSrNoR1.sendKeys(packageSrNoR11);

			Qty1.click();
			String Qty11 = excel.getCellData(i, 20);
			Qty1.sendKeys(Qty11);

			netWeight1.click();
			String netWeight11 = excel.getCellData(i, 21);
			netWeight1.sendKeys(netWeight11);

			grossWeight1.click();
			String grossWeight11 = excel.getCellData(i, 22);
			grossWeight1.sendKeys(grossWeight11);



			manageInvoicePage.saveInvoice();
			manageInvoicePage.performActionOnPopupafterSave();

			WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
			String invoiceNumber = invoiceNumberStoring.getText();
			System.out.println(invoiceNumber);

			TestDataStorage.invoiceNumber = invoiceNumber;

			manageInvoicePage.FinalPopupOkButton();
			Thread.sleep(4000);

			invoicePage.searchField.sendKeys(invoiceNumber);
			invoicePage.firstResultAfterSearch.click();
			invoicePage.firstResultAfterSearch.click();

			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
			Thread.sleep(2000);
			invoicePage.printButton.click();

//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.elementToBeClickable(invoicePage.okButtonWarningPopUp));
//			invoicePage.okButtonWarningPopUp.click();

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

			Thread.sleep(2000);
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnmaterialTransactionMenuIcon();
//			allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
//			outwardRegister.clickOnAddOutwardButton();
//			outwardRegister.newenterInvoiceNoToBarcodeField();
//
//			toggleMenus.clickOnToggleMenu();
//			toggleMenus.clickOnsalesMenuIcon();
//			allSalesSubModules.clickOnInvoiceMenu();
		}
	}


	  public void enterCustomer(String customerName) {
	        wait.until(ExpectedConditions.elementToBeClickable(customerField)).click();
	        customerField.sendKeys(customerName);
	        wait.until(ExpectedConditions.elementToBeClickable(firstResultCustomerField)).click();
	        System.out.println("----------entercustomer method successfully Run------------");
	    }




	public void clickOnCustomerField(String excelPath, String sheetName, WebDriver driver ,int i) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		System.out.println("rowCount =" +  rowCount);
		customerField.click();
		Thread.sleep(2000);
		String customerName = excel.getCellData(i, 0);
		System.out.println("loop value is =" + i);
		customerField.sendKeys(customerName);
		Thread.sleep(2000);
		firstResultCustomerField.click();

	}

	public String isOnExportInvoicePageCurrentURL() {
	    return driver.getCurrentUrl();
	}

	public boolean isExportInvoiceHeaderDisplayed() {
	    return exportInvoiceHeader.isDisplayed();
	    }


	public void enterSoNoField(String soNo) throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(soNoField)).click();
			soNoInputField.sendKeys(soNo);
			Thread.sleep(1500);
			wait.until(ExpectedConditions.elementToBeClickable(soNoFirstResult)).click();
			//soNoFirstResult.click();
			System.out.println("----------entersoNo method successfully Run------------");

		}


	public void fillSoNoField(String excelPath, String sheetName, WebDriver driver ,int i) throws InterruptedException{

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		System.out.println("rowCount =" +  rowCount);
		//SO No
		soNoField.click();
		String soNo = excel.getCellData(i, 1);
		soNoInputField.sendKeys(soNo);
		Thread.sleep(2000);
		soNoFirstResult.click();

	}

	public boolean isSoNoFieldVisible() {
		 return soNoField.isDisplayed();
		 }

	public String getshippingAddressTextAutoPopulated() {
		 return shippingAddress.getDomProperty("value");
		 }

	public void selectTransporterOption() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(transporter));
		transporter.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(amolTransportTransporter));
		amolTransportTransporter.click();
	}


	public String isTransporterFieldchooseCorrectValue() {
//return transporter.getAttribute(value);
		return transporter.getDomAttribute("title");
	}

	public void otherReferenceFieldOperation(String references) {
		wait.until(ExpectedConditions.elementToBeClickable(OtherReferences));
		OtherReferences.click();
		wait.until(ExpectedConditions.elementToBeClickable(OtherReferences));
		OtherReferences.sendKeys(references);
	}
	public Boolean isReferenceFieldvalidation() {
		return OtherReferences.isDisplayed();
	}


	//preCarriageBy

	public void preCarriageBy(String prcarriageVariable) {
		preCarriageBy.click();
		preCarriageBy.sendKeys(prcarriageVariable);

	}

	public boolean ispreCarriageByDisplayed(String prcarriageVariable) {
		return preCarriageBy.isDisplayed();
	}

	//Place Of Receipt Of Pre-Carrier


	public void placeOfReceiptOfPreCarrierFieldAction(String placeOfReceiptOfPreCarrierr) {
		placeOfReceiptOfPreCarrier.click();
		placeOfReceiptOfPreCarrier.sendKeys(placeOfReceiptOfPreCarrierr);
	}

	public boolean isplaceOfReceiptOfPreCarrierFieldDisplayed() {
		return preCarriageBy.isDisplayed();
	}

	//Vessel/Voyage

	public void VesselOrVoyageFieldAction(String vesselOrVoyagee) {
		vesselOrVoyage.click();
		vesselOrVoyage.sendKeys(vesselOrVoyagee);

	}

	public boolean isVesselOrVoyageFieldDisplayed() {
		return vesselOrVoyage.isDisplayed();
	}

	//Port of Loading
	public void portOfLoading(String portOfLoadingg) {
		portOfLoading.click();
		portOfLoading.sendKeys(portOfLoadingg);

	}

	public boolean isportOfLoadingFieldDisplayed() {
		return portOfLoading.isDisplayed();
	}

	//Port of Discharge

	public void portOfDischarge (String portOfDischargee)
	{
	portOfDischarge.click();
	portOfDischarge.sendKeys(portOfDischargee);

	}

	public boolean isPortOfDischargeFieldDisplayed() {
		return portOfDischarge.isDisplayed();

	}

	//Place Of Delivery
	public void placeOfDeliveryField(String placeOfDeliveryyy) {
		placeOfDelivery.click();
		placeOfDelivery.sendKeys(placeOfDeliveryyy);

	}

	public boolean isPlaceOfDeliveryFieldDisplayed() {
		return placeOfDelivery.isDisplayed();

	}

	//Country of Origin of Goods
	public void CountryOfOriginOfGoodsField(String countryOfOriginOfGoodss) {
		countryOfOriginOfGoods.click();
		countryOfOriginOfGoods.sendKeys(countryOfOriginOfGoodss);
	}

	public boolean isCountryOfOriginGoodsFieldDisplayed() {
		return countryOfOriginOfGoods.isDisplayed();

	}

	//Country of Final Destination
	public void countryOfFinalOfGoodsField(String countryOfFinalDestinationn) {
		countryOfFinalDestination.click();
		countryOfFinalDestination.sendKeys(countryOfFinalDestinationn);
	}

	public boolean isCountryOfFinalGoodsFieldDisplayed() {
		return countryOfFinalDestination.isDisplayed();

	}

	//Terms of Delivery
	public void termsOfDeliveryField(String termsOfDeliveryy) {
		termsOfDelivery.click();
		termsOfDelivery.sendKeys(termsOfDeliveryy);
	}

	public boolean isTermsOfDeliveryFieldDisplayed() {
		return termsOfDelivery.isDisplayed();
	}

	//Container
	public void containerField(String containerr) {
		container.click();
		container.sendKeys(containerr);
	}

	public boolean isContainerFieldDisplayed() {
		return container.isDisplayed();
	}

	//Container Seal
	public void containerSealField(String containerSeall) {
		containerSeal.click();
		containerSeal.sendKeys(containerSeall);
	}

	public boolean isContainerSealFieldIsDisplayed() {
		return containerSeal.isDisplayed();
	}

	//E-Seal
	public void eSealField(String eSeall) {

		eSeal.click();
		eSeal.sendKeys(eSeall);
	}

	public boolean isESealFieldDisplayed() {
		return eSeal.isDisplayed();
	}

	//Size (cm)
	public void sizeField(String sizee) {
		size.click();
		size.sendKeys(sizee);
	}

	public boolean isSizeFieldDisplayed() {
		return size.isDisplayed();
	}

	//Packing List / Delivery Note
	public void packingListOrDeliveryNoteField(String packingListOrDeliveryNotee) {
		packingListOrDeliveryNote.click();
		packingListOrDeliveryNote.sendKeys(packingListOrDeliveryNotee);

	}

	public boolean isPackingListOrDeliveryNoteFieldDisplayed() {
		return packingListOrDeliveryNote.isDisplayed();
	}

	//Port
	public void portDropDownField() {
		portDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
		saharAirCargoPortDDOption.click();
	}

	public String getSelectedOptionText() {
		return portDD.getText().replace("×", "").trim();
	}

	//SpecialInstruction
	public void specialInstructionField() {
		manageInvoicePage.enterSpecialInstruction();
	}

	public boolean isSpecialInstructionFieldDisplayed() {
		return specialInstructions.isDisplayed();
	}

	//remarks1
	public void remarkOneField() {
		remark1.sendKeys("Testing Remark1 Found ok");
	}

	public boolean isremarkOneFieldDisplayed() {
		return remark1.isDisplayed();
	}

	//remarks2
	public void remarkTwoField() {
		remark2.sendKeys("Testing Remark2 Found ok");
	}

	public boolean isremarkTwoFieldDisplayed() {
		return remark2.isDisplayed();
	}

	//ITEM DETAILS
	public void enterItemNameInDropDown(String itemName) {
		itemdropdown.click();
		inputFieldItemdropdown.sendKeys(itemName);
		firstResultItemdropdown.click();
	}

	public String  getSelectedOption() {
		 return selectedItem.getText();
		 }

	//StockQty
	public void enterStockQty(String qty) {
		wait.until(ExpectedConditions.elementToBeClickable(stockQty));
		stockQty.click();
		wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
		enteredQty.sendKeys(qty);
		wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
		confirmButton.click();
	}

	public boolean isStockQtyFieldDisplayed() {

		return stockQty.isDisplayed();
	}

	//net weight & Gross weight
	public void enterNetWeightAndGrossWeight(){
		netWeight.sendKeys("500");
		grossWeight.sendKeys("700");
	}

	public boolean isNetWeightAndGrossWeightFieldDisplayed() {

	return netWeight.isDisplayed() && grossWeight.isDisplayed();
	}

//package Table
	//package Sr No
public void enterpackageDetialsInTable(String packageSrNoR11) {
	packageSrNoR1.click();
	packageSrNoR1.sendKeys(packageSrNoR11);
}

public boolean isPackiingTableSRNOFieldDisplayed() {
	return packageSrNoR1.isDisplayed();
}

	//Package Quantity
public void enterpackageQuantityInTable(String Qty11) {
	Qty1.click();
	Qty1.sendKeys(Qty11);
}

public boolean isPackiingTableQTYFieldDisplayed() {
	return Qty1.isDisplayed();
}

//Package netWeight11
public void enterpackageNetWeight1InTable(String netWeight11) {
	netWeight1.click();
	netWeight1.sendKeys(netWeight11);
}

public boolean isPackiingTableNetWeight1FieldDisplayed() {
return netWeight1.isDisplayed();
}

//Package grossWeight1
public void enterpackageGrossWeight1InTable(String grossWeight11) {
	grossWeight1.click();
	grossWeight1.sendKeys(grossWeight11);
}

public boolean isPackiingTableGrossWeight1FieldDisplayed() {
return grossWeight1.isDisplayed();
}

public void collectingInvoiceNumber() {
	String invoiceNumber = invoiceNumberStoring.getText();
	System.out.println(invoiceNumber);

	TestDataStorage.invoiceNumber = invoiceNumber;
}

public void selectInvoiceFromInvoiceList() throws InterruptedException {
	invoicePage.searchField.sendKeys(TestDataStorage.invoiceNumber);
	invoicePage.firstResultAfterSearch.click();
	invoicePage.firstResultAfterSearch.click();

	wait.until(ExpectedConditions.elementToBeClickable(invoicePage.printButton));
	Thread.sleep(2000);
	invoicePage.printButton.click();

}

public void newWindowOperation() throws InterruptedException {

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

	Thread.sleep(2000);
//	toggleMenus.clickOnToggleMenu();
//	toggleMenus.clickOnmaterialTransactionMenuIcon();
//	allMaterialTransactionSubModules.clickOnOutwardRegisterMenu();
//	outwardRegister.clickOnAddOutwardButton();
//	outwardRegister.newenterInvoiceNoToBarcodeField();
//
//	toggleMenus.clickOnToggleMenu();
//	toggleMenus.clickOnsalesMenuIcon();
//	allSalesSubModules.clickOnInvoiceMenu();
}


public void createExportInvoicePowerCorAssertionTestScript() throws InterruptedException {

		manageInvoicePage.selectTransporter();
		OtherReferences.click();
		OtherReferences.sendKeys("REF-1003");
		preCarriageBy.click();
		preCarriageBy.sendKeys("Air Freight");
		placeOfReceiptOfPreCarrier.click();
		placeOfReceiptOfPreCarrier.sendKeys("Delhi");
		vesselOrVoyage.click();
		vesselOrVoyage.sendKeys("MV Atlantic-03");
		portOfLoading.click();
		portOfLoading.sendKeys("Mundra Port");
		portOfDischarge.click();
		portOfDischarge.sendKeys("Halifax");
		placeOfDelivery.click();
		placeOfDelivery.sendKeys("Calgary");
		countryOfOriginOfGoods.click();
		countryOfOriginOfGoods.sendKeys("India");
		countryOfFinalDestination.click();
		countryOfFinalDestination.sendKeys("Canada");
		termsOfDelivery.click();
		termsOfDelivery.sendKeys("EXW");
		container.click();
		container.sendKeys("C-123460");
		containerSeal.click();
		containerSeal.sendKeys("SEAL-987658");
		eSeal.click();
		eSeal.sendKeys("ESEAL-003");
		size.click();
		size.sendKeys("140x100x120");
		packingListOrDeliveryNote.click();
		packingListOrDeliveryNote.sendKeys("PL-1003 / DN-1003");
		portDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
		saharAirCargoPortDDOption.click();
		manageInvoicePage.enterSpecialInstruction();
		remark1.sendKeys("Testing Remark1 Found ok");
		remark2.sendKeys("Testing Remark2 Found ok");

		itemdropdown.click();
		inputFieldItemdropdown.sendKeys("41700");
		Thread.sleep(2000);
		firstResultItemdropdown.click();

		stockQty.click();
		wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
		enteredQty.sendKeys("11");
		Thread.sleep(2000);
		confirmButton.click();

		netWeight.sendKeys("500");

		grossWeight.sendKeys("700");
		packageSrNoR1.click();
		packageSrNoR1.sendKeys("41700");
		Qty1.click();
		Qty1.sendKeys("11");
		netWeight1.click();
		netWeight1.sendKeys("700");
		grossWeight1.click();
		grossWeight1.sendKeys("935");
		manageInvoicePage.saveInvoice();
		manageInvoicePage.performActionOnPopupafterSave();
		WebElement invoiceNumberStoring = driver.findElement(By.xpath("/html/body/div[8]/p/b"));
		String invoiceNumber = invoiceNumberStoring.getText();
		System.out.println(invoiceNumber);
		TestDataStorage.invoiceNumber = invoiceNumber;
		manageInvoicePage.FinalPopupOkButton();
		Thread.sleep(4000);
		System.out.println("================================********************===================");

}


public void fillAllValuesInExportInvoiceExceptItemDetails() throws InterruptedException {

	manageInvoicePage.selectTransporter();
	OtherReferences.click();
	OtherReferences.sendKeys("REF-1003");
	preCarriageBy.click();
	preCarriageBy.sendKeys("Air Freight");
	placeOfReceiptOfPreCarrier.click();
	placeOfReceiptOfPreCarrier.sendKeys("Delhi");
	vesselOrVoyage.click();
	vesselOrVoyage.sendKeys("MV Atlantic-03");
	portOfLoading.click();
	portOfLoading.sendKeys("Mundra Port");
	portOfDischarge.click();
	portOfDischarge.sendKeys("Halifax");
	placeOfDelivery.click();
	placeOfDelivery.sendKeys("Calgary");
	countryOfOriginOfGoods.click();
	countryOfOriginOfGoods.sendKeys("India");
	countryOfFinalDestination.click();
	countryOfFinalDestination.sendKeys("Canada");
	termsOfDelivery.click();
	termsOfDelivery.sendKeys("EXW");
	container.click();
	container.sendKeys("C-123460");
	containerSeal.click();
	containerSeal.sendKeys("SEAL-987658");
	eSeal.click();
	eSeal.sendKeys("ESEAL-003");
	size.click();
	size.sendKeys("140x100x120");
	packingListOrDeliveryNote.click();
	packingListOrDeliveryNote.sendKeys("PL-1003 / DN-1003");
	portDD.click();
	wait.until(ExpectedConditions.elementToBeClickable(saharAirCargoPortDDOption));
	saharAirCargoPortDDOption.click();
	manageInvoicePage.enterSpecialInstruction();
	remark1.sendKeys("Testing Remark1 Found ok");
	remark2.sendKeys("Testing Remark2 Found ok");



}

public void selectItemDeatilsItemFromDropdown() throws InterruptedException {
	itemdropdown.click();
	inputFieldItemdropdown.sendKeys("41700");
	Thread.sleep(2000);
	firstResultItemdropdown.click();
}

public void enterItemQty() throws InterruptedException {
	stockQty.click();
	wait.until(ExpectedConditions.elementToBeClickable(enteredQty));
	enteredQty.sendKeys("11");
	Thread.sleep(2000);
	confirmButton.click();

}

public void enterNetWeight() throws InterruptedException {
	netWeight.sendKeys("500");
		}

public void enterItemCodeDetailsExcepts_PackageSrNo() throws InterruptedException {

	grossWeight.sendKeys("700");
	//packageSrNoR1.click();
	//packageSrNoR1.sendKeys("41700");
	Qty1.click();
	Qty1.sendKeys("11");
	netWeight1.click();
	netWeight1.sendKeys("700");
	grossWeight1.click();
	grossWeight1.sendKeys("935");

}


public void enterItemCodeDetailsinvalid() throws InterruptedException {

	grossWeight.sendKeys("700");
	packageSrNoR1.click();
	packageSrNoR1.sendKeys("41700");
	Qty1.click();
	Qty1.sendKeys("1100");
	netWeight1.click();
	netWeight1.sendKeys("700");
	grossWeight1.click();
	grossWeight1.sendKeys("935");

}
//Enter gross Weight for item code- 41700
public void enterItemCodeDetails_ExceptGrossWeight() throws InterruptedException {

	grossWeight.sendKeys("700");
	packageSrNoR1.click();
	packageSrNoR1.sendKeys("41700");
	Qty1.click();
	Qty1.sendKeys("11");
	netWeight1.click();
	netWeight1.sendKeys("700");
//	grossWeight1.click();
//	grossWeight1.sendKeys("935");

}

//Enter Net Weight for item code- 41700

public void enterItemCodeDetails_ExceptNetWeight() throws InterruptedException {

	grossWeight.sendKeys("700");
	packageSrNoR1.click();
	packageSrNoR1.sendKeys("41700");
	Qty1.click();
	Qty1.sendKeys("11");
//	netWeight1.click();
//	netWeight1.sendKeys("700");
	grossWeight1.click();
	grossWeight1.sendKeys("935");

}

public void enterItemCodeDetails_ExceptQty() throws InterruptedException {

	grossWeight.sendKeys("700");
	packageSrNoR1.click();
	packageSrNoR1.sendKeys("41700");
//	Qty1.click();
//	Qty1.sendKeys("11");
	netWeight1.click();
	netWeight1.sendKeys("700");
	grossWeight1.click();
	grossWeight1.sendKeys("935");

}

public void enterItemCodeDetailswithvalid() throws InterruptedException {

	grossWeight.sendKeys("700");
	packageSrNoR1.click();
	packageSrNoR1.sendKeys("41700");
	Qty1.click();
	Qty1.sendKeys("11");
	netWeight1.click();
	netWeight1.sendKeys("700");
	grossWeight1.click();
	grossWeight1.sendKeys("935");

}















}



