package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.TestDataStorage;

public class PurchaseOrderPage {

	//Variables
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy (xpath="//a[@id='AddDiv']")
	private WebElement addPO;

	@FindBy (xpath="//button[@id='Searchbtn']")
	private WebElement searchButton;

	@FindBy (xpath="//input[@type='search']")
	private WebElement searchField;

	@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/div[3]/div/div/div/table/tbody")
	private WebElement searchedfirstRow;

	@FindBy (xpath="//button[@class='btn btn-warning btn-xs Closed']")
	private WebElement closePoButton;

	@FindBy (xpath="//button[normalize-space()='OK']")
	private WebElement okButtonFromSuccessPopUp;

	//   //button[normalize-space()='OK']

	@FindBy (xpath="//button[@class='btn btn-warning btn-xs Closed']")
	private WebElement okvutton ;
	//Select Plant pop up

	@FindBy (xpath="//span[@id='select2-ModalPlantId-container']")
	private WebElement selectPlantField;

	@FindBy (xpath="//li[text()='Plant-2']")
	private WebElement plantTwo;

	@FindBy (xpath="//button[@id='btnPlantNext']")
	private WebElement nextButton;



	//Select PO Type pop up

	@FindBy (xpath="//span[@id='select2-ClosePoType-container']")
	private WebElement selectPoTypeField;

	@FindBy (xpath="//li[text()='SECONDARY']")
	private WebElement secondaryOption;

	@FindBy (xpath="//button[@id='btnCloseNext']")
	private WebElement nextButtonPoTypePopUp;

	//Select ONE TIME PO Type Pop Up

	@FindBy (xpath="//button[@id='btnClosePo']")
	private WebElement oneTimePO;


	// Constructor
			public  PurchaseOrderPage (WebDriver driver){

			PageFactory.initElements(driver, this);
			this.driver=driver;
			 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			}

			// Methods


			public void selectPlantTwofromPopUp() {

				addPO.click();
				wait.until(ExpectedConditions.visibilityOf(selectPlantField));
				selectPlantField.click();
				wait.until(ExpectedConditions.visibilityOf(plantTwo));
				plantTwo.click();
				nextButton.click();
				}

			public void selectSecondaryTypeOfPOfromPopUp() {
				wait.until(ExpectedConditions.visibilityOf(selectPoTypeField));
				selectPoTypeField.click();
				wait.until(ExpectedConditions.visibilityOf(secondaryOption));
				secondaryOption.click();
				nextButtonPoTypePopUp.click();
					}
			public void selectOneTimeTypeOfPOfromPopUp() {
				wait.until(ExpectedConditions.visibilityOf(oneTimePO));
				oneTimePO.click();
			}

			public void purchaseOrderPage() {
				wait.until(ExpectedConditions.visibilityOf(searchButton));
				searchButton.click();
			}

			public void sendPoNumberToSearchField() {
				wait.until(ExpectedConditions.visibilityOf(searchField));
				String storedPurchaseOrder = TestDataStorage.poNumber; // Retrieve it

		        System.out.println("Using stored PO number: " + storedPurchaseOrder);
		        searchField.sendKeys(storedPurchaseOrder);

			}


			public void slectFirstRowAndClickOnClosedButton() throws InterruptedException {
				Thread.sleep(1000);
				searchedfirstRow.click();
				Thread.sleep(1000);
				closePoButton.click();
				Thread.sleep(1000);
				okButtonFromSuccessPopUp.click();

			}


//			public void sendPoNumberToSearchField() {
//				wait.until(ExpectedConditions.visibilityOf(searchButton));
//				String storedPurchaseOrder = TestDataStorage.poNumber; // Retrieve it
//
//		        System.out.println("Using stored PO number: " + storedPurchaseOrder);
//				searchButton.sendKeys(storedPurchaseOrder);
//
//			}
}
