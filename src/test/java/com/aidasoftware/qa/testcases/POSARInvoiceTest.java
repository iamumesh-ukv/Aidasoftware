package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.pages.POSARInvoicePage;

public class POSARInvoiceTest extends BaseClass {
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	POSARInvoicePage posARInvoicePage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		loginPage = new LoginPage(driver);
		dashboardPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		// Navigate to Sales Order page (you need to add a navigation method in
		// DashboardPage)
		posARInvoicePage = dashboardPage.navigateToPOSARInvoicePage();
	}

	@Test(priority = 1)
	public void createPOSARInvoiceTestWithMandatoryFields() {

	}

}
