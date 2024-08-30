
package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass { //BaseClass- write all reusable method

	ReadConfig readConfig = new ReadConfig(); // creating object of ReadConfig, Import package com.mystore.utilities.ReadCondig

	String url = readConfig.getBaseUrl(); //it will read the value of BaseURL & store
	String browser = readConfig.getBrowser();  // it will read the value of Browser & store

	public String emailAddress = readConfig.getEmail() ;
	String password = readConfig.getPassword();


	public static WebDriver driver; // created webDriver object
	public static Logger logger;

	@BeforeClass
	public void setup() // To launch browser
	{

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		//implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//for logging
		logger = LogManager.getLogger("MyStoreV1"); // intialize Logger

		//open url, as we used in each test cases paste it here
		driver.get(url);
		logger.info("url opened");

	}



	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}


	//user method to capture screen shot
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		//step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		//step3: copy image file to destination
		
		FileUtils.copyFile(src, dest);
	}


}
