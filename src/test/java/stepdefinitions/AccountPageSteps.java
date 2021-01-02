package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged in the application")
	public void user_has_already_logged_in_the_application(DataTable credTable) {

		List<Map<String, String>> crdList = credTable.asMaps();
		String userName = crdList.get(0).get("username");
		String password = crdList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginpage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {

		String accountPageTitle = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title is : " + accountPageTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> a = sectionsTable.asList();
		List<String> expectedSectionsList = new ArrayList<>();
		for (String string : a) {
			expectedSectionsList.add(string.toUpperCase());
		}

		System.out.println("Expected accounts section list : " + expectedSectionsList);
		List<String> actualSectionsList = accountsPage.getAccountsSectionList();
		System.out.println("Actual accounts section list : " + actualSectionsList);

		Assert.assertTrue(expectedSectionsList.containsAll(actualSectionsList));
	}

	@Then("accounts section count sould be {int}")
	public void accounts_section_count_sould_be(Integer expected) {
		int cnt = accountsPage.getAccountsSectionCount();
		Assert.assertTrue(cnt == expected);

	}
}
