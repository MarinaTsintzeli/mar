package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	//For parallel execution
	
	//Initialize WebDriver with the help of ThreadLocal 
	//browser -> from properties browser
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is: " + browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			//checks version of browser installed, matches version of driver installed, if not present -> download
			tlDriver.set(new ChromeDriver());
			//when initialize ChromeDriver, object of ChromeDriver is created 
			//and it is set with ThreadLocal Driver
			//it will create LocalDriver copy for the specific thread
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value: "+ browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	//if running in parallel execution, multiple threads will be calling the getDriver method
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
