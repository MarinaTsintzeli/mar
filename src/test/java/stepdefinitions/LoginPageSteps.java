 package stepdefinitions;

import org.junit.Assert;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private String pagetitle;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	//DriverFactory.getDriver() returns the current Thread's copy of this threadLocal variable
	//WebDriver was instantiate at @Before (with tlDriver.set(new ChromeDriver())

	@Given("user is on login page")
	public void user_is_on_login_page() {
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	} 

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pagetitle = loginPage.getLoginPageTitle();
		System.out.println("Page title is : "+ pagetitle);
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		Assert.assertTrue(pagetitle.contains(expectedTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}
	
	@When("user click on Login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLogin();
	}
	


}
