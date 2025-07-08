package com.erp.automation.tests.sales;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.automation.base.BaseTest;
import com.erp.automation.base.WebDriverManagerClass;
import com.erp.automation.pages.LogOutPage;
import com.erp.automation.pages.LoginPage;
import com.erp.automation.pages.ToggleMenus;
import com.erp.automation.pages.materialTransaction.AllMaterialTransactionSubModules;
import com.erp.automation.pages.materialTransaction.OutwardRegister;
import com.erp.automation.pages.purchase.SelectPlant;
import com.erp.automation.pages.sales.AllSalesSubModules;
import com.erp.automation.pages.sales.InvoicePage;
import com.erp.automation.pages.sales.ManageExportInvoicePage;
import com.erp.automation.pages.sales.ManageInvoicePage;
import com.erp.automation.utils.ConfigReader;

public class ManageExportInvoicePageValidationTest extends BaseTest{







	//WebDriver driver;
	SelectPlant selectPlant;
	ToggleMenus toggleMenus;
	LogOutPage logOutPage;
	AllSalesSubModules allSalesSubModules;
	InvoicePage invoicePage;
	ManageInvoicePage manageInvoicePage;
	String sheetName;
	String excelPath;
	AllMaterialTransactionSubModules allMaterialTransactionSubModules;
	OutwardRegister outwardRegister;
	ManageExportInvoicePage manageExportInvoicePage;

	@BeforeClass
	public void launchErpSite() throws InterruptedException {

		driver = WebDriverManagerClass.getDriver(); // Get WebDriver instance
	
		 String baseUrl = ConfigReader.get("baseUrl");
	       driver.get(baseUrl);
		//driver.get("http://192.168.2.5/ACCSSPLDRYRUN/");
		Thread.sleep(3000);
		selectPlant = new SelectPlant(driver);
		toggleMenus = new ToggleMenus(driver);
		logOutPage = new LogOutPage(driver);
		allSalesSubModules = new AllSalesSubModules(driver);
		invoicePage = new InvoicePage(driver);
		manageInvoicePage = new ManageInvoicePage(driver);
		allMaterialTransactionSubModules =new AllMaterialTransactionSubModules(driver);
		outwardRegister =new OutwardRegister(driver);
		manageExportInvoicePage = new ManageExportInvoicePage (driver);
		System.out.println("ERP site launched");
		// -------------------------------------

	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(3000);
		System.out.println("Logged in to application");
		selectPlant.selectPlantTwo();
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();
		invoicePage.clickOnAddInvoice();
		invoicePage.selectExportInvoiceTypeFromPopUp();
	}

	// Export Invoice-ExportPowerCor

