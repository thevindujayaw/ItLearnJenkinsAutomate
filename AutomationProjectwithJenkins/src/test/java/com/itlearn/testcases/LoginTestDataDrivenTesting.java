package com.itlearn.testcases;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.Login_Page;
import com.itlearn.utility.ReadExcelFile;


public class LoginTestDataDrivenTesting extends BaseTest {
	
//	 System.out.println(System.getProperty("user.dir"));
	String fileName = System.getProperty("user.dir") + "/TestData/TestInfo.xlsx";

	@Test(priority =1,dataProvider="LoginDataProvider")
	public void VerifyLogin(String username,String password) throws IOException, InterruptedException
	{
		Login_Page lp=new Login_Page(driver);
//		String username ="Demo12";
//		String password ="Test123456$";

		
		lp.loginportal(username, password);

		if (username.trim().equals("Demo12") && password.trim().equals("Test123456$")) {
		    System.out.println("login success");
		    lp.logout();
		    Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "Verify_Loginfailure");
		    System.out.println("login failed");
		    Assert.assertTrue(false);
		}

	
	}
	
	//getting data from the excell file
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider() {
	    int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
	    int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");

	    // Check if the row count is valid
	    if (ttlRows <= 1 || ttlColumns == 0) {
	        System.out.println("Error: No data found in the Excel sheet.");
	        return new String[0][0];  // Return an empty array to avoid exceptions
	    }

	    String data[][] = new String[ttlRows - 1][ttlColumns];

	    for (int i = 1; i < ttlRows; i++) {  // Start from 1 to skip headers
	        for (int j = 0; j < ttlColumns; j++) {
	            data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
	        }
	    }
	    return data;
	}
	
	 
}
