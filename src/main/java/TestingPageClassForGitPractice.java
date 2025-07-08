import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingPageClassForGitPractice {

	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy (xpath="gfhfgh")
	private WebElement searchField;

	@FindBy (xpath="gfhfghn")
	private WebElement firstResultAfterSearch;

	// Constructor
	public  TestingPageClassForGitPractice (WebDriver driver){

	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Methods
	public void zzz(String piNumber) {
	//wait.until(ExpectedConditions.visibilityOf(emailId));
	//	purchaseIndentMenu.click();
		searchField.sendKeys(piNumber);
	}


}
