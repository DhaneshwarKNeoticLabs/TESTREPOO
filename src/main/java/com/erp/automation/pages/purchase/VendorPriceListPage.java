package com.erp.automation.pages.purchase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class VendorPriceListPage {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;

	//Select Vendor Price List Type pop up

	@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[3]")
	private WebElement selectVendorPriceListTypeField;

	@FindBy (xpath="//li[contains(text(),'Regular')]")
	private WebElement RegularVendorPriceListOption;

	@FindBy (xpath="//button[@id='btnSave1']")
	private WebElement okButton;

	//Vendor Price List Page

	@FindBy (xpath="//input[@id='VendorCode']")
	private WebElement vendorCode;

	@FindBy (xpath="/html[1]/body[1]/ul[3]/li[1]/div[1]")
	private WebElement firstResultvendorCode;

	@FindBy (xpath="//input[@id='ItemCode']")
	private WebElement itemCode;

	@FindBy (xpath="/html/body/ul[2]/li[1]")
	private WebElement firstResultItemCode;

	//		(//div[@class='ui-menu-item-wrapper'])[1]
	@FindBy (xpath="//span[@class='select2-selection select2-selection--multiple']")
	private WebElement process;

	@FindBy (xpath="//li[text()='DELTA COATING']")
	private WebElement deltaCoatingOptionprocessDD;

	@FindBy (xpath="//li[text()='FORMING']")
	private WebElement formingOptionprocessDD;

	@FindBy (xpath="/html/body/span/span/span/ul/li[3]")
	private WebElement firstOptionprocessDD;

	@FindBy (xpath="//input[@id='UnitRate']")
	private WebElement rateOrunit;

	@FindBy (xpath="//input[@id='ApproversRemark']")
	private WebElement remark;

	@FindBy (xpath="//button[@id='btnSaveApproval']")
	private WebElement saveAndsentForApproval;

	//Success Pop Up

	@FindBy (xpath="//button[text()='OK']")
	private WebElement firstSuccessPopUpOkButton;

	@FindBy (xpath="//button[text()='OK']")
	private WebElement secondSuccessPopUpOkButton;

	// Constructor
	public  VendorPriceListPage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnSelectVendorPriceListTypeFieldAndSelectRegularOption() {
	wait.until(ExpectedConditions.visibilityOf(selectVendorPriceListTypeField));
		selectVendorPriceListTypeField.click();
		wait.until(ExpectedConditions.visibilityOf(RegularVendorPriceListOption));
		RegularVendorPriceListOption.click();
		okButton.click();
	}

	public void sendInputToVendorCodeField() {
		wait.until(ExpectedConditions.visibilityOf(vendorCode));
		vendorCode.sendKeys("unicoat");
		wait.until(ExpectedConditions.visibilityOf(firstResultvendorCode));
		firstResultvendorCode.click();
	}


	public void sendInputToItemCodeField() throws InterruptedException {
		itemCode.sendKeys("41545");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(firstResultItemCode));
		firstResultItemCode.click();
	}

	public void selectProcessFromDropDown() {
		process.click();

		formingOptionprocessDD.click();
//		wait.until(ExpectedConditions.visibilityOf(deltaCoatingOptionprocessDD));
//		deltaCoatingOptionprocessDD.click();

	}

	public void enterRateOrUnit() {
		rateOrunit.sendKeys("20");

	}

	public void enterRemark() {
		remark.sendKeys("Test Remark For Automation");

	}

	public void clickOnSaveAndsentForApproval() {
		saveAndsentForApproval.sendKeys("Test Remark For Automation");

	}

	public void clickOnSuccessPopUp() {
		wait.until(ExpectedConditions.visibilityOf(firstSuccessPopUpOkButton));
		firstSuccessPopUpOkButton.click();
		wait.until(ExpectedConditions.visibilityOf(secondSuccessPopUpOkButton));
		secondSuccessPopUpOkButton.click();

	}

	//Method to log in using Excel data and enter values into dynamic XPath
		public void itemCodesFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

			int rowCount = excel.getRowCount(); // Get total number of rows

			for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)

				wait.until(ExpectedConditions.visibilityOf(itemCode));

				 // Clear field before entering new value
			    itemCode.clear();
			    itemCode.click();


				String itemCodeFromExcel = excel.getCellData(i, 0); // Get item code from Excel (Column 0)
				itemCode.sendKeys(itemCodeFromExcel);

				Thread.sleep(3000);


				 // Find all list items inside the auto-suggestion dropdown
			    List<WebElement> suggestions = driver.findElements(By.xpath("/html/body/ul[2]/li"));

			    if (!suggestions.isEmpty()) {
			        WebElement firstSuggestion = suggestions.get(0); // Always select the first suggestion
			        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
			        firstSuggestion.click();
			    } else {
			        System.out.println("❌ No suggestions found for iteration " + i);
			        continue; // Skip this iteration if no suggestion is available
			    }


				selectProcessFromDropDown();
				enterRateOrUnit();
				enterRemark();
			//	Thread.sleep(2000);
				clickOnSaveAndsentForApproval();
				Thread.sleep(1000);
				clickOnSuccessPopUp();
				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
			//	Thread.sleep(1000);

		}

		}
}
