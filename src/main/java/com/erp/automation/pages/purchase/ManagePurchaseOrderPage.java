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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class ManagePurchaseOrderPage {


	//Variables
			private WebDriver driver;
			private WebDriverWait wait;

			@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/form/div/div/div[4]/div[4]/span/span[1]/span")
			WebElement deliveryDropDownOption;

			@FindBy (xpath="//li[text()='WD-Warehouse Delivery']")
			WebElement WarehouseOptionFromDropDown;

			@FindBy (xpath="//span[@id='select2-ManagementUnitCode-container']")
			WebElement ManagementUnit;

			@FindBy (xpath="//li[text()='M01-Manufacturing']")
			WebElement manufacturingoptionUnderManagementUnit;

			@FindBy (xpath="//li[text()='M05-Machining']")
			WebElement machiningOptionUnderManagementUnit;


			@FindBy (xpath="//input[@id='VendorName']")
			WebElement vendor;

			@FindBy (xpath="/html[1]/body[1]/ul[2]/li[1]/div[1]")
			WebElement vendorFirstSuggestion;

			//purchase Order details

			@FindBy (xpath="//button[@id='Addrow']")
			WebElement addpurchaseDetails;

			@FindBy (xpath="(//span[@role='combobox'])[12]")
			WebElement itemType;

			@FindBy (xpath="//li[text()='FINISHED GOODS']")
			WebElement FinishGoodsOptionunderItemType;

			@FindBy (xpath="//input[@id='ItemCode']")
			WebElement itemCode;

			@FindBy (xpath="/html[1]/body[1]/ul[3]/li[1]/div[1]")
			WebElement FirstResultOfitemCode;

			@FindBy (xpath="//select[@id='UomId']")
			WebElement uom;

//

			@FindBy (xpath="//input[@id='Quantity']")
			WebElement quantity;

			@FindBy (xpath="(//span[@role='combobox'])[13]")
			WebElement processes;

			@FindBy (xpath="//li[text()='DELTA COATING']")
			WebElement deltaCoatingOptionUnderProcesses;

			@FindBy (xpath="//li[text()='FORMING']")
			private WebElement formingOptionprocessDD;

			@FindBy (xpath="(//span[@role='combobox'])[14]")
			WebElement costCenter;

			@FindBy (xpath="//li[text()='C21-Secondary']")
			WebElement secondaryOptionUnderCostCenter;

			@FindBy (xpath="//button[@id='btnSaveItem']")
			WebElement saveItem;


			@FindBy (xpath="//button[@id='btnSaveApproval']")
			WebElement saveAndSentForApprovalButton;

			//Warning PopUp
		    @FindBy(xpath = "//button[text()='OK']") // List of options
		    private WebElement okButtonFromWarningPopUp;

		  //SuccessPopUp
		    @FindBy(xpath = "//button[@class='confirm']") // List of options
		    private WebElement okButtonFromSuccessPopUp;

		  //SuccessPopUp2
		    @FindBy(xpath = "//button[@class='confirm']") // List of options
		    private WebElement okButtonFromSuccessPopUpSecond;

			// Constructor
			public  ManagePurchaseOrderPage (WebDriver driver){

			PageFactory.initElements(driver, this);
			this.driver=driver;
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			}

			// Methods
			public void enterVendorName() throws InterruptedException {
				wait.until(ExpectedConditions.visibilityOf(vendor));
				vendor.sendKeys("unicoat");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(vendorFirstSuggestion));
				vendorFirstSuggestion.click();


			}
			public void clickOndeliveryDropDownOption() {
				wait.until(ExpectedConditions.visibilityOf(deliveryDropDownOption));
				deliveryDropDownOption.click();

			}
			public void selectWarehouseDropDownOption() {
				wait.until(ExpectedConditions.visibilityOf(WarehouseOptionFromDropDown));
				WarehouseOptionFromDropDown.click();

			}
			public void selectManagementUnitDropDownOption() throws InterruptedException {
				wait.until(ExpectedConditions.visibilityOf(ManagementUnit));
				Thread.sleep(2000);
				ManagementUnit.click();
				wait.until(ExpectedConditions.visibilityOf(machiningOptionUnderManagementUnit));
				machiningOptionUnderManagementUnit.click();
		}

			//Purchase Order Details
			public void clickOnaddPurchaseButton() {
					addpurchaseDetails.click();
	}
			//Manage item

			public void enterDetailsForItems() {
				itemType.click();
				FinishGoodsOptionunderItemType.click();
				itemCode.sendKeys("41545");
				FirstResultOfitemCode.click();
				Select nos =new Select(uom);
				nos.selectByVisibleText("NOS");
				quantity.sendKeys("20");
				processes.click();
				deltaCoatingOptionUnderProcesses.click();
				costCenter.click();
				secondaryOptionUnderCostCenter.click();
				saveItem.click();


}


			public void saveAndSubmitForPoApproval() throws InterruptedException {
				//wait.until(ExpectedConditions.visibilityOf(saveAndSentForApprovalButton));
				Thread.sleep(3000);
				saveAndSentForApprovalButton.click();
				//wait.until(ExpectedConditions.visibilityOf(okButtonFromWarningPopUp));
				Thread.sleep(3000);
				okButtonFromWarningPopUp.click();
			//	wait.until(ExpectedConditions.visibilityOf(okButtonFromSuccessPopUp));
				Thread.sleep(3000);
				okButtonFromSuccessPopUp.click();
				Thread.sleep(3000);


			}

			public void finalSuccessPopupConfirmation() throws InterruptedException {
				Thread.sleep(2000);
				okButtonFromSuccessPopUpSecond.click();
				Thread.sleep(3000);

			}

			//Method to log in using Excel data and enter values into dynamic XPath
			public void itemCodesFromExcel(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {
				ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

				int rowCount = excel.getRowCount(); // Get total number of rows

				for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)

					clickOnaddPurchaseButton();
					itemType.click();
					FinishGoodsOptionunderItemType.click();

					wait.until(ExpectedConditions.visibilityOf(itemCode));

					 // Clear field before entering new value
				    itemCode.clear();
				    itemCode.click();


					String itemCodeFromExcel = excel.getCellData(i, 0); // Get item code from Excel (Column 0)
					itemCode.sendKeys(itemCodeFromExcel);

					Thread.sleep(3000);


					 // Find all list items inside the auto-suggestion dropdown
				    List<WebElement> suggestions = driver.findElements(By.xpath("/html/body/ul[3]/li"));

				    if (!suggestions.isEmpty()) {
				        WebElement firstSuggestion = suggestions.get(0); // Always select the first suggestion
				        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
				        firstSuggestion.click();
				    } else {
				        System.out.println("❌ No suggestions found for iteration " + i);
				        continue; // Skip this iteration if no suggestion is available
				    }


				    Select nos =new Select(uom);
					nos.selectByVisibleText("NOS");
					quantity.sendKeys("20");
					processes.click();
					formingOptionprocessDD.click();
					costCenter.click();
					secondaryOptionUnderCostCenter.click();
					saveItem.click();



				   ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
				//	Thread.sleep(1000);

			}
			}

}
