package com.itlearn.pages;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProviders;


public class BaseTest {
	
	public WebDriver driver;
	public ConfigDataProviders config;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		config=new ConfigDataProviders();
		
	}
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	
 @AfterClass
	public void tearDown()
	{
//		BrowserFactory.quitBrowser(driver);
	}
    
    public void captureScreenShot(WebDriver driver,String testName) throws IOException
   {
	 // Convert webdriver object to TakesScreenshot interface
	 TakesScreenshot screenshot= ((TakesScreenshot)driver);
	 
	 // Step 2 :call getScreenshotAs method to capture image file
	 
	 File src = screenshot.getScreenshotAs(OutputType.FILE);
	 String homeDir = System.getProperty("user.home");
	 String screenshotDir = "/Eclipse/AutomationProjectwithJenkins/screenshots/";
	 File srcpath = new File(homeDir + screenshotDir + testName + ".png");
	 System.out.println("this is screenshot section");
	 // Step 3 : copy image file to destination 
	 FileUtils.copyFile(src, srcpath);
	 
   }
 
}