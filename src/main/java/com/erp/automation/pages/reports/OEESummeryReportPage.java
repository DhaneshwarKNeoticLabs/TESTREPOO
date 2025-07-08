package com.erp.automation.pages.reports;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OEESummeryReportPage {

	// Variables
	private WebDriver driver;
	private WebDriverWait wait;



	@FindBy(xpath = "//input[@id='txtMonth']")
	public WebElement monthField;

	@FindBy(xpath = "//span[text()='Apr']")
	public WebElement aprilMonth;


	@FindBy(xpath = "//input[@id='txtYear']")
	private WebElement yearField;

	@FindBy(xpath = "//span[text()='2025']")
	private WebElement option2025FromYearField;

	@FindBy(xpath = "(//span[@role='combobox'])[1]")
	private WebElement processesField;

	@FindBy(xpath = "(//input[@type='search'])[1]")
	private WebElement processesSearchField;

	@FindBy(xpath = "//li[text()='FORMING']")
	private WebElement formingOptionfromDropDown;

	//fromDate

	@FindBy(xpath = "//input[@id='txtFrom']")
	private WebElement fromDate;

	@FindBy(xpath = "(//th[text()='«'])[1]")
	private WebElement fromDateBackArrow;

	@FindBy(xpath = "(//td[text()='1'])[1]")
	private WebElement clickOnDate;

	@FindBy(xpath = "")
	private WebElement fromDateYear;

	@FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
	private WebElement yearFieldFromDatePicker;

	@FindBy(xpath = "(//th[@class='datepicker-switch'])[2]")
	private WebElement yearFieldFromDatePickerTwo;

	//toDate

	@FindBy(xpath = "//input[@id='txtTo']")
	private WebElement toDate;

	@FindBy(xpath = "(//th[text()='«'])[1]")
	private WebElement toDateBackArrow;

	@FindBy(xpath = "(//td[text()='1'])[1]")
	private WebElement clickOnToDate;

	@FindBy(xpath = "//button[@id='btnPrint']")
	private WebElement printButton;

	// Constructor

	public OEESummeryReportPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void selectMonth() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(monthField));
		monthField.click();
		wait.until(ExpectedConditions.elementToBeClickable(aprilMonth));
		aprilMonth.click();
	}


	public void selectYear() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(yearField));
		yearField.click();
		wait.until(ExpectedConditions.elementToBeClickable(option2025FromYearField));
		option2025FromYearField.click();
	}

	public void selectFormingOptionFromDropDown() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(processesField));
		processesField.click();
		wait.until(ExpectedConditions.elementToBeClickable(processesSearchField));
		processesSearchField.sendKeys("FOR");
		wait.until(ExpectedConditions.elementToBeClickable(formingOptionfromDropDown));
		formingOptionfromDropDown.click();
	}

	public void clickOnPrintButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(printButton));
		printButton.click();

	}


	public void selectCustomFromDateTwo(String yearValue) throws InterruptedException {

	    wait.until(ExpectedConditions.elementToBeClickable(fromDate));
	    fromDate.click();
	    Thread.sleep(1000);
	    System.out.println("--Clicked on From Date field--");

	    yearFieldFromDatePicker.click();       // Click to open year selection
	    Thread.sleep(1000);
	    yearFieldFromDatePickerTwo.click();    // Click to open full year view
	    Thread.sleep(1000);

	    // Update XPath based on your actual date picker structure
	    List<WebElement> listOfYear = driver.findElements(By.xpath("//td[@colspan='7']")); // Replace with your correct locator

	    // Flag to track if year was found
	    boolean yearFound = false;

	    for (WebElement yearElement : listOfYear) {
	        String yearText = yearElement.getText().trim();
	        System.out.println("Found year: " + yearText);

	        if (yearText.equals(yearValue)) {
	        	System.out.println("==//===============//===");
	        	System.out.println(yearElement);
	            yearElement.click();
	            System.out.println("--Year " + yearValue + " selected--");
	            yearFound = true;
	            break;
	        }
	    }

	    if (!yearFound) {
	        System.out.println("--Year " + yearValue + " not found in current view--");
	        // Optional: Add logic to navigate to next/previous decade
	    }

	    System.out.println("============================================================");
	}




	public void selectCustomFromDate() throws InterruptedException {

		//FromDate
		wait.until(ExpectedConditions.elementToBeClickable(fromDate));
		fromDate.click();
		Thread.sleep(2000);
		System.out.println("--clicked on from date field--");
		wait.until(ExpectedConditions.elementToBeClickable(fromDateBackArrow));
		Thread.sleep(2000);
		fromDateBackArrow.click();
		System.out.println("--clicked on BAck Arrow 1st time--");
		Thread.sleep(1200);
		fromDateBackArrow.click();
		System.out.println("--clicked on BAck Arrow 2nd time--");
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDate));
		clickOnDate.click();
		System.out.println("--Day selected as 1st of month--");

		//To Date

		wait.until(ExpectedConditions.elementToBeClickable(toDate));
		toDate.click();
		Thread.sleep(2000);
		System.out.println("--clicked on To date field--");
		wait.until(ExpectedConditions.elementToBeClickable(fromDateBackArrow));
		Thread.sleep(2000);
		fromDateBackArrow.click();
		System.out.println("--clicked on BAck Arrow 1st time--");
//		Thread.sleep(1200);
//		fromDateBackArrow.click();
//		System.out.println("--clicked on BAck Arrow 2nd time--");
		wait.until(ExpectedConditions.elementToBeClickable(clickOnToDate));
		clickOnToDate.click();
		System.out.println("--Day selected as 1st of month--");


		//Printing Opertion:-

		wait.until(ExpectedConditions.elementToBeClickable(printButton));
		printButton.click();
		Thread.sleep(3500);

	}
}

