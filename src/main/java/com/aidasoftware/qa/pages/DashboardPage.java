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

	// Objects
	@FindBy(xpath = "//a[@class='showMenu' and contains(., 'Point of Sale')]")
	WebElement POSMainmanu;

	@FindBy(xpath = "//a[normalize-space()='Quote']")
	WebElement POSQuotepage;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public POSQuotationPage navigateToPOSQuotationPage() {
		// POSMainmanu.click();
		// POSQuotepage.click();
		// Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait and click Point of Sale menu
		wait.until(ExpectedConditions.elementToBeClickable(POSMainmanu)).click();
		//System.out.println(POSMainmanu);

		// Wait and click Quote link
		wait.until(ExpectedConditions.elementToBeClickable(POSQuotepage)).click();
		//System.out.println(POSQuotepage);
		return new POSQuotationPage(driver);
	}
}
