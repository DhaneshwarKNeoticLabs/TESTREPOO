package com.erp.automation.pages.reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductionReportSubModules {



	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// All Production Report SubModules Page

	@FindBy(xpath = "//a[@href='/ACCSSPLDRYRUN/Production/OEESummeryReport']")
	public WebElement oeeSummaryMenu;



	@FindBy(xpath = "")
	private WebElement d;


	// Constructor

	public AllProductionReportSubModules(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void clickOnOEESummaryReportMenu() throws InterruptedException {
		oeeSummaryMenu.click();
	}
}