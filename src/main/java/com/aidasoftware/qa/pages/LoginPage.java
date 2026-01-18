package com.aidasoftware.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Objects
	@FindBy(xpath = "//input[@id='txtEmailID']")
	WebElement emailAddressField;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='chkRememberMe']")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//h1[normalize-space()='Dashboard']")
	WebElement successmessageText;

	@FindBy(xpath ="//span[contains(text(),'Please enter Email Address')]")
	WebElement emailWarning;

	@FindBy(xpath = "//span[contains(text(),'Please enter Password')]")
	WebElement passwordWarning;

	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement emailPasswordNotMatchingWarning;

	@FindBy(xpath = "//a[@class='showMenu'][normalize-space()='Orders']")
	WebElement clickOnOrdersManu;

	@FindBy(xpath = "//a[normalize-space()='Quotes']")
	WebElement clickOnQuotePage;  
	
	               // Action Method

	// Generic reusable method (ONLY ONCE)
	public String getWarningText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed() ? element.getText().trim() : "";
		} catch (Exception e) {
			System.out.println("Warning not displayed: " + element);
			return "";
		}
	}

	public String successMessageGetText() {
		return successmessageText.getText();
	}

	public String retrieveEmailWarning() {
		return getWarningText(emailWarning);

	}

	public String retrievepasswordWarning() {
		return getWarningText(passwordWarning);
	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {

		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;

	}

	public void emailAddressField(String emailText) {
		emailAddressField.sendKeys(emailText);
	}

	public void passwordField(String passwordText) {
		passwordField.sendKeys(passwordText);

	}

	public LoginPage clickOnLoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}

	public QuotationPage navigateQuotationPage() {
		clickOnOrdersManu.click();
		return new QuotationPage(driver);
	}

	public DashboardPage login(String emailText, String passwordText) {
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();

		return new DashboardPage(driver);
	}
}