	@Test  (enabled = false,priority=1)
	public void TC001_invoiceCreationTestExportPowerCor() throws InterruptedException {

		// Get method name for reporting
				String methodName = new Object() {
				}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.createExportInvoicePowerCorAssertionTestScript();
		System.out.println("#### ---- invoice saved successfully for Powercor => ---- ####");
		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	// Financial Year should always be current Financial year
	@Test (enabled = true,priority = 2)
	public void TC002_testFinancialYearValidation_AlwaysShowsCurrentFY() {

		// Get method name for reporting
				String methodName = new Object() {
				}.getClass().getEnclosingMethod().getName();

				// Get the invoice date from the UI
				String FinancialYearStr = manageExportInvoicePage.getTextFincialYearField();

				System.out.println("Financial Year from UI: " + FinancialYearStr);

				// Calculate the current Financial Year
				LocalDate today = LocalDate.now();
				int year = today.getYear();
				int startYear;
				int endYear;

				if (today.getMonthValue() >= 4) {
					startYear = year;
					endYear = year + 1;
				} else {
					startYear = year - 1;
					endYear = year;
				}

				String expectedFY = startYear + "-" + endYear;
				System.out.println("Expected Financial Year: " + expectedFY);

				// Validate
				Assert.assertEquals(FinancialYearStr, expectedFY,
						"**** Test Case: " + methodName + " => FAIL (Financial Year mismatch) ****");

				System.out.println("#### Test Case: " + methodName + " => PASS (Financial Year matches current FY) ####");

	}

	@Test(enabled = true, priority = 3)
	public void TC003_testInvoiceDateIsCurrentDate() {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		// Get the invoice date from the UI
		String invoiceDateStr = manageExportInvoicePage.getInvoiceDateFromField();
		// Get current system date in the same format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Adjust if needed
		System.out.println("Value of Date Time Formatter = " + formatter);
		String currentDateStr = LocalDate.now().format(formatter);
		System.out.println("Value of Current Date = " + currentDateStr);
		// Compare dates
		Assert.assertEquals(invoiceDateStr, currentDateStr,
				"#### test case = " + methodName + " => fail (Invoice Date mismatch) ####");
		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test(enabled = true, priority = 4)
	public void TC004_visibilityOfCustomerPONoAfterSelectingSONo() throws InterruptedException {

		// Get method name for reporting
		String methodName = new Object() {
				}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();

		Assert.assertEquals(manageExportInvoicePage.getValueFromCustomerPONoField(), "CO/PO/SO/23577x",
				"**** test case = " + methodName + " => fail  ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled = true,priority=5)
	public void TC005_visibilityofShippingCustomerAfterSelectingSONo() throws InterruptedException {

		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromShippingCustomerField();

		Assert.assertEquals(manageExportInvoicePage.getValueFromShippingCustomerField(),
				"Powercor Manufacturing (A Divison of Linamar Corporation)",
				"**** test case = " + methodName + " => fail  ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled = true,priority=6)
	public void TC006_visibilityofShippingAddressAfterSelectingSONo() throws InterruptedException {

		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromShippingAddressField();

		Assert.assertEquals(manageExportInvoicePage.getValueFromShippingAddressField(),
				"A Division Of Linamar Corporation,,545 Elmira Road,,Guelph - N1K1C2,Ontario,Canada",
				"**** test case = " + methodName + " => fail  ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled = true,priority=7)
	public void TC007_visibilityofShippingStateCodeAfterSelectingSONo() throws InterruptedException {

		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromShippingStateCodeField();

		Assert.assertEquals(manageExportInvoicePage.getValueFromShippingStateCodeField(),
				"ONTO",
				"**** test case = " + methodName + " => fail  ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled = true,priority=8)
	public void TC008_visibilityofFreightAfterSelectingSONo() throws InterruptedException {

		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromFreightField();

		Assert.assertEquals(manageExportInvoicePage.getValueFromFreightField(),
				" To Pay ",
				"**** test case = " + methodName + " => fail  ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled =true,priority=9)
	public void TC009_TransporterErrorMessageValidation() {

		// Get method name for reporting
				String methodName = new Object() {
				}.getClass().getEnclosingMethod().getName();

				manageInvoicePage.saveInvoice();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageInvoicePage.getTransporterElement());
				manageExportInvoicePage.getTransporterErrorMessageValidation();
				Assert.assertEquals(manageExportInvoicePage.getTransporterErrorMessageValidation(),
						"Please Select Transporter Mode",
						"**** test case = " + methodName + " => fail  ****");

				System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=10)
	public void TC010_OtherReferenceErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());
		manageExportInvoicePage.getErrorMessageFromOtherReferencesField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromOtherReferencesField(),
				"Please Enter Other References",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=11)
	public void TC011_shippingCustomerErrorMessageValidation() throws InterruptedException {


		//H

		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		//manageExportInvoicePage.selectSoNoField();
		//manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.selectTransporterModeField();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());
		manageExportInvoicePage.getErrorMessageFromShippingCustomerField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromShippingCustomerField(),
				"Shipping Customer Required",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=12)
	public void TC012_PreCarriageByErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());
		manageExportInvoicePage.getErrorMessageFromPreCarriageByField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPreCarriageByField(),
				"Please Enter Pre-Carriage By",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=13)
	public void TC013_PlaceOfReceiptOfPreCarrierErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromPlaceOfReceiptOfPreCarrierField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPlaceOfReceiptOfPreCarrierField(),
				"Please Enter Place of Receipt of Pre-Carrier",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=14)
	public void TC014_VesselVoyageFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromVesselVoyageField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromVesselVoyageField(),
				"Please Enter Vessel/Voyage",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=15)
	public void TC015_PortofLoadingFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromPortofLoadingField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPortofLoadingField(),
				"Please Enter Port of Loading",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=16)
	public void TC016_PortofDischargeFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromPortofDischargeField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPortofDischargeField(),
				"Please Enter Port Of Discharge",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=17)
	public void TC017_PlaceOfDeliveryFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromPlaceOfDeliveryField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPlaceOfDeliveryField(),
				"Please Enter Place Of Delivery",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=18)
	public void TC018_CountryofOriginofGoodsFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromCountryofOriginofGoodsField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromCountryofOriginofGoodsField(),
				"Please Enter Country of Origin Of Goods",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=19)
	public void TC019_CountryofFinalDestinationFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromCountryofFinalDestinationField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromCountryofFinalDestinationField(),
				"Please Enter Final Destination Country",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=20)
	public void TC020_TermsofDeliveryFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromTermsofDeliveryField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromTermsofDeliveryField(),
				"Please Enter Terms of Delivery",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=21)
	public void TC021_ContainerFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromContainerField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromContainerField(),
				"Please Enter Container #",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=22)
	public void TC022_ContainerSealFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromContainerSealField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromContainerSealField(),
				"Please Enter Container Seal #",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=23)
	public void TC023_ESealFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromESealField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromESealField(),
				"Please Enter E-Seal #",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=24)
	public void TC024_SizeFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromSizeField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromSizeField(),
				"Please Enter Size",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=25)
	public void TC025_packingListOrDeliveryNoteFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFrompackingListOrDeliveryNoteField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFrompackingListOrDeliveryNoteField(),
				"Please Enter Packing List Or Delivery Note #",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=26)
	public void TC026_specialInstructionFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromSpecialInstructionField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromSpecialInstructionField(),
				"Please Enter Special Instruction",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=27)
	public void TC027_portFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		//manageExportInvoicePage.selectport();
		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromPortField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromPortField(),
				"Please Select Port",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=28)
	public void TC028_itemDetailsFieldErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getErrorMessageFromItemDetailsField();
		Assert.assertEquals(manageExportInvoicePage.getErrorMessageFromItemDetailsField(),
				"Enter Atleast 1 Item",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=29)
	public void TC029_InvoiceQtyCannotBeZeroErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_InvoiceQtyCannotBeZero();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_InvoiceQtyCannotBeZero(),
				"Invoice Qty cannot be zero",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=30)
	public void TC030_PleaseEnternetWeightErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_PleaseEnternetWeight();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_PleaseEnternetWeight(),
				"Please Enter net Weight",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}


	@Test (enabled=true,priority=31)
	public void TC031_PleaseEnterGrossWeightErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_PleaseEnterGrossWeight();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_PleaseEnterGrossWeight(),
				"Please Enter gross Weight",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");
	}

	@Test (enabled=true,priority=32)
	public void TC032_PackageSrNoForItemCodeErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();
		manageExportInvoicePage.enterItemCodeDetailsExcepts_PackageSrNo();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_PackageSrNoForItemCode();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_PackageSrNoForItemCode(),
				"Enter package se no for item code- 41700",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=33)
	public void TC033_PackageListMismatchForItemCodeErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();
		manageExportInvoicePage.enterItemCodeDetailsinvalid();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_PackingListMismatchForItemCode();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_PackingListMismatchForItemCode(),
				"Packing List mismatch for item code- 41700",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=34)
	public void TC034_EnterGrossWeightForItemCodeErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();
		manageExportInvoicePage.enterItemCodeDetails_ExceptGrossWeight();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_EnterGrossWeightForItemCode();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_EnterGrossWeightForItemCode(),
				"Enter Gross Weight for item code- 41700",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=35)
	public void TC035_EnterNetWeightForItemCodeErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();
		manageExportInvoicePage.enterItemCodeDetails_ExceptNetWeight();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_EnterNetWeightForItemCode();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_EnterNetWeightForItemCode(),
				"Enter Net Weight for item code- 41700",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=36)
	public void TC036_EnterQtyforitemcodeErrorMessageValidation() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();
		manageExportInvoicePage.enterItemCodeDetails_ExceptQty();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getToastmessage_EnterQtyForItemCode();
		Assert.assertEquals(manageExportInvoicePage.getToastmessage_EnterQtyForItemCode(),
				"Enter Qty for item code- 41700",
				"**** test case = " + methodName + " => FAIL ****");

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=37)
	public void TC037_ValidationOfVisibilityOfWarningPopup() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();

		manageExportInvoicePage.enterItemCodeDetailswithvalid();

		manageInvoicePage.saveInvoice();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageExportInvoicePage.getWarningPopUpmessageText();
		Assert.assertEquals(manageExportInvoicePage.getWarningPopUpmessageText(),
				"This Invoice will be generated for Plant Plant-2 ,Are you sure that you want to continue?",
				"**** test case = " + methodName + " => FAIL ****");

		manageExportInvoicePage.clickOnCancelWarningPopup();

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	@Test (enabled=true,priority=38)
	public void TC038_VisibilityofSuccessPopup() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();

		manageExportInvoicePage.enterItemCodeDetailswithvalid();

		manageInvoicePage.saveInvoice();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageInvoicePage.performActionOnPopupafterSave();

		manageExportInvoicePage.getSuccessPopUpmessageText();

		Assert.assertEquals(manageExportInvoicePage.getSuccessPopUpmessageText(),
				"Success!",
				"**** test case = " + methodName + " => FAIL ****");

		manageExportInvoicePage.clickOnOkButtonFromSuccessPopup();

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}

	//Generation of Export Invoice NO
	@Test (enabled=true,priority=39)
	public void TC039_GenerationofExportInvoiceNO() throws InterruptedException {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageExportInvoicePage.enterCustomerField();
		manageExportInvoicePage.selectSoNoField();
		manageExportInvoicePage.getValueFromCustomerPONoField();
		manageExportInvoicePage.selectport();
		manageExportInvoicePage.fillAllValuesInExportInvoiceExceptItemDetails();
		manageExportInvoicePage.selectItemDeatilsItemFromDropdown();
		manageExportInvoicePage.enterItemQty();
		manageExportInvoicePage.enterNetWeight();

		manageExportInvoicePage.enterItemCodeDetailswithvalid();

		manageInvoicePage.saveInvoice();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageExportInvoicePage.getOtherReferenceElement());

		manageInvoicePage.performActionOnPopupafterSave();

		manageExportInvoicePage.getSuccessPopUpMessageAllText();

		String expectedSubstring = "Invoice # EX";


		Assert.assertTrue(manageExportInvoicePage.getSuccessPopUpMessageAllText().contains(expectedSubstring),
					"**** test case = " + methodName + " => FAIL ****");

		manageExportInvoicePage.clickOnOkButtonFromSuccessPopup();

		System.out.println("#### Test Case: " + methodName + " => PASS ####");

	}






	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		logOutPage.clickOnProfileIconAndLogOut();
		Thread.sleep(1000);

		System.out.println("After method execution-logout successfully done");
		System.out.println("===============================================");


	}

	@AfterClass
	public void afterClass() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebDriverManagerClass.quitDriver(); // Quit the WebDriver
		System.out.println("Browser closed");
	}








}
