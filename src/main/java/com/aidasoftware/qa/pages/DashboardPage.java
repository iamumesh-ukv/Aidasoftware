package com.aidasoftware.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;

//	WebDriver driver;
	WebDriverWait wait;

	// Objects
	@FindBy(xpath = "//a[@class='showMenu' and contains(., 'Point of Sale')]")
	WebElement POSMainMenu;

	@FindBy(xpath = "//a[normalize-space()='Quote']")
	WebElement POSQuotePage;

//	  // Objects (Main Menu + Sub Menus)

//
//    @FindBy(xpath = "//a[normalize-space()='Quote']")
//    WebElement POSQuotePage;
//
	@FindBy(xpath = "//a[@href='/POSSalesOrder/Manage']")
	WebElement POSSalesOrderPage;

	@FindBy(xpath = "//a[@href='/ARInvoice/POSManage']")
	WebElement POSARInvoicePage;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Navigate to Quote Page
	public POSQuotationPage navigateToPOSQuotationPage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSQuotePage)).click();
		return new POSQuotationPage(driver);
	}

	// Navigate to Sales Order Page
	public POSSalesOrderPage navigateToPOSSalesOrderPage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSSalesOrderPage)).click();
		return new POSSalesOrderPage(driver);
	}

	// Navigate to AR Invoice Page
	public POSARInvoicePage navigateToPOSARInvoicePage() {
		wait.until(ExpectedConditions.elementToBeClickable(POSMainMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(POSARInvoicePage)).click();
		return new POSARInvoicePage(driver);
	}

	/*
	 * public POSQuotationPage navigateToPOSQuotationPage() { //
	 * POSMainmanu.click(); // POSQuotepage.click(); // Actions actions = new
	 * Actions(driver); WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(10));
	 * 
	 * // Wait and click Point of Sale menu
	 * wait.until(ExpectedConditions.elementToBeClickable(POSMainmanu)).click();
	 * //System.out.println(POSMainmanu);
	 * 
	 * // Wait and click Quote link
	 * wait.until(ExpectedConditions.elementToBeClickable(POSQuotepage)).click();
	 * //System.out.println(POSQuotepage); return new POSQuotationPage(driver);
	 */

//	public POSSalesOrderPage navigateToPOSSalesOrderPage() {
//		// click on menu Sales Order
//		// POSSalesorderPage.click();
//		return new POSSalesOrderPage(driver);
//	}
}
//}
