package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.Login_Page;
import com.itlearn.pages.SearchPage;
import com.itlearn.utility.ReadExcelFile;

public class SearchTestcases extends BaseTest{

	String fileName = System.getProperty("user.dir") + "/TestData/TestInfo.xlsx"; 
	@Test(priority = 1)
	void searchCoursetestcase() {
			
		//login process
		Login_Page lp =new Login_Page(driver);
		String username=ReadExcelFile.getCellValue(fileName,"LoginData", 1,0);		
		String passwrod=ReadExcelFile.getCellValue(fileName,"LoginData", 1,1);
		lp.loginportal(username,passwrod);
		
		SearchPage sp = new SearchPage(driver);
		String search=ReadExcelFile.getCellValue(fileName,"SearchCourse", 0,0);
		sp.searchcourse(search);
		
		
			
	}
}
