package com.erp.automation.pages.tooling;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolAcceptancePage {


	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// All Production Report SubModules Page

	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchField;

	@FindBy(xpath = "/html/body/section/div/form/div/div/div/div/div[2]/div/div/div/table/tbody/tr[1]")
	private WebElement firstRowResultAfterSearch;

	@FindBy(xpath = "//a[@title='Add']")
	public WebElement addButtonViewToolReturn;


	// Constructor

	public ToolAcceptancePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void openToolReturnForSearchedRecord() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys("20080");
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(firstRowResultAfterSearch));
		firstRowResultAfterSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(addButtonViewToolReturn));
		addButtonViewToolReturn.click();

	}

}
