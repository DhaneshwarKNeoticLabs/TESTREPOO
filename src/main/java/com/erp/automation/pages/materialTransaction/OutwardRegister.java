package com.erp.automation.pages.materialTransaction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.automation.utils.TestDataStorage;

public class OutwardRegister {


	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//a[@id='btnHistory']")
	private WebElement addOutwardButton;

	// Barcode Outward Register-pop up

	@FindBy (xpath="//input[@id='mdlTxtBarcode']")
	private WebElement barcode;

	//child Browser Element

	@FindBy (xpath="//input[@id='txtVehicleNo']")
	private WebElement vehicleNo;

	@FindBy (xpath="//input[@id='txtNameOfVehicleOwner']")
	private WebElement vehicleOwnerName;

	@FindBy (xpath="//button[@id='btnAccept']")
	private WebElement AcceptButton;

	@FindBy (xpath="//div[@class='sa-confirm-button-container']")
	private WebElement okButtonFromSuccessPopUp;

	@FindBy (xpath="(//button[@type='button'])[5]")
	private WebElement cancelButton;

	// Constructor
	public  OutwardRegister (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnAddOutwardButton() throws InterruptedException {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
		addOutwardButton.click();
		Thread.sleep(2000);
	}

	public void enterInvoiceNoToBarcodeField() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(barcode));
		String invoiceNumber = TestDataStorage.invoiceNumber;
// Split the string based on '/'
		String[] parts = invoiceNumber.split("/");

// The first part is the required output
		String actualInvoiceNo = parts[0];

		System.out.println("Required Output: " + actualInvoiceNo);

		Thread.sleep(2000);

		String parentWindow = driver.getWindowHandle();


		barcode.sendKeys(actualInvoiceNo);
		Thread.sleep(2000);


		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(1)); // Index 1 for the second tab


		vehicleNo.sendKeys("MH11AS2555");
		vehicleOwnerName.sendKeys("Amol");
		AcceptButton.click();
		Thread.sleep(3000);
		okButtonFromSuccessPopUp.click();

		driver.close(); // Close the child window
		driver.switchTo().window(parentWindow); // Return to the parent window

		cancelButton.click();

	}


	public void newenterInvoiceNoToBarcodeField() throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(barcode));
	    String invoiceNumber = TestDataStorage.invoiceNumber;

	    // Split the string based on '/'
	    String[] parts = invoiceNumber.split("/");
	    String actualInvoiceNo = parts[0]; // The first part is the required output
	    System.out.println("Required Output: " + actualInvoiceNo);

	    Thread.sleep(2000);

	    String parentWindow = driver.getWindowHandle(); // Store parent window handle

	    // Enter invoice number
	    barcode.sendKeys(actualInvoiceNo);
	    Thread.sleep(2000);

	    // Fetch all window handles and switch to the child window
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String handle : windowHandles) {
	        if (!handle.equals(parentWindow)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }

	    // Perform actions in the child window
	    vehicleNo.sendKeys("MH11AS2555");
	    vehicleOwnerName.sendKeys("Amol");
	    AcceptButton.click();
	    Thread.sleep(3000);
	    okButtonFromSuccessPopUp.click();

	    // Close the child window (use try-catch for handling exceptions)
	    try {
	        driver.close();
	    } catch (WebDriverException e) {
	        System.out.println("Standard close failed, using JavaScript.");
	        ((JavascriptExecutor) driver).executeScript("window.close();");
	    }

	    // Switch back to the parent window
	    driver.switchTo().window(parentWindow);

	    // Perform any additional actions on the parent window
	    cancelButton.click();
	}



}
