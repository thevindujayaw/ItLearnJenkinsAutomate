package com.itlearn.testcases;


import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.Dashboardpage;
import com.itlearn.pages.Login_Page;
import com.itlearn.utility.ReadExcelFile;

public class Dashboardclick extends BaseTest {
	
	
	String fileName = System.getProperty("user.dir") + "/TestData/TestInfo.xlsx"; 
	
	@Test(priority = 1)
	void Coursepayment() throws InterruptedException {
			
		//login process
		Login_Page lp =new Login_Page(driver);
		String username=ReadExcelFile.getCellValue(fileName,"LoginData", 1,0);		
		String passwrod=ReadExcelFile.getCellValue(fileName,"LoginData", 1,1);
		lp.loginportal(username,passwrod);
		
		Thread.sleep(4000);
		Dashboardpage dbDashboardpage = new Dashboardpage(driver);
		dbDashboardpage.dashboardclick();

  }
	
}