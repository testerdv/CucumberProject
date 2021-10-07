package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private String title; 
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); 
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
	   title=loginPage.getLoginPageTitle(); 
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
	    Assert.assertTrue(title.contains(pageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	 Assert.assertTrue(loginPage.isForgotPswdLinkExists());   
	}

	@When("user enters username {string}")
	public void user_enters_username(String email) {
	    loginPage.enterEmail(email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pswd) {
	    loginPage.enterPassword(pswd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

	
}
