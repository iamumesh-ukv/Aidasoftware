package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSARInvoicePage {

	WebDriver driver;
	public WebDriver wait;


	@FindBy(xpath = "//img[@src='../images/pay_icon.png']")
	WebElement clickOnARInvoiceButton;

	@FindBy(xpath = "//span[@id='select2-ddlCashAccount-container']")
	WebElement clickOnCashAccountDropdown;

	@FindBy(xpath = "//select[contains(@id,'CashAccount')]/option")
	List<WebElement> cashAccountList;

	@FindBy(xpath = "//select[@id='ddlPaymentBy']")
	WebElement clickOnPaymentByDropdown;

	@FindBy(xpath = "//select[@id='ddlPaymentBy']//option")
	List<WebElement> paymentList;

	@FindBy(xpath = "//input[@id='OutstandingAmount']")
	WebElement outstandingAmountField;

	@FindBy(xpath = "//input[@id='invoicepayment_AmountPaid']")
	WebElement amountField;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement clickOnSaveButton;

	// ===== Constructor =====
	public POSARInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===== Action Methods =====
	public void clickOnPOSInvoiceIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnARInvoiceButton)).click();
		// clickOnARInvoiceButton.click();
	}

	public void openCashAccontDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnCashAccountDropdown)).click();
		// clickOnCashAccountDropdown.click();
	}

	public void selectCashAccount(String cashAccount) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOfAllElements(cashAccountList));
		for (WebElement account : cashAccountList) {
			if (account.getText().trim().equalsIgnoreCase(cashAccount)) {
				account.click();
				break;
			}
		}
	}

	public void openPaymentDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnPaymentByDropdown)).click();
		// clickOnPaymentByDropdown.click();
	}

	public void selectPaymentByType(String selectPaymentType) {
		for (WebElement payment : paymentList) {
			if (payment.getText().trim().equalsIgnoreCase(selectPaymentType)) {
				payment.click();
				// Click outside to close the dropdown
				Actions actions = new Actions(driver);
				actions.moveByOffset(10, 10).click().perform();
				break;
			}
		}
	}

//	public void enterAmount() {
//
//		System.out.println("Method started");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		// Wait until element is present in DOM
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='OutstandingAmount']")));
//
//		// Scroll element into view (center)
//		js.executeScript("arguments[0].scrollIntoView({block:'center'});", outstandingAmountField);
//
//		// Get value via JS (works even if attribute not updated)
//		String value = (String) js.executeScript("return arguments[0].value || arguments[0].innerText;",
//				outstandingAmountField);
//
//		if (value == null || value.trim().isEmpty()) {
//			throw new RuntimeException("Outstanding amount value is empty");
//		}
//
//		// Scroll to amount field
//		js.executeScript("arguments[0].scrollIntoView({block:'center'});", amountField);
//
//		wait.until(ExpectedConditions.elementToBeClickable(amountField));
//
//		amountField.clear();
//		amountField.sendKeys(value);
//	}

	public void enterAmount() {
		String value = outstandingAmountField.getAttribute("value");
		amountField.clear();
		amountField.sendKeys(value);
	}

	public void clickOnPOSInvoiceSaveButton() {
		clickOnSaveButton.click();
	}
}
