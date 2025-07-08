package com.erp.automation.tests.sales;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.automation.base.BasePage;
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

public class ManageInvoicePageValidationTest {

	WebDriver driver;
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
	BasePage basePage;

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
		allMaterialTransactionSubModules = new AllMaterialTransactionSubModules(driver);
		outwardRegister = new OutwardRegister(driver);
		manageExportInvoicePage = new ManageExportInvoicePage(driver);
		basePage = new BasePage(driver);
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
		// ==================================================
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();
		invoicePage.clickOnAddInvoice();
		invoicePage.selectDomesticInvoiceTypeFromPopUp();
	}

	@Test(enabled = true, priority = 1)
	public void TC001_testCustomerField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getCustomerFieldError(), "Please Select Customer",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 2)
	public void TC002_testSOTypeField_EmptyValidationMessageDisplayed() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getSONOTypeFieldError(), "Please Enter SO Type@",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 3)
	public void TC003_testSONOField_EmptyValidationMessageDisplayed() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getSONOFieldError(), "Please Select SO #",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 4)
	public void TC004_testcustomerPoNoerrorField_EmptyValidationMessageDisplayed() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.customerPoNoerrorFieldError(), "Please Enter Customer PO #",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");
	}

	@Test(enabled = true, priority = 5)
	public void TC005_testcustomerPoNoerrorField_DisabledValidationMessageDisplayed() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		System.out.println(manageInvoicePage.isCustomerPoNoFieldDisabled());
		Assert.assertFalse(manageInvoicePage.isCustomerPoNoFieldDisabled(),
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");
	}

	@Test(enabled = true, priority = 6)
	public void TC006_testInvoiceDateIsCurrentDate() {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		// Get the invoice date from the UI
		String invoiceDateStr = manageInvoicePage.getInvoiceDateFromField();

		// Get current system date in the same format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Adjust if needed
		System.out.println("Value of Date Time Formatter = " + formatter);
		String currentDateStr = LocalDate.now().format(formatter);
		System.out.println("Value of Current Date = " + currentDateStr);

		// Compare dates
		Assert.assertEquals(invoiceDateStr, currentDateStr,
				"**** test case = " + methodName + " => fail (Invoice Date mismatch) ****");
	}

	@Test(enabled = true, priority = 7)
	public void TC007_testInvoiceFinancialDateIsCurrentFY() {
		// Get method name for reporting
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		// Get the invoice date from the UI
		String FinancialYearStr = manageInvoicePage.getTextFincialYearField();

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

		System.out.println("**** Test Case: " + methodName + " => PASS (Financial Year matches current FY) ****");
	}

	@Test(enabled = true, priority = 8)
	public void TC008_testFinancialYearField_Disabled() {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		System.out.println(manageInvoicePage.isfinancialYearFieldDisabled());
		Assert.assertFalse(manageInvoicePage.isfinancialYearFieldDisabled(),
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");
	}

	@Test(enabled = true, priority = 9)
	public void TC009_transporterField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getTransporterFieldError(), "Please Select Transporter",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 10)
	public void TC010_transporterModeField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getTransporterModeFieldError(), "Please Select Transporter Mode",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 11)
	public void TC011_shippingStateCodeField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getShippingStateCodeFieldError(), "Please Enter Shipping State Code",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true, priority = 12)
	public void TC012_shippingStateField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getShippingStateFieldError(), "Please Select Shipping State",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}


	@Test(enabled = true,priority = 13)
	public void TC013_shippingCityField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getShippingCityFieldError(), "Please Select Shipping City",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true,priority = 14)
	public void TC014_shippingPinCodeField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getShippingPinCodeFieldError(), "Please Enter Shipping Pin Code",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true,priority = 15)
	public void TC015_specialInstructionField_EmptyValidationMessageDisplayed() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		basePage.scrollToBottom();
		manageInvoicePage.saveInvoice();
		basePage.scrollToTop();

		Assert.assertEquals(manageInvoicePage.getSpecialInstructionFieldError(), "Please Enter Special Instruction",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test(enabled = true,priority = 16)
	public void TC016_ShippingCustomerField_ValidatingAutoPopulatedText() throws InterruptedException {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.enterShippingCustomerField(), "ZF India Private Limited  (Chakan)",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test (enabled=true,priority = 17)
	public void TC017_ShippingAddressField_ValidatingAutoPopulatedText () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.getShippingAddressField(), "B-38, Chakan Industrial Area, ,Phase II ,Village Vasuli , Chakan,Tal. Khed,Pune - 410501,Maharashtra,India",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test (enabled=true,priority = 18)
	public void TC018_ShippingStateCodeField_ValidatingAutoPopulatedText () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.getShippingCodeStateField(), "27",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	@Test (enabled=true,priority =19)
	public void TC019_GSTField_ValidatingAutoPopulatedText () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.getGSTField(), "27AAACZ3052C1ZN",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}


	@Test (enabled=true,priority =20)
	public void TC020_getFreightField_ValidatingAutoPopulatedText () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.getFreightField(), " To Pay ",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}


	@Test (enabled=true,priority =21)
	public void TC021_testCustomerPOField_ValidatingAutoPopulatedText () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		Assert.assertEquals(manageInvoicePage.getCustomerPoField(), "123456",
				"**** test case =" + methodName + " => fail ****");

		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	//Warning PopUp Should be visible after click on Save Button.
	@Test (enabled=true,priority =22)
	public void TC022_testWarningPopUp_ValidatingVisibilityOfPopUp () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		manageInvoicePage.selectTransporter();
		manageInvoicePage.enterSpecialInstruction();
		manageInvoicePage.selectItemDropdownAndFillItemDetails();
		manageInvoicePage.saveInvoice();

		Assert.assertEquals(manageInvoicePage.getTextFromWarningPopUp(), "Warning",
				"**** test case =" + methodName + " => fail ****");

		Assert.assertTrue(manageInvoicePage.getVisibilityOfWarningPopUp(),
				"**** test case =" + methodName + " => fail ****");

		manageInvoicePage.performActionOnPopupafterSave();
		manageInvoicePage.FinalPopupOkButton();
		Thread.sleep(4000);
		System.out.println("##@Test--> " + methodName + "-->Pass##");

	}

	//Error message visible after user trying to save invoice without item details.

	@Test (enabled=true,priority =23)
	public void TC023_testItemDetails_ValidatingErrorMessageWhenWithoutItemDetails () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		manageInvoicePage.selectTransporter();
		manageInvoicePage.enterSpecialInstruction();
		//manageInvoicePage.selectItemDropdownAndFillItemDetails();
		manageInvoicePage.saveInvoice();
		Thread.sleep(3000);

		Assert.assertEquals(manageInvoicePage.getErrorTextFromErrorText(),
				"Enter Atleast 1 Item",
				"**** test case =" + methodName + " => fail ****");

		Assert.assertTrue(manageInvoicePage.getVisibilityOfErrorText(),
				"**** test case =" + methodName + " => fail ****");

