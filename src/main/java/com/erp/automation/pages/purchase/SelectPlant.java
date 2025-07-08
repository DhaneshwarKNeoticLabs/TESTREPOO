package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPlant {



	//Variables
		private WebDriver driver;
		private WebDriverWait wait;

		@FindBy (xpath="//button[@id='plant0']")
		private WebElement plantOne;

		@FindBy (xpath="//button[@id='plant1']")
		private WebElement plantTwo;

		// Constructor
		public SelectPlant(WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		}

		// Methods


		public void selectPlantOne() throws InterruptedException {
			Thread.sleep(5000);
		    // Wait for the modal to be visible
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));

		    // Locate the table
		    WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));

		    // Now find the button inside the table
		    WebElement plantOne = table.findElement(By.xpath("//button[@id='plant0']"));

		    // Wait until the button is clickable
		    wait.until(ExpectedConditions.elementToBeClickable(plantOne)).click();
		}

		public void selectPlantTwo() throws InterruptedException {
			Thread.sleep(5000);
		    // Wait for the modal to be visible
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));

		    // Locate the table
		    WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));

		    // Now find the button inside the table
		    WebElement plantOne = table.findElement(By.xpath("//button[@id='plant1']"));

		    // Wait until the button is clickable
		    wait.until(ExpectedConditions.elementToBeClickable(plantOne)).click();
		}








}
