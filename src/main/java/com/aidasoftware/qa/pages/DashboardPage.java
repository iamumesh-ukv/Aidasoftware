package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//a[normalize-space()='Point of Sale']")
	WebElement POSMainmanu;

	@FindBy(xpath="//a[normalize-space()='Quote']")
	WebElement POSQuotepage;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public POSQuotationPage navigateToPOSQuotationPage()
	{
		POSMainmanu.click();
		POSQuotepage.click();
		return new POSQuotationPage(driver);
	}
	
}
