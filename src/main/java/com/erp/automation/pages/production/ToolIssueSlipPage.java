package com.erp.automation.pages.production;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolIssueSlipPage {


	//Variables
		private WebDriver driver;
		private WebDriverWait wait;


		@FindBy (xpath="//input[@id='txtItemCode']")
		private WebElement itemCode;

		@FindBy (xpath="/html/body/ul[2]/li/div")
		private WebElement itemCodeFirstResult;

		@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[3]")
		private WebElement processField;

		@FindBy (xpath="//li[text()='FORMING']")
		private WebElement processFieldFormingOption;

		@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[4]")
		private WebElement noOfCavity;

		@FindBy (xpath="//li[text()='1']")
		private WebElement noOfCavityDropDown1;

		//WorkOrder
		@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[5]")
		private WebElement workOrderField;

		@FindBy (xpath="//input[@class='select2-search__field']")
		private WebElement workOrderInputField;

		@FindBy (xpath="//li[text()='SHL/0006/05/2025']")
		private WebElement workOrderFirstOption;

		//Machine
		@FindBy (xpath="(//span[@class='select2-selection select2-selection--single'])[6]")
		private WebElement machineField;

		@FindBy (xpath="//input[@class='select2-search__field']")
		private WebElement machineInputField;

		//@FindBy (xpath="//li[text()='100F1']")
		@FindBy (xpath="/html/body/span/span/span[2]/ul/li[1]")
		private WebElement machineFirstOption;

		// Operator
		@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[7]")
		private WebElement operatorField;

		@FindBy(xpath = "//input[@class='select2-search__field']")
		private WebElement operatorInputField;

		@FindBy(xpath = "//li[text()='ABHIJIT  GAJANAN  MOHITE ']")
		private WebElement OperatorFirstOption;

		// Shift
		@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[8]")
		private WebElement shiftField;

		@FindBy(xpath = "//input[@class='select2-search__field']")
		private WebElement shiftInputField;

		@FindBy(xpath = "//li[text()='1ST SHIFT']")
		private WebElement shiftFirstOption;

		//Tool Details:-

		//BP

		@FindBy(xpath = "(//i[@class='md md-plus'])[1]")
		private WebElement addBPButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement toolNameField;

		@FindBy(xpath = "/html/body/ul[3]/li[1]/div")
		private WebElement toolNameFirstOption;


		//CP


		@FindBy(xpath = "(//i[@class='md md-plus'])[2]")
		private WebElement addCPButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement CPField;

		@FindBy(xpath = "/html/body/ul[4]/li/div")
		private WebElement CPFirstOption;



		//CR

		@FindBy(xpath = "(//i[@class='md md-plus'])[3]")
		private WebElement addCRButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement CRField;

		@FindBy(xpath = "/html/body/ul[5]/li/div")
		private WebElement CRFirstOption;

		//DIE
		@FindBy(xpath = "(//i[@class='md md-plus'])[4]")
		private WebElement addDIEButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement DIEField;

		@FindBy(xpath = "/html/body/ul[6]/li/div")
		private WebElement DIEFirstOption;

		//TMAN
		@FindBy(xpath = "(//button[@type='button'])[12]")
		private WebElement addTMANButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement TMANField;

		@FindBy(xpath = "/html/body/ul[7]/li/div")
		private WebElement TMANFirstOption;

		//TP
		@FindBy(xpath = "(//button[@type='button'])[14]")
		private WebElement addTPButton;

		@FindBy(xpath = "//input[@class='txtItemName form-control']")
		private WebElement TPField;

		@FindBy(xpath = "/html/body/ul[8]/li/div")
		private WebElement TPFirstOption;



		// Adapter Details:-



		//Save button
		@FindBy(xpath = "//button[@id='btnSave']")
		private WebElement savebutton;

		@FindBy(xpath = "//button[text()='OK']")
		private WebElement okButtonFromPopUp;





		// Constructor
		public  ToolIssueSlipPage (WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}


		// Methods
		public void enterToolIssueSlipDetails() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(itemCode));
		itemCode.sendKeys("11010");
		wait.until(ExpectedConditions.elementToBeClickable(itemCodeFirstResult));
		itemCodeFirstResult.click();
		//Assertion should be implement for auto
		wait.until(ExpectedConditions.elementToBeClickable(processField));
		processField.click();
		wait.until(ExpectedConditions.elementToBeClickable(processFieldFormingOption));
		processFieldFormingOption.click();
		wait.until(ExpectedConditions.elementToBeClickable(noOfCavity));
		noOfCavity.click();
		wait.until(ExpectedConditions.elementToBeClickable(noOfCavityDropDown1));
		noOfCavityDropDown1.click();
		//WorkOrder
		wait.until(ExpectedConditions.elementToBeClickable(workOrderField));
		workOrderField.click();
		wait.until(ExpectedConditions.elementToBeClickable(workOrderInputField));
		workOrderInputField.sendKeys("SHL/0006/05/2025");
		wait.until(ExpectedConditions.elementToBeClickable(workOrderFirstOption));
		workOrderFirstOption.click();
		//Machine
		wait.until(ExpectedConditions.elementToBeClickable(machineField));
		machineField.click();
		wait.until(ExpectedConditions.elementToBeClickable(machineInputField));
		machineInputField.sendKeys("100F1");
		wait.until(ExpectedConditions.elementToBeClickable(machineFirstOption));
		machineFirstOption.click();
		//Operator
		wait.until(ExpectedConditions.elementToBeClickable(operatorField));
		operatorField.click();
		wait.until(ExpectedConditions.elementToBeClickable(operatorInputField));
		operatorInputField.sendKeys("ABHIJIT  GAJANAN  MOHITE ");
		wait.until(ExpectedConditions.elementToBeClickable(OperatorFirstOption));
		OperatorFirstOption.click();

		// Shift
		wait.until(ExpectedConditions.elementToBeClickable(shiftField));
		shiftField.click();
		wait.until(ExpectedConditions.elementToBeClickable(shiftInputField));
		shiftInputField.sendKeys("1ST SHIFT");
		wait.until(ExpectedConditions.elementToBeClickable(shiftFirstOption));
		shiftFirstOption.click();

		//Tool Details:-

			 	//bp
		wait.until(ExpectedConditions.elementToBeClickable(addBPButton));
		addBPButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(toolNameField));
		toolNameField.sendKeys("11010");
		wait.until(ExpectedConditions.elementToBeClickable(toolNameFirstOption));
		toolNameFirstOption.click();

			//cp

		wait.until(ExpectedConditions.elementToBeClickable(addCPButton));
		addCPButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(CPField));
		CPField.sendKeys("11010");
		wait.until(ExpectedConditions.elementToBeClickable(CPFirstOption));
		CPFirstOption.click();

		//Cr

		wait.until(ExpectedConditions.elementToBeClickable(addCRButton));
		addCRButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(CRField));
		CRField.sendKeys("11010");
		wait.until(ExpectedConditions.elementToBeClickable(CRFirstOption));
		CRFirstOption.click();


		//die
		wait.until(ExpectedConditions.elementToBeClickable(addDIEButton));
		addDIEButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(DIEField));
		DIEField.sendKeys("11010");
		wait.until(ExpectedConditions.elementToBeClickable(DIEFirstOption));
		DIEFirstOption.click();

		//tman
