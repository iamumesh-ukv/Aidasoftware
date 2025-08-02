package com.aidasoftware.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSQuotationPage {

	WebDriver driver;

	//Objects
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement posAddQuoteButton;

	@FindBy(xpath = "//span[@id='select2-ddlCustomerID-container']")
	WebElement clickOnCustomerDrowpdown;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	List<WebElement> customerList;

	@FindBy(xpath = "----------")
	WebElement clickOnSalesTypeDropdown;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']//option")
	List<WebElement> salesTypeOptions;

	@FindBy(xpath = "//input[@id='txtInstallationDate']")
	WebElement clickOnDeliveryDate;

	@FindBy(xpath = "//a[@id='btnAddLineItem']")
	WebElement clickOnAddItemButton;

	@FindBy(xpath = "//span[@id='select2-ddlItemMaster-container']")
	WebElement clickOnSelectItemDropdown;

	@FindBy(xpath = "---------------")
	List<WebElement> itemList;

	@FindBy(xpath = "//input[@id='txtQty']")
	WebElement enterQuantity;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']")
	WebElement clickOnWorkTypeDropdown;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']//option")
	List<WebElement> workTypeOptions;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clickOnSaveButtonToSaveQuote;

	@FindBy(xpath = "//div[@class='mt10']//input[@value='Save']")
	WebElement clickOnSubmitAndGenerateSalesOrderButton;

	// constructor to initialize the object on this page
	public POSQuotationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action methods
	public POSQuotationPage clickOnPosQuoteButton() {
		posAddQuoteButton.click();

		// return new POSQuotationPage(driver);
		return this;
	}

	public void openCustomerDropdown() {
		clickOnCustomerDrowpdown.click();
	}

	public void selectCustomerByName(String customerName) {
		for (WebElement customer : customerList) {
			if (customer.getText().trim().equalsIgnoreCase(customerName)) {
				customer.click();
				break;
			}
		}
	}

	public void openSalesTypeDropdown() {
		clickOnSalesTypeDropdown.click();
	}

	public void selectSalesTypeByVisibleText(String typeName) {
		for (WebElement type : salesTypeOptions) {
			if (type.getText().trim().equalsIgnoreCase(typeName)) {
				type.click();
				break;
			}
		}
	}

	public void clickDeliveryDate() {
		clickOnDeliveryDate.click();
		// Use JSExecutor or sendKeys if needed for selecting date
	}

	public void clickAddItem() {
		clickOnAddItemButton.click();
	}

	public void openItemDropdown() {
		clickOnSelectItemDropdown.click();
	}

	public void selectItemByName(String itemName) {
		for (WebElement item : itemList) {
			if (item.getText().trim().equalsIgnoreCase(itemName)) {
				item.click();
				break;
			}
		}
	}

	public void enterQuantity(String quantity) {
		enterQuantity.clear();
		enterQuantity.sendKeys(quantity);
	}

	public void openWorkTypeDropdown() {
		clickOnWorkTypeDropdown.click();
	}

	public void selectWorkTypeByVisibleText(String workType) {
		for (WebElement option : workTypeOptions) {
			if (option.getText().trim().equalsIgnoreCase(workType)) {
				option.click();
				break;
			}
		}
	}

//	public void clickSave() {
//		clickOnSaveButton.click();
//	}

	public void clickSaveQuote() {
		clickOnSaveButtonToSaveQuote.click();
	}

	public void clickSubmitAndGenerateOrder() {
		clickOnSubmitAndGenerateSalesOrderButton.click();
	}
}
