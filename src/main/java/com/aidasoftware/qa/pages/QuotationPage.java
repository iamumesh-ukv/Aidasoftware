package com.aidasoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotationPage {
	
	WebDriver driver;
	
	//Object
	
	
	
	
	 public  QuotationPage( WebDriver driver)
	 {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	 
	 // Action
	
	
	
	
	

}
