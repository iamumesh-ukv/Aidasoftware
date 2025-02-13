package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public  LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Objects
	@FindBy(xpath="//input[@id='txtEmailID']")
	WebElement emailAddressField;

	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passwordField;

	@FindBy(xpath="//input[@id='chkRememberMe']")
	WebElement rememberCheckBox;

	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginButton;

	@FindBy(xpath="//span[@id='spnValidateEmail']()='Please enter Email Address'")
	WebElement emailWarning;

	@FindBy(xpath="//span[@id='spnValidatePassword']()='Please enter Password'")
	WebElement passwordWarning;


	public void emailAddressField(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	public void passwordField(String passwordText)
	{
		passwordField.sendKeys(passwordText);

	}

	public String retrieveEmailWarning()
	{
		String emaiWarningText = emailWarning.getText();
		return emaiWarningText;
	}
	public String retrievepasswordWarning()
	{
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}

	public LoginPage clickOnLoginButton()
	{
		loginButton.click();
		return new LoginPage(driver);
	}
	public LoginPage login(String emailText, String passwordText)
	{
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new LoginPage(driver);
	}

}
