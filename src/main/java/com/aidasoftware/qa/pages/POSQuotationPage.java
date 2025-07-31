package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSQuotationPage {

	WebDriver driver;

	// Objects
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement posAddQuoteButton;

	@FindBy(xpath = "//span[@id='select2-ddlCustomerID-container']")
	WebElement clickOnCustomerDrowpdown;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	WebElement selectCustomer;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	WebElement clickOnSalesTypeDropdown;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']//option")
	WebElement selectSalesType;

	@FindBy(xpath = "//input[@id='txtInstallationDate']")
	WebElement clickOnDeliveryDate;

	@FindBy(xpath = "//a[@id='btnAddLineItem']")
	WebElement clickOnAddItemButton;

	@FindBy(xpath = "//span[@id='select2-ddlItemMaster-container']")
	WebElement clickOnSelectItemDropdown;

	@FindBy(xpath = "---------------")
	WebElement selectItem;

	@FindBy(xpath = "//input[@id='txtQty']")
	WebElement enterQuantity;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']")
	WebElement clickOnWorkTypeDropdown;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']//option")
	WebElement selectWorkType;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clickOnSaveButton;

	@FindBy(xpath = "//div[@class='mt10']//input[@value='Save']")
	WebElement clickOnSaveButtonToSaveQuote;

	@FindBy(xpath = "//div[@class='mt10']//input[@value='Save']")
	WebElement clickOnSubmitAndGenerateSalesOrderButton;

	//constructor to initialize the object on this page
	public POSQuotationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public POSQuotationPage clickOnPosQuoteButton() {
		posAddQuoteButton.click();

		return new POSQuotationPage(driver);
	}
}
