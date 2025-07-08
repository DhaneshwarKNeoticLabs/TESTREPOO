package com.erp.automation.pages.sales;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.TestDataStorage;

public class SoApprovalPage {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//input[@type='search']")
	private WebElement searchField;

	@FindBy (xpath="/html/body/section/div/div[2]/div/div/div/div/div/div/table/tbody/tr")
	private WebElement firstResultAfterSearch;

	@FindBy (xpath="/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]")
	private WebElement firstResultAfterSearchForSOPage;

	@FindBy (xpath="//button[@class='btn btn-warning btn-xs Closed']")
	private WebElement closeSOButton;

	@FindBy (xpath="//input[@id='CloseReason']")
	private WebElement enterClosedReasonPopUpTextField;

	@FindBy (xpath="//button[@id='btnClosedSO']")
	private WebElement closebuttonPopUp;

	@FindBy (xpath="//button[@class='confirm']")
	private WebElement okButtonFromWarningPopUp;

	@FindBy (xpath="//button[@class='confirm']")
	private WebElement okButtonFromSuccessPopUp;

	@FindBy (xpath="//a[@class='btn btn-icon btn-info btn-xs fa fa-edit edit']")
	private WebElement editButton;

	// Constructor
	public  SoApprovalPage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void sendSoNoInSearchFieldToOpenSo() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		String storedSalesOrder = TestDataStorage.soNumber; // Retrieve it

        System.out.println("Using stored SO number: " + storedSalesOrder);
        searchField.sendKeys(storedSalesOrder);
		Thread.sleep(3000);
		firstResultAfterSearch.click();
	}

	public void sendSoNoInSearchFieldToOpenSoOnSOpage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchField));
		String storedSalesOrder = TestDataStorage.soNumber; // Retrieve it

        System.out.println("Using stored SO number: " + storedSalesOrder);
        searchField.sendKeys(storedSalesOrder);
		Thread.sleep(3000);
		firstResultAfterSearchForSOPage.click();
	}

	public void closingTheSO() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(closeSOButton));
		closeSOButton.click();
		wait.until(ExpectedConditions.visibilityOf(enterClosedReasonPopUpTextField));
		wait.until(ExpectedConditions.elementToBeClickable(enterClosedReasonPopUpTextField));
		enterClosedReasonPopUpTextField.sendKeys("Clsong this SO for testing Purpose");
		wait.until(ExpectedConditions.elementToBeClickable(closebuttonPopUp));
		closebuttonPopUp.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromWarningPopUp));
		okButtonFromWarningPopUp.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromSuccessPopUp));
		okButtonFromSuccessPopUp.click();

	}

	public void clickOnEditButton() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		editButton.click();

	}
}
