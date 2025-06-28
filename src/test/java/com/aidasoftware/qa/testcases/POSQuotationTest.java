package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.POSQuotationPage;

public class POSQuotationTest extends BaseClass {

	POSQuotationPage posQuotationPage;
	public WebDriver driver;

	public POSQuotationTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		DashboardPage dashboardPage = new DashboardPage(driver);
		posQuotationPage = dashboardPage.navigateToPOSQuotationPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
