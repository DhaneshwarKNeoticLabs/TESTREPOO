package com.erp.automation.tests.sales;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
import com.erp.automation.utils.ExcelUtils;

public class ExportInvoiceCreationWithAssertions {

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
	}
	// Export Invoice-ExportPowerCor
	@Test  (enabled = true)
	public void ExportInvoicePowerCorCreationWithAssertions() throws InterruptedException {
		selectPlant.selectPlantTwo();
		System.out.println("Selected plant two");
		toggleMenus.clickOnToggleMenu();
		toggleMenus.clickOnsalesMenuIcon();
		allSalesSubModules.clickOnInvoiceMenu();
		// Provide the Excel file path
		excelPath = "src/test/resources/ExcelTestData.xlsx";
		sheetName = "ExportInvoicePowerCor";

		//manageExportInvoicePage.createExportInvoicePowerCor(excelPath, sheetName, driver);
//====================================================================================================================================================
//====================================================================================================================================================
//====================================================================================================================================================


		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) {
			Thread.sleep(3000);

			System.out.println("#########Export Invoice iteration No = " + i + "#########" );

			//Add Invoice and select Domestic Invoice TypeFromPopUp
			invoicePage.clickOnAddInvoice();
			invoicePage.selectExportInvoiceTypeFromPopUp();

			//String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(manageExportInvoicePage.isOnExportInvoicePageCurrentURL().contains("Sales/ExportInvoice?InvoiceTypeId=2&InvoiceNo=NA&Handle=AddInvoice"), "URL doesn't indicate Export Invoice page.");
			System.out.println("--URL indicate landing on Export Invoice page--");
			//Customer
			String customerName=excel.getCellData(i,0);
			manageExportInvoicePage.enterCustomer(customerName);
			//manageExportInvoicePage.clickOnCustomerField(excelPath, sheetName, driver,i);
			Assert.assertTrue(manageExportInvoicePage.isExportInvoiceHeaderDisplayed(), "Export Invoice header is not visible.");
			System.out.println("--Export Invoice header is visible.--");

			//SO No
			//manageExportInvoicePage.fillSoNoField(excelPath, sheetName, driver, i);
			String soNo = excel.getCellData(i, 1);
			System.out.println("SO No is = " + soNo);
			manageExportInvoicePage.enterSoNoField(soNo);
			Assert.assertTrue(manageExportInvoicePage.isSoNoFieldVisible(),"So No field is not visible in UI");
			System.out.println("--SONo is visible on UI --");
			System.out.println("Address text Autopopulated =" + manageExportInvoicePage.getshippingAddressTextAutoPopulated());
			Assert.assertEquals(manageExportInvoicePage.getshippingAddressTextAutoPopulated(), "A Division Of Linamar Corporation,,545 Elmira Road,,Guelph - N1K1C2,Ontario,Canada");
			System.out.println("--Address Text is visible and found ok --");

			//selectTransporter - Amol

			manageExportInvoicePage.selectTransporterOption();
			Assert.assertEquals(manageExportInvoicePage.isTransporterFieldchooseCorrectValue(), " Amol Transport ","**Fails test isTransporterFieldchooseCorrectValue**");
			System.out.println("--Transporter is selected correctly visible and found ok --");


			//Other References
			String references = excel.getCellData(i,2);
			System.out.println("references Field value is ="+ references);
			manageExportInvoicePage.otherReferenceFieldOperation(references);
			Assert.assertTrue(manageExportInvoicePage.isReferenceFieldvalidation(),"OtherReference field is not visible in UI");
			System.out.println("--Other References is visible on UI --");


			//Pre-Carriage By

			String prcarriageVariable = excel.getCellData(i,3);
			manageExportInvoicePage.preCarriageBy(prcarriageVariable);
			System.out.println("Pre-Carriage Field value is ="+ prcarriageVariable);
			Assert.assertTrue(manageExportInvoicePage.ispreCarriageByDisplayed(prcarriageVariable),"Pre-Carriage field is not visible in UI");
			System.out.println("--Pre-Carriage is visible on UI --");


			//Place Of Receipt Of Pre-Carrier
			String placeOfReceiptOfPreCarrierr =excel.getCellData(i, 4);
			manageExportInvoicePage.placeOfReceiptOfPreCarrierFieldAction(placeOfReceiptOfPreCarrierr);
			System.out.println("Place Of Receipt Of Pre-Carrier Field value is ="+ placeOfReceiptOfPreCarrierr);
			Assert.assertTrue(manageExportInvoicePage.isplaceOfReceiptOfPreCarrierFieldDisplayed(),"Pre-Carriage field is not visible in UI");
			System.out.println("--Place Of Receipt Of Pre-Carrier is visible on UI --");

			//Vessel/Voyage
			String vesselOrVoyagee =excel.getCellData(i, 5);
			manageExportInvoicePage.VesselOrVoyageFieldAction(vesselOrVoyagee);
			System.out.println(" Vessel/Voyage Field value is ="+ vesselOrVoyagee);
			Assert.assertTrue(manageExportInvoicePage.isVesselOrVoyageFieldDisplayed(),"VesselOrVoyage field is not visible in UI");
			System.out.println("--VesselOrVoyage Field is visible on UI --");

			//Port of Loading

			String portOfLoadingg =excel.getCellData(i, 6);
			manageExportInvoicePage.portOfLoading(portOfLoadingg);
			System.out.println(" Port of Loading Field value is ="+ vesselOrVoyagee);
			Assert.assertTrue(manageExportInvoicePage.isportOfLoadingFieldDisplayed(),"Port of Loading field is not visible in UI");
			System.out.println("--Port of Loading Field is visible on UI --");

			//Port of Discharge
			String portOfDischargee=excel.getCellData(i,7);
			manageExportInvoicePage.portOfDischarge(portOfDischargee);
			System.out.println("Port of Discharge field id = " + portOfDischargee);
			Assert.assertTrue(manageExportInvoicePage.isPortOfDischargeFieldDisplayed());
			System.out.println("--Port of Discharge Field is visible on UI --");

			//Place Of Delivery
			String placeOfDeliveryyy =excel.getCellData(i,8);
			manageExportInvoicePage.placeOfDeliveryField(placeOfDeliveryyy);
			System.out.println("Place Of Delivery field id = " + placeOfDeliveryyy);
			Assert.assertTrue(manageExportInvoicePage.isPlaceOfDeliveryFieldDisplayed());
			System.out.println("--Place Of Delivery Field is visible on UI --");

			//Country of Origin of Goods
			String countryOfOriginOfGoodss = excel.getCellData(i, 9);
			manageExportInvoicePage.CountryOfOriginOfGoodsField(countryOfOriginOfGoodss);
			System.out.println("Country Of Origin Of Goods id = " + countryOfOriginOfGoodss);
			Assert.assertTrue(manageExportInvoicePage.isCountryOfOriginGoodsFieldDisplayed());
			System.out.println("--Country of Origin of Goods Field is visible on UI --");

			//Country of Final Destination
			String countryOfFinalDestinationn = excel.getCellData(i, 10);
			manageExportInvoicePage.countryOfFinalOfGoodsField(countryOfFinalDestinationn);
			System.out.println("Country Of Final Of Goods id = " + countryOfFinalDestinationn);
			Assert.assertTrue(manageExportInvoicePage.isCountryOfFinalGoodsFieldDisplayed());
			System.out.println("--Country of Final of Goods Field is visible on UI --");

			//Terms of Delivery
			String termsOfDeliveryy = excel.getCellData(i, 11);
			manageExportInvoicePage.termsOfDeliveryField(termsOfDeliveryy);
			System.out.println("Terms of Delivery is = " + termsOfDeliveryy);
			Assert.assertTrue(manageExportInvoicePage.isTermsOfDeliveryFieldDisplayed());
			System.out.println("--Terms of Delivery Field is visible on UI --");

			//Container
			String containerr = excel.getCellData(i, 12);
			manageExportInvoicePage.containerField(containerr);
			System.out.println("Container is = " + containerr);
			Assert.assertTrue(manageExportInvoicePage.isContainerFieldDisplayed());
			System.out.println("--Container Field is visible on UI --");

			//Container Seal
			String containerSeall = excel.getCellData(i, 13);
			manageExportInvoicePage.containerSealField(containerSeall);
			System.out.println("Container Seal is = " + containerSeall);
			Assert.assertTrue(manageExportInvoicePage.isContainerSealFieldIsDisplayed());
			System.out.println("--Container Seal Field is visible on UI --");

			//E-Seal
			String eSeall = excel.getCellData(i, 14);
			manageExportInvoicePage.eSealField(eSeall);
			System.out.println("E-Seal is = " + eSeall);
			Assert.assertTrue(manageExportInvoicePage.isESealFieldDisplayed());
			System.out.println("--E-Seal Field is visible on UI --");

			//Size (cm)
			String sizee = excel.getCellData(i, 15);
			manageExportInvoicePage.sizeField(sizee);
			System.out.println("Size is = " + sizee);
			Assert.assertTrue(manageExportInvoicePage.isSizeFieldDisplayed());
			System.out.println("--Size field is visible on UI--");

			//Packing List / Delivery Note
			String packingListOrDeliveryNotee = excel.getCellData(i, 16);
			manageExportInvoicePage.packingListOrDeliveryNoteField(packingListOrDeliveryNotee);
			System.out.println("Packing List / Delivery Note is = " + packingListOrDeliveryNotee);
			Assert.assertTrue(manageExportInvoicePage.isPackingListOrDeliveryNoteFieldDisplayed());
			System.out.println("--Packing List / Delivery Note field is visible on UI--");

			//Port
			manageExportInvoicePage.portDropDownField();
			Assert.assertEquals(manageExportInvoicePage.getSelectedOptionText(),"sahar air cargo","**wrong Option Selected**");
			System.out.println("--Port DropDown option is selected and option is " + manageExportInvoicePage.getSelectedOptionText() + "--");

			//SpecialInstruction
			manageExportInvoicePage.specialInstructionField();
			Assert.assertTrue(manageExportInvoicePage.isSpecialInstructionFieldDisplayed(),"**Special Instruction is not visible**");
			System.out.println("Special Instruction is visible");


			//remarks1
			manageExportInvoicePage.remarkOneField();
			Assert.assertTrue(manageExportInvoicePage.isremarkOneFieldDisplayed(),"**Remark one is not visible**");
			System.out.println("Remark one is visible");


			//remarks2
			manageExportInvoicePage.remarkTwoField();
			Assert.assertTrue(manageExportInvoicePage.isremarkTwoFieldDisplayed(),"**Remark two is not visible**");
			System.out.println("Remark two is visible");

			//ITEM DETAILS
			String itemName = excel.getCellData(i, 17);
			manageExportInvoicePage.enterItemNameInDropDown(itemName);
			Assert.assertEquals(manageExportInvoicePage.getSelectedOption(),"41700-HUB 1-2-8-9-10-R CLU","**Wrong DropDown Option is not selected**");
			System.out.println("Item = " + manageExportInvoicePage.getSelectedOption() + " selected");

			//StockQty
			String qty = excel.getCellData(i, 18);
			manageExportInvoicePage.enterStockQty(qty);
			Assert.assertTrue(manageExportInvoicePage.isStockQtyFieldDisplayed(),"**Stock Quantity is not visible**");
			System.out.println("Stock Quantity is visible");

			//net weight & Gross weight
			manageExportInvoicePage.enterNetWeightAndGrossWeight();
			Assert.assertTrue(manageExportInvoicePage.isNetWeightAndGrossWeightFieldDisplayed(),"**net weight & Gross weight is not visible**");
			System.out.println("Net weight & Gross weight is visible");

			//package Table
			//package Sr No Table
			String packageSrNoR11 = excel.getCellData(i, 19);
			manageExportInvoicePage.enterpackageDetialsInTable(packageSrNoR11);
			System.out.println("Package SRNO is = " + packageSrNoR11);
			Assert.assertTrue(manageExportInvoicePage.isPackiingTableSRNOFieldDisplayed());
			System.out.println("--Package SRNO field is visible on UI--");

			//package Quantity
			String Qty11 = excel.getCellData(i, 20);
			manageExportInvoicePage.enterpackageQuantityInTable(Qty11);
			System.out.println("Package Qty is = " + Qty11);
			Assert.assertTrue(manageExportInvoicePage.isPackiingTableQTYFieldDisplayed());
			System.out.println("--Package Qty field is visible on UI--");

			//netWeight1
			String netWeight11 = excel.getCellData(i, 21);
			manageExportInvoicePage.enterpackageNetWeight1InTable(netWeight11);
			System.out.println("Package netWeight1 is = " + netWeight11);
			Assert.assertTrue(manageExportInvoicePage.isPackiingTableNetWeight1FieldDisplayed());
			System.out.println("--Package netWeight1 field is visible on UI--");

			//grossWeight1
			String grossWeight11 = excel.getCellData(i, 22);
			manageExportInvoicePage.enterpackageGrossWeight1InTable(grossWeight11);
			System.out.println("Package grossWeight11 is = " + grossWeight11);
			Assert.assertTrue(manageExportInvoicePage.isPackiingTableGrossWeight1FieldDisplayed());
			System.out.println("--Package grossWeight11 field is visible on UI--");


			manageInvoicePage.saveInvoice();
			manageInvoicePage.performActionOnPopupafterSave();

			manageExportInvoicePage.collectingInvoiceNumber();
			manageInvoicePage.FinalPopupOkButton();
			Thread.sleep(4000);

			manageExportInvoicePage.selectInvoiceFromInvoiceList();
			manageExportInvoicePage.newWindowOperation();

		}
	}

	// Export Invoice-TennecoBrasil

		@Test  (enabled = false)
		public void invoiceCreationTestExportTennecoBrasil() throws InterruptedException {
			selectPlant.selectPlantTwo();
			System.out.println("Selected plant two");

			toggleMenus.clickOnToggleMenu();
			toggleMenus.clickOnsalesMenuIcon();
			allSalesSubModules.clickOnInvoiceMenu();


			System.out.println("invoice For Tenneco Brasil Starting");
			// Provide the Excel file path
			excelPath = "src/test/resources/ExcelTestData.xlsx";
			sheetName = "ExportInvoicePowerTenneco";

			manageExportInvoicePage.invoiceCreationTestExportTennecoBrasil(excelPath, sheetName, driver);

			System.out.println("invoice saved successfully For Tenneco Brasil");

		}

		@AfterMethod
		public void afterMethod() throws InterruptedException {
			Thread.sleep(3000);
			logOutPage.clickOnProfileIconAndLogOut();
			Thread.sleep(1000);

			System.out.println("After method execution-logout successfully done");

		}

		@AfterClass
		public void afterClass() {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			WebDriverManagerClass.quitDriver(); // Quit the WebDriver
			System.out.println("Browser closed");
		}

	}


