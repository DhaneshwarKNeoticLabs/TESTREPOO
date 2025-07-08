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

public class ManagePurchaseIndentPage {

	// Variables
	private WebDriver driver;
	private WebDriverWait wait;
	String piNumber;

	// Store

	@FindBy(xpath = "//span[@id='select2-storeCode-container']") // Dropdown click element
	private WebElement storeDropdown;

	@FindBy(xpath = "//ul[@id='select2-storeCode-results']/li") // List of options
	private List<WebElement> storeDropdownOptions;

	// Store ----> Raw material
	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li[2]") // List of options
	private WebElement storeDropdownOptionsSelectRawMaterial;

	// Store ---->central

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li[4]") // List of options
	private WebElement storeDropdownOptionsSelectCentral;

	// ManagmentUnit

	@FindBy(xpath = "/html/body/section/div/div[2]/div[1]/div/div[2]/div[3]/span[1]/span[1]/span/span[1]") // List of
																											// options
	private WebElement managementUniteDropdownOptions;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li[2]") // List of options
	private WebElement managementUniteDropdownOptionsSelectManufacturing;

	// Project
	@FindBy(xpath = "/html/body/section/div/div[2]/div[1]/div/div[2]/div[4]/span[1]/span[1]/span/span[1]") // List of
																											// options
	private WebElement projectDropdownOptions;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li[6]") // List of options
	private WebElement projectDropdownOptionsSelectSSPLS002Project_S_2;
//

	// Deleting two extra rows
	// Deleting 2nd row
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[2]/td[12]/button") // List of
																											// options
	private WebElement deleteSecondRow;
	// Deleting 3rd row
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[3]/td[12]/button") // List of
																											// options
	private WebElement deleteThirdRow;

	// ItemCode
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/input") // List of
																											// options
	private WebElement itemCodeField;

	@FindBy(xpath = "/html[1]/body[1]/ul[4]/li[1]/div[1]") // List of options
	private WebElement itemCodeFieldFirstResult;

	// item Name

	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/input[1]") // List of
																											// options
	private WebElement itemNameField;

	@FindBy(xpath = "/html/body/ul[4]/li[1]") // List of options
	private WebElement itemNameFieldFirstResult;

	// Quantity
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[10]/input") // List of
																											// options
	private WebElement QuantityFirstRow;

	// Remark
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[11]/input") // List of
																											// options
	private WebElement RemarkFirstRow;

	// Purpose
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/textarea") // List of options
	private WebElement piPurpose;

	// Save button
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/div[2]/button[2]") // List of options
	private WebElement saveButton;

	// Save and Sent for Approval button
	@FindBy(xpath = "//button[@id='btnSaveSendapproval']") // List of options
	private WebElement saveAndSentForApprovalButton;

	// Warning PopUp
	@FindBy(xpath = "//button[text()='OK']") // List of options
	private WebElement okButtonFromWarningPopUp;

//	    /html/body/div[10]/div[7]/div/button

	// SuccessPopUp
	@FindBy(xpath = "//button[@class='confirm']") // List of options
	private WebElement okButtonFromSuccessPopUp;
	// /html/body/div[18]/div[7]/div/button

	@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']") // List of options
	private WebElement SuccessPopUp;

	@FindBy(xpath = "//p[contains(text(), 'PI #')]/b[1]") // List of options
	private WebElement piNumberStoring;

	public ManagePurchaseIndentPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

		PageFactory.initElements(driver, this);
	}

	// Store

	// store-->Raw Material

	public void clickOnStoreDropdown() {

		storeDropdown.click();

	}

	public void clickOnStoreDropdownOptionsSelectRawMaterial() {

		storeDropdownOptionsSelectRawMaterial.click();

	}

	// store-->Central storeDropdownOptionsSelectCentral

	public void clickOnStoreDropdownOptionsSelectCentral() {

		storeDropdownOptionsSelectCentral.click();

	}

	// Management unit
	public void clickOnManagementUnitDropdown() {

		managementUniteDropdownOptions.click();

	}

	public void ClickOnProjectDropdownOptionsSelectSSPLS002Project_S_2() {

		managementUniteDropdownOptionsSelectManufacturing.click();

	}

	// Project
	public void clickOnProjectDropdown() {

		projectDropdownOptions.click();

	}

	public void clickOnprojectDropdownOptionsSelectSSPLS002Project_S_2() {

		projectDropdownOptionsSelectSSPLS002Project_S_2.click();

	}

	// Delete Extra Rows
	public void deleteExtraSecondAndThirdRows() throws InterruptedException {

		deleteSecondRow.click();
		System.out.println("delete second Row");
		Thread.sleep(2000);
		deleteSecondRow.click();
		System.out.println("delete Third Row");

	}
	// SendInput to the Item Code Field

	// itemCode
	public void enterInItemCodeField() {

		itemCodeField.sendKeys("RMGRNSCRP001");
		itemCodeFieldFirstResult.click();

	}