/*
		wait.until(ExpectedConditions.elementToBeClickable(addTMANButton));
		addTMANButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(TMANField));
		TMANField.sendKeys("11055");
		wait.until(ExpectedConditions.elementToBeClickable(TMANFirstOption));
		TMANFirstOption.click();

		//TP

		wait.until(ExpectedConditions.elementToBeClickable(addTPButton));
		addTPButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(TPField));
		TPField.sendKeys("11055");
		wait.until(ExpectedConditions.elementToBeClickable(TPFirstOption));
		TPFirstOption.click();

		*/

//=========================================================================================


//		//TP
//
//		wait.until(ExpectedConditions.elementToBeClickable(addTPButton));
//		addTPButton.click();
//		wait.until(ExpectedConditions.elementToBeClickable(TPField));
//		TPField.sendKeys("11055");
//		wait.until(ExpectedConditions.elementToBeClickable(TPFirstOption));
//		TPFirstOption.click();



		//Adapter Details:-

		//Add Adapter Button

		//Adapter Code = item sub-type


		//Adapter Name = item Attribute



		//Save Button

		wait.until(ExpectedConditions.elementToBeClickable(savebutton));
		savebutton.click();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromPopUp));

//		okButtonFromPopUp.click();
//		Thread.sleep(7000);
//		wait.until(ExpectedConditions.elementToBeClickable(okButtonFromPopUp));
//
//		okButtonFromPopUp.click();
//		Thread.sleep(5000);
//
		}




}
