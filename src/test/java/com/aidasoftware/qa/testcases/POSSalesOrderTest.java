package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.DashboardPage;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.pages.POSSalesOrderPage;

public class POSSalesOrderTest extends BaseClass {

	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	POSSalesOrderPage salesOrderPage;

	public POSSalesOrderTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		loginPage = new LoginPage(driver);
		dashboardPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		// Navigate to Sales Order page (you need to add a navigation method in DashboardPage)
		 salesOrderPage = dashboardPage.navigateToPOSSalesOrderPage();
	}

	@Test(priority = 1)
	public void createSalesOrderTestWithMandatoryFields() {
		salesOrderPage.clickOnPOSManu();
		salesOrderPage.clickOnPOSSalesOrderPage();
		
		salesOrderPage.clickOnSalesOrderEditButton();
//		salesOrderPage.selectCustomer("AMAN");
//		salesOrderPage.enterOrderDate("25-08-2025");;
//
//		salesOrderPage.clickAddItem();
//		salesOrderPage.selectItem("ITEM001");
		salesOrderPage.enterIssueQuantity("500");
//		salesOrderPage.selectWorkType("Installation");
//
//		salesOrderPage.enterRemarks("Urgent Order");
//		salesOrderPage.saveOrder();
		salesOrderPage.clickUpdateSalesOrderButton();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