//Method to log in using Excel data and enter values into dynamic XPath
	public void itemCodesFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount(); // Get total number of rows

		for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)
			// Click on "Add Row" button before entering data
			WebElement addRowButton = driver.findElement(
					By.xpath("/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/thead/tr/th[13]/button"));

			wait.until(ExpectedConditions.visibilityOf(addRowButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addRowButton);

			String itemCode = excel.getCellData(i, 0); // Get item code from Excel (Column 0)

			// Generate dynamic XPath for input field
			String dynamicXPath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[" + i
					+ "]/td[3]/input";

			WebElement inputField = driver.findElement(By.xpath(dynamicXPath)); // Find the input field
			wait.until(ExpectedConditions.visibilityOf(inputField));
			inputField.sendKeys(itemCode); // Enter item code

			System.out.println("Entered Item Code: " + itemCode + " at row " + i);

			Thread.sleep(2000);

			String firstElementXPath = "/html[1]/body[1]/ul[" + (i + 3) + "]/li[1]/div[1]";

			// Wait until the first suggestion is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstSuggestion = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstElementXPath)));

			// Click the first suggestion
			firstSuggestion.click();

			System.out.println("Selected first suggestion for item code: " + itemCode);

			// Generate qty XPath for QTY field
			String qtyPath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[" + i
					+ "]/td[10]/input";

			WebElement qty = driver.findElement(By.xpath(qtyPath)); // Find the input field
			wait.until(ExpectedConditions.visibilityOf(qty));
			qty.sendKeys("1"); // Enter item code

			// Generate dynamic XPath for Remark field
			String remarkPath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[" + i
					+ "]/td[11]/input";

			WebElement remark = driver.findElement(By.xpath(remarkPath)); // Find the input field
			wait.until(ExpectedConditions.visibilityOf(remark));
			remark.sendKeys("Test Remark By Automation");

		}

		String lastExtraRowPath = "/html/body/section/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[" + rowCount
				+ "]/td[12]/button";
		WebElement lastExtraRow = driver.findElement(By.xpath(lastExtraRowPath)); // Find the input field
		wait.until(ExpectedConditions.visibilityOf(lastExtraRow));
		lastExtraRow.click();
		piPurpose.sendKeys("For Automation Purpose only");

	}

	public void enterInItemNameField() {

		itemNameField.sendKeys("41700");
		itemNameFieldFirstResult.click();

	}

	public void enterValuesInQtyRemPurpose() {

		QuantityFirstRow.sendKeys("1");
		RemarkFirstRow.sendKeys("Test Remark By Automation");
		piPurpose.sendKeys("Automation Test Purpose");

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

	public void clickOnSaveAndSendForApprovalButton() {

		saveAndSentForApprovalButton.click();

	}

	public void clickOnOkButtonFromWarningPopUp() throws InterruptedException {

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(okButtonFromWarningPopUp));
		okButtonFromWarningPopUp.click();

		wait.until(ExpectedConditions.visibilityOf(SuccessPopUp));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("sweet-overlay")));
		// div[@class='sweet-alert showSweetAlert visible']
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link
		// navbar-avatar']")));
		Thread.sleep(2000);
		okButtonFromSuccessPopUp.click();
		Thread.sleep(2000);
		// pi no storing
//
//	 piNumber=piNumberStoring.getText();
//	 System.out.println(piNumber);
//
	}

	public void okButtonFromFinalSuccessPopUp() throws InterruptedException {

		// Thread.sleep(2000);
		// System.out.println(piNumber);
		okButtonFromSuccessPopUp.click();

	}

////	    // Get all dropdown values as a list of strings
////	    public List<String> getDropdownValues() {
////	    	storeDropdown.click(); // Open the dropdown
////	        return storeDropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
////	    }
////
////	    // Select an option by index
////	    public void selectByIndex(int index) throws InterruptedException {
////	    	storeDropdown.click(); // Open dropdown
////
////	    	storeDropdownOptions.get(index).click(); // Click option at index
////
////	    }
//
////	  Get all dropdown values as a list of strings
////	    public List<String> getDropdownValues() {
////	    	  wait.until(ExpectedConditions.elementToBeClickable(storeDropdown)).click(); // Open the dropdown
////	    	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-storeCode-results']/li"))); // Wait for options to be present
////
////	    	    // Refresh the options list after dropdown opens
////	    	    List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-storeCode-results']/li"));
////
////	    	    return options.stream().map(WebElement::getText).collect(Collectors.toList());
////	    }
////
////	    // Select an option by index
////	    public void selectByIndex(int index) throws InterruptedException {
////	    	 wait.until(ExpectedConditions.elementToBeClickable(storeDropdown)).click(); // Open dropdown
////	    	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-storeCode-results']/li"))); // Wait for options to be present
////
////	    	    // Refresh the options list after dropdown opens
////	    	    List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-storeCode-results']/li"));
////
////
////	    	    if (index >= 0 && index < options.size()) {
//////	    	    	Thread.sleep(5000);
//////	    	        storeDropdownOptionss.click();
////	    	        options.get(index).click(); // Click option at index
////
////	    	    }
////
////
////    	        else {
////    	        	Thread.sleep(2000);
////        	        storeDropdownOptionss.click();
////	    	        throw new IndexOutOfBoundsException("Invalid index: " + index + ", available options: " + options.size());
////
////
////	    	    }
////
//
//
//
//	    }
}
