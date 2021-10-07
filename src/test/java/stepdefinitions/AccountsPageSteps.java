package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {
	
	List<Map<String,String>> list=dataTable.asMaps();
	
	String username=list.get(0).get("username");
	String password=list.get(0).get("password");
	
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	loginPage.enterEmail(username);
	loginPage.enterPassword(password);
	accountsPage=loginPage.clickOnLogin();
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		accountsPage.getsAccountPageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable sections) {
		List<String> expectedAccountsSectionList=sections.asList();
		List<String> actualAccountsSectionList=accountsPage.getsAccountsSectionList();
		System.out.println("expectedAccountsSectionList::"+expectedAccountsSectionList);
		System.out.println("actualAccountsSectionList::"+actualAccountsSectionList);
		Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedAccountSectionsCount) {
		int actualAccountSectionsCount=accountsPage.getsAccountsSectionCount();
		System.out.println("Actual Account Section Count from page class:"+actualAccountSectionsCount);
		System.out.println("Expected Account Section Count from page class:"+expectedAccountSectionsCount);
		Assert.assertTrue(actualAccountSectionsCount==expectedAccountSectionsCount);
	}

}

