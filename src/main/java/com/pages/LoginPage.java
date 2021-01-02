package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPswLink = By.linkText("Forgot your password?");
	
	//2. Constructor of PageClass:
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPswLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String username, String password) {
		System.out.println("Login with: " + username + " and " + password);
		enterUsername(username);
		enterPassword(password);
		clickOnLogin();
		// its doLogin method responsibility to give the AccountsPage object
		//because it goes to the new page
		return new AccountsPage(driver);
	}
}
