package com.aidasoftware.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSARInvoicePage {

	WebDriver driver;
	public WebDriver wait;

//	  // Objects (Main Menu + Sub Menus)
//  @FindBy(xpath = "//a[@class='showMenu' and contains(., 'Point of Sale')]")
//  WebElement POSMainMenu;
//
//  @FindBy(xpath = "//a[normalize-space()='Quote']")
//  WebElement POSQuotePage;
//
//  @FindBy(xpath = "//a[normalize-space()='Sales Order']")
//  WebElement POSSalesOrderPage;
//
//  @FindBy(xpath = "//a[normalize-space()='AR Invoice']")
//  WebElement POSARInvoicePage;
	@FindBy(xpath = "//img[@src='../images/pay_icon.png']")
	WebElement clickOnARInvoiceButton;

	@FindBy(xpath = "//span[@class='select2-selection__rendered']")
	WebElement clickOnCashAccountDropdown;

	@FindBy(xpath = "//select[contains(@id,'CashAccount')]/option")
	List<WebElement> cashAccountList;

	@FindBy(xpath = "//select[@id='ddlPaymentBy']")
	WebElement clickOnPaymentByDropdown;

	@FindBy(xpath = "//select[@id='ddlPaymentBy']//option")
	List<WebElement> selectPaymentType;

	// ===== Constructor =====
	public POSARInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===== Action Methods =====
	public void clickOnPOSInvoiceIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnARInvoiceButton)).click();
		// clickOnARInvoiceButton.click();
	}

	public void openCashAccontDropdown() {
		clickOnCashAccountDropdown.click();
	}

	public void selectCashAccount(String cashAccount) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(cashAccountList));
		for (WebElement account : cashAccountList) {
			if (account.getText().trim().equalsIgnoreCase(cashAccount)) {
				account.click();
				;
				break;
			}
		}
	}

	public void openPaymentDropdown() {
		clickOnPaymentByDropdown.click();
	}

	public void selectPaymentByType(String paymentList) {
		for (WebElement payment : selectPaymentType) {
			if (payment.getText().trim().equalsIgnoreCase(paymentList)) {
				payment.click();
				break;
			}
		}
	}
}
