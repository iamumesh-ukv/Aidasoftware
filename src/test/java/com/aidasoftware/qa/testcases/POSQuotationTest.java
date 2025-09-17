package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.POSQuotationPage;
import com.aidasoftware.qa.pages.LoginPage;

public class POSQuotationTest extends BaseClass {

	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	POSQuotationPage posQuotationPage;

	public POSQuotationTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		/*
		 * // this peace of of code I added LoginPage loginPage = new LoginPage(driver);
		 * DashboardPage dashboardPage = loginPage.login(prop.getProperty("validEmail"),
		 * prop.getProperty("validPassword")); posQuotationPage =
		 * dashboardPage.navigateToPOSQuotationPage(); // Critical for test to work
		 * 
		 * // DashboardPage dashboardPage = new DashboardPage(driver); //
		 * posQuotationPage = dashboardPage.navigateToPOSQuotationPage();
		 */
		loginPage = new LoginPage(driver);
		dashboardPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		posQuotationPage = dashboardPage.navigateToPOSQuotationPage();
	}

//	@Test(priority = 1)
//	public void verifyPOSQuotationPageLoads() {
//		// posQuotationPage.clickOnPosQuoteButton();
//
//		if (posQuotationPage != null) {
//			posQuotationPage.clickOnPosQuoteButton();
//		} else {
//			System.out.println("posQuotationPage is null. Navigation failed.");
//		}
//	}

	@Test(priority = 1)
	public void createPOSQuotationTestWithMandatoryFields() {
		posQuotationPage.clickOnPosQuoteButton();

		// Select customer
		posQuotationPage.openCustomerDropdown();
		posQuotationPage.selectCustomerByName("AMAN");

		// Select Sales Type
		posQuotationPage.openSalesTypeDropdown();
		posQuotationPage.selectSalesTypeByVisibleText("Regular");

		// Select Delivery Date
		posQuotationPage.clickDeliveryDate();
		// Add custom method if you use JS or calendar picker to choose date
		posQuotationPage.selectDeliveryDate("15", "October", "2025");

		// Add Item
		posQuotationPage.clickAddItem();
		posQuotationPage.openItemDropdown();
		posQuotationPage.selectItemByName("101150 MNS Stock inventory item FD-1 LD-2");

		// Enter Quantity
		posQuotationPage.enterQuantity("500");

		// Select Work Type
		posQuotationPage.openWorkTypeDropdown();
		posQuotationPage.selectWorkTypeByVisibleText("CARPET");

		posQuotationPage.enterUnitCost("3.50");
		posQuotationPage.enterUnitPrice("6.50");

		// Click Save buttons
		posQuotationPage.clickSave();

		// Click on Quote save button
		// posQuotationPage.clickSaveQuote();

		// Optionally generate sales order
		posQuotationPage.clickSubmitAndGenerateOrder();

		// posQuotationPage.clickOnQouteCreateedSuccessfullyPopup();
	}

	// @AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

}
