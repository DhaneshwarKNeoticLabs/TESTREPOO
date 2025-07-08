package com.erp.automation.pages.sales;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class CustomersPage {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	//customers list page

	@FindBy (xpath="//button[@id='btnAddNewCustomer']")
	private WebElement addNewCustomer;

	//customers Detail page

	//Organization Details

	@FindBy (xpath="//input[@id='txtName']")
	private WebElement customerName;

	@FindBy (xpath="//input[@id='txtCustCode']")
	private WebElement vendorCode;

	@FindBy (xpath="//span[@id='select2-ddlCompPaymentTerm-container']")
	private WebElement componentPaymentTerm;

	@FindBy (xpath="/html/body/section/div/form/div[1]/div[1]/div[2]/div[2]/div[1]/select/option[3]")
	private WebElement componentPaymentTerm45Days;

	@FindBy (xpath="//input[@id='CustEmailId']")
	private WebElement emailID;

	@FindBy (xpath="//div[@class='col-md-2 form-group']//ul[@class='select2-selection__rendered']")
	private WebElement plantDD;

	@FindBy (xpath="/html/body/section/div/form/div[1]/div[1]/div[2]/div[2]/div[3]/select/option[3]")
	private WebElement plantTwoOptionFromDD;

	@FindBy (xpath="//ins[@class='iCheck-helper']")
	private WebElement isActiveRadioButton;

	// Address Details

	@FindBy (xpath="//span[@id='select2-ddlCustSegment-container']")
	private WebElement customerSegment;

	@FindBy (xpath="//li[text()='APAC-Asia pacific']")
	private WebElement customerSegmentAPACAsiapacific;

	@FindBy (xpath="//span[@id='select2-ddlCountry-container']")
	private WebElement countryDD;

	@FindBy (xpath="//li[text()='India']")
	private WebElement countryIndiaOption;

	@FindBy (xpath="//span[@id='select2-ddlState-container']")
	private WebElement stateDD;

	@FindBy (xpath="//li[text()='Maharashtra / 27']")
	private WebElement maharashtraOption;

	@FindBy (xpath="//span[@id='select2-ddlCity-container']")
	private WebElement cityDD;

	@FindBy (xpath="//li[text()='Pune']")
	private WebElement puneOption;

	@FindBy (xpath="//input[@id='txtAddressLine1']")
	private WebElement addressLineOne;

	@FindBy (xpath="//input[@id='txtAddressLine2']")
	private WebElement addressLineTwo;

	@FindBy (xpath="//input[@id='txtAddressLine3']")
	private WebElement addressLineThree;

	@FindBy (xpath="//input[@id='txtPinCode']")
	private WebElement pincode;

	@FindBy (xpath="//input[@id='txtPhoneNo']")
	private WebElement mobileNo;

	@FindBy (xpath="//input[@id='txtFAX']")
	private WebElement faxNo;

	@FindBy (xpath="//span[@class='select2 select2-container select2-container--default']//ul[@class='select2-selection__rendered']")
	private WebElement transporter;

	@FindBy (xpath="//li[text()='Amol Transport']")
	private WebElement amolTransport;

	@FindBy (xpath="//input[@id='PanNo']")
	private WebElement pan;

	@FindBy (xpath="//span[@id='select2-ddlCurrency-container']")
	private WebElement currencyDD;

	@FindBy (xpath="//li[text()='INR']")
	private WebElement inrCurrencyOption;

	// GST Details


	@FindBy (xpath="//input[@id='txtREGNNo']")
	private WebElement regNumber;

	@FindBy (xpath="//span[@id='select2-ddlSuppType-container']")
	private WebElement supplyType;

	@FindBy (xpath="//li[text()='B2B']")
	private WebElement supplyTypeB2B;

	@FindBy (xpath="//input[@id='txtTradeName']")
	private WebElement tradeName;

	@FindBy (xpath="//input[@id='txtLegalName']")
	private WebElement legalName;

	@FindBy (xpath="(//input[@type='file'])[1]")
	private WebElement uploadFileTDSDeclaration;

	@FindBy (xpath="(//input[@type='file'])[2]")
	private WebElement uploadFileGSTCertificate;

	// Bank Details

	@FindBy (xpath="//input[@id='txtBankName']")
	private WebElement bankName;

	@FindBy (xpath="//input[@id='txtAccountNo']")
	private WebElement accountNo;

	@FindBy (xpath="//input[@id='txtIFSCCode']")
	private WebElement IFSCNo;

	// Terms And Conditions

	@FindBy (xpath="/html/body/section/div/form/div[1]/div[4]/div[2]/div[1]/div[1]/span/span[1]/span/span[1]")
	private WebElement paymentMode;

	@FindBy (xpath="//li[text()=' RTGS ']")
	private WebElement rtgs;

	@FindBy (xpath="//input[@id='txtpayCyle']")
	private WebElement paymentCycle;

	@FindBy (xpath="/html/body/section/div/form/div[1]/div[4]/div[2]/div[1]/div[3]/span/span[1]/span/span[1]")
	private WebElement deliveryTerms;

	@FindBy (xpath="//li[text()='Warehouse Delivery']")
	private WebElement wearhouseDeliveryTerms;

	@FindBy (xpath="//input[@id='txtGracePeriod']")
	private WebElement gracePeriod;

	@FindBy (xpath="//textarea[@id='txtSpecialInstructions']")
	private WebElement specialInstructions;

	@FindBy (xpath="//span[@id='select2-DestinationId-container']")
	private WebElement transportDestinationOfCustomerDD ;

	@FindBy (xpath="//li[text()='Pune']")
	private WebElement puneTransportDestinationDDOption;

	@FindBy (xpath="//input[@id='txtGRNGracePeriod']")
	private WebElement GRNGracePeriod;

	@FindBy (xpath="//textarea[@id='txtRemark']")
	private WebElement remark;

	// customer POC Tab


	@FindBy (xpath="//button[@id='btnAddCustomerPoc']")
	private WebElement addCustomerPOCDetails;


	@FindBy (xpath="//input[@id='txtNameForPOC']")
	private WebElement name;


	@FindBy (xpath="//select[@id='ddlDepartmentForPOC']")
	private WebElement departmentDD;

//	Select d =new Select(departmentDD);
//	d.SelectByText();
//
	@FindBy (xpath="/html/body/section/div/form/div[1]/div[5]/div/div/div[1]/div/div/table/tbody/tr/td[2]/select/option[33]")
	private WebElement salesDepartmentDDOption;

	@FindBy (xpath="//select[@id='ddlDesignationForPOC']")
	private WebElement designationDD;

	@FindBy (xpath="//option[text()='AGM - Finance']")
	private WebElement designationDDOption;

	@FindBy (xpath="//input[@id='txtMobileForPOC']")
	private WebElement mobile;

	@FindBy (xpath="//input[@id='txtEmailForPOC']")
	private WebElement email;

	@FindBy (xpath="//input[@id='txtInfoForPOC']")
	private WebElement remarkcustPOC;

	//customer Item Detail

	@FindBy (xpath="//a[@id='ui-id-3']")
	private WebElement customerItemDetailSection;


	@FindBy (xpath="//button[@id='btnAddItemDetails']")
	private WebElement addButtonCustItemDetail;

	@FindBy (xpath="//input[@id='txtItemCodeForItemDetails']")
	private WebElement itemCode;

	@FindBy (xpath="/html/body/ul[2]/li[1]/div")
	private WebElement firstSuggestionItemCode;

	@FindBy (xpath="//input[@id='txtTheirItemCodeForItemDetails']")
	private WebElement theirItemCode;

	@FindBy (xpath="//input[@id='txtTheirItemNameForItemDetails']")
	private WebElement theirItemName;

	@FindBy (xpath="//input[@id='AmortizationCost']")
	private WebElement amortizationCost;

	@FindBy (xpath="(//input[@id='AmortizationQty'])[1]")
	private WebElement amortizationQty;

	@FindBy (xpath="(//ins[@class='iCheck-helper'])[2]")
	private WebElement isActiveRadioButton2;

	//customer Property

	@FindBy (xpath="//a[@id='ui-id-4']")
	private WebElement customerProperty;

	@FindBy (xpath="//button[@id='btnAddItemCustVendorCodeProperty']")
	private WebElement addButtonCustomerProperty;

	@FindBy (xpath="(//input[@type='text'])[33]")
	private WebElement itemCodeCustomerProperty;

	@FindBy (xpath="/html/body/ul[3]/li[1]/div")
	private WebElement firstSuggestionItemCustomerProperty;

	@FindBy (xpath="(//input[@type='text'])[34]")
	private WebElement theirItemCodeCustmerProperty;

	@FindBy (xpath="(//input[@type='text'])[35]")
	private WebElement theirItemNameCustmerProperty;

	@FindBy (xpath="(//input[@type='text'])[36]")
	private WebElement amortizationCostCustmerProperty;

	@FindBy (xpath="(//input[@id='AmortizationQty'])[2]")
	private WebElement amortizationQtyCustmerProperty;

	@FindBy (xpath="(//ins[@class='iCheck-helper'])[3]")
	private WebElement isActiveRadio;


	//Save&Send for Approve

	@FindBy (xpath="//button[@id='btnSaveSendforapprove']")
	private WebElement saveAndSendForApprove;

	@FindBy (xpath="//button[@class='confirm']")
	private WebElement okButtonFromPopUp;




	// Constructor
	public  CustomersPage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnAddNewCustomerMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addNewCustomer));
		addNewCustomer.click();
