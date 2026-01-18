package com.aidasoftware.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	public WebDriver driver;
	WebDriverWait wait;

	// POS-Objects
	@FindBy(xpath = "//a[@class='showMenu' and contains(., 'Point of Sale')]")
	WebElement POSMainMenu;
	@FindBy(xpath = "//a[normalize-space()='Quote']")
	WebElement POSQuotePage;
	@FindBy(xpath = "//a[@href='/POSSalesOrder/Manage']")
	WebElement POSSalesOrderPage;
	@FindBy(xpath = "//a[@href='/ARInvoice/POSManage']")
	WebElement POSARInvoicePage;

	// Regular-Objects
	@FindBy(xpath = "//a[normalize-space()='Orders']")
	WebElement orderMainMenu;
	@FindBy(xpath = "//a[normalize-space()='Quotes']")
	WebElement orderQuotes;
	@FindBy(xpath = "//a[@href='/SalesOrder/Manage']")
	WebElement orderSalesOrder;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // initialize wait
		PageFactory.initElements(driver, this);
	}

	// Navigate to Login Page
	public LoginPage navigateToLoginPage() {

		return new LoginPage(driver);
	}

	// Navigate to POS - Quote Page
	public POSQuotationPage navigateToPOSQuotationPage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSQuotePage)).click();
		return new POSQuotationPage(driver);
	}

	// Navigate to POS-Sales Order Page
	public POSSalesOrderPage navigateToPOSSalesOrderPage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSSalesOrderPage)).click();
		return new POSSalesOrderPage(driver);
	}

	// Navigate to POS - AR Invoice Page
	public POSARInvoicePage navigateToPOSARInvoicePage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSARInvoicePage)).click();
		return new POSARInvoicePage(driver);
	}

	// Navigate to Regular - Quote Page
	public QuotationPage navigateToQuotationPage() {
		wait.until(ExpectedConditions.elementToBeClickable(orderMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(orderQuotes)).click();
		return new QuotationPage(driver);
	}

	// Navigate to Regular - Sales Order Page
	public SalesOrderPage navigateToSalesOrderPage() {
		wait.until(ExpectedConditions.elementToBeClickable(orderMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(orderSalesOrder)).click();
		return new SalesOrderPage(driver);
	}
}
