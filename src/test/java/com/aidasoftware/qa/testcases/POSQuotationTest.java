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

	POSQuotationPage posQuotationPage;
	public WebDriver driver;

	public POSQuotationTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		// this peace of of code I added
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = loginPage.login(prop.getProperty("validEmail"),
				prop.getProperty("validPassword"));
		posQuotationPage = dashboardPage.navigateToPOSQuotationPage(); // Critical for test to work

		// DashboardPage dashboardPage = new DashboardPage(driver);
		// posQuotationPage = dashboardPage.navigateToPOSQuotationPage();
	}

	@Test
	public void verifyPOSQuotationPageLoads() {
		// posQuotationPage.clickOnPosQuoteButton();

		if (posQuotationPage != null) {
			posQuotationPage.clickOnPosQuoteButton();
		} else {
			System.out.println("posQuotationPage is null. Navigation failed.");
		}
	}
//
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

}
