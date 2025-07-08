package com.erp.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.automation.utils.ExcelUtils;


public class ExcelTestLogIn {
    WebDriver driver;
//    String username;
//    String password;

    // Define locators using @FindBy annotation
    @FindBy(xpath="//input[@id='UserName']")
    private WebElement usernameField;

    @FindBy (xpath="//input[@id='PassWord']")
    private WebElement passwordField;

    @FindBy(xpath="//button[normalize-space()='Sign in']")
    private WebElement loginButton;

    // Constructor to initialize WebElements
    public ExcelTestLogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to log in using Excel data
    public void loginFromExcel(String excelPath, String sheetName) throws InterruptedException {
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

        String username = excel.getCellData(1, 0); // Get username from Excel (Row 1, Column 0)
        String password = excel.getCellData(1, 1); // Get password from Excel (Row 1, Column 1)

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        Thread.sleep(3000);
       // loginButton.click();

        excel.closeWorkbook(); // Close the Excel file after use
    }
}
