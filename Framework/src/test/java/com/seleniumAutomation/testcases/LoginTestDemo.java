package com.seleniumAutomation.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.seleniumAutomation.pages.BaseClass;
import com.seleniumAutomation.pages.LoginPage;

public class LoginTestDemo extends BaseClass {

	@Test(priority = 1)
	public void loginApp() throws InterruptedException, FileNotFoundException {
		logger=report.createTest("Login to Demo Bank");
		LoginPage lp = new LoginPage(driver);
		logger.info("Starting Application");
		lp.loginToDemo(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Logon successul");
		
	}
	
	
}
