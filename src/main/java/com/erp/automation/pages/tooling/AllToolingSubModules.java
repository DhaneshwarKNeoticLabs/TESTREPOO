package com.erp.automation.pages.tooling;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllToolingSubModules {




	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// All Tooling SubModules Page

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[14]/ul/li[2]/a/span")
	public WebElement toolAcceptance;



	@FindBy(xpath = "")
	private WebElement toolHistory;

	@FindBy(xpath = "")
	private WebElement toolRework;


	// Constructor

	public AllToolingSubModules(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void clickOnToolAcceptanceMenu() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(toolAcceptance));
		toolAcceptance.click();
	}



}
