package com.itlearn.pages;

import java.util.NoSuchElementException;


import javax.xml.xpath.XPath;

import org.apache.poi.ss.formula.eval.UnaryMinusEval;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	
	
	public WebDriver driver;
	
	public Login_Page(WebDriver driver1){
		
		this.driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	
	
	   @FindBy(xpath = "//*[@id=\"loginlabel\"]") WebElement loginclick;
	   @FindBy(name="log")WebElement namefield;
	   @FindBy(name="pwd")WebElement passwrodfield;
	   @FindBy(name="wp-submit")WebElement loginbutton;
	   
	   @FindBy(id = "gk-login-toggle") WebElement profilbutton;
	   @FindBy(xpath = "//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a ")	WebElement logoutbuton;
	   
	
    public void loginportal(String username,String password) {
    	
    	
    	loginclick.click();
    	namefield.sendKeys(username);
    	passwrodfield.sendKeys(password);
    	loginbutton.click();
    }
    public void logout() {
    	profilbutton.click();
    	logoutbuton.click();
    }
    public boolean isLoginSuccessful(String username, String password) {
        try {
            // Assuming there's an element that confirms a successful login
            WebElement dashboardElement = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/nav[2]/ul/li[2]/a")); // Change locator as needed

            // Check if element is displayed
            return dashboardElement.isDisplayed();
        } catch (NoSuchElementException e) {
            // If element is not found, login failed
            return false;
        }
    }

  }
