package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSQuotationPage {

	WebDriver driver;

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

	@FindBy(xpath = "//div[contains(@class,'xdsoft_monthselect')]//div[contains(@class,'xdsoft_option')] ") // month
																											// label
	WebElement monthLabel;

	@FindBy(xpath = "//div[contains(@class,'xdsoft_yearselect')]//div[contains(@class,'xdsoft_option')] ") // year label
	WebElement yearLabel;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDeliveryDate)).click();
	}

	public void selectDeliveryDate(String day, String month, String year) {
		// Step 1: Open the calendar
		clickOnDeliveryDate.click();

		// Step 2: Loop until the month & year are matched
		while (true) {
			String displayedMonth = monthLabel.getText().trim();
			String displayedYear = yearLabel.getText().trim();

			if (displayedMonth.equalsIgnoreCase(month) && displayedYear.equals(year)) {
				break; // found the correct month & year
			}

			// If year is greater, click next, else click previous
			int targetYear = Integer.parseInt(year);
			int currentYear = Integer.parseInt(displayedYear);

			if (currentYear > targetYear || (currentYear == targetYear && !isMonthBefore(displayedMonth, month))) {
				prevBtn.click();
			} else {
				nextBtn.click();
			}
		}

		// Step 3: Select the date
		WebElement dayElement = driver.findElement(
				// By.xpath("//table//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
				// + day + "']"));
				By.xpath(
						"//div[contains(@class,'xdsoft_calendar')]//td[contains(@class,'xdsoft_date') and text()='\" + day + \"']\r\n"
								+ ""));
		dayElement.click();
	}

	// Helper method: check if currentMonth comes before targetMonth
	private boolean isMonthBefore(String currentMonth, String targetMonth) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		return months.indexOf(currentMonth) < months.indexOf(targetMonth);
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