//		manageInvoicePage.performActionOnPopupafterSave();
//		manageInvoicePage.FinalPopupOkButton();
//		Thread.sleep(4000);
		System.out.println("----------------////////////-----------");

		System.out.println("##@Test--> " + methodName + "-->Pass##");
}

	//Success PopUp Should be visible after click in OK Button from Warning PopUp.

	@Test (enabled=true,priority =24)
	public void TC024_testSucessPopUp_ValidatingVisibilityOfPopUp () throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		manageInvoicePage.selectTransporter();
		manageInvoicePage.enterSpecialInstruction();
		manageInvoicePage.selectItemDropdownAndFillItemDetails();
		manageInvoicePage.saveInvoice();

		manageInvoicePage.performActionOnPopupafterSave();

		Assert.assertEquals(manageInvoicePage.getTextFromSuccessPopUp(), "Success!",
				"**** test case =" + methodName + " => fail ****");

		Assert.assertTrue(manageInvoicePage.getVisibilityOfSuccessPopUp(),
				"**** test case =" + methodName + " => fail ****");

		manageInvoicePage.getInvoiceNumberFromSuccessPopUp();
	//	manageInvoicePage.FinalPopupOkButton();
		Thread.sleep(4000);
		System.out.println("##@Test--> " + methodName + "-->Pass##");
	}

	//Verify Generation of Invoice No After Invoice Creation.

	@Test (enabled=true,priority =25)
	public void TC025_testInvoiceNo_ValidatingVisibilityOfInvoiceNumber() throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		manageInvoicePage.selectTransporter();
		manageInvoicePage.enterSpecialInstruction();
		manageInvoicePage.selectItemDropdownAndFillItemDetails();
		manageInvoicePage.saveInvoice();

		manageInvoicePage.performActionOnPopupafterSave();

		Assert.assertEquals(manageInvoicePage.getTextFromSuccessPopUp(), "Success!",
				"**** test case =" + methodName + " => fail ****");

		Assert.assertTrue(manageInvoicePage.getVisibilityOfSuccessPopUp(),
				"**** test case =" + methodName + " => fail ****");

		manageInvoicePage.getOnlyInvoiceNumberFromSuccessPopUp();

		Assert.assertTrue(manageInvoicePage.invoiceNoVisibility(),
				"**** test case =" + methodName + " => fail ****");

		manageInvoicePage.FinalPopupOkButton();
		Thread.sleep(4000);

		System.out.println("##@Test--> " + methodName + "-->Pass##");


	}

	@Test (enabled=true,priority =26)
	public void TC026_testInvoiceQTYShouldNotZero_ValidationOfInvoiceQty() throws InterruptedException {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		manageInvoicePage.enterValueInCustomerField();
		manageInvoicePage.selectSOField();

		manageInvoicePage.selectTransporter();
		manageInvoicePage.enterSpecialInstruction();
		manageInvoicePage.selectItemDropdownAndFillItemDetails_ZeroQTY();
		manageInvoicePage.saveInvoice();

		//manageInvoicePage.performActionOnPopupafterSave();

		Assert.assertEquals(manageInvoicePage.getTextFromErrorToastMessage(), "Invoice Qty cannot be zero",
				"**** test case =" + methodName + " => fail ****");

		Assert.assertTrue(manageInvoicePage.getVisibilityOfErrorToastMessage(),
				"**** test case =" + methodName + " => fail ****");
//
//		manageInvoicePage.getOnlyInvoiceNumberFromSuccessPopUp();
//
//		Assert.assertTrue(manageInvoicePage.invoiceNoVisibility(),
//				"**** test case =" + methodName + " => fail ****");
//
//		manageInvoicePage.FinalPopupOkButton();
//		Thread.sleep(4000);
//
		System.out.println("##@Test--> " + methodName + "-->Pass##");


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
