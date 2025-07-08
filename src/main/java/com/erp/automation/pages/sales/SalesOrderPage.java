package com.erp.automation.pages.sales;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesOrderPage {

	//Variables
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//a[@id='AddSO']")
	private WebElement addSoButton;

	// -----select SO Type first Pop up
	@FindBy(xpath = "/html/body/section/div/div[3]/div/div/div[2]/div/span[1]/span[1]/span")
	WebElement selectDropDownFromSelectSOTypePopUp;

	@FindBy(xpath = "//li[text()=' Domestic SO ']")
	WebElement domesticSOOptionFromDropDown;

	@FindBy(xpath = "//button[@id='btnCloseNext']")
	WebElement nextBtnFromSelectSOTypePopUp;

	// -----select SO Type second Pop up
	@FindBy(xpath = "//button[@id='btnCloseSo']")
	WebElement selectOneTimeSOTypeFromPopUp;


	// Constructor
	public  SalesOrderPage (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnAddSoButton() {
		// wait.until(ExpectedConditions.visibilityOf(addSoButton));
		wait.until(ExpectedConditions.elementToBeClickable(addSoButton));
		addSoButton.click();

	}

	public void selectSOTypeDomesticFromPopUpAndNext() {
		wait.until(ExpectedConditions.visibilityOf(selectDropDownFromSelectSOTypePopUp));
		selectDropDownFromSelectSOTypePopUp.click();
		wait.until(ExpectedConditions.visibilityOf(domesticSOOptionFromDropDown));
		domesticSOOptionFromDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtnFromSelectSOTypePopUp));
		nextBtnFromSelectSOTypePopUp.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectOneTimeSOTypeFromPopUp));
		selectOneTimeSOTypeFromPopUp.click();

	}

}
