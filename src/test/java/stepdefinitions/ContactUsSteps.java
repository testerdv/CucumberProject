package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.ContactUs;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactUsSteps {
	
	WebDriver driver=DriverFactory.getDriver();
	private ContactUs contactUs=new ContactUs(DriverFactory.getDriver());
	private ExcelReader excelReader;

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
	    driver.get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and {string}")
	public void user_fills_the_form_from_given_sheetname_and(String sheetName, String row) {
	    int rownum=Integer.parseInt(row);
	    excelReader=new ExcelReader(System.getProperty("user.dir")+"//ContactUs_Excel.xlsx",sheetName);
	    
	    Map<String,String> rowValues=excelReader.readExcel(rownum);
	    
	    contactUs.selectSubjectHeading(rowValues.get("Subject Heading"));
	    contactUs.setEmail(rowValues.get("Email address"));
	    contactUs.setOrderRef(rowValues.get("Order reference"));
	    contactUs.setMessage(rowValues.get("Message"));
	    
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUs.clickSendButton();
	}

	@Then("it shows successful message {string}")
	public void it_shows_successfull_message(String msg) {
	    Assert.assertTrue(contactUs.getSuccessfulMessage().contains(msg));
	}

}
