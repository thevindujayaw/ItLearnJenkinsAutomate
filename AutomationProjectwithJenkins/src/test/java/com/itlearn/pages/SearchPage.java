package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.managers.VoidDriverManager;

public class SearchPage {
	
	
   public WebDriver driver;
	
	public SearchPage(WebDriver driver1){
		
		this.driver=driver1;
		PageFactory.initElements(driver1,this);
		
	}
	
	@FindBy(name ="search_course")WebElement searchinput;
	@FindBy(xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button ")WebElement searchbtn;
	
	
	public void searchcourse(String coursename) {
		
		
		searchinput.sendKeys(coursename);
		searchbtn.click();
	}

}

