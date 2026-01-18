package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.pages.SalesOrderPage;

public class SalesOrderTest extends BaseClass {
	public WebDriver driver;
	DashboardPage dashboardPage;
	SalesOrderPage salesOrderPage;
	LoginPage loginPage;

	public SalesOrderTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

		dashboardPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		salesOrderPage = dashboardPage.navigateToSalesOrderPage();
	}

	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}
	public void createSalesOrderTestWithMandatoryFields() {

}
}
