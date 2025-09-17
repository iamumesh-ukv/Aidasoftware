package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

	// ===== Constructor =====
	public POSARInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// ===== Action Methods =====
}
