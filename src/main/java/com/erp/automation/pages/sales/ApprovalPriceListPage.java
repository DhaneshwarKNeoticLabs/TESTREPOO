package com.erp.automation.pages.sales;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.ExcelUtils;

public class ApprovalPriceListPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;


		@FindBy (xpath="//input[@type='search']")
		private WebElement searchField;

		@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/div/div/div/div/div/table/tbody/tr")
		private WebElement firstResultAfterSearch;

		// Manage Approve Price List Page

		@FindBy (xpath="//input[@id='ApproversRemark']")
		private WebElement remarkField;

		@FindBy (xpath="//button[@id='approve']")
		private WebElement approveButton;

		@FindBy (xpath="//button[@class='confirm']")
		private WebElement okButtonSuccesfulPopUp;

		// Constructor
		public  ApprovalPriceListPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void customePriceListApprovalProcess(String excelPath, String sheetName, WebDriver driver) throws InterruptedException {

			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

			int rowCount = excel.getRowCount(); // Get total number of rows

			for (int i = 1; i < rowCount; i++) { // Start from row 1 (assuming row 0 has headers)

				wait.until(ExpectedConditions.visibilityOf(searchField));
				wait.until(ExpectedConditions.elementToBeClickable(searchField));
				searchField.clear();
				searchField.click();

				String itemCodeFromExcel = excel.getCellData(i, 1); // Get item code from Excel (Column 0)
				searchField.sendKeys(itemCodeFromExcel);

				System.out.println("itemcode =" + itemCodeFromExcel);
				Thread.sleep(2000);

				firstResultAfterSearch.click();


				wait.until(ExpectedConditions.elementToBeClickable(remarkField));
				remarkField.sendKeys("Automation Test Remark");

				approveButton.click();
				Thread.sleep(3000);
				okButtonSuccesfulPopUp.click();
				Thread.sleep(2000);

		}


		}

}
