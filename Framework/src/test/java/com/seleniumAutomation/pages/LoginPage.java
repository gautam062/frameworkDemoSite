package com.seleniumAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name = 'uid']")
	WebElement txtUserName;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	public void setUserName(String username) {
		txtUserName.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void loginToDemo(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		setUserName(username);
		setPassword(password);
		clickLogin();

	}
}
