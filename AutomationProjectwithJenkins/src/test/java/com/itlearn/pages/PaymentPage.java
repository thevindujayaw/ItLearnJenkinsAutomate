package com.itlearn.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	 public WebDriver driver;
		
		public PaymentPage(WebDriver driver1){
			
			this.driver=driver1;
			PageFactory.initElements(driver1,this);
			
		}
		
		@FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label")WebElement paywithstripElement;
		
		@FindBy(xpath = "//*[@id=\"learn-press-checkout-place-order\"] ")WebElement placeirderElement;
		@FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe")WebElement iframeElement;
		
		@FindBy(name="cardnumber")WebElement entercardNumberElement;
		@FindBy(name = "exp-date")WebElement expdatElement;
	    @FindBy(name = "cvc")WebElement cvvElement;
	    @FindBy(xpath = "//*[@id=\"payment-button\"]")WebElement paynowbuttonElement;
	   
	    
	    public void paymentOption(String cardNumber, String expDate, String cvv) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Click Stripe payment option
	        wait.until(ExpectedConditions.elementToBeClickable(paywithstripElement)).click();
	        
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll the element into view
	        js.executeScript("arguments[0].scrollIntoView(true);", placeirderElement);

	        // Wait until it's actually clickable
	        wait.until(ExpectedConditions.elementToBeClickable(placeirderElement));

	        // Click via JS (to avoid interception)
	        js.executeScript("arguments[0].click();", placeirderElement);
	        
	        
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for the iframe to be present
	        WebElement iframeElement = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='card-element']/div/iframe")));
	        
	        
	        // Switch to iframe for card input
	        driver.switchTo().frame(iframeElement);
	        
	        Thread.sleep(3000);
	        // Wait for card elements to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("card-element"))).sendKeys(cardNumber);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("expdat"))).sendKeys(expDate);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cvv"))).sendKeys(cvv);

	        
	        // Switch back to default content
	        driver.switchTo().defaultContent();

	        // Scroll into view before clicking
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paynowbuttonElement);

	        // Click Pay Now button
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(paynowbuttonElement)).click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paynowbuttonElement);
	        }

	    }
	    

}
