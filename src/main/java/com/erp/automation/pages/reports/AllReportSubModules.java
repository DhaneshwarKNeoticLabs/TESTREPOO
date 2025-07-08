package com.erp.automation.pages.reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllReportSubModules {


	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// All Report SubModules Page

	@FindBy(xpath = "//a[@href='#mm-24']")
	public WebElement productionReport;



	@FindBy(xpath = "")
	private WebElement s;


	public AllReportSubModules(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods

		public void clickOnProductionReport() throws InterruptedException {
			productionReport.click();
		}
}
