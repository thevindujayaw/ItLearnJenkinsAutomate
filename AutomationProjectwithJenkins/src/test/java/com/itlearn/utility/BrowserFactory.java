package com.itlearn.utility;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	
	 
	 
	 public static WebDriver startApplication(WebDriver driver, String browserName, String testurl) {
    	
    	if(browserName.equals("Chrome")) {
    		
    		System.setProperty("webdriver.chrome.driver", "/Users/thevinduj/Desktop/webdrivers/chromedriver");
    		ChromeOptions op = new ChromeOptions();
    		op.addArguments("--remot-allow-origins=*");
    		driver =new ChromeDriver();
    	}
    	else if (browserName.equals("Firefox")) {
    		System.setProperty("webdriver.chrome.driver", "/Users/thevinduj/Desktop/webdrivers/geckodriver");
    		driver =new FirefoxDriver();
			
		}
    	else if (browserName.equals("Safari")) {
    		
    		driver =new SafariDriver();
    		
      }
    	else {
			System.out.println("browser not supported");
		}
    	
    	
    	driver.manage().window ().maximize();
    	driver.get(testurl);
    	driver.manage () . timeouts () . implicitlyWait(30,TimeUnit.SECONDS);
    	return driver;
    }
	 
	 public static void quitBrowser(WebDriver driver) {
		 
		 driver.quit();
	 }
	 
}
    
