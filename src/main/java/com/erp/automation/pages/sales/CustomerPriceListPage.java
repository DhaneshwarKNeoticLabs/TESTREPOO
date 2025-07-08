package com.erp.automation.pages.sales;

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

public class CustomerPriceListPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		//Select Vendor Price List Type pop up

		@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[3]")
		private WebElement selectCustomerPriceListTypeField;

		@FindBy (xpath="//li[contains(text(),'Regular')]")
		private WebElement RegularCustomerPriceListOption;

		@FindBy (xpath="//button[@id='btnSave1']")
		private WebElement okButton;

		//Vendor Price List Page

		@FindBy (xpath="//input[@id='CustomerCode']")
		private WebElement customerCode;

		@FindBy (xpath="/html/body/ul[3]/li/div")
		private WebElement firstSuggestionCustomerCode;

		@FindBy (xpath="//input[@id='ItemCode']")
		private WebElement itemCode;

		@FindBy (xpath="/html/body/ul[2]/li[1]/div")
		private WebElement firstSuggestionItemCode;

		@FindBy (xpath="//input[@id='UnitRate']")
		private WebElement rate;

		@FindBy (xpath="//input[@id='ApproversRemark']")
		private WebElement remark;


		@FindBy (xpath="//button[@id='btnSaveApproval']")
		private WebElement saveApprovalButton;

		@FindBy (xpath="//button[@class='confirm']")
		private WebElement okButtonFromPopUp;


		// Constructor
		public  CustomerPriceListPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void clickOnSelectCustomerPriceListTypeFieldAndSelectRegularOption() {
		wait.until(ExpectedConditions.visibilityOf(selectCustomerPriceListTypeField));
		selectCustomerPriceListTypeField.click();
			wait.until(ExpectedConditions.visibilityOf(RegularCustomerPriceListOption));
			RegularCustomerPriceListOption.click();
			okButton.click();
		}

		// Method to log in using Excel data and enter values into dynamic XPath
		public void customerCodesFromExcel(String excelPath, String sheetName, WebDriver driver)
				throws InterruptedException {
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

			int rowCount = excel.getRowCount(); // Get total number of rows

			for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)

				wait.until(ExpectedConditions.visibilityOf(customerCode));
				wait.until(ExpectedConditions.elementToBeClickable(customerCode));

				// Clear field before entering new value
				//Thread.sleep(1000);
				customerCode.clear();
				//Thread.sleep(1000);
				customerCode.click();

				String customerCodeFromExcel = excel.getCellData(i, 0); // Get item code from Excel (Column 0)
				customerCode.sendKeys(customerCodeFromExcel);

				Thread.sleep(2000);

				// Find all list items inside the auto-suggestion dropdown
				List<WebElement> suggestions = driver.findElements(By.xpath("/html/body/ul[3]/li/div"));

				if (!suggestions.isEmpty()) {
					WebElement firstSuggestion = suggestions.get(0); // Always select the first suggestion
					wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
					firstSuggestion.click();
				} else {
					System.out.println("❌ No suggestions found for iteration " + i);
					continue; // Skip this iteration if no suggestion is available
				}

				itemCode.clear();
				itemCode.click();

				String itemCodeFromExcel = excel.getCellData(i, 1); // Get item code from Excel (Column 0)
				itemCode.sendKeys(itemCodeFromExcel);

				System.out.println("itemcode =" + itemCodeFromExcel);
				Thread.sleep(2000);

				firstSuggestionItemCode.click();

				rate.clear();
				rate.click();
				String rateFromExcel = excel.getCellData(i, 2); // Get item code from Excel (Column 0)
				Thread.sleep(2000);
				rate.sendKeys(rateFromExcel);
				System.out.println("itemRate =" + rateFromExcel);

				remark.sendKeys("Test Automation Remark");
				saveApprovalButton.click();
				Thread.sleep(2000);
				okButtonFromPopUp.click();
				Thread.sleep(3000);
				okButtonFromPopUp.click();


			}

		}


	}
