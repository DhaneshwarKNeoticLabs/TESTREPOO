package com.erp.automation.pages.production;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolReturnPage {

	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// Initial PopUp ===== Tool Issue Details

	@FindBy(xpath = "//input[@id='Item']")
	public WebElement item;

	@FindBy(xpath = "//button[@id='Searchbtn']")
	public WebElement searchButton;

	@FindBy(xpath = "/html/body/section/div/div[3]/div/div/div[2]/div[2]/div/table/tbody/tr")
	public WebElement firstRowSelection;


//Main Tool Return Page

	@FindBy(xpath = "(//span[@role='combobox'])[2]")
	public WebElement supervisorField;

	@FindBy(xpath = "//span[text()='ANIL  VISHNU ADBHAI']")
	public WebElement supervisorFieldOption;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement supervisorInputField;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	public WebElement supervisorFieldFirstResult;

	@FindBy(xpath = "//input[@id='ProducedQty']")
	public WebElement producedQty;

	@FindBy(xpath = "//input[@id='Remark']")
	public WebElement mainRemarkField;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[1]")
	public WebElement checkbox01;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[3]")
	public WebElement checkbox02;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[5]")
	public WebElement checkbox03;

	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[7]")
	public WebElement checkbox04;

	@FindBy(xpath = "(//input[@class='form-control ProducedQuantity'])[2]")
	public WebElement producedQty01;

	@FindBy(xpath = "(//input[@class='form-control ProducedQuantity'])[3]")
	public WebElement producedQty02;

	@FindBy(xpath = "(//input[@class='form-control ProducedQuantity'])[4]")
	public WebElement producedQty03;

	@FindBy(xpath = "(//input[@class='form-control ProducedQuantity'])[5]")
	public WebElement producedQty04;

	@FindBy(xpath = "(//input[@class='Remark form-control'])[1]")
	public WebElement remark01;

	@FindBy(xpath = "(//input[@class='Remark form-control'])[2]")
	public WebElement remark02;

	@FindBy(xpath = "(//input[@class='Remark form-control'])[3]")
	public WebElement remark03;

	@FindBy(xpath = "(//input[@class='Remark form-control'])[4]")
	public WebElement remark04;

	@FindBy(xpath = "//button[@id='btnSave']")
	public WebElement saveButton;

	@FindBy(xpath = "/html/body/div[8]/p/b")
	public WebElement toolReturnNoFromPopUp;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement okButton;

	//confirmation popup




	// Constructor

	public ToolReturnPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void enterDetailsinToolIssueDetailsPopUp() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(item));
		item.sendKeys("11010");
		searchButton.click();
		Thread.sleep(1000);
		firstRowSelection.click();
		Thread.sleep(1000);
	}

	public void enterDetailsInToolReturnPage() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(supervisorField));
		supervisorField.click();
//		wait.until(ExpectedConditions.elementToBeClickable(supervisorFieldOption));
//		supervisorFieldOption.click();
		wait.until(ExpectedConditions.elementToBeClickable(supervisorInputField));
		supervisorInputField.sendKeys("ANIL  VISHNU ADBHAI");
		Thread.sleep(1500);
		supervisorFieldFirstResult.click();

		producedQty.sendKeys("5000");
		wait.until(ExpectedConditions.elementToBeClickable(mainRemarkField));
		mainRemarkField.sendKeys("Test Remark-ok");
		checkbox01.click();
		checkbox02.click();
		checkbox03.click();
		checkbox04.click();
		producedQty01.sendKeys("5000");
		producedQty02.sendKeys("5000");
		producedQty03.sendKeys("5000");
		producedQty04.sendKeys("5000");
		remark01.sendKeys("Test Remark-ok");
		remark02.sendKeys("Test Remark-ok");
		remark03.sendKeys("Test Remark-ok");
		remark04.sendKeys("Test Remark-ok");
		saveButton.click();
		Thread.sleep(2000);
		String toolReturnNO = toolReturnNoFromPopUp.getText();
		System.out.println("--toolReturnNoFromPopUp is" + toolReturnNO);
		Thread.sleep(1000);
		okButton.click();
		Thread.sleep(1000);





	}


}
