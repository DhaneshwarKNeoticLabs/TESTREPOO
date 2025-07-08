package com.erp.automation.pages.master;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {

	// Variables
	private WebDriver driver;
	private WebDriverWait wait;

// Item Page

	@FindBy(xpath = "//button[@id='AddItem']")
	public WebElement addItemButton;

// Item Specifications

	@FindBy(xpath = "//span[@id='select2-ItemTypeId-container']")
	private WebElement itemType;

	@FindBy(xpath = "//label[text()='Item Type']")
	public WebElement itemTypeTitle;

	@FindBy(xpath = "(//input[@type='search'])[3]")
	private WebElement itemTypeSearchField;

	@FindBy(xpath = "//li[text()='CONSUMABLES']")
	private WebElement itemTypeFirstOption;

	@FindBy(xpath = "//span[@id='select2-ItemSubTypeCode-container']")
	private WebElement itemSubType;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
	private WebElement itemSubTypeSearchField;

	@FindBy(xpath = "//li[text()='Calculator']")
	private WebElement itemSubTypeFirstOption;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[3]")
	private WebElement itemAttribute;

	@FindBy(xpath = "//li[text()='Calculator']")
	private WebElement itemAttributeFirstOption;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[1]")
	private WebElement plantDD;

	@FindBy(xpath = "//li[text()='Plant-2']")
	private WebElement plantOne;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[4]")
	private WebElement Process;

//	@FindBy (xpath="")
//	private WebElement ProcessSearchField;

	@FindBy(xpath = "//li[text()='MIXING ']")
	private WebElement ProcessFirstOption;

	@FindBy(xpath = "//input[@id='ItemName']")
	private WebElement itemName;

	@FindBy(xpath = "(//span[@class='selection'])[6]")
	private WebElement shape;

	@FindBy(xpath = "//li[text()='1  CYLINDRICAL']")
	private WebElement shapeOptionsCylindrical;

	@FindBy(xpath = "(//span[@class='selection'])[7]")
	private WebElement material;

	@FindBy(xpath = "//li[text()='1 IRON']")
	private WebElement materialOptionIron;

	@FindBy(xpath = "(//span[@class='selection'])[8]")
	private WebElement uom;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
	private WebElement uomSearchField;

	@FindBy(xpath = "//li[text()='NOS']")
	private WebElement uomFirstOption;

	@FindBy(xpath = "//span[@id='select2-ToolMaterialId-container']")
	private WebElement toolMaterial;

	@FindBy(xpath = "//li[text()='ALUMINIUM']")
	private WebElement toolMaterialOptionAluminium;

	@FindBy(xpath = "//input[@id='PredictedQty']")
	private WebElement predictedQty;

	@FindBy(xpath = "(//span[@class='selection'])[11]")
	private WebElement productGroup;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
	private WebElement productGroupSearchField;

	@FindBy(xpath = "//li[text()='Homeappl-Home Appliances  ']")
	private WebElement productGroupFirstOption;

	@FindBy(xpath = "//span[@id='select2-GreenScrapId-container']")
	private WebElement greenScrap;

	@FindBy(xpath = "//li[text()='IRON GREEN SCRAP']")
	private WebElement greenScrapIron;

	@FindBy(xpath = "//input[@id='WtPerUnit']")
	private WebElement WeightPerUnit;

	@FindBy(xpath = "//input[@id='ExpToolLife']")
	private WebElement ExpectedToolLife;

	@FindBy(xpath = "//input[@id='ActualToolLife']")
	private WebElement ActualToolLife;

	@FindBy(xpath = "(//span[@class='selection'])[14]")
	private WebElement phase;

	@FindBy(xpath = "//li[text()='Production']")
	private WebElement phaseProductionOption;

	@FindBy(xpath = "(//input[@data-switchery='true'])[1]")
	private WebElement itemStatusCheckBox;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[1]")
	private WebElement itemStatusCheckBoxAction;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[2]")
	private WebElement ScrapCheckBox;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[3]")
	private WebElement isQyalityCheckRadioButton;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[5]")
	private WebElement isImportCapaxCheckBox;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[6]")
	private WebElement IsBOMRequired;

	// GST Details

	@FindBy(xpath = "//input[@id='HsnNo']")
	private WebElement hsnNo;

	@FindBy(xpath = "//input[@id='GeneralLedger']")
	private WebElement generalLedgerField;

	@FindBy(xpath = "/html/body/ul[4]/li/div")
	private WebElement generalLedger51210107;

	// Inventory Details

	@FindBy(xpath = "//input[@id='ReorderQty']")
	private WebElement reOrderQuantity;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[7]")
	private WebElement ShowInInventory;

	// Manufacturing Details

	@FindBy(xpath = "//input[@id='Manufacturer']")
	private WebElement manufacturer;

	@FindBy(xpath = "//input[@id='ManufacturingSrNo']")
	private WebElement modal;

	@FindBy(xpath = "//input[@id='ManufacturingYear']")
	private WebElement yearOfManufacturing;

	@FindBy(xpath = "/html/body/div[9]/div[3]/table/tbody/tr/td/span[1]")
	private WebElement SelectYearOfManufacturingOption2019;

	// others

	@FindBy(xpath = "//input[@id='ItemPicture']")
	private WebElement uploadFile;

	@FindBy(xpath = "//button[@id='btnMasterSave']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement confirmarionPopUp;



	// Constructor

	public ItemPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Methods

	public void clickOnAddItem() throws InterruptedException {
		addItemButton.click();
	}

	public void fillMangeItem() throws InterruptedException {
		addItemButton.click();
	}

	public void selectItemType() throws InterruptedException {
		itemType.click();
		itemTypeSearchField.sendKeys("Consum");
		wait.until(ExpectedConditions.elementToBeClickable(itemTypeFirstOption));

		itemTypeFirstOption.click();

	}

	public String getItemTypeTitle() {
		return itemTypeTitle.getText();
	}

	public boolean itemTypeSelection() throws InterruptedException {
		itemType.click();

		//wait.until(ExpectedConditions.elementToBeClickable(itemTypeSearchField));

		List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("ul#select2-ItemTypeId-results li"));
		Thread.sleep(500);
		//System.out.println(dropdownOptions);

		for(WebElement option : dropdownOptions )
		{
			if(option.getText().trim().equalsIgnoreCase("CONSUMABLES")) {
	            return true;
	        }
	}
		return true;

	}


	public boolean subItemTypeSelection() throws InterruptedException {
		itemSubType.click();

		//wait.until(ExpectedConditions.elementToBeClickable(itemTypeSearchField));

		List<WebElement> dropdownOptionsItemSub = driver.findElements(By.cssSelector("ul#select2-results__options li"));
		Thread.sleep(500);
		//System.out.println(dropdownOptions);

		for(WebElement option : dropdownOptionsItemSub )
		{
			if(option.getText().trim().equalsIgnoreCase("Calculator")) {
	            return true;
	        }
	}
		return true;

	}

	public void selectItemSubType() throws InterruptedException {
		itemSubType.click();
		itemSubTypeSearchField.sendKeys("calculator");
		wait.until(ExpectedConditions.elementToBeClickable(itemSubTypeFirstOption));
		itemSubTypeFirstOption.click();

	}



	public void selectItemAttribute() throws InterruptedException {
		Thread.sleep(1000);
		itemAttribute.click();
		wait.until(ExpectedConditions.elementToBeClickable(itemAttributeFirstOption));
		itemAttributeFirstOption.click();

	}

	public void selectPlantDD() throws InterruptedException {
		plantDD.click();
		wait.until(ExpectedConditions.elementToBeClickable(plantOne));
		plantOne.click();
	}

	public void selectProcess() throws InterruptedException {
		Process.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProcessFirstOption));
		ProcessFirstOption.click();
    }

	public void enterItemName() throws InterruptedException {
		// Generate random name
		Random rand = new Random();
		int randomNum = rand.nextInt(10000); // Generates number between 0-9999
		String randomName = "calculator_" + randomNum;

		itemName.click();
		itemName.sendKeys(randomName);
	}

	public void enterItemNameByUsingDataProvider(String NewItemName ) throws InterruptedException {
	itemName.click();
		itemName.sendKeys(NewItemName);
	}

	public void selectShape() throws InterruptedException {
		shape.click();
		wait.until(ExpectedConditions.elementToBeClickable(shapeOptionsCylindrical));
		shapeOptionsCylindrical.click();

	}

	public void selectMaterial() throws InterruptedException {
		material.click();
		wait.until(ExpectedConditions.elementToBeClickable(materialOptionIron));
		materialOptionIron.click();

	}

	public void selectUOM() throws InterruptedException {
		uom.click();
		wait.until(ExpectedConditions.visibilityOf(uomSearchField));
		uomSearchField.sendKeys("NOS");
		wait.until(ExpectedConditions.elementToBeClickable(uomFirstOption));
		uomFirstOption.click();
	}

	public void ToolMaterial() throws InterruptedException {
		toolMaterial.click();
		wait.until(ExpectedConditions.elementToBeClickable(toolMaterialOptionAluminium));
		toolMaterialOptionAluminium.click();

	}

	public void enterPredictedQty() throws InterruptedException {
		predictedQty.click();
		wait.until(ExpectedConditions.elementToBeClickable(predictedQty));
		predictedQty.sendKeys("1500500", Keys.ENTER);

	}

	public void selectProductGroup() throws InterruptedException {
		productGroup.click();
		wait.until(ExpectedConditions.elementToBeClickable(productGroupSearchField));
		productGroupSearchField.sendKeys("Home");
		wait.until(ExpectedConditions.elementToBeClickable(productGroupFirstOption));
		productGroupFirstOption.click();
	}

	public void selectGreenScrap() throws InterruptedException {
		greenScrap.click();
		wait.until(ExpectedConditions.elementToBeClickable(greenScrapIron));
		greenScrapIron.click();

	}

	public void selectWeightPerUnit() throws InterruptedException {
		WeightPerUnit.click();
		wait.until(ExpectedConditions.elementToBeClickable(WeightPerUnit));
		WeightPerUnit.sendKeys("500");

	}

	public void EnterExpectedToolLife() throws InterruptedException {
		ExpectedToolLife.click();
		wait.until(ExpectedConditions.elementToBeClickable(ExpectedToolLife));
		ExpectedToolLife.sendKeys("100000");

	}

	public void EnterActualToolLife() throws InterruptedException {
		ActualToolLife.click();
		wait.until(ExpectedConditions.elementToBeClickable(ActualToolLife));
		ActualToolLife.sendKeys("90000");

	}

	public void selectPhase() throws InterruptedException {
		phase.click();
		wait.until(ExpectedConditions.elementToBeClickable(phaseProductionOption));
		phaseProductionOption.click();
	}

	public void checkItemStatusRadioButton() throws InterruptedException {
		itemStatusCheckBoxAction.click();
		itemStatusCheckBoxAction.click();
		System.out.println("run method sucessfully -'checkItemStatusRadioButton'");
	}

	// method which returns the selection status

	public boolean isCheckBoxSelectedForItemStatusRadioButton() {

		return itemStatusCheckBox.isSelected();
	}

	public void selectScrapCheckBoxCheckRadioOption() throws InterruptedException {
		ScrapCheckBox.click();
		ScrapCheckBox.click();
	}

	public void selectIsQualityCheckRadioOption() throws InterruptedException {
		isQyalityCheckRadioButton.click();
		isQyalityCheckRadioButton.click();
		isQyalityCheckRadioButton.click();
	}

	public void selectIsImportCapexCheckRadioOption() throws InterruptedException {
		isImportCapaxCheckBox.click();
		isImportCapaxCheckBox.click();
	}

	public void selectIsBOMRequiredCheckRadioOption() throws InterruptedException {
		IsBOMRequired.click();
		IsBOMRequired.click();
	}

	// GST Details

	public void enterGSTDetails() throws InterruptedException {
		hsnNo.sendKeys("12345678");
		generalLedgerField.click();
		generalLedgerField.sendKeys("51210107");
		generalLedger51210107.click();
	}

	// Inventory Details
	public void enterInventoryDetails() throws InterruptedException {
		reOrderQuantity.clear();
		reOrderQuantity.sendKeys("10");
		ShowInInventory.click();
		Thread.sleep(2000);
		ShowInInventory.click();
	}

	// Manufacturing Details

	private static final String[] NAME_PREFIXES = { "Alpha", "Beta", "Omega", "Delta", "Nimbus", "Vertex", "Zenith",
			"Nova", "Astra", "Orion", "Fusion", "Quantum", "Titan", "Xeno", "Ranch", "Fatima", "Yuvati", "Nividia",
			"Ashlee", "Hinduja", "", "Echo", "Sierra", "Pinnacle", "Crest", "Vortex", "Horizon", "Summit", "Elysium",
			"Nebula", "Stratos", "Aurora", "Cobalt", "Infinity", "Vertex", "Celestial", "Solstice", "Paragon",
			"Genesis", "Vanguard", "Aegis", "Catalyst", "Odyssey", "Legacy", "Ember", "Radiance", "Serenity", "Haven",
			"Mirage", "Nexus", "Eclipse", "Zephyr", "Atlas", "Trinity", "Horizon", "Solara", "Vertex", "Synthesis",
			"Momentum", "Elysian", "Spectra", "Phoenix", "Aether", "Chronos", "Titanium" };

	public static String getRandomManufacturerName() {
		Random random = new Random();
		String prefix = NAME_PREFIXES[random.nextInt(NAME_PREFIXES.length)];
		int suffixNumber = 100 + random.nextInt(900); // Random 3-digit number
		return prefix + suffixNumber + " Pvt Ltd";
	}

	public void enterManufacturingDetails() throws InterruptedException {

		manufacturer.sendKeys(getRandomManufacturerName());
		modal.sendKeys("254535");
		yearOfManufacturing.click();
		SelectYearOfManufacturingOption2019.click();

	}

	public void uploadFileDocument() {
		File uploadFile = new File(
				"C:\\Users\\Administrator.DESKTOP-LE8QUGM\\eclipse-workspace\\erp-test-automation\\src\\test\\resources\\GeneralInvoiceReportt.pdf");

		// Wait until the file input element is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement OtherUploadFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ItemPicture")));

		// Send the file path to the hidden input field
		OtherUploadFile.sendKeys(uploadFile.getAbsolutePath());

		System.out.println("File uploaded successfully!-OtherUploadFile");

	}

	public void saveAndSubmitActionMethod() throws InterruptedException {
		saveButton.click();
		Thread.sleep(2300);
		confirmarionPopUp.click();
		Thread.sleep(500);
	}

}
