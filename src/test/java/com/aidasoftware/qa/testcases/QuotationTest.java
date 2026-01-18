package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.pages.QuotationPage;

public class QuotationTest extends BaseClass {
	DashboardPage dashboardPage;
	QuotationPage quotationPage;
	LoginPage loginPage;
	public WebDriver driver;

	public QuotationTest() {
		super();
	}

	@BeforeTest()
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		{

			loginPage = new LoginPage(driver);
			dashboardPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
			quotationPage = dashboardPage.navigateToQuotationPage();
		}
	}

//	@AfterMethod
//	public void tearDwon() {
//		driver.quit();
//	}

	@Test
	public void createQuotationTestWithMandatoryFields() {
		quotationPage.clickAddQuote();

		// Select customer
		quotationPage.openCustomerDropdown();
		quotationPage.selectCustomerByName("AMAN");
		// Select floor plan
		quotationPage.openFloorPlanDropdown();
		quotationPage.selectFloorPlan("Ground Floor");
		
		quotationPage.enterBuildingNumber("9889");
		quotationPage.enterUnitNumber("A-101");

		// Select Sales Type
		quotationPage.selectSalesTypeByVisibleText("Regular");
		quotationPage.selectInstallationDate("25", "March", "2026");

		// Add Item
		quotationPage.clickAddLineItem();
		quotationPage.openItemDropdown();
		quotationPage.selectItemByName("101150 MNS Stock inventory item FD-1 LD-2");
		quotationPage.enterQuantity("500");

		// Select Work Type
		quotationPage.openWorkTypeDropdown();
		quotationPage.selectWorkTypeByVisibleText("CARPET");

		quotationPage.enterUnitCost("3.50");
		quotationPage.enterUnitPrice("6.50");

	}
}
