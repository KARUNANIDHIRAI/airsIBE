package com.airs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public  ReadConfig() {
		File CPfis = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(CPfis);
			pro = new Properties();
			pro.load(fis);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL() {

		String URL = pro.getProperty("baseURL");
		return URL;
	}
	
	public String getChromeDrvPath() {
		String URL = pro.getProperty("chromeDriverPath");
		return URL;		
	}

	public String getIEDrvPath() {
		String URL = pro.getProperty("IEDriverPath");
		return URL;		
	}
	
	public String getFirefoxDrvPath() {
		System.out.println("firefoxDriverPath not found");
		String URL = pro.getProperty("firefoxDriverPath");
		return URL;		
	}	

	public String getAppUserName() {
		String URL = pro.getProperty("applUserName");
		return URL;		
	}
	
	public String getApplPassword() {
		String URL = pro.getProperty("applPassword");
		return URL;		
	}	
}
