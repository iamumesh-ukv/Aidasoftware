package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuotationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	// Objects
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement clickOnAddQuoteButton;

	@FindBy(xpath = "//span[@id='select2-ddlCustomerID-container']")
	WebElement clickOnCustomerDrowpdown;

	@FindBy(xpath = "//ul[@id='select2-ddlCustomerID-results']//li")
	List<WebElement> customerList;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ddlFP-container']")
	WebElement clickOnFloorPlanDrowpdown;

	@FindBy(xpath = "//ul[@class='select2-results__options']//li")
	List<WebElement> floorPlanList;

	@FindBy(xpath = "//input[@id='txtBuildingNo']")
	WebElement buildingNumberField;

	@FindBy(xpath = "//input[@id='txtUnitNo']")
	WebElement unitNumberField;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']")
	WebElement clickOnSalesTypeDropdown;

	@FindBy(xpath = "//select[@id='Item1_SalesTypeID']//option")
	List<WebElement> salesTypeOptions;

	// Objects for date picker
	@FindBy(xpath = "//input[@id='txtInstallationDate']")
	WebElement clickOnInstallationDate;
	// Objects for date picker
	@FindBy(xpath = "//input[@id='txtInstallationDate']")
	WebElement selectInstallationDate;

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

	@FindBy(xpath = "//span[@id='btnSalesOrderClose']")
	WebElement clickOnQuoteConfirmationPopup;

	public QuotationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// ================= Action Methods =================

	public void clickAddQuote() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnAddQuoteButton)).click();
	}

	// ---------- Customer ----------
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

	// ---------- Floor Plan ----------
	public void openFloorPlanDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnFloorPlanDrowpdown)).click();
	}
//	public void selectFloorPlanFromFloorPlanDropdown(String value) {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    // Enter value in search box
//	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//input[@role='textbox']")
//	    ));
//	    searchBox.sendKeys(value);
//
//	    // Select matching option
//	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
//	            By.xpath("//li[contains(text(),'" + value + "')]")
//	    ));
//	    option.click();
//	}
	public void selectFloorPlanFromFloorPlanDropdown(String value) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Click drop-down first (VERY IMPORTANT)
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//span[@role='combobox']")
	    ));
	    dropdown.click();

	    // Wait for search box to appear
	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@role='textbox']")
	    ));

	    // Clear properly
	    searchBox.sendKeys(Keys.CONTROL + "a");
	    searchBox.sendKeys(Keys.DELETE);

	    // Type value
	    searchBox.sendKeys(value);

	    //  Wait until correct result is visible
	    By resultLocator = By.xpath("//ul[contains(@class,'select2-results')]//li[normalize-space()='" + value + "']");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));

	    //  Click the option
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(resultLocator));
	    option.click();

	    //  Optional: wait until drop-down closes (extra stability)
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.xpath("//input[@role='textbox']")
	    ));
	}

//	public void openFloorPlanDropdown() {
//
//	    // Click to focus and open drop down
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(clickOnFloorPlanDrowpdown)).click();
//
//	    // Small wait to allow options to load
//	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//	          //  By.xpath("//li | //div[contains(@class,'option')]")
//	          //
//	    		By.xpath("//span[@id='select2-ddlFP-container']")
//	    ));
//
//	    // Select first option using keyboard
//	    clickOnFloorPlanDrowpdown.sendKeys(Keys.ARROW_DOWN);
//	    clickOnFloorPlanDrowpdown.sendKeys(Keys.ENTER);
//	}
//
	public void selectFloorPlanFromFlooePlanDropdown(String floorPlanName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(floorPlanList));
		for (WebElement selectPlan : floorPlanList) {
			if (selectPlan.getText().trim().equalsIgnoreCase(floorPlanName)) {
				selectPlan.click();
			}
		}

	}
	

	// ---------- Building & Unit ----------
	public void enterBuildingNumber(String buildingNo) {
		buildingNumberField.sendKeys(buildingNo);
	}

	public void enterUnitNumber(String unitNo) {
		wait.until(ExpectedConditions.visibilityOf(unitNumberField)).clear();
		unitNumberField.sendKeys(unitNo);
	}

	// ---------- Sales Type ----------
	public void openSalesTypeDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSalesTypeDropdown));
		clickOnSalesTypeDropdown.click();
	}

	public void selectSalesTypeByVisibleText(String typeName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(salesTypeOptions));
		for (WebElement type : salesTypeOptions) {
			if (type.getText().trim().equalsIgnoreCase(typeName)) {
				type.click();
				break;
			}
		}
	}

	public void clickOnInstallationDateCalendar() {
		// clickOnInstallationDate.click();
		// Use JSExecutor or sendKeys if needed for selecting date
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnInstallationDate)).click();
	}

	// ---------- Installation Date ----------
	public void clickOnInstallationDate() {
		wait.until(ExpectedConditions.elementToBeClickable(selectInstallationDate)).click();
	}

	public void selectInstallationDate(String date, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until calendar is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_calendar']")));

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
	}

	// ---------- Line Item ----------

	public void clickAddLineItem() {
		clickOnAddItemButton.click();
	}

	public void openItemDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSelectItemDropdown)).click();

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

	public void clickOnSaveLineItem() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSaveButton)).click();
		// clickOnSaveButton.click();
	}

	public void clickOnSaveQuote() {
		clickOnSaveButtonToSaveQuote.click();
	}

	public void clickSubmitAndGenerateSalesOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSubmitAndGenerateSalesOrderButton)).click();
		// clickOnSubmitAndGenerateSalesOrderButton.click();
	}

	public void clickOnQouteCreateedSuccessfullyPopup() {
		clickOnQuoteConfirmationPopup.click();
	}

}
