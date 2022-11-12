package com.seleniumAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider() {
		
		File src = new File("./Configuration/Config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config File "+ e.getMessage());
		}
	}

	public String getDataFromConfig(String keyTosearch) {
		return prop.getProperty(keyTosearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getURL() {
		return prop.getProperty("qaUrl");
	}
}
