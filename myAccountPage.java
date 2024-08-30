package com.mystore.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	

	//1. create object of webdriver
		WebDriver ldriver;
		
		// create constructor, classname and constructor name is same
		public myAccountPage(WebDriver rdriver)
		{
			ldriver = rdriver; // initialize Localdriver to Remotedriver
			PageFactory.initElements(rdriver, this);
		}
		// Identify elements
		@FindBy(id = "email_create")
		WebElement createEmailId;
		
		@FindBy(id = "SubmitCreate")
		WebElement SubmitCreate;
		
		// 2'nd TC-Alraedy Registered user WebElement
		@FindBy(id = "email")  
		WebElement registeredUserEmail;
		
		@FindBy(id = "passwd")
		WebElement registeredUserPwd;
		
		@FindBy(id = "SubmitLogin")
		WebElement submitLogin;
		
		
		// identify action on webelement
		public void enterCreateEmailAddress(String emailADD) {
			createEmailId.sendKeys(emailADD);
			
		}
		public void clickSubmitCreate()
		{
			SubmitCreate.click();
			
	}
		public void clickSubmitCreate1()
		{
			SubmitCreate.click();
		}
		
		//ACTIONS METHODS FOR ALREADY REGISTERED USERS
		
		public void enterEmailAddress(String emailAdd) 
		{
			WebElement registeredUsersEmail = null;
			registeredUsersEmail.sendKeys(emailAdd);
		}

		public void enterPassword(String pwd) 
		{
			WebElement registeredUsersPwd = null;
			registeredUsersPwd.sendKeys(pwd);
		}

		
		public void clickSignIn()
		{
			WebElement submitLogin = null;
			submitLogin.click();
		}

	}


