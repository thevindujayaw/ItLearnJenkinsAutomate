package com.itlearn.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.Login_Page;
import com.itlearn.utility.ReadExcelFile;

public class testLogin extends BaseTest {
	
	String filename = System.getProperty("user.dir")+"/Users/thevinduj/Eclipse/AutomationProjectwithJenkins/TestData/TestInfo.xlsx";
	@Test
	public void verifyLogin() {
		
		Login_Page lp  = new Login_Page(driver);
		String username ="Demo12";
		String password ="Test123456$";
		lp.loginportal(username, password);
			
	}
	
	@DataProvider(name="Logindataprovider")
	public String [][]Logindataprovider(){
		                                                  //sheet name
		int ttlRows = ReadExcelFile.getRowCount(filename, "LoginData");
		
		int ttlColoumns = ReadExcelFile.getColCount(filename, "LoginData");
		
		String data [][]=new String [ttlRows-1][ttlColoumns];
		
		for(int i=1;i<ttlRows;i++) {
		
			for(int j=1;j<ttlRows;j++) {
				
				data[i-1][j]=ReadExcelFile.getCellValue(filename, "LoginData", i, j);
				
				
			}
		}
		return data	;	
	}
	
	

}
