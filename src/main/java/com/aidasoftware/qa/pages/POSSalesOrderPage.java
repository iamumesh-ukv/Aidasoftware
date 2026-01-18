package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSSalesOrderPage {

	WebDriver driver;
	private WebDriverWait wait;

	// ===== Objects on Sales Order Page =====

	@FindBy(xpath = "//a[@class='showMenu' and contains(., 'Point of Sale')]")
	WebElement clickOnPointOfSaleManu;

	@FindBy(xpath = "//a[@href='/POSSalesOrder/Manage']")
	WebElement clickOnPOSSalesOrderPage;

	@FindBy(xpath = "//img[contains(@src,'edit.png')]")
	WebElement clickOnSalesOrderEditButton;

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
	WebElement enterQuantity;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']")
	WebElement workTypeDropdown;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']//option")
	List<WebElement> workTypeOptions;

	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	WebElement remarksTextArea;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='mt10 btnAlign']//input[@value='Update']")
	WebElement updateButton;

	// ===== Constructor =====
	public POSSalesOrderPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// ===== Action Methods =====

	public POSSalesOrderPage clickOnPOSManu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPointOfSaleManu)).click();
		clickOnPointOfSaleManu.click();
		return this;
	}

	public void clickOnPOSSalesOrderPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPOSSalesOrderPage)).click();
		// clickOnPOSSalesOrderPage.click();
	}

	public void clickOnSalesOrderEditButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSalesOrderEditButton)).click();
		// clickOnSalesOrderEditButton.click();
	}
//	public void selectCustomer(String customerName) {
//		customerDropdown.click();
//		for (WebElement customer : customerOptions) {
//			if (customer.getText().trim().equalsIgnoreCase(customerName)) {
//				customer.click();
//				break;
//			}
//		}
//	}
//
//	public void enterOrderDate(String date) {
//		orderDateInput.clear();
//		orderDateInput.sendKeys(date);
//	}
//
//	public void clickAddItem() {
//		addItemButton.click();
//	}

//	public void selectItem(String itemName) {
//		itemDropdown.click();
//		for (WebElement item : itemOptions) {
//			if (item.getText().trim().equalsIgnoreCase(itemName)) {
//				item.click();
//				break;
//			}
//		}
//	}

	public void enterIssueQuantity(String issueQuantity) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait until element is visible
	    WebElement element = wait.until(
	            ExpectedConditions.visibilityOf(enterQuantity)
	    );

	    // Scroll element into view
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});", element  );

	    // Clear and enter value
	    element.clear();
	    element.sendKeys(issueQuantity);
	}
//	public void selectWorkType(String workType) {
//		for (WebElement option : workTypeOptions) {
//			if (option.getText().trim().equalsIgnoreCase(workType)) {
//				option.click();
//				break;
//			}
//		}
//	}
//
//	public void enterRemarks(String remarks) {
//		remarksTextArea.clear();
//		remarksTextArea.sendKeys(remarks);
//	}
//
//	public void saveOrder() {
//		saveButton.click();
//	}

	public void clickUpdateSalesOrderButton() {
		updateButton.click();
	}

}