//		Thread.sleep(2000);
	}

	public void fillingCustomerProfile(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

		ExcelUtils excel =new ExcelUtils(excelPath, sheetName);
		int rowCount=excel.getRowCount();
		System.out.println(rowCount);


		//Organization Details
		wait.until(ExpectedConditions.elementToBeClickable(customerName));
		customerName.click();
		String customerNamee = excel.getCellData(1, 0);
		customerName.sendKeys(customerNamee);

		wait.until(ExpectedConditions.elementToBeClickable(vendorCode));
		vendorCode.click();
		String vendorCodee = excel.getCellData(1, 1);
		vendorCode.sendKeys(vendorCodee);

		wait.until(ExpectedConditions.elementToBeClickable(componentPaymentTerm));
		componentPaymentTerm.click();
		wait.until(ExpectedConditions.elementToBeClickable(componentPaymentTerm45Days));
		componentPaymentTerm45Days.click();

		wait.until(ExpectedConditions.elementToBeClickable(emailID));
		emailID.click();
		String emailIDD = excel.getCellData(1,2);
		emailID.sendKeys(emailIDD);

		wait.until(ExpectedConditions.elementToBeClickable(plantDD));
		plantDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(plantTwoOptionFromDD));
		plantTwoOptionFromDD.click();
		WebElement PlantTwoInField =driver.findElement(By.xpath("//li[@title='Plant-2']"));
		wait.until(ExpectedConditions.elementToBeClickable(PlantTwoInField));
		PlantTwoInField.click();
		isActiveRadioButton.click();

		//Address Details

		wait.until(ExpectedConditions.elementToBeClickable(customerSegment));
		customerSegment.click();
		wait.until(ExpectedConditions.elementToBeClickable(customerSegmentAPACAsiapacific));
		customerSegmentAPACAsiapacific.click();

		wait.until(ExpectedConditions.elementToBeClickable(countryDD));
		countryDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(countryIndiaOption));
		countryIndiaOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(stateDD));
		stateDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(maharashtraOption));
		maharashtraOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(cityDD));
		cityDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(puneOption));
		puneOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(addressLineOne));
		addressLineOne.click();
		String addressLineOnee = excel.getCellData(1,3);
		addressLineOne.sendKeys(addressLineOnee);

		wait.until(ExpectedConditions.elementToBeClickable(addressLineTwo));
		addressLineTwo.click();
		String addressLineTwoo = excel.getCellData(1,4);
		addressLineTwo.sendKeys(addressLineTwoo);

		wait.until(ExpectedConditions.elementToBeClickable(addressLineThree));
		addressLineThree.click();
		String addressLineThreee = excel.getCellData(1,5);
		addressLineThree.sendKeys(addressLineThreee);

		wait.until(ExpectedConditions.elementToBeClickable(pincode));
		pincode.click();
		String pincodee = excel.getCellData(1,6);
		pincode.sendKeys(pincodee);

		wait.until(ExpectedConditions.elementToBeClickable(mobileNo));
		mobileNo.click();
		String mobileNoo = excel.getCellData(1,7);
		mobileNo.sendKeys(mobileNoo);

		wait.until(ExpectedConditions.elementToBeClickable(faxNo));
		faxNo.click();
		String faxNoo = excel.getCellData(1,8);
		faxNo.sendKeys(faxNoo);

		wait.until(ExpectedConditions.elementToBeClickable(transporter));
		transporter.click();
		wait.until(ExpectedConditions.elementToBeClickable(amolTransport));
		amolTransport.click();

		wait.until(ExpectedConditions.elementToBeClickable(pan));
		pan.click();
		String pann = excel.getCellData(1,9);
		pan.sendKeys(pann);

		wait.until(ExpectedConditions.elementToBeClickable(currencyDD));
		currencyDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(inrCurrencyOption));
		inrCurrencyOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(regNumber));
		regNumber.click();
		String regNumberr = excel.getCellData(1,10);
		regNumber.sendKeys(regNumberr);

		wait.until(ExpectedConditions.elementToBeClickable(supplyType));
		supplyType.click();
		wait.until(ExpectedConditions.elementToBeClickable(supplyTypeB2B));
		supplyTypeB2B.click();

		wait.until(ExpectedConditions.elementToBeClickable(tradeName));
		tradeName.click();
		String tradeNamee = excel.getCellData(1,11);
		tradeName.sendKeys(tradeNamee);

		//Attachment Functionality

		wait.until(ExpectedConditions.elementToBeClickable(legalName));
		legalName.click();
		String legalNamee = excel.getCellData(1,12);
		legalName.sendKeys(legalNamee);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileNo);

		// Define the file path
		File uploadFile = new File("C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\GeneralInvoiceReportt.pdf");

		// Wait until the file input element is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement TDSDeclearation = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DeclarationFile")));

		// Send the file path to the hidden input field
		TDSDeclearation.sendKeys(uploadFile.getAbsolutePath());

		System.out.println("File uploaded successfully!-DeclarationFile");


		WebElement GSTCertificate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("GstFileName")));

		// Send the file path to the hidden input field
		GSTCertificate.sendKeys(uploadFile.getAbsolutePath());

		System.out.println("File uploaded successfully!-GST File");


	 //Bank Details

		wait.until(ExpectedConditions.elementToBeClickable(bankName));
		bankName.click();
		String bankNamee = excel.getCellData(1,13);
		bankName.sendKeys(bankNamee);

		wait.until(ExpectedConditions.elementToBeClickable(accountNo));
		accountNo.click();
		String accountNoo = excel.getCellData(1,14);
		accountNo.sendKeys(accountNoo);

		wait.until(ExpectedConditions.elementToBeClickable(IFSCNo));
		IFSCNo.click();
		String IFSCNoo = excel.getCellData(1,15);
		IFSCNo.sendKeys(IFSCNoo);

	//Terms And Conditions

		wait.until(ExpectedConditions.elementToBeClickable(paymentMode));
		paymentMode.click();
		wait.until(ExpectedConditions.elementToBeClickable(rtgs));
		rtgs.click();

		wait.until(ExpectedConditions.elementToBeClickable(paymentCycle));
		String paymentCyclee = excel.getCellData(1,16);
		paymentCycle.sendKeys(paymentCyclee);

		wait.until(ExpectedConditions.elementToBeClickable(deliveryTerms));
		deliveryTerms.click();
		wait.until(ExpectedConditions.elementToBeClickable(wearhouseDeliveryTerms));
		wearhouseDeliveryTerms.click();

		wait.until(ExpectedConditions.elementToBeClickable(gracePeriod));
		String gracePeriodd = excel.getCellData(1,17);
		gracePeriod.sendKeys(gracePeriodd);

		wait.until(ExpectedConditions.elementToBeClickable(specialInstructions));
		String specialInstructionss = excel.getCellData(1,18);
		specialInstructions.sendKeys(specialInstructionss);

		wait.until(ExpectedConditions.elementToBeClickable(transportDestinationOfCustomerDD));
		transportDestinationOfCustomerDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(puneTransportDestinationDDOption));
		puneTransportDestinationDDOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(GRNGracePeriod));
		String GRNGracePeriodd = excel.getCellData(1,19);
		GRNGracePeriod.sendKeys(GRNGracePeriodd);

		wait.until(ExpectedConditions.elementToBeClickable(remark));
		remark.click();
		remark.sendKeys("Automation Testing Remark");

		//Customer POC
		wait.until(ExpectedConditions.elementToBeClickable(addCustomerPOCDetails));
		addCustomerPOCDetails.click();

		wait.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys("Pranit Patil");

		wait.until(ExpectedConditions.elementToBeClickable(departmentDD));
		departmentDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(salesDepartmentDDOption));
		salesDepartmentDDOption.click();

		wait.until(ExpectedConditions.elementToBeClickable(designationDD));
		designationDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(designationDDOption));
		designationDDOption.click();
		mobile.sendKeys("9858989622");
		email.sendKeys("testpranit@patilp.com");
		remarkcustPOC.sendKeys("Test POC name added");

	//Customer Item Details
		wait.until(ExpectedConditions.elementToBeClickable(customerItemDetailSection));
		customerItemDetailSection.click();

		wait.until(ExpectedConditions.elementToBeClickable(addButtonCustItemDetail));
		addButtonCustItemDetail.click();

		wait.until(ExpectedConditions.elementToBeClickable(itemCode));
		String itemCodee = excel.getCellData(1,20);
		itemCode.sendKeys(itemCodee);

		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(firstSuggestionItemCode));
		firstSuggestionItemCode.click();

		wait.until(ExpectedConditions.elementToBeClickable(theirItemCode));
		String theirItemCodee = excel.getCellData(1,21);
		theirItemCode.sendKeys(theirItemCodee);

