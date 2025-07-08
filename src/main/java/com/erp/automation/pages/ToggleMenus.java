package com.erp.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToggleMenus {


	//Variables
		private WebDriver driver;
	 	private WebDriverWait wait;


		@FindBy (xpath="//a[@data-toggle='menubar']")
		private WebElement toggleMenuBarIcon;

		@FindBy (xpath="//li[@class='site-menu-item active']//a")
		private WebElement dashboardMenuIcon;

		@FindBy (xpath="//div[@id='mm-0']//li[3]//a[1]")
		WebElement purchaseMenuIcon;

		@FindBy (xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]")
		WebElement salesMenuIcon;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[6]/a[1]")
		WebElement materialTransactionMenuIcon;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[15]/a[1]")
		WebElement accountFinanceMenuIcon;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[2]/a[1]")
		WebElement masterMenuIcon;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[13]/a[1]")
		WebElement ReportsMenuIcon;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[5]/a[1]")
		WebElement productionMenu;

		@FindBy (xpath="/html/body/div[2]/div[2]/div[1]/ul/li[7]/a[1]")
		WebElement toolingMenu;


		// Constructor
		public  ToggleMenus (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}

		// Methods
		public void clickOnToggleMenu() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(toggleMenuBarIcon));
			Thread.sleep(2000);
			toggleMenuBarIcon.click();
		}

		public void clickOnPurchaseMenuIcon() {

			purchaseMenuIcon.click();
		}

		public void clickOnsalesMenuIcon() {
			salesMenuIcon.click();
		}

		public void clickOnmaterialTransactionMenuIcon() {
			wait.until(ExpectedConditions.elementToBeClickable(materialTransactionMenuIcon));
			materialTransactionMenuIcon.click();
		}

		public void clickOnAccountFinanceMenuIcon() {
			wait.until(ExpectedConditions.elementToBeClickable(accountFinanceMenuIcon));
			accountFinanceMenuIcon.click();
		}

		public void clickOnMasterMenuIcon() {
			wait.until(ExpectedConditions.elementToBeClickable(masterMenuIcon));
			masterMenuIcon.click();
		}

		public void clickOnReportsMenuIcon() {
			wait.until(ExpectedConditions.elementToBeClickable(ReportsMenuIcon));
			ReportsMenuIcon.click();
		}

		public void productionMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(productionMenu));
			productionMenu.click();
		}


		public void toolingMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(toolingMenu));
			toolingMenu.click();
		}


}
