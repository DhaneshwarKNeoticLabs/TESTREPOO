package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.TestDataStorage;

public class PiApprovalPage {


	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//input[@type='search']")
	private WebElement searchField;

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[1]")
	private WebElement firstResultAfterSearch;

	// Constructor
	public  PiApprovalPage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void sendPiNumberInSearchField(String piNumber) {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
	//	purchaseIndentMenu.click();
		searchField.sendKeys(piNumber);
	}

	public void sendPiNumberInSearchFieldFromUtilsClass() {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		wait.until(ExpectedConditions.elementToBeClickable(searchField));

		String storedPurchaseIndent = TestDataStorage.piNumber; // Retrieve it

        System.out.println("Using stored PO number: " + storedPurchaseIndent);
        searchField.sendKeys(storedPurchaseIndent);
//			searchField.sendKeys(piNumber);
		}

	public void selectFirstResultOfPiAfterSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(firstResultAfterSearch));

		firstResultAfterSearch.click();
		}
}
