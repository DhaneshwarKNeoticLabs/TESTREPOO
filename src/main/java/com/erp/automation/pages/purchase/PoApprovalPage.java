package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.TestDataStorage;

public class PoApprovalPage {



	//Variables
			private WebDriver driver;
			private WebDriverWait wait;


			@FindBy (xpath="//input[@type='search']")
			private WebElement searchButton;

			@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[3]")
			private WebElement firstRowResult;

			@FindBy (xpath="//textarea[@id='RejectionReason']")
			private WebElement approveOrRejectRemark;

			@FindBy (xpath="//button[@id='btnApprovePo']")
			private WebElement approveButton;

			@FindBy (xpath="//button[@id='btnRejectPo']")
			private WebElement rejectButton;

			@FindBy (xpath="//button[@class='confirm']")
			private WebElement successOkButton;

			// Constructor
					public  PoApprovalPage (WebDriver driver){

					PageFactory.initElements(driver, this);
					this.driver=driver;
					 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
					}

					// Methods
					public void sendPoNumberToSearchField() {
						wait.until(ExpectedConditions.visibilityOf(searchButton));
						String storedPurchaseOrder = TestDataStorage.poNumber; // Retrieve it

				        System.out.println("Using stored PO number: " + storedPurchaseOrder);
				        searchButton.clear();
						searchButton.sendKeys(storedPurchaseOrder);

					}

					public void selectFirstResultAndViewPo() {
						wait.until(ExpectedConditions.visibilityOf(firstRowResult));
						firstRowResult.click();


					}

					public void sendRemarkAndPoApproval() throws InterruptedException {
						approveOrRejectRemark.sendKeys("Automation Testing Remark while Approving");
						approveButton.click();
						Thread.sleep(5000);
						successOkButton.click();
					}

					public void sendRemarkAndPoReject() throws InterruptedException {
						approveOrRejectRemark.sendKeys("Automation Testing Remark while Rejecting");
						rejectButton.click();
						Thread.sleep(5000);
						successOkButton.click();
					}



}
