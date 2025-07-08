package com.erp.automation.pages.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PiPopUpItemType {


	//Variables
		private WebDriver driver;
		//private WebDriverWait wait;


		@FindBy (xpath="(//input[@id='CheckMark'])[1]")
		private WebElement piGoods;

		@FindBy (xpath="(//span[text()='-Select-'])[1]")
		private WebElement selectOption;

		@FindBy (xpath="//li[text()='ASSETS']")
		private WebElement assets;

		@FindBy (xpath="//li[text()='RAW MATERIAL']")
		private WebElement rawMeterial;

		@FindBy (xpath="//li[text()='CONSUMABLES']")
		private WebElement consumables;

		// Constructor
				public  PiPopUpItemType (WebDriver driver){

				PageFactory.initElements(driver, this);
				this.driver=driver;
				  // wait=new WebDriverWait(driver,10);
				}

				// Methods
				public void clickOnPiPopUpItemTypePiGoods() {
					piGoods.click();

				}

				public void clickOnSelectOption() {
					selectOption.click();

				}

				public void selectAssetOption() throws InterruptedException {
					Thread.sleep(2000);
					assets.click();

				}


				public void selectrawMeterialOption() throws InterruptedException {
					Thread.sleep(2000);
					rawMeterial.click();

				}

				public void selectConsumableOption() throws InterruptedException {
					Thread.sleep(2000);
					consumables.click();

				}

}
