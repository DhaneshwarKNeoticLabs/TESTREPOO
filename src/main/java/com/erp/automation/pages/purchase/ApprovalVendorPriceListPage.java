package com.erp.automation.pages.purchase;

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

public class ApprovalVendorPriceListPage {

	//Variables
		private WebDriver driver;
		private WebDriverWait wait;
		ManageVendorApprovePriceListPage manageVendorApprovePriceListPage;

		//Select Vendor Price List Type pop up

		@FindBy (xpath="//input[@type='search']")
		private WebElement searchField;




		// Constructor
		public  ApprovalVendorPriceListPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		manageVendorApprovePriceListPage=new ManageVendorApprovePriceListPage(driver);
		}


		// Methods
		public void clickOnSearchField() {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		searchField.click();


		}

		//Method to log in using Excel data and enter values into dynamic XPath
				public void enterItemCodesFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
					ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

					int rowCount = excel.getRowCount(); // Get total number of rows

					for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)

						wait.until(ExpectedConditions.visibilityOf(searchField));
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));

						 // Clear field before entering new value
						searchField.clear();
						searchField.click();


						String itemCodeFromExcel = excel.getCellData(i, 0); // Get item code from Excel (Column 0)
						searchField.sendKeys(itemCodeFromExcel);

						Thread.sleep(3000);





						 // Find all list items after search
					    List<WebElement> suggestions = driver.findElements(By.xpath("/html/body/section/div/div[3]/div[1]/div/div/div/div/div/div/table/tbody/tr"));

					    if (!suggestions.isEmpty()) {
					        WebElement firstSuggestion = suggestions.get(0); // Always select the first suggestion
					        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
					        firstSuggestion.click();
					    } else {
					        System.out.println("❌ No suggestions found for iteration " + i);
					        continue; // Skip this iteration if no suggestion is available
					    }


					    manageVendorApprovePriceListPage.clickOnApproveButtonAndSuccessPopup();
//						selectProcessFromDropDown();
//						enterRateOrUnit();
//						enterRemark();
//					//	Thread.sleep(2000);
//						clickOnSaveAndsentForApproval();
//						Thread.sleep(1000);
//						clickOnSuccessPopUp();
//						Thread.sleep(1000);
//						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
//					//	Thread.sleep(1000);

				}
				}
}
