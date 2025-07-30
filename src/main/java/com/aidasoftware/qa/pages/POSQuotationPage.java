package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSQuotationPage {

	WebDriver driver;

	// Object
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement posAddQuoteButton;

	public POSQuotationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	public POSQuotationPage clickOnPosQuoteButton() {
		posAddQuoteButton.click();

		return new POSQuotationPage(driver);
	}
}
