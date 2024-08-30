
package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.RegisteredUserAccount;


public class TC_MyAccountPageTest extends BaseClass {


	@Test
	public void verifyRegistrationAndLogin()  //To verify Registration & Login
	{

		logger.info("***************TestCase Verify Registration and Login starts*****************"); 
		// Logger.info("Url opened");

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);
		
		myAcpg.enterCreateEmailAddress("cs923@gmail.com");
		logger.info("Email address entered in create account section.");

		myAcpg.clickSubmitCreate(); // click on submit button
		logger.info("clicked on create an account button");

		// creating object of AccountCreatingDetails Page
		AccountCreationDetails accCreationPg = new AccountCreationDetails(driver); 

		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Prachi");
		accCreationPg.enterCustomerLastName("Gupta");
		accCreationPg.enterPassword("cs923");
		accCreationPg.enterAddressFirstName("Prachi");
		accCreationPg.enterAddressLastName("Gupta");
		accCreationPg.enterAddress("18/8 worli road");

		accCreationPg.enterCity("Mumbai");
		accCreationPg.selectState("Alabama");

		accCreationPg.enterPostcode("00000");
		accCreationPg.selectCountry("United States");
		accCreationPg.enterMobilePhone("9891778192");
		accCreationPg.enterAlias("Home");

		logger.info("entered user details on account creation page.");

		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");

		// creating object of RegisteredUserAccount Page
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("Prachi Gupta", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}

	@Test
	public void VerifyLogin() throws IOException  //2'nd TC- Verify Login
	{

		logger.info("***************TestCase Verify Login starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("cs923@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("cs923");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link");


		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName = regUser.getUserName();


		if(userName.equals("Prachi Gupta"))
		{
			logger.info("VerifyLogin - Passed");
			regUser.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin"); // we created a Capture screenshot method in base class
			Assert.assertTrue(false);

		}

		logger.info("***************TestCase Verify Login ends*****************"); 


	}


	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("cs923@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("cs923");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		regUser.clickOnSignOut();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}


		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}


}
