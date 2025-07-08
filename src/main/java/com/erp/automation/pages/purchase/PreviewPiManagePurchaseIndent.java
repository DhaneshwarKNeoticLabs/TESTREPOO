package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreviewPiManagePurchaseIndent {

	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="//button[@id='btnApprove']")
	private WebElement approveButton;


	@FindBy (xpath="//button[@class='confirm']")
	private WebElement successPopUpOkButton;

	// Constructor
	public  PreviewPiManagePurchaseIndent (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void clickOnPiApprove() {
		  wait.until(ExpectedConditions.visibilityOf(approveButton));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", approveButton);
	        wait.until(ExpectedConditions.visibilityOf(successPopUpOkButton));
	       successPopUpOkButton.click();

	}


}
