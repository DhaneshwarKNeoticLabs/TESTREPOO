package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllPurchaseSubModules {

	//Variables
			private WebDriver driver;
			private WebDriverWait wait;


			@FindBy (xpath="//span[normalize-space()='Purchase Indent']")
			private WebElement purchaseIndentMenu;

			@FindBy (xpath="//a[@href='/ACCSSPLDRYRUN/Purchase/ListPIForApproval']")
			private WebElement piApproval;

			@FindBy (xpath="//span[contains(text(),'Po Approval')]")
			private WebElement poApproval;

			@FindBy (xpath="(//span[contains(text(),'Vendor Price List')])[2]")
			private WebElement vendorPriceList;

			@FindBy (xpath="//a[@href='/ACCSSPLDRYRUN/Purchase/ListPurchaseOrder']")
			private WebElement purchaseOrder;

			@FindBy (xpath="//span[text()='Approval Vendor Price List']")
			private WebElement approvalVendorPriceList;

			// Constructor
			public  AllPurchaseSubModules (WebDriver driver){

			PageFactory.initElements(driver, this);
			this.driver=driver;
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			}


			// Methods
			public void clickOnpurchaseIndentMenu() {
			//wait.until(ExpectedConditions.visibilityOf(emailId));
				purchaseIndentMenu.click();
			}

			public void clickOnPiApprovalMenu() {
				wait.until(ExpectedConditions.elementToBeClickable(piApproval));
				piApproval.click();
				}

			public void clickOnPoApprovalMenu() {
				wait.until(ExpectedConditions.visibilityOf(poApproval));
				poApproval.click();
				}

			public void clickOnVendorPriceListMenu() {
				wait.until(ExpectedConditions.visibilityOf(poApproval));
				vendorPriceList.click();
				}

			public void clickOnPurchaseOrderMenu() {
				wait.until(ExpectedConditions.visibilityOf(purchaseOrder));
				purchaseOrder.click();
				}

			public void clickOnApprovalVendorPriceListMenu() {
				wait.until(ExpectedConditions.visibilityOf(approvalVendorPriceList));
				approvalVendorPriceList.click();
				}

}
