package tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] 
				{
			{
				"Ahmed","Mokhtar","Ahmed@mokhtar90.com","12345678"
			},
			{
				"Ahmed","Sleem","Ahmed@sleem80.com","123456"
			}
				};
	}

	@Test(priority=1,dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String fName,String lName,String email,String password) 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(fName,lName,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}

}
