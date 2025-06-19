package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.pages.QuotationPage;

public class QuotationTest extends BaseClass {
	
	QuotationPage quotationPage;
	
	public QuotationTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeTest()
	public void setup()
	{
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		{
//			HomePage homePage= new HomePage(driver);
//			loginPage = homePage.navigateToLoginPage();	
			
			LoginPage loginPage = new LoginPage(driver);
			QuotationPage quotationPage = loginPage.navigateQuotationPage();
		}
	}
	
	

}
