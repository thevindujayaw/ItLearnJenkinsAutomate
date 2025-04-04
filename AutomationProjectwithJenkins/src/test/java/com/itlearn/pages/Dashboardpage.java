package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {
	
	
	WebDriver driver;
	
 public Dashboardpage(WebDriver driver1){
		
		this.driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	
 @FindBy(xpath = "//*[@id=\"login-list\"]/li[1]/a")WebElement dashboardElement;
 @FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div/main/article/div/div[1]/div/div[1]/ul/li[3]")WebElement offerdacedemicsElement;
 @FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button")WebElement subscribElement;
 
 public void dashboardclick() {
	 
	 dashboardElement.click();
	 offerdacedemicsElement.click();
	 subscribElement.click();
	 
	 
 }
 

}
