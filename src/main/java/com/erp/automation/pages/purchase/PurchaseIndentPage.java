
package com.erp.automation.pages.purchase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseIndentPage {




	//Variables
		private WebDriver driver;
		private WebDriverWait wait;


		@FindBy (xpath="//a[@id='AddDiv']")
		private WebElement clickOnAddPi;

		@FindBy (xpath="//span[@id='select2-ModalPlantId-container']")
		private WebElement plantSelectionPopUpOption;

		@FindBy (xpath="/html/body/span/span/span[2]/ul/li[3]")
		WebElement selectPlantTwoOption;

		@FindBy (xpath="//button[@id='btnPlantNext']")
		WebElement clickNextButton;

		@FindBy (xpath="//input[@id='SerchPiNo']")
		WebElement piNumberField;

		@FindBy (xpath="//button[@id='Searchbtn']")
		WebElement searchButton;

		@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/div[3]/div/table/thead/tr/th[1]")
		WebElement indentHeaderName;

		@FindBy (xpath="/html/body/section/div/div[2]/div[1]/div/div[3]/div/table/tbody/tr[1]/td[1]")
		WebElement firstRow;

		@FindBy (xpath="//button[@class='btn btn-success btn-xs CreatePO']")
		WebElement createPo;
		//----------select Plant Pop up

		@FindBy (xpath="//button[@id='btnPlantNext']")
		WebElement nextBtnFromSelectPlantPopUp;

		//----------select PO Type first Pop up
		@FindBy (xpath="/html/body/section/div/div[6]/div/div/div[2]/div/div[2]/span[1]/span[1]/span")
		WebElement selectDropDownFromSelectPoTypePopUp;

		@FindBy (xpath="//li[text()='CONSUMABLES']")
		WebElement consumableOptionFromDropDown;

		@FindBy (xpath="//button[@id='btnPIPONext']")
		WebElement nextBtnFromSelectPoTypePopUp;

		//----------select PO Type second Pop up

		@FindBy (xpath="//button[@id='btnClosePo']")
		WebElement oneTimeFromPoTypePopUp;

		//----------select purchase indent PopUp
		@FindBy (xpath="/html/body/section/div/div[9]/div/div/div[2]/div[1]/div[2]/span[1]/span[1]/span")
		WebElement vendorField;

		@FindBy (xpath="(//input[@class='select2-search__field'])[2]")
		WebElement vendorInputField;

		@FindBy (xpath="//li[text()='Mayur Traders']")
		WebElement selectMayurTradersOption;

		@FindBy (xpath="/html/body/section/div/div[9]/div/div/div[2]/div[2]/div/table/thead/tr/th[1]/div")
		WebElement selectAllCheckBox;

		@FindBy (xpath="//button[@id='btnFinish']")
		WebElement addItemsButton;

		// Constructor
		public  PurchaseIndentPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}

		// Methods
		public void clickOnAddPurchaseIndent() {
			clickOnAddPi.click();

		}

		public void selctioinOfPlantTwoAfterAddPurchaseIndent() throws InterruptedException  {

			//clickOnAddPi.click();
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebElement element = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single clssclass']"));
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].click();", element);
////			Thread.sleep(5000);
			plantSelectionPopUpOption.click();

			selectPlantTwoOption.click();
			clickNextButton.click();
			}

		public void clickOnSearch() {
			wait.until(ExpectedConditions.visibilityOf(searchButton));
			searchButton.click();

		}

//		public void clickOnIndentHeaderAndSelectFirstRowAndClickOnCreatePo() throws InterruptedException {
//			wait.until(ExpectedConditions.visibilityOf(indentHeaderName));
//			indentHeaderName.click();
//			wait.until(ExpectedConditions.visibilityOf(firstRow));
//			firstRow.click();
//			Thread.sleep(2000);
//		//	wait.until(ExpectedConditions.visibilityOf(createPo));
//			createPo.click();
//
//		}

		public void clickOnIndentHeaderAndSelectFirstRowAndClickOnCreatePo() {
		    try {
		        wait.until(ExpectedConditions.visibilityOf(indentHeaderName));
		        indentHeaderName.click();
		        System.out.println("Indent header clicked.");

		        wait.until(ExpectedConditions.visibilityOf(firstRow));
		        firstRow.click();
		        System.out.println("First row selected.");

		        Thread.sleep(2000); // You may replace this with an explicit wait if possible.

		        // wait.until(ExpectedConditions.visibilityOf(createPo));
		        createPo.click();
		        System.out.println("Create PO clicked.");
		    } catch (Exception e) {
		        System.out.println("Error occurred while creating PO: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

		public void clickOnNextBtnFromSelectPlantPopUp() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(nextBtnFromSelectPlantPopUp));
			Thread.sleep(3000);
			nextBtnFromSelectPlantPopUp.click();
			Thread.sleep(3000);


		}

		public void selectPoTypeConsumableFromPopUpAndNext() {
			wait.until(ExpectedConditions.visibilityOf(selectDropDownFromSelectPoTypePopUp));
			selectDropDownFromSelectPoTypePopUp.click();
			wait.until(ExpectedConditions.visibilityOf(consumableOptionFromDropDown));
			consumableOptionFromDropDown.click();
			wait.until(ExpectedConditions.visibilityOf(nextBtnFromSelectPoTypePopUp));
			nextBtnFromSelectPoTypePopUp.click();

		}

		public void selectOneTimeFromPoTypePopUp() {
			wait.until(ExpectedConditions.visibilityOf(oneTimeFromPoTypePopUp));
			oneTimeFromPoTypePopUp.click();


		}

		public void operationOnSelectPurchaseIndentPopUp() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(vendorField));
			vendorField.click();
			wait.until(ExpectedConditions.visibilityOf(vendorInputField));
			vendorInputField.sendKeys("Mayur Trader");
			wait.until(ExpectedConditions.visibilityOf(selectMayurTradersOption));
			selectMayurTradersOption.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(selectAllCheckBox));
			selectAllCheckBox.click();
			wait.until(ExpectedConditions.visibilityOf(addItemsButton));
			addItemsButton.click();




		}

}


