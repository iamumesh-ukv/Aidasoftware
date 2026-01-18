package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
	public WebDriver driver;

	public SalesOrderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}