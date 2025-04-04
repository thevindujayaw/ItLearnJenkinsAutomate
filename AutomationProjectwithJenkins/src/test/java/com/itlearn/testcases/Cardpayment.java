package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.Dashboardpage;
import com.itlearn.pages.Login_Page;
import com.itlearn.pages.PaymentPage;
import com.itlearn.utility.ReadExcelFile;

public class Cardpayment extends BaseTest{

	String fileName = System.getProperty("user.dir") + "/TestData/TestInfo.xlsx"; 
	@Test(priority = 1)
	void searchCoursetestcase() throws InterruptedException {
			
		//login process
		Login_Page lp =new Login_Page(driver);
		String username=ReadExcelFile.getCellValue(fileName,"LoginData", 1,0);		
		String passwrod=ReadExcelFile.getCellValue(fileName,"LoginData", 1,1);
		lp.loginportal(username,passwrod);
		
		
		
			//go to dashboard and payment portal
			Dashboardpage dp= new Dashboardpage(driver);
			dp.dashboardclick();
			
			Thread.sleep(3000);
			//instance of payment page
		    PaymentPage paymentPage=new PaymentPage(driver);
		    
		    //get data from the excell file
		    String cardnum=ReadExcelFile.getCellValue(fileName,"payment", 0,0);
		    String expdate=ReadExcelFile.getCellValue(fileName,"payment", 0,1);
		    String cvvnum=ReadExcelFile.getCellValue(fileName,"payment", 0,2);
		 
		    //pass values
		    paymentPage.paymentOption(cardnum, expdate, cvvnum);
		
		    
	 }
	
	

}