//		wait.until(ExpectedConditions.elementToBeClickable(theirItemName));
//		String theirItemNamee = excel.getCellData(1,22);
//		theirItemName.sendKeys(theirItemNamee);

		wait.until(ExpectedConditions.elementToBeClickable(amortizationCost));
		String amortizationCostt = excel.getCellData(1,23);
		amortizationCost.sendKeys(amortizationCostt);

		wait.until(ExpectedConditions.elementToBeClickable(amortizationQty));
		String amortizationQtyy = excel.getCellData(1,24);
		amortizationQty.sendKeys(amortizationQtyy);
		isActiveRadioButton2.click();

	//customer Property Section
		customerProperty.click();

		wait.until(ExpectedConditions.elementToBeClickable(addButtonCustomerProperty));
		addButtonCustomerProperty.click();

		wait.until(ExpectedConditions.elementToBeClickable(itemCodeCustomerProperty));
		String itemCodeCustomerPropertyy = excel.getCellData(1,20);
		itemCodeCustomerProperty.sendKeys(itemCodeCustomerPropertyy);

		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(firstSuggestionItemCustomerProperty));
		firstSuggestionItemCustomerProperty.click();

		wait.until(ExpectedConditions.elementToBeClickable(theirItemCodeCustmerProperty));
		String theirItemCodeCustmerPropertyy = excel.getCellData(1,21);
		theirItemCodeCustmerProperty.sendKeys(theirItemCodeCustmerPropertyy);

//		wait.until(ExpectedConditions.elementToBeClickable(theirItemNameCustmerProperty));
//		String theirItemNameCustmerPropertyy = excel.getCellData(1,22);
//		theirItemNameCustmerProperty.sendKeys(theirItemNameCustmerPropertyy);

		wait.until(ExpectedConditions.elementToBeClickable(amortizationCostCustmerProperty));
		String amortizationCostCustmerPropertyy = excel.getCellData(1,23);
		amortizationCostCustmerProperty.sendKeys(amortizationCostCustmerPropertyy);

		wait.until(ExpectedConditions.elementToBeClickable(amortizationQtyCustmerProperty));
		String amortizationQtyCustmerPropertyy = excel.getCellData(1,24);
		amortizationQtyCustmerProperty.sendKeys(amortizationQtyCustmerPropertyy);
		isActiveRadio.click();

		saveAndSendForApprove.click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(okButtonFromPopUp));
		okButtonFromPopUp.click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(okButtonFromPopUp));
		okButtonFromPopUp.click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(okButtonFromPopUp));
		okButtonFromPopUp.click();


	}

}
