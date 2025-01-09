package com.aidasoftware.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.HomePage;
import com.aidasoftware.qa.pages.LoginPage;

public class LoginTest extends BaseClass {

	
	LoginPage loginPage; 

	public  LoginTest()
	{
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		{
			HomePage homePage= new HomePage(driver);
			loginPage = homePage.navigateToLoginPage();
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		Object [][]data = {{"umesh_kumar@flexsin.org","Umesh@123"}};
		
		return data;
	}
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		loginPage.login(email, password);
	}


}
