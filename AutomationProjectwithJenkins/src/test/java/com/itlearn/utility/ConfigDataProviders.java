package com.itlearn.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProviders {
Properties pro;
	
	public ConfigDataProviders()
	{
		File src = new File("/Users/thevinduj/Eclipse/AutomationProjectwithJenkins/configurations/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			
			pro= new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		} 
	}

	
	public String getBrowser() {
		// TODO Auto-generated method stub
		return pro.getProperty("browser");
	}



	public String getStagingUrl() {
		// TODO Auto-generated method stub
		return pro.getProperty("testurl");
	}
}