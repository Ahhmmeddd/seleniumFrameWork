package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
	}
	@When("i click on register link")
	public void i_click_on_register_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered the user data")
	public void i_entered_the_user_data()
	{
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Ahmed","Mokhtar","Ahmed0@mokhtar10.com","123456");

	}
	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully()
	{
		registerObject.userLogout();
	}

}
