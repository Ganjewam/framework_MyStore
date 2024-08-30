package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	//1. create object of webdriver
	WebDriver ldriver;

	// create constructor, classname and constructor name is same
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver; // initialize Localdriver to Remotedriver
		PageFactory.initElements(rdriver, this);
	}
	// Identify elements
	@FindBy(linkText = "Sign in")
	WebElement signIn;

	// identify action on webelement
	public void clickOnSignIn() {
		signIn.click();

	}
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}

	public void clickOnTShirtMenu()
	{
		WebElement tshirtMenu = null;
		tshirtMenu.click();
	}

}

