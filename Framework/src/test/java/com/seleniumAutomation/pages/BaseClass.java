package com.seleniumAutomation.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.seleniumAutomation.utilities.BrowserFactory;
import com.seleniumAutomation.utilities.ConfigDataProvider;
import com.seleniumAutomation.utilities.ExcelDataProvider;
import com.seleniumAutomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() throws FileNotFoundException {
		Reporter.log("Setting up reports and Test getting ready",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Report_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done and Test can be started",true);
	}

	@BeforeClass
	public void setup() {
		Reporter.log("Setting up browser",true);
		BrowserFactory bf = new BrowserFactory(driver);
		driver = bf.startApplication(config.getBrowser(), config.getURL());
		Reporter.log("Browser is up and running",true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test About to end",true);
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		} else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		} else if(result.getStatus()==ITestResult.SKIP) {
			logger.pass("Test Skiped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		} 
		report.flush();
		Reporter.log("Reports generated and Test completed.",true);
	}
}
