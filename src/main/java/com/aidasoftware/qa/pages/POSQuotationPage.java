package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSQuotationPage {

	WebDriver driver;
	private WebDriverWait wait;

	// Objects
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement posAddQuoteButton;

	@FindBy(xpath = "//span[@id='select2-ddlCustomerID-container']")
	WebElement clickOnCustomerDrowpdown;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	List<WebElement> customerList;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']")
	WebElement clickOnSalesTypeDropdown;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']//option")
	List<WebElement> salesTypeOptions;

	// Objects for date picker
	@FindBy(xpath = "//input[@id='txtInstallationDate']")
	WebElement clickOnDeliveryDate;

	@FindBy(xpath = "//div[contains(@class,'xdsoft_monthselect')]//div[contains(@class,'xdsoft_option')]")
	List<WebElement> monthLabels;

	@FindBy(xpath = "//div[contains(@class,'xdsoft_yearselect')]//div[contains(@class,'xdsoft_option')]")
	List<WebElement> yearLabels;

	@FindBy(xpath = "//button[@class='xdsoft_next']") // Next button in calendar
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='xdsoft_prev']") // Previous button in calendar
	WebElement prevBtn;

	@FindBy(xpath = "//a[@id='btnAddLineItem']")
	WebElement clickOnAddItemButton;

	@FindBy(xpath = "//span[@id='select2-ddlItemMaster-container']")
	WebElement clickOnSelectItemDropdown;

	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	List<WebElement> itemList;

	@FindBy(xpath = "//input[@id='txtQty']")
	WebElement enterQuantity;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']")
	WebElement clickOnWorkTypeDropdown;

	@FindBy(xpath = "//select[@id='ddlWorkTypeID']//option")
	List<WebElement> workTypeOptions;

	@FindBy(xpath = "//input[@id='txtUnitCost']")
	WebElement enterUnitCost;

	@FindBy(xpath = "//input[@id='txtUnitPrice']")
	WebElement enterUnitPrice;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clickOnSaveButton;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clickOnSaveButtonToSaveQuote;

	@FindBy(xpath = "//div[@class='mt10']//input[@value='Submit & Generate Sales Order']")
	WebElement clickOnSubmitAndGenerateSalesOrderButton;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
	WebElement clickOnQuoteConfirmationPopup;

	// constructor to initialize the object on this page
	public POSQuotationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Action methods
	public POSQuotationPage clickOnPosQuoteButton() {
		posAddQuoteButton.click();

		// return new POSQuotationPage(driver);
		return this;
	}

	public void openCustomerDropdown() {
		// clickOnCustomerDrowpdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnCustomerDrowpdown)).click();
	}

	public void selectCustomerByName(String customerName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(customerList));
		for (WebElement customer : customerList) {
			if (customer.getText().trim().equalsIgnoreCase(customerName)) {
				customer.click();
				break;
			}
		}
	}

	public void openSalesTypeDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSalesTypeDropdown));
		clickOnSalesTypeDropdown.click();
	}

	public void selectSalesTypeByVisibleText(String typeName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(salesTypeOptions));
		for (WebElement type : salesTypeOptions) {
			if (type.getText().trim().equalsIgnoreCase(typeName)) {
				type.click();
				break;
			}
		}
	}

	public void clickDeliveryDate() {
		// clickOnDeliveryDate.click();
		// Use JSExecutor or sendKeys if needed for selecting date
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDeliveryDate)).click();
	}

	public void selectDeliveryDate(String date, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until calendar is visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='xdsoft_calendar']")));

		// Loop until desired month and year appear
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//div[@class='xdsoft_label xdsoft_month']")).getText();
			String currentYear = driver.findElement(By.xpath("//div[@class='xdsoft_label xdsoft_year']")).getText();

			if (currentMonth.equalsIgnoreCase(month) && currentYear.equals(year)) {
				break;
			} else {
				WebElement nextBtn = driver.findElement(By.xpath("//*[contains(@class,'xdsoft_next')]"));
				nextBtn.click();
			}
		}

		// Select the date from calendar
		List<WebElement> allDates = driver
				.findElements(By.xpath("//div[@class='xdsoft_calendar']//tbody//td[contains(@class,'xdsoft_date')]"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	public void clickAddItem() {
		clickOnAddItemButton.click();
	}

	public void openItemDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSelectItemDropdown)).click();
		// clickOnSelectItemDropdown.click();
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(workTypeOptions));
		for (WebElement option : workTypeOptions) {
			if (option.getText().trim().equalsIgnoreCase(workType)) {
				option.click();
				break;
			}
		}
	}

//	public void enterUnitCost(String unitcost) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// wait until element is visible and clickable
//		wait.until(ExpectedConditions.visibilityOf(enterUnitCost));
//		wait.until(ExpectedConditions.elementToBeClickable(enterUnitCost));
//		//enterUnitCost.clear();
//		enterUnitCost.sendKeys(unitcost);
//	}

	public void enterUnitCost(String unitCost) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until element is visible and enabled
		wait.until(ExpectedConditions.visibilityOf(enterUnitCost));
		wait.until(ExpectedConditions.elementToBeClickable(enterUnitCost));

		// Clear existing value properly (handles fields with default "0.00")
		enterUnitCost.sendKeys(Keys.CONTROL + "a"); // select all
		enterUnitCost.sendKeys(Keys.DELETE); // delete
		enterUnitCost.sendKeys(unitCost); // type new value
	}

	public void enterUnitPrice(String unitprice) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait until element is visible and clickable
		wait.until(ExpectedConditions.visibilityOf(enterUnitPrice));
		wait.until(ExpectedConditions.elementToBeClickable(enterUnitPrice));
		// enterUnitPrice.clear();

		// Clear existing value properly (handles fields with default "0.00")
		enterUnitPrice.sendKeys(Keys.CONTROL + "a"); // select all
		enterUnitPrice.sendKeys(Keys.DELETE); // delete
		enterUnitPrice.sendKeys(unitprice); // type new value
	
	}

	public void clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSaveButton)).click();
		// clickOnSaveButton.click();
	}

//	public void clickSaveQuote() {
//		clickOnSaveButtonToSaveQuote.click();
//	}

//	public void clickSubmitAndGenerateOrder() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//		wait.until(ExpectedConditions.elementToBeClickable(clickOnSubmitAndGenerateSalesOrderButton)).click();
//		//clickOnSubmitAndGenerateSalesOrderButton.click();
//	}

	public void clickOnQouteCreateedSuccessfullyPopup() {
		clickOnQuoteConfirmationPopup.click();
	}
}
