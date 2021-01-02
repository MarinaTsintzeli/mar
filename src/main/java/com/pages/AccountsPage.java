package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	//1. By Locators
	private By accountSections = By.cssSelector("div#center_column div a span");
	
	//2. Constructor of AccountsClass:
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountHeadersList = driver.findElements(accountSections);
		
		for (WebElement e : accountHeadersList) {
			String text = e.getText();
			accountsList.add(text);
			
		}
		return accountsList;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
}
