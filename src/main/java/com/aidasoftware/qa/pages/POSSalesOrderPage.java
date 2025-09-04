package com.aidasoftware.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSSalesOrderPage {

	WebDriver driver;

	// ===== Objects on Sales Order Page =====

	@FindBy(xpath = "//span[@id='select2-ddlCustomerID-container']")
	WebElement customerDropdown;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	List<WebElement> customerOptions;

	@FindBy(xpath = "//input[@id='txtOrderDate']")
	WebElement orderDateInput;

	@FindBy(xpath = "//a[@id='btnAddLineItem']")
	WebElement addItemButton;

	@FindBy(xpath = "//span[@id='select2-ddlItemMaster-container']")
	WebElement itemDropdown;

	@FindBy(xpath = "//ul[@id='select2-ddlItemMaster-results']//li")
	List<WebElement> itemOptions;

	@FindBy(xpath = "//input[@id='txtQty']")
	WebElement quantityInput;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']")
	WebElement workTypeDropdown;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']//option")
	List<WebElement> workTypeOptions;

	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	WebElement remarksTextArea;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='mt10']//input[@value='Submit']")
	WebElement submitButton;

	// ===== Constructor =====
	public POSSalesOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===== Action Methods =====

	public void selectCustomer(String customerName) {
		customerDropdown.click();
		for (WebElement customer : customerOptions) {
			if (customer.getText().trim().equalsIgnoreCase(customerName)) {
				customer.click();
				break;
			}
		}
	}

	public void enterOrderDate(String date) {
		orderDateInput.clear();
		orderDateInput.sendKeys(date);
	}

	public void clickAddItem() {
		addItemButton.click();
	}

	public void selectItem(String itemName) {
		itemDropdown.click();
		for (WebElement item : itemOptions) {
			if (item.getText().trim().equalsIgnoreCase(itemName)) {
				item.click();
				break;
			}
		}
	}

	public void enterQuantity(String qty) {
		quantityInput.clear();
		quantityInput.sendKeys(qty);
	}

	public void selectWorkType(String workType) {
		for (WebElement option : workTypeOptions) {
			if (option.getText().trim().equalsIgnoreCase(workType)) {
				option.click();
				break;
			}
		}
	}

	public void enterRemarks(String remarks) {
		remarksTextArea.clear();
		remarksTextArea.sendKeys(remarks);
	}

	public void saveOrder() {
		saveButton.click();
	}

	public void submitOrder() {
		submitButton.click();
	}

}
