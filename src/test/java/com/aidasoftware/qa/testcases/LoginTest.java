package com.aidasoftware.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aidasoftware.qa.baseclass.BaseClass;
import com.aidasoftware.qa.pages.HomePage;
import com.aidasoftware.qa.pages.LoginPage;
import com.aidasoftware.qa.utilities.Utilities;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		{
			HomePage homePage = new HomePage(driver);
			loginPage = homePage.navigateToLoginPage();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = { { "umesh_kumar@flexsin.org", "Umesh@123" } };
		return data;
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		loginPage.login(email, password);
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		// Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),"Expected
		// Warning message is not displayed");

		// System.out.println("Actual Warning Message: " +
		// loginPage.retrieveEmailPasswordNotMatchingWarningMessageText());
		// System.out.println("Expected Warning Message: " +
		// dataProp.getProperty("emailPasswordNoMatchWarning"));

		String atualPasswordWarning = driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
		Assert.assertEquals(atualPasswordWarning, dataProp.getProperty("passwordWarning"),
				"Password warning is not displaying");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.login(dataProp.getProperty("invalidEmail"), prop.getProperty("ValidPassword"));
		// String atualPasswordWarning =
		// driver.findElement(By.xpath("//span[@id='spnValidatePassword']")).getText();
		// Assert.assertEquals(atualPasswordWarning,
		// dataProp.getProperty("passwordWarning"),"Password warning is not
		// displaying");
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
		// loginPage.login(prop.getProperty(" "), prop.getProperty(" "));
		loginPage.clickOnLoginButton();
	}
}
