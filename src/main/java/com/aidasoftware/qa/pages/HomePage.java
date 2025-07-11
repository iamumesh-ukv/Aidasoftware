package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;


	//Objects
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement loginOption; 

	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage navigateToLoginPage()
	{
		return new LoginPage(driver);
	}

	public LoginPage selectLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver);

	}
}