package com.aidasoftware.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String generateEmailWithTimeStamp()
	{
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "umesh"+timestamp+"@gmail.com";

	}

	// Need to call this method from MyListeners page for apply screenshots method in project
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try
		{
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}
	
	
	/*
	public static void selectDate(WebDriver driver,
            By monthLocator, By yearLocator,
            By nextButton, By prevButton,
            String day, String month, String year) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Get displayed month/year
String displayedMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(monthLocator)).getText().trim();
String displayedYear = wait.until(ExpectedConditions.visibilityOfElementLocated(yearLocator)).getText().trim();

int targetYear = Integer.parseInt(year);
int currentYear = Integer.parseInt(displayedYear);

// Adjust year
while (currentYear != targetYear) {
if (currentYear < targetYear) {
wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
} else {
wait.until(ExpectedConditions.elementToBeClickable(prevButton)).click();
}
displayedYear = wait.until(ExpectedConditions.visibilityOfElementLocated(yearLocator)).getText().trim();
currentYear = Integer.parseInt(displayedYear);
}

// Adjust month
while (!displayedMonth.equalsIgnoreCase(month)) {
wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
displayedMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(monthLocator)).getText().trim();
}

// Select day
By dayLocator = By.xpath("//td[not(contains(@class,'disabled'))]//*[normalize-space(text())='" + day + "']");
WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dayLocator));
dateElement.click();
}
*/
}